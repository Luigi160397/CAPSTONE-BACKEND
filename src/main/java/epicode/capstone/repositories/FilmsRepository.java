package epicode.capstone.repositories;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import epicode.capstone.entities.Categoria;
import epicode.capstone.entities.Film;

@Repository
public interface FilmsRepository extends JpaRepository<Film, UUID> {
	Page<Film> findByCategoria(Categoria categoria, Pageable pageable);

	@Query("SELECT f FROM Film f WHERE f.nome LIKE %:nome%")
	Page<Film> findByNome(String nome, Pageable pageable);
}
