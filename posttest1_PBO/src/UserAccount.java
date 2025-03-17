// Rifki Abiyan
// 2309106030
// A2 23
public class UserAccount {
    private String username;
    private String password;
    private String role; 

    public UserAccount(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    // Getter dan Setter
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    @Override
    public String toString() {
        return "UserAccount [Username: " + username + ", Role: " + role + "]";
    }
}