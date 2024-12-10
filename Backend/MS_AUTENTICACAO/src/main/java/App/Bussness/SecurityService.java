package App.Bussness;

import App.Domain.AuthenticationDTO;
import App.Domain.LoginResponseDTO;
import App.Domain.RegisterDTO;
import App.Infra.Gateway.SecurityGateway;
import App.Infra.Persistence.Entity.User;
import App.Infra.Persistence.Repository.UserRepository;
import App.Util.TokenService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class SecurityService implements SecurityGateway {


    private final AuthenticationManager authenticationManager;
    private final UserRepository repository;
    private final TokenService tokenService;

    public SecurityService(AuthenticationManager authenticationManager, UserRepository repository, TokenService tokenService) {
        this.authenticationManager = authenticationManager;
        this.repository = repository;
        this.tokenService = tokenService;
    }

    @Override
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data)
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
    public ResponseEntity register(@RequestBody @Valid RegisterDTO data)
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
