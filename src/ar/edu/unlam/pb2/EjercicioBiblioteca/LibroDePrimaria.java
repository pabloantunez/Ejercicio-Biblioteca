package ar.edu.unlam.pb2.EjercicioBiblioteca;

public class LibroDePrimaria extends Libro {

	public LibroDePrimaria(String codigoLibro, String nombre, String autor, String editorial) {
		super(codigoLibro, nombre, autor, editorial);
	}

	@Override
	public Boolean evaluarCondicion(Estudiante estudiante) {
		if (estudiante.getTipo().equals(TipoEstudiante.PRIMARIO)) {
			return true;
		}
		return false;
	}

}
