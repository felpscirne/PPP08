package adapterproject.controller.adapter;

import org.telegram.telegrambots.bots.DefaultAbsSender;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import adapterproject.controller.legacy.LegacyNotificationSender;

public class TelegramSender implements SenderAdapter {
    private LegacyNotificationSender legacyNotificationSender; 

    
    private static final String BOT_TOKEN = "8169926785:AAHGhZYhJas64jvZ3C65KxkHNR48JUSc4aA";

   
    private static class TelegramMessageSender extends DefaultAbsSender {
        protected TelegramMessageSender(DefaultBotOptions options) {
            super(options);
        }

        @Override
        public String getBotToken() {
            return BOT_TOKEN;
        }

        
        public String getBotUsername() {
           
            return "BotzinDePPP"; 
        }
    }

    private TelegramMessageSender telegramBot;

    public TelegramSender() {
        this.legacyNotificationSender = new LegacyNotificationSender();
        DefaultBotOptions botOptions = new DefaultBotOptions();
        this.telegramBot = new TelegramMessageSender(botOptions);
    }

    @Override
    public void send(String chatId, String messageContent) {
        

        if (BOT_TOKEN.isEmpty()) {
            System.err.println("AVISO: TOKEN do Bot Telegram não configurado. O envio real do Telegram não funcionará.");
            legacyNotificationSender.sendNotification(chatId, messageContent, "TELEGRAM (Simulado)");
            return;
        }

        try {
            System.out.println("--- Enviando Telegram REAL via Bot API (usando Adapter) ---");
            SendMessage message = new SendMessage();
            message.setChatId(chatId); 
            message.setText(messageContent);

            telegramBot.execute(message); 

            System.out.println("Mensagem Telegram enviada com sucesso para o chat ID: " + chatId);
        } catch (TelegramApiException e) {
            System.err.println("Erro ao enviar Telegram via Bot API: " + e.getMessage());
            System.out.println("--- Tentando enviar via SISTEMA LEGADO NOTIFICACAO como fallback ---");
            legacyNotificationSender.sendNotification(chatId, messageContent, "TELEGRAM (Falha no Envio Real)");
        } catch (Exception e) {
             System.err.println("Erro inesperado ao enviar Telegram: " + e.getMessage());
             legacyNotificationSender.sendNotification(chatId, messageContent, "TELEGRAM (Erro Inesperado)");
        }
    }
}