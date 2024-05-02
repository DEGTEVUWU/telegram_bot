package tg_bot.telegram_bot.openAI;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

public record Message (
    @JsonProperty("role") String role,
    @JsonProperty("content") String content
) {}

