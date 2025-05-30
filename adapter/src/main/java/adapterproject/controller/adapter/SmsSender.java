package adapterproject.controller.adapter;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import adapterproject.controller.legacy.LegacySmsSender;

public class SmsSender implements SenderAdapter {
    private LegacySmsSender legacySmsSender;

    public static final String ACCOUNT_SID = "AC758452758665aa0eb1c08c23714f6e41"; 
    public static final String AUTH_TOKEN = "6f823245f3fa345f445f5278b676a466"; 
    public static final String TWILIO_PHONE_NUMBER = "+17622487716"; 

    public SmsSender() {
        this.legacySmsSender = new LegacySmsSender();
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
    }

    @Override
    public void send(String destination, String messageContent) {
        try {
            System.out.println("--- Enviando SMS REAL via Twilio (usando Adapter) ---");
            Message message = Message.creator(
                            new PhoneNumber(destination),
                            new PhoneNumber(TWILIO_PHONE_NUMBER),
                            messageContent)
                    .create();

            System.out.println("SMS enviado com sucesso! SID da mensagem: " + message.getSid());
        } catch (Exception e) {
            System.err.println("Erro ao enviar SMS via Twilio: " + e.getMessage());
            System.out.println("--- Tentando enviar via SISTEMA LEGADO SMS como fallback ---");
            legacySmsSender.sendSms(destination, messageContent);
        }
    }
}