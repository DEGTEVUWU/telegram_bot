package tg_bot.telegram_bot.openAI.api;

import lombok.Builder;

import java.util.List;


@Builder
public record ChatCompletionRequest (
        String model,
        List<Message> messages
) {}
