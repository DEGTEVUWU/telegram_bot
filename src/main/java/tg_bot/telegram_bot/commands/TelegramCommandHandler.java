package tg_bot.telegram_bot.commands;

import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;

public interface TelegramCommandHandler {
    BotApiMethod<?> processCommand(Update update);
    TelegramCommands getSupportedCommand();
}
