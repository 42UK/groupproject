package src.fillable.user;

public class User implements Comparable<User> {
    private final String name;
    private final String password;
    private final String email;

    public static class Builder {

        private String name;
        private String password;
        private String email = "";

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public String peekName() {
            return new String(name);
        }

        public String peekPassword() {
            return new String(password);
        }

        public String peekEmail() {
            return new String(email);
        }

        public User build() {
            return new User(this);
        }
    }

    private User(Builder builder) {
        this.name = builder.name;
        this.password = builder.password;
        this.email = builder.email;
    }

    @Override
    public int compareTo(User other) {
        return this.name.compareTo(other.name);
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
