package App.FeignClient;


import App.Domain.Response.ServicoResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "servico-service", url = "http://localhost:8000/servico/servicoms")
public interface ServicoFeiginService {


    @GetMapping("/BuscarServicoPorId")
    public ResponseEntity<ServicoResponseDTO> BuscarServicoPorId(@RequestParam Long id);


}
