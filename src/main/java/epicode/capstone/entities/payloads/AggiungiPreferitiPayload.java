package epicode.capstone.entities.payloads;

import java.util.UUID;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class AggiungiPreferitiPayload {
	@NotNull(message = "L'id del film è obbligatorio")
	UUID idFilm;
}
