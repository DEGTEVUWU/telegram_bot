package tg_bot.telegram_bot;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.SneakyThrows;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import tg_bot.telegram_bot.openAI.ChatGPTService;

@AllArgsConstructor
@Getter
public class TelegramBot extends TelegramLongPollingBot {

    private final ChatGPTService gptService;

    public TelegramBot(DefaultBotOptions options, String botToken, ChatGPTService chatGPTService) {
        super(options, botToken);
        this.gptService = chatGPTService;
    }

    @SneakyThrows
    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            var text = update.getMessage().getText();
            var chatId = update.getMessage().getChatId();

//            var chatCompletionResponse = openAIClient.createChatCompletion(ChatCompletionRequest);
//            var textResponse = chatCompletionResponse.choices().get(0).message().content();
            var gptGeneratedText = gptService.getResponseChatForUser(chatId, text);
            SendMessage sendMessage = new SendMessage(chatId.toString(), gptGeneratedText);
            sendApiMethod(sendMessage);
        }
    }

    @Override
    public String getBotUsername() {
        return "Open_AI_Bot";
    }
}
