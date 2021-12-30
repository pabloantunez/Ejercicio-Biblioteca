package ar.edu.unlam.pb2.EjercicioBiblioteca;

public class Prestamo {

	String dni, codigoLibro;

	public Prestamo(String dni, String codigoLibro) {
		this.dni = dni;
		this.codigoLibro = codigoLibro;
	}
	
	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getCodigoLibro() {
		return codigoLibro;
	}

	public void setCodigoLibro(String codigoLibro) {
		this.codigoLibro = codigoLibro;
	}

	@Override
	public String toString() {
		return "Prestamo [dni=" + dni + ", codigoLibro=" + codigoLibro + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigoLibro == null) ? 0 : codigoLibro.hashCode());
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
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
		Prestamo other = (Prestamo) obj;
		if (codigoLibro == null) {
			if (other.codigoLibro != null)
				return false;
		} else if (!codigoLibro.equals(other.codigoLibro))
			return false;
		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;
		return true;
	}
	
}
