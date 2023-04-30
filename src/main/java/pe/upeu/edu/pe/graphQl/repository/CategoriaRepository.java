package pe.upeu.edu.pe.graphQl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.upeu.edu.pe.graphQl.entity.Categoria;


public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
