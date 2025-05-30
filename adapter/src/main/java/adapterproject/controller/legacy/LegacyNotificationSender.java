package adapterproject.controller.legacy;

public class LegacyNotificationSender {

    public void sendNotification(String identifier, String content, String type) {
       
        System.out.println("[SISTEMA LEGADO NOTIFICACAO] Enviando Notificação (" + type + ") para: " + identifier + " com o conteúdo: '" + content + "'");
    }
}