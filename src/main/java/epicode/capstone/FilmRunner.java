package epicode.capstone;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import epicode.capstone.entities.Film;
import epicode.capstone.repositories.FilmsRepository;

@Component
public class FilmRunner implements CommandLineRunner {
	@Autowired
	FilmsRepository filmRepo;

	@Override
	public void run(String... args) throws Exception {
		List<Film> filmDB = filmRepo.findAll();
//		if (filmDB.size() == 0) {
//			Film film1 = new Film(null, null, null, null, null);
//
//		}
	}

}
