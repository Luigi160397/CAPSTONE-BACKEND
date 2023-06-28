package epicode.capstone;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.github.javafaker.Faker;

import epicode.capstone.entities.Commento;
import epicode.capstone.entities.Film;
import epicode.capstone.entities.User;
import epicode.capstone.repositories.CommentiRepository;
import epicode.capstone.repositories.FilmsRepository;
import epicode.capstone.repositories.UsersRepository;

@Component
public class CommentiRunner implements CommandLineRunner {
	@Autowired
	UsersRepository usersRepo;
	@Autowired
	CommentiRepository commentiRepo;
	@Autowired
	FilmsRepository filmsRepo;

	@Override
	public void run(String... args) throws Exception {
		Faker faker = new Faker(new Locale("it"));
		List<User> usersDB = usersRepo.findAll();
		List<Commento> commentiDB = commentiRepo.findAll();
		List<Film> filmsDB = filmsRepo.findAll();

		if (commentiDB.size() == 0) {
			for (int i = 0; i < 40; i++) {
				try {
					int randomIndex = faker.random().nextInt(usersDB.size());
					User user = usersDB.get(randomIndex);
					int randomIndex2 = faker.random().nextInt(filmsDB.size());
					Film film = filmsDB.get(randomIndex2);
					String contenuto = faker.lorem().paragraph();
					Commento commento = new Commento(contenuto, film, user);
					commentiRepo.save(commento);
				} catch (Exception e) {
					System.out.println(e);
				}
			}
		}

	}

}
