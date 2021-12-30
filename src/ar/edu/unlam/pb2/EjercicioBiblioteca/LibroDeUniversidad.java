package ar.edu.unlam.pb2.EjercicioBiblioteca;

public class LibroDeUniversidad extends Libro{

	public LibroDeUniversidad(String codigoLibro, String nombreLibro, String nombreAutor, String editorial) {
		super(codigoLibro, nombreLibro, nombreAutor, editorial);
	}

	@Override
	public Boolean evaluarCondicion(Estudiante estudiante) {
		if (estudiante.getTipo().equals(TipoEstudiante.UNIVERSITARIO)) {
			return true;
		}
		return false;
	}
}
