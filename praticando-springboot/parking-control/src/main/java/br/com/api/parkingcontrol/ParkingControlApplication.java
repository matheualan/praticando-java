package br.com.api.parkingcontrol;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ParkingControlApplication {

	public static void main(String[] args) {
		SpringApplication.run(ParkingControlApplication.class, args);
	}

//	Despached Servlet é a ferramenta/dispositivo que recebe a requisição e faz o roteamento
//	por "de baixo dos panos" para definir qual controller  vai receber e responder a requisição
	@GetMapping("/")
	public String index() {
		return "Olá Mundo!" +
				"\nVocê está na classe Main do Projeto!";
	}

}
