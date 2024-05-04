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
    public TelegramBot telegramBot(
            @Value("${bot.token}")String botToken,
            TelegramBotsApi telegrambotsApi,
            ChatGPTService gptService
    ) {
        var botOptions = new DefaultBotOptions();
        var firstBot = new TelegramBot(botOptions, botToken, gptService);
        telegrambotsApi.registerBot(firstBot);
        return firstBot;
    }

    @Bean
    @SneakyThrows
    public TelegramBotsApi telegramBotsApi() {
        return new TelegramBotsApi(DefaultBotSession.class);
    }
}
