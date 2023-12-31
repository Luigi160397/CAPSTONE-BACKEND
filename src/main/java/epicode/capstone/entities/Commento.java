package epicode.capstone.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
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
	@Column(columnDefinition = "TEXT")
	private String contenuto;
	@ManyToOne
	@JsonBackReference
	private Film film;
	@ManyToOne
	@JsonIgnoreProperties({ "preferiti" })
	private User user;
	private LocalDateTime dataOra;

	public Commento(String contenuto, Film film, User user) {
		super();
		this.contenuto = contenuto;
		this.film = film;
		this.user = user;
		this.dataOra = LocalDateTime.now();
	}

}
