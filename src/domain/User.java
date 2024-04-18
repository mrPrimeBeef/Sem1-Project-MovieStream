package domain;

public class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    User createUser(String username, String password) {
        return new User(username, password);
    }
    boolean confirmPassword(String password) {
        return this.password.equals(password);
    }
    boolean login(String password) {
        return this.password.equals(password);
    }
    boolean checkUsernameAvailability(String username) {
        return this.username.equals(username);
    }
    boolean validatePassword(String password) {
        return this.password.equals(password);
    }
}
