package co.istad.lms.features.telegrambot;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;

@Service
@RequiredArgsConstructor
public class TelegramBotServiceImpl implements TelegramBotService{

    @Value("${telegram.bot.token}")
    private String botToken;

    @Value("${telegram.bot.id}")
    private String chatId;

    private final RestTemplate restTemplate;

    @Override
    public void sendAdmissionResponse(String messageText) {
        String url = String.format("https://api.telegram.org/bot%s/sendMessage", botToken);

        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");

        String requestJson = String.format("{\"chat_id\":\"%s\",\"text\":\"%s\"}", chatId, messageText);

        HttpEntity<String> entity = new HttpEntity<>(requestJson, headers);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
        if (!response.getStatusCode().is2xxSuccessful()) {
            throw new RuntimeException("Failed to send message to Telegram");
        }
    }
}
