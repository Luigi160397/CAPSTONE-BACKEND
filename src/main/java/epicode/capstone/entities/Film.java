package epicode.capstone.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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
	@OneToMany(mappedBy = "film")
	@JsonManagedReference
	private List<Commento> commenti;
	@ManyToMany(mappedBy = "preferiti")
	@JsonIgnore
	private List<User> users;

	public Film(String nome, String urlCopertina, Categoria categoria, String descrizione, String voto) {
		super();
		this.nome = nome;
		this.urlCopertina = urlCopertina;
		this.categoria = categoria;
		this.descrizione = descrizione;
		this.voto = voto;
		this.commenti = new ArrayList<>();
		this.users = new ArrayList<>();
	}

}
