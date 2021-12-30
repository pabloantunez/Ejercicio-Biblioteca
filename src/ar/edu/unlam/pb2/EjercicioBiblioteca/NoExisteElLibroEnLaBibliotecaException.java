package ar.edu.unlam.pb2.EjercicioBiblioteca;

public class NoExisteElLibroEnLaBibliotecaException extends Exception {
	
	public NoExisteElLibroEnLaBibliotecaException (String mensaje) {
		super (mensaje);
	}
}
