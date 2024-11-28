package App.Bussness;


import App.Bussness.Util.TokenService;
import App.Domain.AuthenticationDTO;
import App.Domain.LoginResponseDTO;
import App.Domain.RegisterDTO;
import App.Infra.Gateway.AuthorizationGateway;
import App.Infra.Persistence.Entity.User;
import App.Infra.Persistence.Repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class JWTService implements AuthorizationGateway {

    private AuthenticationManager authenticationManager;
    private final UserRepository repository;
    private final TokenService tokenService;

    public JWTService(UserRepository repository, TokenService tokenService) {
        this.repository = repository;
        this.tokenService = tokenService;
    }

    @Override
    public ResponseEntity login(AuthenticationDTO data)
    {
        try
        {
            var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
            var auth = this.authenticationManager.authenticate(usernamePassword);

            var token = tokenService.generateToken((User) auth.getPrincipal());

            return ResponseEntity.ok(new LoginResponseDTO(token));
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return null;
    }

    @Override
    public ResponseEntity register(RegisterDTO data)
    {
        try
        {
            if(this.repository.findByLogin(data.login()) != null) return ResponseEntity.badRequest().build();

            String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
            User newUser = new User(data.login(), encryptedPassword, data.role());
            this.repository.save(newUser);

            return ResponseEntity.ok().build();
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return null;
    }

}
