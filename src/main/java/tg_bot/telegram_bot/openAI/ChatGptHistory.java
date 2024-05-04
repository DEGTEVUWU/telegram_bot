package tg_bot.telegram_bot.openAI;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tg_bot.telegram_bot.openAI.api.Message;

import java.awt.desktop.AboutHandler;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Service
@AllArgsConstructor
public class ChatGptHistory {
    private final Map<Long, ChatHistory> chatHistoryMap = new ConcurrentHashMap<>();
    public Optional<ChatHistory> getUserHistory(Long userId) {
        return Optional.ofNullable(chatHistoryMap.get(userId));
    }
    public void createHistory(Long userId) {
        chatHistoryMap.put(userId, new ChatHistory(new ArrayList<>()));
    }
    public void createHistoryIfNotExist(Long userId) {
        if (!chatHistoryMap.containsKey(userId)) {
            createHistory(userId);
        }
    }
    public ChatHistory addMessageToHistory(
            Long userId,
            Message message
    ) {
        var chatHistory = chatHistoryMap.get(userId);
        if (chatHistory == null) {
            throw new IllegalStateException("History not exist = %s".formatted(userId));
        }
        chatHistory.chatMessage().add(message);
        return chatHistory;
    }
}
