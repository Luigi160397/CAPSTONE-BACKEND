package epicode.capstone.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import epicode.capstone.entities.Film;
import epicode.capstone.entities.User;
import epicode.capstone.entities.payloads.AggiungiPreferitiPayload;
import epicode.capstone.entities.payloads.ModificaUserPayload;
import epicode.capstone.entities.payloads.UserRegistrationPayload;
import epicode.capstone.repositories.UsersRepository;
import epicode.capstone.services.FilmsService;
import epicode.capstone.services.UsersService;

@RestController
@RequestMapping("/users")
public class UsersController {
	@Autowired
	UsersService usersService;
	@Autowired
	FilmsService filmsService;
	@Autowired
	UsersRepository usersRepo;

	@GetMapping("")
	@PreAuthorize("hasAnyAuthority('USER', 'ADMIN')")
	public Page<User> getUsers(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size,
			@RequestParam(defaultValue = "id") String sortBy) {
		return usersService.find(page, size, sortBy);
	}

	@PostMapping("")
	@PreAuthorize("hasAuthority('ADMIN')")
	@ResponseStatus(HttpStatus.CREATED)
	public User createUser(@RequestBody UserRegistrationPayload body) {
		return usersService.create(body);
	}

	@PutMapping("/{id}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public User getByIdAndUpdate(@PathVariable UUID id, @RequestBody ModificaUserPayload body) {
		return usersService.findByIdAndUpdate(id, body);
	}

	@GetMapping("/{id}")
	@PreAuthorize("hasAnyAuthority('USER', 'ADMIN')")
	public User getById(@PathVariable UUID id) throws Exception {
		return usersService.findById(id);
	}

	@DeleteMapping("/{id}")
	@PreAuthorize("hasAuthority('ADMIN')")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteUser(@PathVariable UUID id) {
		usersService.findByIdAndDelete(id);
	}

	@GetMapping("/me")
	@PreAuthorize("hasAnyAuthority('USER', 'ADMIN')")
	public User getCurrentUser() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		return usersService.findByUsername(username);
	}

	@GetMapping("/me/preferiti")
	@PreAuthorize("hasAnyAuthority('USER', 'ADMIN')")
	public List<Film> getPreferiti() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		return usersService.findByUsername(username).getPreferiti();
	}

	@PostMapping("/me/preferiti")
	@PreAuthorize("hasAnyAuthority('USER', 'ADMIN')")
	@ResponseStatus(HttpStatus.CREATED)
	public User addFilmToPreferiti(@RequestBody AggiungiPreferitiPayload payload) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		User user = usersService.findByUsername(username);

		Film film = filmsService.findById(payload.getIdFilm());

		user.addFilm(film);
		return usersRepo.save(user);
	}

	@DeleteMapping("/me/preferiti/{filmId}")
	@PreAuthorize("hasAnyAuthority('USER', 'ADMIN')")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public User removeFilmFromPreferiti(@PathVariable UUID filmId) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		User user = usersService.findByUsername(username);

		Film film = filmsService.findById(filmId);

		user.removeFilm(film);
		return usersRepo.save(user);
	}
}
