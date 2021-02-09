package domain.Users;

public class User <T> {

    private String name;
    private String surname;
    private String email;
    private T userID;

    public static class Builder <T> {

        private final User <T> newUser;

        public Builder () {
            newUser = new User<>();
        }
        public Builder <T> withUserID(T userID) {
            newUser.userID = userID;
            return this;
        }
        public Builder <T> withEmail(String email) {
            newUser.email = email;
            return this;
        }

        public Builder <T> withName(String name) {
            newUser.name = name;
            return this;
        }

        public Builder <T> withSurname(String surname) {
            newUser.surname = surname;
            return this;
        }

        public User <T> build()  {
            return newUser;
        }

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUserID(T userID) {
        this.userID = userID;
    }
    public T getUserID() {
        return userID;
    }

    @Override
    public String toString() {
        return "Пользователь" + '\n' +
                "Имя: " + getName() + '\n' +
                "Фамилия: " + getSurname() + '\n' +
                "e-mail: " + getEmail() + '\n' +
                "User id: " + getUserID() +'\n';

    }
}

