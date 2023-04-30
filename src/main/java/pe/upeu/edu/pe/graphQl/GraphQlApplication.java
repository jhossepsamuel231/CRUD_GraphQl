package pe.upeu.edu.pe.graphQl;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import pe.upeu.edu.pe.graphQl.entity.Categoria;
import pe.upeu.edu.pe.graphQl.entity.Producto;
import pe.upeu.edu.pe.graphQl.repository.CategoriaRepository;
import pe.upeu.edu.pe.graphQl.repository.ProductoRepository;

import java.util.List;
import java.util.Random;
import java.util.UUID;


@SpringBootApplication
public class GraphQlApplication {

	public static void main(String[] args) {
		SpringApplication.run(GraphQlApplication.class, args);
	}
	
	
	@Bean
	CommandLineRunner commandLineRunner(CategoriaRepository categoriaRepository, ProductoRepository productoRepository){
		Random random = new Random();
		return args -> {
			List.of("Computadoras","Impresoras","SmartPhones").forEach(cat -> {
				Categoria categoria = Categoria.builder().nombre(cat).build();
				categoriaRepository.save(categoria);
			});
			categoriaRepository.findAll().forEach(categoria -> {
				for (int i = 0; i < 10; i++){
					Producto producto =	Producto.builder()
							.id(UUID.randomUUID().toString())
							.nombre("Computadora" + i)
							.precio(100 + Math.random()*50000)
							.cantidad(random.nextInt(100))
							.categoria(categoria)
							.build();
					productoRepository.save(producto);
				}
			});
		};
	}
}
