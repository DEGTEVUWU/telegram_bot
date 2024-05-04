package tg_bot.telegram_bot.openAI;

import lombok.Builder;
import tg_bot.telegram_bot.openAI.api.Message;

import java.util.List;

@Builder
public record ChatHistory (
        List<Message> chatMessage
){}
