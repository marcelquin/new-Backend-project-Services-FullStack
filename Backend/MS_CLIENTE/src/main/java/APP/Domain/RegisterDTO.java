package APP.Domain;


import APP.Infra.Persistence.Enum.UserRole;

public record RegisterDTO(String login, String password, UserRole role) {
}
