package ar.edu.unlam.pb2.EjercicioBiblioteca;

public class LibroDeSecundaria extends Libro {

	public LibroDeSecundaria(String codigoLibro, String nombreLibro, String nombreAutor, String editorial) {
		super(codigoLibro, nombreLibro, nombreAutor, editorial);
	}
	
	@Override
	public Boolean evaluarCondicion(Estudiante estudiante) {
		if (estudiante.getTipo().equals(TipoEstudiante.SECUNDARIO)) {
			return true;
		}
		return false;
	}

}
