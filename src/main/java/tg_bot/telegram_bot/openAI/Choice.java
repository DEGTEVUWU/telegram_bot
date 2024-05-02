package tg_bot.telegram_bot.openAI;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

public record Choice (
    @JsonProperty("message") Message message
) {}
