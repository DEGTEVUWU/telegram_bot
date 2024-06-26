package tg_bot.telegram_bot.openAI;

import com.fasterxml.jackson.annotation.JsonProperty;
import tg_bot.telegram_bot.openAI.api.Choice;

import java.util.List;

public record ChatCompletionObject (
    @JsonProperty("choices") List<Choice> choices
) {}
