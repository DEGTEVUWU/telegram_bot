package tg_bot.telegram_bot.openAI;

import lombok.AllArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.client.RestClient;

import org.springframework.web.client.RestTemplate;

import java.util.concurrent.ExecutionException;

@AllArgsConstructor
public class OpenAIClient {
    private final String token;
    private final RestTemplate restTemplate;

    public ChatCompletionObject createChatCompletion(String message) {
        String url = "https://api.openai.com/v1/chat/completions";
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization", "Bearer " + token);
        httpHeaders.add("Content-Type", "application/json");
//        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
//        httpHeaders.setBearerAuth(token);

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

        HttpEntity<String> httpEntity = new HttpEntity<>(requestBody, httpHeaders);
        ResponseEntity<ChatCompletionObject> responseEntity = restTemplate.exchange(
                url, HttpMethod.POST, httpEntity, ChatCompletionObject.class
        );
        return responseEntity.getBody();


    }

}
