package epicode.capstone.entities.payloads;

import epicode.capstone.entities.Categoria;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreaFilmPayload {

	@NotNull(message = "Il nome è obbligatorio")
	String nome;
	@NotNull(message = "L'URL della copertina è obbligatorio")
	String urlCopertina;
	@NotNull(message = "La categoria è obbligatoria")
	Categoria categoria;
	@NotNull(message = "La descrizione è obbligatoria")
	String descrizione;
	@NotNull(message = "Il voto è obbligatorio")
	String voto;
}
