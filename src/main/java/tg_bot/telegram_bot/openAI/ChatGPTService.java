package tg_bot.telegram_bot.openAI;

import jakarta.annotation.Nonnull;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tg_bot.telegram_bot.openAI.api.ChatCompletionRequest;
import tg_bot.telegram_bot.openAI.api.Message;
import tg_bot.telegram_bot.openAI.api.OpenAIClient;

import java.util.List;

@AllArgsConstructor
@Service
public class ChatGPTService {
    private final OpenAIClient openAIClient;
    private final ChatGptHistory chatGptHistory;

    @Nonnull
    public String getResponseChatForUser(
            Long userId,
            String userTextInput
    ) {

        chatGptHistory.createHistoryIfNotExist(userId);

        var history = chatGptHistory.addMessageToHistory(
                userId,
                Message.builder()
                    .content(userTextInput)
                    .role("user")
                    .build()
        );

        var request = ChatCompletionRequest.builder()
                .model("gpt-3")
                .messages(history.chatMessage())
                .build();

        var response = openAIClient.createChatCompletion(request);
        var messageFromGpt = response.choices().get(0).message();

        chatGptHistory.addMessageToHistory(userId, messageFromGpt);

        return messageFromGpt.content();
    }
}
