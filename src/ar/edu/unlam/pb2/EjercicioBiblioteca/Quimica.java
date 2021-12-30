package ar.edu.unlam.pb2.EjercicioBiblioteca;

public class Quimica extends LibroDeUniversidad implements Fotocopiable {

	public Quimica(String codigoLibro, String nombreLibro, String nombreAutor, String editorial) {
		super(codigoLibro, nombreLibro, nombreAutor, editorial);

	}

	@Override
	public void fotocopiable() {
		System.out.println("Se fotocopió el libro");
	}
}
