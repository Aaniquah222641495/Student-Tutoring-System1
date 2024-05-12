package za.ac.cput.domain;

import jakarta.persistence.*;

import java.util.Arrays;
import java.util.Objects;

@Entity
public class Resource {
    @Id
    private String id;

    @OneToOne
    @JoinColumn(name = "sender id")
    private User sender;

    @OneToOne
    @JoinColumn(name = "receiver_id")
    private User receiver;
    @Lob
    @Column(name = "resource", columnDefinition="BLOB")
    private byte[] resource;

    private String resourceName;

    public Resource() {
    }

    public Resource(Builder builder) {
        this.id = builder.id;
        this.sender = builder.sender;
        this.receiver = builder.receiver;
        this.resourceName = builder.resourceName;
        this.resource = builder.resource;
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

    public byte[] getResource() {
        return resource;
    }

    public String getResourceName() {
        return resourceName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Resource resource1 = (Resource) o;
        return Objects.equals(id, resource1.id) && Objects.equals(sender, resource1.sender) && Objects.equals(receiver, resource1.receiver) && Objects.deepEquals(resource, resource1.resource) && Objects.equals(resourceName, resource1.resourceName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, sender, receiver, Arrays.hashCode(resource), resourceName);
    }

    public static class Builder{
        private String id;
        private User sender;
        private User receiver;
        private byte[] resource;
        private String resourceName;

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

        public Builder setResource(byte[] resource) {
            this.resource = resource;
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
