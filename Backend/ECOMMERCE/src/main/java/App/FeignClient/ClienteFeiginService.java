package App.FeignClient;



import App.Domain.MsServicesDTO.ClienteDTO;
import App.Domain.MsServicesDTO.ClienteResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@FeignClient(name = "cliente-service", url = "http://localhost:8000/cliente/clientems")
public interface ClienteFeiginService {

    @GetMapping("/BuscarClientesPorId")
    public ClienteResponseDTO BuscarClientesPorId(@RequestParam Long id);


}
