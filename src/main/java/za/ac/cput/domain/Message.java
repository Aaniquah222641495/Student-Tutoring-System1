package za.ac.cput.domain;

public class Message {
    private String id;
    private User sender;
    private User receiver;
    private String text;

    public Message() {
    }

    public Message(Builder builder) {
        this.id = builder.id;
        this.sender = builder.sender;
        this.receiver = builder.receiver;
        this.text = builder.text;
    }

    public String getId() {
        return id;
    }

    public User getSender() {
        return sender;
    }

    public User getReceiver() {
        return receiver;
    }

    public String getText() {
        return text;
    }

    public static class Builder{
        private String id;
        private User sender;
        private User receiver;
        private String text;

        public Builder setId(String id) {
            this.id = id;
            return this;
        }

        public Builder setSender(User sender) {
            this.sender = sender;
            return this;
        }

        public Builder setReceiver(User receiver) {
            this.receiver = receiver;
            return this;
        }

        public Builder setText(String text) {
            this.text = text;
            return this;
        }

        public Builder copy(Message message) {
            this.id = message.id;
            this.sender = message.sender;
            this.receiver = message.receiver;
            this.text = message.text;
            return this;
        }

        public Message build() {
            return new Message(this);
        }
    }
}
