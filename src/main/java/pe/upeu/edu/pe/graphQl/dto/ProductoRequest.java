package pe.upeu.edu.pe.graphQl.dto;

public record ProductoRequest(
		String id,
		String nombre,
		double precio, 
		int cantidad,
		long categoriaId
		) {

}
