package adapterproject.controller.legacy;

public class LegacySmsSender {

    public void sendSms(String phone, String message) {
        System.out.println("[SISTEMA LEGADO SMS] Enviando SMS para: " + phone + " com a mensagem: '" + message + "'");
    }
}