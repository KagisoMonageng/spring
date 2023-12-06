package mercurystoreapi.store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class StoreApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(StoreApiApplication.class, args);
	}

	@GetMapping
	public String defaultGet(){
		return "<div style='width: 100%; height:100vh; display:flex; flex-direction:column;gap:1rem ; justify-content:center; place-items:center;'> <div style='width:100px; height:100px; background-color: green; border-radius:50%'></div><h1 style='font-family:sans-serif;padding:0;margin:0;'> Server is running</h1> <p style='padding:0;margin:0;font-family:sans-serif;'>Ready to take your requests</p></div>";
	}

}
