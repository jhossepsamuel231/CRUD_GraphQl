package pe.upeu.edu.pe.graphQl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.upeu.edu.pe.graphQl.entity.Producto;

public interface ProductoRepository extends JpaRepository<Producto, String> {
}
