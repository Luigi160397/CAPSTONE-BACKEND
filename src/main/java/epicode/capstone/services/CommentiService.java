package epicode.capstone.services;

import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import epicode.capstone.entities.Commento;
import epicode.capstone.entities.Film;
import epicode.capstone.entities.User;
import epicode.capstone.entities.payloads.CreaCommentoPayload;
import epicode.capstone.exceptions.NotFoundException;
import epicode.capstone.repositories.CommentiRepository;

@Service
public class CommentiService {
	@Autowired
	private CommentiRepository commentiRepo;
	@Autowired
	private FilmsService filmsService;

	public List<Commento> find(UUID idFilm) {
		Film found = filmsService.findById(idFilm);
		return found.getCommenti();
	}

	public Commento create(UUID idFilm, User user, CreaCommentoPayload c) {
		Film found = filmsService.findById(idFilm);

		Commento newCommento = new Commento(c.getContenuto(), found, user);
		return commentiRepo.save(newCommento);
	}

	public Commento findById(UUID id) throws NotFoundException {
		return commentiRepo.findById(id).orElseThrow(() -> new NotFoundException("Commento non trovato!"));

	}

	public Commento findByIdAndUpdate(UUID idFilm, UUID idCommento, User user, CreaCommentoPayload c) {
		Commento commento = this.findById(idCommento);
		Film film = filmsService.findById(idFilm);
		commento.setId(idCommento);
		commento.setContenuto(c.getContenuto());
		commento.setFilm(film);
		commento.setUser(user);
		return commentiRepo.save(commento);

	}

	public void findByIdAndDelete(UUID idFilm, UUID idCommento) throws NotFoundException {
		List<Commento> listaCommentiFilm = filmsService.findById(idFilm).getCommenti();
		Iterator<Commento> iter = listaCommentiFilm.iterator();
		while (iter.hasNext()) {
			Commento commento = iter.next();
			if (commento.getId().equals(idCommento)) {
				iter.remove();
				break;
			}
		}
		Commento commento = this.findById(idCommento);
		commentiRepo.delete(commento);
	}

}
