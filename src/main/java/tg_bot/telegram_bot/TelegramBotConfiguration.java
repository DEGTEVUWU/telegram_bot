package tg_bot.telegram_bot;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import tg_bot.telegram_bot.openAI.ChatGPTService;

@Configuration
public class TelegramBotConfiguration {

    @Bean
    @SneakyThrows
    public TelegramBotsApi telegramBotsApi(
            TelegramBot telegramBot
    ) {
        var telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(telegramBot);
        return telegramBotsApi;

    }
}
