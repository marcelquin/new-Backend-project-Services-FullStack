package App.Domain;


import App.Infra.Persistence.Enum.UserRole;

public record RegisterDTO(String login, String password, UserRole role) {
}
