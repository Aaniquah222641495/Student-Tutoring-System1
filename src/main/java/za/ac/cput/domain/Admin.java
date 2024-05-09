package za.ac.cput.domain;

import jakarta.persistence.Entity;

@Entity
public class Admin extends User{

    public Admin() {
    }

    public Admin(Builder builder){
        this.id = builder.id;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.password = builder.password;
        this.email = builder.email;
    }

    public static class Builder{
        private Integer id;
        private String firstName;
        private String lastName;
        private String password;
        private String email;

        public Builder setId(Integer id) {
            this.id = id;
            return this;
        }

        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder copy(Admin admin){
            this.id = admin.getId();
            this.firstName = admin.getFirstName();
            this.lastName = admin.getLastName();
            this.password = admin.getPassword();
            this.email = admin.getEmail();
            return this;
        }

        public Admin build(){
            return new Admin(this);
        }
    }
}
