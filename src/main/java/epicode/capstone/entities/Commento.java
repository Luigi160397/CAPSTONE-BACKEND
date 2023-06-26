package epicode.capstone.entities;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "commenti")
public class Commento {
	@Id
	@GeneratedValue
	private UUID id;
	private String contenuto;
	@ManyToOne
	@JsonBackReference
	private Film film;
	@ManyToOne
	@JsonBackReference
	private User user;

	public Commento(String contenuto, Film film, User user) {
		super();
		this.contenuto = contenuto;
		this.film = film;
		this.user = user;
	}

}
