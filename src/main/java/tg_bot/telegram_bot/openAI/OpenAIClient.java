package tg_bot.telegram_bot.openAI;

import lombok.AllArgsConstructor;
import org.springframework.web.client.RestClient;

import org.springframework.http.HttpHeaders;

@AllArgsConstructor
public class OpenAIClient {
    private final String token;
    private final RestClient restClient;
    public ChatCompletionObject createChatCompletion(String message) {
        String url = "https://api.openai.com/v1/chat/completions";
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + token);
        headers.add("Content-Type", "application/json");

        String requestBody = """
                {
                    "model": "No models available",
                    "messages": [
                      {
                        "role": "system",
                        "content": "You are a helpful assistant."
                      },
                      {
                        "role": "user",
                        "content": "%s"
                      }
                    ]
                  }
                """.formatted(message);



    }

}
