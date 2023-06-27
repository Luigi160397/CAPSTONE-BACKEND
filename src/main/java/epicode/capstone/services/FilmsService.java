package epicode.capstone.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import epicode.capstone.entities.Categoria;
import epicode.capstone.entities.Film;
import epicode.capstone.entities.payloads.CreaFilmPayload;
import epicode.capstone.exceptions.NotFoundException;
import epicode.capstone.repositories.FilmsRepository;

@Service
public class FilmsService {
	@Autowired
	private FilmsRepository filmsRepo;

	public Page<Film> find(int page, int size, String sortBy, Categoria categoria, String nome) {
		if (size < 0)
			size = 10;
		if (size > 100)
			size = 100;
		Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
		if (categoria != null) {
			return filmsRepo.findByCategoria(categoria, pageable);
		} else if (!nome.equals("")) {
			return filmsRepo.findByNome(nome, pageable);
		} else {
			return filmsRepo.findAll(pageable);
		}
	}

	public Film findById(UUID id) throws NotFoundException {
		return filmsRepo.findById(id).orElseThrow(() -> new NotFoundException("Film non trovato!"));

	}

	public Film create(CreaFilmPayload u) {

		Film newFilm = new Film(u.getNome(), u.getUrlCopertina(), u.getCategoria(), u.getDescrizione(), u.getVoto());
		return filmsRepo.save(newFilm);
	}

	public Film findByIdAndUpdate(UUID id, CreaFilmPayload f) {
		Film found = this.findById(id);
		found.setId(id);
		found.setNome(f.getNome());
		found.setUrlCopertina(f.getUrlCopertina());
		found.setCategoria(f.getCategoria());
		found.setDescrizione(f.getDescrizione());
		found.setVoto(f.getVoto());
		found.setCommenti(found.getCommenti());
		found.setUsers(found.getUsers());
		return filmsRepo.save(found);

	}

	public void findByIdAndDelete(UUID id) throws NotFoundException {
		Film found = this.findById(id);
		filmsRepo.delete(found);
	}
}
