package com.example.notificationbot.command;

import com.example.notificationbot.telegram.TelegramBot;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public interface Command {
    void execute(Update update, String chatId, TelegramBot telegramBot) throws TelegramApiException;
}
