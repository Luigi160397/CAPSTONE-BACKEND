package epicode.capstone.auth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
public class SwaggerConfiguration {
	// TODO correggere le info
	@Bean
	public OpenAPI openAPI() {
		return new OpenAPI().addSecurityItem(new SecurityRequirement().addList("Bearer Authentication"))
				.components(new Components().addSecuritySchemes("Bearer Authentication", createAPIKeyScheme()))
				.info(new Info().title("FilmVerse REST API")
						.description("API per le funzionalità di FilmVerse, il portale per gli amanti del cinema.")
						.version("1.0")
						.contact(new Contact().name("Luigi Di Fraia").email("luigi.difraia.97@gmail.com")
								.url("https://portfolio-luigi-di-fraia.vercel.app/"))
						.license(new License().name("License of API").url("API license URL")));
	}

	private SecurityScheme createAPIKeyScheme() {
		return new SecurityScheme().type(SecurityScheme.Type.HTTP).bearerFormat("JWT").scheme("bearer");
	}

}