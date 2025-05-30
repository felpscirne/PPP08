package adapterproject.model;

public class Message {
    private String content;
    private String destination;
    private MessageType messageType;

    public enum MessageType {
        SMS, TELEGRAM
    }

    public Message(String content, String destination, MessageType messageType) {
        this.content = content;
        this.destination = destination;
        this.messageType = messageType;
    }

    public String getContent() {
        return content;
    }

    public String getDestination() {
        return destination;
    }

    public MessageType getMessageType() {
        return messageType;
    }
}