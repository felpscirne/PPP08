package adapterproject.controller;

import adapterproject.controller.adapter.SenderAdapter;
import adapterproject.controller.adapter.SmsSender;
import adapterproject.controller.adapter.TelegramSender; 
import adapterproject.model.Message;
import adapterproject.view.ConsoleView;

public class MessageController {
    private ConsoleView view;

    private static final String DEFAULT_SMS_MESSAGE = "Rodoooouuu! Fala Igor, beleza? Enviando SMS o/";
    private static final String DEFAULT_TELEGRAM_MESSAGE = "Valeu, Igor!!!! Provavelmente tem varios erros, mas essa foi punk, merece um 10!! 😊";

    public MessageController(ConsoleView view) {
        this.view = view;
    }

    public void start() {
        view.displayWelcomeMessage();
        int option;
        do {
            option = view.displayMenu();
            switch (option) {
                case 1:
                    sendSms();
                    break;
                case 2:
                    sendTelegram(); 
                    break;
                case 3:
                    view.displayGoodbyeMessage();
                    break;
                default:
                    view.displayErrorMessage("Opção inválida. Tente novamente.");
            }
        } while (option != 3);
        view.closeScanner();
    }

    private void sendSms() {
        String destination = view.getDestinationData(Message.MessageType.SMS);
        Message message = new Message(DEFAULT_SMS_MESSAGE, destination, Message.MessageType.SMS);

        SenderAdapter smsAdapter = new SmsSender();
        smsAdapter.send(message.getDestination(), message.getContent());
        view.displaySuccessMessage("SMS", message.getDestination());
    }

    private void sendTelegram() { 
        String destination = view.getDestinationData(Message.MessageType.TELEGRAM);
        Message message = new Message(DEFAULT_TELEGRAM_MESSAGE, destination, Message.MessageType.TELEGRAM);

        SenderAdapter telegramAdapter = new TelegramSender(); // Nova instância
        telegramAdapter.send(message.getDestination(), message.getContent());
        view.displaySuccessMessage("Telegram", message.getDestination());
    }
}