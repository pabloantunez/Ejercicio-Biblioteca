package ar.edu.unlam.pb2.EjercicioBiblioteca;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class BibliotecaTest {

	@Test
	public void sePudoCrearLaBiblioteca() {
		Biblioteca biblioteca = new Biblioteca("Biblioteca de la Nación");
		assertNotNull(biblioteca);
	}

	@Test
	public void sePuedeAgregarUnLibro() throws YaExisteElLibroException {
		Biblioteca biblioteca = new Biblioteca("Biblioteca de la Nación");
		Libro lengua = new LibroDePrimaria("9", "Pocajontas", "Disney", "Sueños");
		Boolean valorObtenido = biblioteca.agregarLibro(lengua);

		assertTrue(valorObtenido);
	}

	@Test(expected = YaExisteElLibroException.class)
	public void noSePuedeAgregarUnLibro() throws YaExisteElLibroException {
		Biblioteca biblioteca = new Biblioteca("Biblioteca de la Nación");
		Libro lengua = new LibroDePrimaria("9", "Pocajontas", "Disney", "Sueños");
		Libro lengua2 = new LibroDePrimaria("9", "Harry", "Potter", "Sueños");

		biblioteca.agregarLibro(lengua);
		biblioteca.agregarLibro(lengua2);
	}

	@Test
	public void sePudoCrearUnEstudiante() {
		Estudiante estudiante = new Estudiante("89087765", "Cristian Gonzalez", TipoEstudiante.UNIVERSITARIO);
		assertNotNull(estudiante);
	}


	@Test(expected = NoHayMasCopiasDelLibroException.class)
	public void noSePudoPrestarElLibroPorqueNoHayMasCopias()
			throws NoHayMasCopiasDelLibroException, NoExisteElLibroEnLaBibliotecaException,
			YaRetiroMasDeDosLibrosException, YaExisteElLibroException, NoCoincideElEstudianteConElTipoDeLibroException {
		Biblioteca biblioteca = new Biblioteca("Biblioteca de la Nación");
		Libro libroQuimica = new Quimica("10", "Quimica 1", "Juan", "Los Bosques");
		Estudiante estudiante = new Estudiante("89087765", "Cristian Gonzalez", TipoEstudiante.UNIVERSITARIO);
		Estudiante estudiante2 = new Estudiante("8909854", "Pablo Antúnez", TipoEstudiante.UNIVERSITARIO);
		Estudiante estudiante3 = new Estudiante("1234566", "Gabriel Celestino", TipoEstudiante.UNIVERSITARIO);
		biblioteca.agregarLibro(libroQuimica);
		estudiante.retirarLibro(libroQuimica, biblioteca);
		estudiante.retirarLibro(libroQuimica, biblioteca);
		estudiante2.retirarLibro(libroQuimica, biblioteca);
		estudiante3.retirarLibro(libroQuimica, biblioteca);
	}

	@Test(expected = NoExisteElLibroEnLaBibliotecaException.class)
	public void noSePudoPrestarElLibroPorqueNoExisteEnLaBiblioteca()
			throws NoHayMasCopiasDelLibroException, NoExisteElLibroEnLaBibliotecaException,
			YaRetiroMasDeDosLibrosException, YaExisteElLibroException, NoCoincideElEstudianteConElTipoDeLibroException {
		Biblioteca biblioteca = new Biblioteca("Biblioteca de la Nación");
		Libro libroQuimica = new Quimica("10", "Quimica 1", "Juan", "Los Bosques");
		Estudiante estudiante = new Estudiante("89087765", "Cristian Gonzalez", TipoEstudiante.UNIVERSITARIO);
		estudiante.retirarLibro(libroQuimica, biblioteca);
	}

	@Test(expected = YaRetiroMasDeDosLibrosException.class)
	public void noSePudoPrestarElLibroPorqueYaRetiroElMaximoPermitido()
			throws NoHayMasCopiasDelLibroException, NoExisteElLibroEnLaBibliotecaException,
			YaRetiroMasDeDosLibrosException, YaExisteElLibroException, NoCoincideElEstudianteConElTipoDeLibroException {
		Biblioteca biblioteca = new Biblioteca("Biblioteca de la Nación");
		Libro libroQuimica = new Quimica("10", "Quimica 1", "Juan", "Los Bosques");
		Estudiante estudiante = new Estudiante("89087765", "Cristian Gonzalez", TipoEstudiante.UNIVERSITARIO);
		biblioteca.agregarLibro(libroQuimica);
		estudiante.retirarLibro(libroQuimica, biblioteca);
		estudiante.retirarLibro(libroQuimica, biblioteca);
		estudiante.retirarLibro(libroQuimica, biblioteca);
	}
	
	@Test(expected = NoCoincideElEstudianteConElTipoDeLibroException.class)
	public void noSePudoRetirarElLibroPorqueNoCoincidenLosEstudiantesConElTipoDeLibro()
			throws NoHayMasCopiasDelLibroException, NoExisteElLibroEnLaBibliotecaException,
			YaRetiroMasDeDosLibrosException, YaExisteElLibroException, NoCoincideElEstudianteConElTipoDeLibroException {
		Biblioteca biblioteca = new Biblioteca("Biblioteca de la Nación");
		Libro libroHistoria = new Historia("10", "Quimica 1", "Juan", "Los Bosques");
		Estudiante estudiante = new Estudiante("89087765", "Cristian Gonzalez", TipoEstudiante.UNIVERSITARIO);
		biblioteca.agregarLibro(libroHistoria);
		estudiante.retirarLibro(libroHistoria, biblioteca);
		estudiante.retirarLibro(libroHistoria, biblioteca);
		estudiante.retirarLibro(libroHistoria, biblioteca);
	}
	
	@Test
	public void alDevolverLosLibrosPermiteRetirarOtroNuevo() throws YaExisteElLibroException,
			NoHayMasCopiasDelLibroException, NoExisteElLibroEnLaBibliotecaException, YaRetiroMasDeDosLibrosException, NoCoincideElEstudianteConElTipoDeLibroException, NoTieneLibroAsignadoException {
		Biblioteca biblioteca = new Biblioteca("Biblioteca de la Nación");
		Estudiante estudiante = new Estudiante("89087765", "Cristian Gonzalez", TipoEstudiante.UNIVERSITARIO);
		Libro libroQuimica = new Quimica("10", "Quimica 1", "Juan", "Los Bosques");
		Libro libroQuimica2 = new Quimica("11", "Quimica 1", "Juan", "Los Bosques");
		biblioteca.agregarLibro(libroQuimica);
		biblioteca.agregarLibro(libroQuimica2);
		estudiante.retirarLibro(libroQuimica, biblioteca);
		estudiante.retirarLibro(libroQuimica2, biblioteca);
		estudiante.devolverLibro (libroQuimica,biblioteca);
		estudiante.devolverLibro (libroQuimica2,biblioteca);	
		estudiante.retirarLibro(libroQuimica, biblioteca);
		estudiante.retirarLibro(libroQuimica2, biblioteca);
		estudiante.devolverLibro (libroQuimica,biblioteca);
		estudiante.devolverLibro (libroQuimica2,biblioteca);
	}
	
	@Test (expected = NoTieneLibroAsignadoException.class)
	public void alDevolverElLibroElMismoNoEstabaAsignadoAlEstudiante () throws YaExisteElLibroException, NoHayMasCopiasDelLibroException, NoExisteElLibroEnLaBibliotecaException, YaRetiroMasDeDosLibrosException, NoCoincideElEstudianteConElTipoDeLibroException, NoTieneLibroAsignadoException {
		Biblioteca biblioteca = new Biblioteca("Biblioteca de la Nación");
		Estudiante estudiante = new Estudiante("89087765", "Cristian Gonzalez", TipoEstudiante.UNIVERSITARIO);
		Estudiante estudiante2 = new Estudiante("79087765", "Pablo Antúnez", TipoEstudiante.UNIVERSITARIO);
		Libro libroQuimica = new Quimica("10", "Quimica 1", "Juan", "Los Bosques");
		biblioteca.agregarLibro(libroQuimica);
		estudiante.retirarLibro(libroQuimica, biblioteca);
		estudiante2.devolverLibro (libroQuimica,biblioteca);				
	}	
}
