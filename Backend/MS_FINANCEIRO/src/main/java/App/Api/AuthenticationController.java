package App.Api;



import App.Domain.AuthenticationDTO;
import App.Domain.RegisterDTO;
import App.Infra.UseCase.Security.UseCaseAuthorizationPost;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("ms_produtoauth")
@Tag(name = "Security ms_produto",
        description = "Gerencia informações referente a entidade")
@CrossOrigin(origins = "*")
public class AuthenticationController {
   private final UseCaseAuthorizationPost caseAuthorizationPost;

    public AuthenticationController(UseCaseAuthorizationPost caseAuthorizationPost) {
        this.caseAuthorizationPost = caseAuthorizationPost;
    }

    @Operation(summary = "Faz a verificação e retorna token de autenticação", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Ops algoo deu errado"),
    })
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data){
        return caseAuthorizationPost.login(data);
    }

    @Operation(summary = "Salva novo Registro na tabela", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Ops algoo deu errado"),
    })
    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterDTO data){
       return caseAuthorizationPost.register(data);
    }
}
