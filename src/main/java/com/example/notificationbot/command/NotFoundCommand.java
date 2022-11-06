package com.example.notificationbot.command;

import com.example.notificationbot.telegram.TelegramBot;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Service
public class NotFoundCommand implements Command {
    @Override
    public void execute(Update update, String chatId, TelegramBot telegramBot) throws TelegramApiException {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setText("Command not found");

        sendMessage.setChatId(chatId);
        telegramBot.execute(sendMessage);
    }
}
