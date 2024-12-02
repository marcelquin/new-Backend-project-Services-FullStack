package App.Bussness;


import App.Domain.Response.AuthenticationDTO;
import App.Domain.Response.LoginResponseDTO;
import App.Domain.Response.RegisterDTO;
import App.FeignClient.SecurityClienteFeiginService;
import App.FeignClient.SecurityFinanceiroFeiginService;
import App.FeignClient.SecurityServicoFeiginService;
import App.Infra.Gateway.SecurityGateway;
import App.Infra.Persistence.Entity.User;
import App.Infra.Persistence.Repository.UserRepository;
import App.Util.TokenService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class SecurityService implements SecurityGateway {

    private AuthenticationManager authenticationManager;
    private final UserRepository repository;
    private final TokenService tokenService;
    private final SecurityClienteFeiginService securityClienteFeiginService;
    private final SecurityServicoFeiginService securityServicoFeiginService;
    private final SecurityFinanceiroFeiginService securityFinanceiroFeiginService;

    public SecurityService(UserRepository repository, TokenService tokenService, SecurityClienteFeiginService securityClienteFeiginService, SecurityServicoFeiginService securityServicoFeiginService, SecurityFinanceiroFeiginService securityFinanceiroFeiginService) {
        this.repository = repository;
        this.tokenService = tokenService;
        this.securityClienteFeiginService = securityClienteFeiginService;
        this.securityServicoFeiginService = securityServicoFeiginService;
        this.securityFinanceiroFeiginService = securityFinanceiroFeiginService;
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
            securityServicoFeiginService.register(data);
            //securityClienteFeiginService.register(data);
            //securityFinanceiroFeiginService.register(data);
            return ResponseEntity.ok().build();
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return null;
    }


}
