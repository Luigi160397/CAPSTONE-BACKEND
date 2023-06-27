package epicode.capstone.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import epicode.capstone.entities.Commento;
import epicode.capstone.entities.User;
import epicode.capstone.entities.payloads.CreaCommentoPayload;
import epicode.capstone.services.CommentiService;
import epicode.capstone.services.UsersService;

@RestController
@RequestMapping("/commenti")
public class CommentiController {
	@Autowired
	CommentiService commentiService;
	@Autowired
	UsersService usersService;

	@GetMapping("/{idFilm}")
	@PreAuthorize("hasAnyAuthority('USER', 'ADMIN')")
	public List<Commento> getCommenti(@PathVariable UUID idFilm) {
		return commentiService.find(idFilm);
	}

	@PostMapping("/{idFilm}")
	@PreAuthorize("hasAuthority('ADMIN')")
	@ResponseStatus(HttpStatus.CREATED)
	public Commento createCommento(@PathVariable UUID idFilm, @RequestBody CreaCommentoPayload body) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		User user = usersService.findByUsername(username);
		return commentiService.create(idFilm, user, body);
	}

}
