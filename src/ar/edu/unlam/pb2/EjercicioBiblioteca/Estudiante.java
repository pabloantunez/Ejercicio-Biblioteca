package ar.edu.unlam.pb2.EjercicioBiblioteca;

public class Estudiante {
	private String dni, nombreCompleto;
	private TipoEstudiante tipo;

	public Estudiante(String dni, String nombreCompleto, TipoEstudiante tipo) {
		this.dni = dni;
		this.nombreCompleto = nombreCompleto;
		this.tipo = tipo;
	}

	public void retirarLibro(Libro libro, Biblioteca biblioteca)
			throws NoHayMasCopiasDelLibroException, NoExisteElLibroEnLaBibliotecaException,
			YaRetiroMasDeDosLibrosException, NoCoincideElEstudianteConElTipoDeLibroException {

		if (!biblioteca.getLibros().contains(libro)) { // que no exista el libro
			throw new NoExisteElLibroEnLaBibliotecaException("No Existe el libro en la biblioteca");
		}
		if (libro.getCantidadCopias() == 0) { // que no hayan mas ejemplares
			throw new NoHayMasCopiasDelLibroException("No hay más copias disponibles del libro");
		}
		if (!evaluarCondicionDePrestamos(biblioteca)) { // que ya haya retirado 2 libros
			throw new YaRetiroMasDeDosLibrosException("Ya retiro el máximo de libros permitidos");
		}
		if (!libro.evaluarCondicion(this)) {
			throw new NoCoincideElEstudianteConElTipoDeLibroException("No puede retirar el libro por no coincidir estudiante");
		}
		libro.setCantidadCopias(libro.getCantidadCopias() - 1);
		Prestamo prestamo = new Prestamo (this.dni, libro.getCodigoLibro());
		biblioteca.getPrestamos().add(prestamo);// es necesario crear un
		// prestamo para pasarselo.
	}

	private boolean evaluarCondicionDePrestamos(Biblioteca biblioteca) {
		Integer contadorDePrestamos = 0;
		for (Prestamo prestamo : biblioteca.getPrestamos()) {
			if (prestamo.getDni().equals(this.dni)) {
				contadorDePrestamos++;
			}
		}
		return contadorDePrestamos < 2;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public TipoEstudiante getTipo() {
		return tipo;
	}

	public void setTipo(TipoEstudiante tipo) {
		this.tipo = tipo;
	}

	public void devolverLibro(Libro libro, Biblioteca biblioteca) throws NoTieneLibroAsignadoException {
		Prestamo prestamo = new Prestamo(this.dni, libro.getCodigoLibro());
		if (!biblioteca.getPrestamos().contains(prestamo)) {
			throw new NoTieneLibroAsignadoException("El estudiante no tiene asignado dicho libro");
		}
		libro.setCantidadCopias(libro.getCantidadCopias() + 1);
		biblioteca.getPrestamos().remove(prestamo);

	}

}
