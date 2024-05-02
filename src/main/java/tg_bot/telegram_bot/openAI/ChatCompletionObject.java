package tg_bot.telegram_bot.openAI;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

public record ChatCompletionObject (
    @JsonProperty("choices") List<Choice> choices
) {}
