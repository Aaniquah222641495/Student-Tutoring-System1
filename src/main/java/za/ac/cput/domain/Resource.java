package za.ac.cput.domain;

public class Resource {

    private int id;
    private User sender;
    private User receiver;
    private byte[] resource;
    private String resourceName;

    public Resource() {
    }

    public Resource(Builder builder) {
        this.id = id;
        this.sender = sender;
        this.receiver = receiver;
        this.resourceName = resourceName;
        this.resource = resource;
    }

    public int getId() {
        return id;
    }

    public User getSender() {
        return sender;
    }

    public User getReceiver() {
        return receiver;
    }

    public byte[] getResource() {
        return resource;
    }

    public String getResourceName() {
        return resourceName;
    }

    public static class Builder{
        private int id;
        private User sender;
        private User receiver;
        private byte[] resource;
        private String resourceName;

        public Builder setId(int id) {
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

        public Builder setResource(byte resource) {
            this.resource = new byte[]{resource};
            return this;
        }

        public Builder setResourceName(String resourceName) {
            this.resourceName = resourceName;
            return this;
        }

        public Builder copy(Resource resource){
            this.id = resource.getId();
            this.sender = resource.getSender();
            this.receiver = resource.getReceiver();
            this.resource = resource.getResource();
            this.resourceName = resource.getResourceName();
            return this;
        }

        public Resource build() {
            return new Resource(this);
        }
    }

}
