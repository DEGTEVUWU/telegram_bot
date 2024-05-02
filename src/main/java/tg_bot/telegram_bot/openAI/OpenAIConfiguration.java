package tg_bot.telegram_bot.openAI;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class OpenAIConfiguration {

    @Bean
    public OpenAIClient openAIClient(
            @Value("${openai.token}")String botToken,
            RestTemplateBuilder restTemplateBuilder
            ) {
        return new OpenAIClient(botToken, restTemplateBuilder.build());

    }
}
