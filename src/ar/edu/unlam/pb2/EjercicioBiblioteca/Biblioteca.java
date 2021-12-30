package ar.edu.unlam.pb2.EjercicioBiblioteca;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Biblioteca {

	private String nombre;
	private List<Libro> libros;
	private List<Prestamo> prestamos;

	public Biblioteca(String nombre) {
		this.nombre = nombre;
		this.libros = new ArrayList<Libro>();
		this.prestamos = new LinkedList<Prestamo>();
	}

	public Boolean agregarLibro(Libro libro) throws YaExisteElLibroException {

		// libro ya existente en biblioteca.

		Boolean yaExisteElLibro = verificarExistenciaDeLibro(libro);
		if (yaExisteElLibro) {
			throw new YaExisteElLibroException ("Ya existe el libro en la biblioteca");
		}
		return this.libros.add(libro);	
	}

	private Boolean verificarExistenciaDeLibro(Libro libro) {
		return libros.contains(libro);
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Libro> getLibros() {
		return libros;
	}

	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}

	public List<Prestamo> getPrestamos() {
		return prestamos;
	}

	public void setPrestamos(List<Prestamo> prestamos) {
		this.prestamos = prestamos;
	}

	
}
