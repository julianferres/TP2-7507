package Modelo;

import java.util.ArrayList;

public class AldeanoLibre implements EstadoAldeano{
	

	@Override
	public void repararEdificio(Mapa mapa, Celda celda, Edificio edificio) {
	}

	@Override
	public ArrayList<Zona> posiblesZonasAConstruirPlazaCentral(Mapa mapa, Celda celda) {
		return null;
	}
	
	@Override
	public ArrayList<Zona> posiblesZonasAConstruirCuartel(Mapa mapa, Celda celda) {
		return null;
	}

	@Override
	public int recolectarOro() {
		return 0;
	}

	@Override
	public void construirCuartel(Zona zona, Mapa mapa) {
	}

	@Override
	public void construirPlazaCentral(Zona zona, Mapa mapa) {
	}

	public boolean aldeanoLibre(){
		return true;
	}

	public void realizarTareas(Aldeano aldeano){
		aldeano.recolectarOro();
	}

}
