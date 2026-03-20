package crudhexagonal.domain.model;

import java.util.UUID;

public class User {
    private UUID id;
    private String username;
    private String password;

    public User(UUID id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public User(String username, String password) {
        this.id = UUID.randomUUID();
        this.username = username;
        this.password = password;
    }

    public UUID getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void changePassword(String newPassword){
        if (newPassword == null || newPassword.length() < 6){
            throw new IllegalArgumentException("Senha deve conter ao menos 6 caracteres");
        }
        this.password = newPassword;
    }
}
