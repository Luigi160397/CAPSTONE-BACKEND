package epicode.capstone.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import epicode.capstone.entities.User;
import epicode.capstone.entities.payloads.ModificaUserPayload;
import epicode.capstone.entities.payloads.UserRegistrationPayload;
import epicode.capstone.exceptions.BadRequestException;
import epicode.capstone.exceptions.NotFoundException;
import epicode.capstone.repositories.UsersRepository;

@Service
public class UsersService {
	@Autowired
	private UsersRepository usersRepo;
	@Autowired
	private FilmsService filmsService;

	public Page<User> find(int page, int size, String sortBy) {
		if (size < 0)
			size = 10;
		if (size > 100)
			size = 100;
		Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));

		return usersRepo.findAll(pageable);
	}

	public User findById(UUID id) throws NotFoundException {
		return usersRepo.findById(id).orElseThrow(() -> new NotFoundException("Utente non trovato!"));

	}

	public User findByIdAndUpdate(UUID id, ModificaUserPayload u) {
		User found = this.findById(id);
		found.setId(id);
		found.setUsername(found.getUsername());
		found.setEmail(u.getEmail());
		found.setPassword(found.getPassword());
		found.setNome(u.getNome());
		found.setCognome(u.getCognome());
		found.setRole(u.getRole());
		found.setCommenti(found.getCommenti());
		found.setPreferiti(found.getPreferiti());
		return usersRepo.save(found);

	}

	public User create(UserRegistrationPayload u) {

		usersRepo.findByEmail(u.getEmail()).ifPresent(user -> {
			throw new BadRequestException("Email " + user.getEmail() + " already in use!");
		});
		User newUser = new User(u.getUsername(), u.getEmail(), u.getPassword(), u.getNome(), u.getCognome());
		return usersRepo.save(newUser);
	}

	public User findByEmail(String email) throws NotFoundException {
		return usersRepo.findByEmail(email)
				.orElseThrow(() -> new NotFoundException("Utente con questa mail: " + email + " non trovato!"));
	}

	public User findByUsername(String username) throws NotFoundException {
		return usersRepo.findByUsername(username)
				.orElseThrow(() -> new NotFoundException("Nessun utente con username: " + username + " trovato"));
	}

	public void findByIdAndDelete(UUID id) throws NotFoundException {
		User found = this.findById(id);
		usersRepo.delete(found);
	}

}
