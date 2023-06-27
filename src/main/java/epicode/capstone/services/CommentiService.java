package epicode.capstone.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import epicode.capstone.entities.Commento;
import epicode.capstone.entities.Film;
import epicode.capstone.entities.User;
import epicode.capstone.entities.payloads.CreaCommentoPayload;
import epicode.capstone.repositories.CommentiRepository;

@Service
public class CommentiService {
	@Autowired
	private CommentiRepository commentiRepo;
	@Autowired
	private FilmsService filmsService;
	@Autowired
	private UsersService usersService;

	public List<Commento> find(UUID idFilm) {
		Film found = filmsService.findById(idFilm);
		return found.getCommenti();
	}

	public Commento create(UUID idFilm, User user, CreaCommentoPayload c) {
		Film found = filmsService.findById(idFilm);

		Commento newCommento = new Commento(c.getContenuto(), found, user);
		return commentiRepo.save(newCommento);
	}

}
