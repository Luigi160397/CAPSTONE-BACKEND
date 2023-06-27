package epicode.capstone.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import epicode.capstone.entities.Film;

@Repository
public interface FilmsRepository extends JpaRepository<Film, UUID> {

}
