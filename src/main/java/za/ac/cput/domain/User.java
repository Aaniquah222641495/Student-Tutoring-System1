package za.ac.cput.domain;

public class User {
    private Integer id;
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    public enum Type{ADMIN, STUDENT, TUTOR}
    private Type type;

    private User(Builder builder){
        this.id = builder.id;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.password = builder.password;
        this.email = builder.email;
        this.type = builder.type;

    }
    public Type getType() {
        return type;
    }

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public static class Builder{
        private Integer id;
        private String firstName;
        private String lastName;
        private String password;
        private String email;
        private User.Type type;

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

        public Builder setType(Type type) {
            this.type = type;
            return this;
        }

        public Builder copy(User user){
            this.id = user.getId();
            this.firstName = user.getLastName();
            this.lastName = user.getLastName();
            this.password = user.getPassword();
            this.email = user.getEmail();
            this.type = user.getType();
            return this;
        }

        public User build(){
            return new User(this);
        }
    }

}
