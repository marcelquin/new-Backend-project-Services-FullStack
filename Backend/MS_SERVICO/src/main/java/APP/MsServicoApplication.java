package APP;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "MS_Servico",
		version = "1",
		description = "Gerencia informações referentes a produtos"))
public class MsServicoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsServicoApplication.class, args);
	}

}
