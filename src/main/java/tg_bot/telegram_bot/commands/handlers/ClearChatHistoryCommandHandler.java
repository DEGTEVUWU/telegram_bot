package tg_bot.telegram_bot.commands.handlers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import tg_bot.telegram_bot.commands.TelegramCommandHandler;
import tg_bot.telegram_bot.commands.TelegramCommands;
import tg_bot.telegram_bot.openAI.ChatGptHistoryService;

@Component
@AllArgsConstructor
public class ClearChatHistoryCommandHandler implements TelegramCommandHandler {

    private final ChatGptHistoryService chatGptHistoryService;

    private final String CLEAR_MESSAGE = "История общейния с chat-GPT была очищена";

    @Override
    public BotApiMethod<?> processCommand(Update update) {
        chatGptHistoryService.clearHistory(update.getMessage().getChatId());
        return SendMessage.builder()
                .chatId(update.getMessage().getChatId())
                .text(CLEAR_MESSAGE)
                .build();

    }

    @Override
    public TelegramCommands getSupportedCommand() {
        return TelegramCommands.CLEAR_COMMAND;
    }
}
