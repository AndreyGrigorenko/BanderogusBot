package org.example;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class Main extends TelegramLongPollingBot {
  //BanderogusKurvaGoItBot
  //5947790150:AAHdBRK4gOFjLTA2bN1eolPP-KdwrYNGQbY
  public static void main(String[] args) throws TelegramApiException {
    TelegramBotsApi api = new TelegramBotsApi(DefaultBotSession.class);
    api.registerBot(new Main());

  }

  @Override
  public String getBotUsername() {
    return "BanderogusKurvaGoItBot";
  }

  @Override
  public String getBotToken() {
    return "5947790150:AAHdBRK4gOFjLTA2bN1eolPP-KdwrYNGQbY";
  }

  @Override
  public void onUpdateReceived(Update update) {
    Long chatId = getChatId(update);
    SendMessage msg = createMessage("Hello *Andrii*");
    msg.setChatId(chatId);
    sendApiMethodAsync(msg);
  }

  public Long getChatId(Update update) {
    if (update.hasMessage()) {
      return  update.getMessage().getFrom().getId();
    }

    if (update.hasCallbackQuery()) {
      return  update.getCallbackQuery().getFrom().getId();
    }

    return null;
  }

  public SendMessage createMessage(String text) {
    SendMessage message = new SendMessage();
    message.setText(text);
    message.setParseMode("markdown");

    return message;
  }
}