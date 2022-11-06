package com.example.notificationbot.command;

import com.example.notificationbot.telegram.TelegramBot;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.File;

@Service
public class GetImageCommand implements Command{
    @Override
    public void execute(Update update, String chatId, TelegramBot telegramBot) throws TelegramApiException {
        InputFile inputFile = new InputFile();
        inputFile.setMedia(new File("image.jpg"));
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setPhoto(inputFile);

        sendPhoto.setChatId(chatId);
        telegramBot.execute(sendPhoto);

    }
}
