package tg_bot.telegram_bot.openAI;

import jakarta.annotation.Nonnull;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tg_bot.telegram_bot.openAI.api.ChatCompletionRequest;
import tg_bot.telegram_bot.openAI.api.Message;
import tg_bot.telegram_bot.openAI.api.OpenAIClient;

@AllArgsConstructor
@Service
public class ChatGPTService {
    private final OpenAIClient openAIClient;
    private final ChatGptHistoryService chatGptHistoryService;

    @Nonnull
    public String getResponseChatForUser(
            Long userId,
            String userTextInput
    ) {

        chatGptHistoryService.createHistoryIfNotExist(userId);

        var history = chatGptHistoryService.addMessageToHistory(
                userId,
                Message.builder()
                    .content(userTextInput)
                    .role("user")
                    .build()
        );

        var request = ChatCompletionRequest.builder()
                .model("gpt-3.5-turbo")
                .messages(history.chatMessage())
                .build();

        var response = openAIClient.createChatCompletion(request);
        var messageFromGpt = response.choices().get(0).message();

        chatGptHistoryService.addMessageToHistory(userId, messageFromGpt);

        return messageFromGpt.content();
    }
}
