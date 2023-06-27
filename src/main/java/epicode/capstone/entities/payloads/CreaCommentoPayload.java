package epicode.capstone.entities.payloads;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreaCommentoPayload {
	@NotNull(message = "Il contenuto è obbligatorio")
	String contenuto;

}
