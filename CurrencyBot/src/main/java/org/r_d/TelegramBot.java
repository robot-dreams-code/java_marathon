package org.r_d;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class TelegramBot extends TelegramLongPollingBot {    
    private static boolean isHelloMessage(String message) {
        message = message.toLowerCase();

        String helloWord1 = "привіт";
        String helloWord2 = "вітаю";

        return message.contains(helloWord1) || message.contains(helloWord2);
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String message = update.getMessage().getText();
            if (isHelloMessage(message)) {
                String botName = "CurrencyBot";
                sendText(update.getMessage().getChatId(), "Вітаю, я - " + botName);
            }
            else if (message.contains(" ")) {
                String[] values = message.split(" ");
                Currency cur = Processor.processCur(Integer.parseInt(values[0]) );
                float value = Float.parseFloat(values[1]);
                String response = Processor.calculateCurrency(cur, value);
                sendText(update.getMessage().getChatId(), response);}
            else
                sendText(update.getMessage().getChatId(), "Спробуй ще");
            String response = "Введіть валюту для конвертації в USD 1 - UAH, 2 - EUR, 3 - GBP та суму конвертації через пробіл";
            sendText(update.getMessage().getChatId(), response);
        }
    }
    
    public void sendText(long chatId, String text) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText(text);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getBotUsername() {
        return "****";
    }

    @Override
    public String getBotToken() {
        return "****";
    }
}
