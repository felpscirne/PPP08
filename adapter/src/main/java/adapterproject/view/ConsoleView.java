package adapterproject.view;

import java.util.Scanner;

import adapterproject.model.Message;

public class ConsoleView {
    private Scanner scanner;

    public ConsoleView() {
        this.scanner = new Scanner(System.in);
    }

    public void displayWelcomeMessage() {
        System.out.println("----------------------------------------");
        System.out.println("        Sistema de Envio de Mensagens   ");
        System.out.println("----------------------------------------");
    }

    public int displayMenu() {
        System.out.println("\nEscolha uma opção:");
        System.out.println("1. Enviar SMS");
        System.out.println("2. Enviar Telegram"); 
        System.out.println("3. Sair");
        System.out.print("Opção: ");
        return scanner.nextInt();
    }

    public String getDestinationData(Message.MessageType messageType) {
        scanner.nextLine(); 
        String destinationLabel;
        if (messageType == Message.MessageType.SMS) {
            destinationLabel = "número de telefone (com código do país e DDD, ex: +5511987654321)";
        } else if (messageType == Message.MessageType.TELEGRAM) {
            destinationLabel = "ID do chat do Telegram (usuário deve ter iniciado conversa com o bot @pppcirne_bot) ID neste link --> https://api.telegram.org/bot8169926785:AAHGhZYhJas64jvZ3C65KxkHNR48JUSc4aA/getUpdates"; 
        } else { // EMAIL
            destinationLabel = "e-mail";
        }
        System.out.print("Digite o " + destinationLabel + " do destinatário: ");
        return scanner.nextLine();
    }

    public void displaySuccessMessage(String type, String destination) {
        System.out.println("\n--- Mensagem de " + type + " enviada com sucesso para " + destination + " ---");
    }

    public void displayErrorMessage(String error) {
        System.err.println("\n!!! ERRO: " + error + " !!!");
    }

    public void displayGoodbyeMessage() {
        System.out.println("\nObrigado por usar o sistema de mensagens!");
    }

    public void closeScanner() {
        scanner.close();
    }
}