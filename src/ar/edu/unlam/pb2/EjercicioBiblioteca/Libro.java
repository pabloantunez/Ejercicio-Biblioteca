package ar.edu.unlam.pb2.EjercicioBiblioteca;

public abstract class Libro {

	private String codigoLibro, nombreLibro, nombreAutor, editorial;
	private Integer cantidadCopias;

	public Libro(String codigoLibro, String nombreLibro, String nombreAutor, String editorial) {
		this.codigoLibro = codigoLibro;
		this.nombreLibro = nombreLibro;
		this.nombreAutor = nombreAutor;
		this.editorial = editorial;
		this.cantidadCopias = 3;
	}
	
	public abstract Boolean evaluarCondicion (Estudiante estudiante);
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigoLibro == null) ? 0 : codigoLibro.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Libro other = (Libro) obj;
		if (codigoLibro == null) {
			if (other.codigoLibro != null)
				return false;
		} else if (!codigoLibro.equals(other.codigoLibro))
			return false;
		return true;
	}

	public String getCodigoLibro() {
		return codigoLibro;
	}

	public void setCodigoLibro(String codigoLibro) {
		this.codigoLibro = codigoLibro;
	}

	public String getNombreLibro() {
		return nombreLibro;
	}

	public void setNombreLibro(String nombreLibro) {
		this.nombreLibro = nombreLibro;
	}

	public String getNombreAutor() {
		return nombreAutor;
	}

	public void setNombreAutor(String nombreAutor) {
		this.nombreAutor = nombreAutor;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public Integer getCantidadCopias() {
		return cantidadCopias;
	}

	public void setCantidadCopias(Integer cantidadCopias) {
		this.cantidadCopias = cantidadCopias;
	}

	@Override
	public String toString() {
		return "Libro [codigoLibro=" + codigoLibro + ", nombreLibro=" + nombreLibro + ", nombreAutor=" + nombreAutor
				+ ", editorial=" + editorial + ", cantidadCopias=" + cantidadCopias + "]";
	}
}
