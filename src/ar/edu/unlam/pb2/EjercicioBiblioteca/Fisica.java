package ar.edu.unlam.pb2.EjercicioBiblioteca;

public class Fisica extends LibroDeUniversidad implements Fotocopiable{

	public Fisica(String codigoLibro, String nombreLibro, String nombreAutor, String editorial) {
		super(codigoLibro, nombreLibro, nombreAutor, editorial);
	}

	@Override
	public void fotocopiable() {
		System.out.println("El libro de Fisica fue fotocopiado.");
	}

}
