package com.example.notificationbot.telegram;

import com.example.notificationbot.command.Command;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.Map;

@Getter
@Setter
@RequiredArgsConstructor
@Component
public class TelegramBot extends TelegramLongPollingBot {

    @Value("${telegram.bot.name}")
    private String botUserName;

    @Value("${telegram.bot.token}")
    private String botToken;

    private final Map<String, Command> commands;

    @Override
    public String getBotUsername() {
        return botUserName;
    }

    @Override
    public String getBotToken() {
        return botToken;
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String commandName = update.getMessage().getText().replace("/", "") + "Command";
            Command command = commands.getOrDefault(commandName, commands.get("notFoundCommand"));
            try {
                command.execute(update, update.getMessage().getChatId().toString(), this);
            } catch (TelegramApiException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
