package epicode.capstone.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "films")
public class Film {
	@Id
	@GeneratedValue
	private UUID id;
	private String nome;
	private String urlCopertina;
	@Enumerated(EnumType.STRING)
	private Categoria categoria;
	@Column(columnDefinition = "TEXT")
	private String descrizione;
	private String voto;
	private String durata;
	private String annoUscita;
	private String urlTrailer;
	@OneToMany(mappedBy = "film", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Commento> commenti;
	@ManyToMany(mappedBy = "preferiti")
	@JsonIgnore
	private List<User> users;

	public Film(String nome, String urlCopertina, Categoria categoria, String descrizione, String voto, String durata,
			String annoUscita, String urlTrailer) {
		super();
		this.nome = nome;
		this.urlCopertina = urlCopertina;
		this.categoria = categoria;
		this.descrizione = descrizione;
		this.voto = voto;
		this.durata = durata;
		this.annoUscita = annoUscita;
		this.urlTrailer = urlTrailer;
		this.commenti = new ArrayList<>();
		this.users = new ArrayList<>();
	}

}
