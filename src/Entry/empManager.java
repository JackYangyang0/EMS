package Entry;

public class empManager {
    private String username;
    private String password;

    @Override
    public String toString() {
        return "empManager{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public empManager() {
    }

    public empManager(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
