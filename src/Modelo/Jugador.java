package Modelo;

import java.util.ArrayList;

public class Jugador {

	ArrayList<Edificio> edificios;
	ArrayList<Unidad> unidades;
	ArrayList<Aldeano> aldeanos;
	private int cantidadDeOro;
	
	public Jugador(int cantidadDeOro){
		this.cantidadDeOro = cantidadDeOro;
		this.edificios = new ArrayList<Edificio>();
		this.unidades = new ArrayList<Unidad>();
		this.aldeanos = new ArrayList<Aldeano>();
	}

	public void agregarObjetivo(Aldeano aldeano){
		aldeanos.add(aldeano);
	}

	public void agregarObjetivo(Unidad unidad) { unidades.add(unidad);}

	public void agregarObjetivo(Edificio edificio){edificios.add(edificio);}

	public void eliminarObjetivo(Aldeano aldeano){
		aldeanos.remove(aldeano);
	}
	public void eliminarObjetivo(Unidad unidad){
		unidades.remove(unidad);
	}
	public void eliminarObjetivo(Edificio edificio){
		edificios.remove(edificio);
	}

	public void aumentarOro(int monto){
		this.cantidadDeOro += monto;
	}

	public int cantidadDeOro(){
		return this.cantidadDeOro;
	}

	/*

	Ver, quizas sea algo similar a agregarObjetivo.
	public boolean lePerteneceObjetivo(Objetivo objetivo){
		return objetivos.contains(objetivo);
	}

	*/

}