package adapterproject;

import adapterproject.controller.MessageController;
import adapterproject.view.ConsoleView;

public class Main {
    public static void main(String[] args) {
        ConsoleView view = new ConsoleView();
        MessageController controller = new MessageController(view);
        controller.start();
    }
}