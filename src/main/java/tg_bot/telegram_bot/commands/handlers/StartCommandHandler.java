package tg_bot.telegram_bot.commands.handlers;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import tg_bot.telegram_bot.commands.TelegramCommandHandler;
import tg_bot.telegram_bot.commands.TelegramCommands;

@Component
public class StartCommandHandler implements TelegramCommandHandler {

    private final String HELLO_MESSAGE = """
            Привет %s,
            Это связанный с OpenAI telegram-бот
            Он запоминает сообщения для контекста.
            Начать общение - /start, очистить контекст - /clear
            """;

    @Override
    public BotApiMethod<?> processCommand(Update update) {
        return SendMessage.builder()
                .chatId(update.getMessage().getChatId())
                .text(HELLO_MESSAGE.formatted(update.getMessage().getChat().getFirstName()))
                .build();
    }

    @Override
    public TelegramCommands getSupportedCommand() {
        return TelegramCommands.START_COMMAND;
    }
}
