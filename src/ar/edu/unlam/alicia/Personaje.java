package ar.edu.unlam.alicia;

import java.util.ArrayList;
import java.util.Iterator;

public class Personaje {

	private Integer dinero;
	private Integer edad;
	private String nombre;
	private Integer peso;
	private Integer altura;
	private ArrayList<Alimento> compraAlimento;

	public Personaje(Integer altura, Integer peso, String nombre, Integer edad, Integer dinero) {
		this.altura = altura;
		this.peso = peso;
		this.nombre = nombre;
		this.edad = edad;
		this.dinero = dinero;
		compraAlimento = new ArrayList<Alimento>();
	}

	public Integer getDinero() {
		return dinero;
	}

	public ArrayList<Alimento> getCompraAlimento() {
		return compraAlimento;
	}

	public void setCompraAlimento(ArrayList<Alimento> compraAlimento) {
		this.compraAlimento = compraAlimento;
	}

	public void setDinero(Integer dinero) {
		this.dinero = dinero;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getPeso() {
		return peso;
	}

	public void setPeso(Integer peso) {
		this.peso = peso;
	}

	public Integer getAltura() {
		return altura;
	}

	public void setAltura(Integer altura) {
		this.altura = altura;
	}

	public void comprarAlimento(Alimento alimento) {
		compraAlimento.add(alimento);

	}

	public void restarImporte(Integer precio) {
		dinero = dinero - precio;
	}

	public void encojimiento() throws NoSePuedeEncojer {
		if (getAltura() >= 100) {
			setAltura(getAltura() - 50);
		} else {
			throw new NoSePuedeEncojer();
		}
	}

	public void crecer() throws NoPuedeCrecerMas {
		if (getAltura() <= 240) {
			setAltura(getAltura() + 40);
		} else {
			throw new NoPuedeCrecerMas();
		}
	}

	public Alimento buscarAlimento(String nombre) {
		Alimento buscado = null;
		for (Alimento alimento : compraAlimento) {
			if (alimento.getNombre().equals(nombre)) {
				buscado = alimento;
			}
		}
		return buscado;
	}

	public void consumirAlimento(String alimentoAcomer) throws NoPuedeCrecerMas, NoSePuedeEncojer, AlimentoInexistente {
		if (getCompraAlimento().contains(buscarAlimento(alimentoAcomer))) {
			for (Alimento alimento : compraAlimento) {
				if (alimento.getNombre().equals(alimentoAcomer) && alimento instanceof crecer) {
					crecer();
					compraAlimento.remove(alimento);
					break;
				}
			}
			for (Alimento alimento : compraAlimento) {
				if (alimento.getNombre().equals(alimentoAcomer) && alimento instanceof encoger) {
					encojimiento();
					compraAlimento.remove(alimento);
					break;
				}
			}

		} else {
			throw new AlimentoInexistente("No existe el alimento");
		}
	}
}
