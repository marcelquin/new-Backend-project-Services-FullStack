package App.FeignClient;




import App.Domain.Response.ClienteResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@FeignClient(name = "cliente-service", url = "http://localhost:8000/cliente/clientems")
public interface ClienteFeiginService {

    @GetMapping("/BuscarClientesPorId")
    public ResponseEntity<ClienteResponseDTO> BuscarClientesPorId(@RequestParam Long id);


}
