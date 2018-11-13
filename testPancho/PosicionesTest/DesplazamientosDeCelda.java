package PosicionesTest;

import org.junit.Assert;
import org.junit.Test;

import Modelo.Celda;

public class DesplazamientosDeCelda {

	@Test
	public void test01DesplazamientoHaciaLaDerechaUnCasillero(){
		
		Celda posicion = new Celda(0, 0);
		Celda posicionDesplazada = new Celda(1, 0);
		
		posicion.desplazarDerecha();
		
		Assert.assertTrue(posicion.igualA(posicionDesplazada));
	}
	
	@Test
	public void test02DesplazamientoHaciaLaIzquierdaUnCasillero(){
		
		Celda posicion = new Celda(0, 0);
		Celda posicionDesplazada = new Celda(-1, 0);
		
		posicion.desplazarIzquierda();
		
		Assert.assertTrue(posicion.igualA(posicionDesplazada));
	}
	
	@Test
	public void test03DesplazamientoHaciaArribaUnCasillero(){
		
		Celda posicion = new Celda(0, 0);
		Celda posicionDesplazada = new Celda(0, 1);
		
		posicion.desplazarArriba();
		
		Assert.assertTrue(posicion.igualA(posicionDesplazada));
	}
	
	@Test
	public void test04DesplazamientoHaciaAbajoUnCasillero(){
		
		Celda posicion = new Celda(0, 0);
		Celda posicionDesplazada = new Celda(0, -1);
		
		posicion.desplazarAbajo();
		
		Assert.assertTrue(posicion.igualA(posicionDesplazada));
	}
	
	@Test
	public void test05DesplazamientoHaciaArribaIzquierdaUnCasillero(){
		
		Celda posicion = new Celda(0, 0);
		Celda posicionDesplazada = new Celda(-1, 1);
		
		posicion.desplazarArribaIzquierda();
		
		Assert.assertTrue(posicion.igualA(posicionDesplazada));
	}
	
	@Test
	public void test06DesplazamientoHaciaArribaDerechaUnCasillero(){
		
		Celda posicion = new Celda(0, 0);
		Celda posicionDesplazada = new Celda(1, 1);
		
		posicion.desplazarArribaDerecha();
		
		Assert.assertTrue(posicion.igualA(posicionDesplazada));
	}
	
	@Test
	public void test07DesplazamientoHaciaAbajoIzquierdaUnCasillero(){
		
		Celda posicion = new Celda(0, 0);
		Celda posicionDesplazada = new Celda(-1, -1);
		
		posicion.desplazarAbajoIzquierda();
		
		Assert.assertTrue(posicion.igualA(posicionDesplazada));
	}
	
	@Test
	public void test08DesplazamientoHaciaAbajoDerechaUnCasillero(){
		
		Celda posicion = new Celda(0, 0);
		Celda posicionDesplazada = new Celda(1, -1);
		
		posicion.desplazarAbajoDerecha();
		
		Assert.assertTrue(posicion.igualA(posicionDesplazada));
	}
}
