package ar.edu.unlam.alicia;

import java.util.ArrayList;
import java.util.HashSet;

public class Supermercado {
	
	
	private String nombre;
	private HashSet<Alimento>alimentos;
	private ArrayList<Alimento>alimentosEnStock;
	public Supermercado(String nombre) {
		this.nombre = nombre;
		alimentos = new HashSet<Alimento>();
		alimentosEnStock = new ArrayList<Alimento>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public HashSet<Alimento> getAlimentos() {
		return alimentos;
	}

	public void setAlimentos(HashSet<Alimento> alimentos) {
		this.alimentos = alimentos;
	}

	public ArrayList<Alimento> getAlimentosEnStock() {
		return alimentosEnStock;
	}

	public void setAlimentosEnStock(ArrayList<Alimento> alimentosEnStock) {
		this.alimentosEnStock = alimentosEnStock;
	}
	public void agregarAlimento(Alimento alimento) {
		if(alimentos.contains(alimento)) {
			alimentosEnStock.add(alimento);
		}else {
			alimentos.add(alimento);
			alimentosEnStock.add(alimento);
		}
	}

	public void venderAlimento(String alimentoAVender, Personaje personaje) throws NoTeAlcanzaElDinero {
		for (Alimento alimento : alimentosEnStock) {
			if(alimento.getNombre().equals(alimentoAVender)) {
				if(personaje.getDinero()>= alimento.getValor()) {
				personaje.comprarAlimento(alimento);
				personaje.restarImporte(alimento.getValor());
				alimentosEnStock.remove(alimento);
				break;
				}else {
					throw new NoTeAlcanzaElDinero();
				}
			}
		}
		
	}
	

}
