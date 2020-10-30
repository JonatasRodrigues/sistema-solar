package br.com.meli.sistema.solar.app;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "br.com.meli.sistema.solar.*")
@EnableJpaRepositories("br.com.meli.sistema.solar.repository")
@EntityScan("br.com.meli.sistema.solar.model")   
public class Application {

	 public static void main(String[] args) {
	        SpringApplication.run(Application.class, args);
	    }
}
