package JuegoTest;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;

import Modelo.Juego;
import Modelo.Jugador;
import Modelo.Mapa;
import Modelo.Aldeano;
import Modelo.Celda;
import Modelo.Zona;
import Modelo.Cuartel;

public class JuegoIniciaTest {	

	@Before
	public void reset(){
		Mapa.reset();
	}
	
	@Test
	public void test01JugadoresTienen100DeOro(){

		Juego juego = new Juego();
		Jugador jugador1 = juego.obtenerJugador1();
		Jugador jugador2 = juego.obtenerJugador2();			
		Assert.assertTrue(jugador1.cantidadDeOro() == 100);
		Assert.assertTrue(jugador2.cantidadDeOro() == 100);
		jugador1.aumentarOro(20);
		Assert.assertTrue(jugador1.cantidadDeOro() == 120);
	}

	@Test
	public void test02JugadoresTienen3DePoblacionInicial(){

		Juego juego = new Juego();
		Jugador jugador1 = juego.obtenerJugador1();
		Jugador jugador2 = juego.obtenerJugador2();			
		Assert.assertTrue(jugador1.poblacion()==3);
		Assert.assertTrue(jugador2.poblacion()==3);		
	}	

	@Test
	public void test03PoblacionVaCambiando(){

		Juego juego = new Juego();
		Jugador jugador1 = juego.obtenerJugador1();
		Jugador jugador2 = juego.obtenerJugador2();
		

		Aldeano aldeano1 = new Aldeano(new Celda(0,0), jugador1 );
		Aldeano aldeano2 = new Aldeano(new Celda(15,15), jugador2 );

		jugador1.agregarObjetivo(aldeano1);
		jugador2.agregarObjetivo(aldeano2);

		Assert.assertTrue(jugador1.poblacion()==4);
		Assert.assertTrue(jugador2.poblacion()==4);

		jugador1.eliminarObjetivo(aldeano1);
		jugador2.eliminarObjetivo(aldeano2);

		Assert.assertTrue(jugador1.poblacion()==3);
		Assert.assertTrue(jugador2.poblacion()==3);

	}

	@Test
	public void test04AldeanosEmpiezanLibres(){

		Juego juego = new Juego();
		Jugador jugador1 = juego.obtenerJugador1();
		Jugador jugador2 = juego.obtenerJugador2();
		
		Celda celda1 = new Celda(0,0);
		Celda celda2 = new Celda(15,15);

		Aldeano aldeano1 = new Aldeano(celda1, jugador1 );
		Aldeano aldeano2 = new Aldeano(celda2, jugador2 );

		jugador1.agregarObjetivo(aldeano1);
		jugador2.agregarObjetivo(aldeano2);		

		Assert.assertTrue( aldeano1.Libre() );
		Assert.assertTrue( aldeano2.Libre() );		
	}

	@Test
	public void test05JugadorPuedeMoverSusAldeanos(){

		Juego juego = new Juego();
		Jugador jugador1 = juego.obtenerJugador1();
		Jugador jugador2 = juego.obtenerJugador2();
		
		Celda celda1 = new Celda(0,0);
		Celda celda2 = new Celda(15,15);

		Aldeano aldeano1 = new Aldeano(celda1, jugador1 );
		Aldeano aldeano2 = new Aldeano(celda2, jugador2 );

		jugador1.agregarObjetivo(aldeano1);
		jugador2.agregarObjetivo(aldeano2);		

		Assert.assertTrue( aldeano1.estaEnPosicion(celda1) );
		Assert.assertTrue( aldeano2.estaEnPosicion(celda2) );		

		Aldeano aldeanoObtenido1 = (Aldeano)jugador1.obtenerUnidad(celda1);
		Aldeano aldeanoObtenido2 = (Aldeano)jugador2.obtenerUnidad(celda2);

		Assert.assertTrue(aldeanoObtenido1.estaEnPosicion(celda1) );
		Assert.assertTrue(aldeanoObtenido2.estaEnPosicion(celda2) );

		aldeanoObtenido1.moverArribaDerecha(Mapa.obtenerInstancia());
		aldeanoObtenido2.moverAbajo(Mapa.obtenerInstancia());

		Assert.assertFalse( Mapa.obtenerInstancia().posicionOcupada(celda1) );
		Assert.assertFalse( Mapa.obtenerInstancia().posicionOcupada(celda2) );

	}

	@Test
	public void test06JugadorPuedeHacerQueSusAldeanosConstruyan(){

		Juego juego = new Juego();
		Jugador jugador1 = juego.obtenerJugador1();		
		
		Celda celda1 = new Celda(0,0);
		Aldeano aldeano1 = new Aldeano(celda1, jugador1 );		

		jugador1.agregarObjetivo(aldeano1);
		Aldeano aldeanoObtenido1 = (Aldeano)jugador1.obtenerUnidad(celda1);

		Zona zonaAconstruir = new Zona(new Celda(1,1),2,2); 
		aldeanoObtenido1.construirCuartelEnZona(zonaAconstruir);

		Assert.assertFalse( aldeanoObtenido1.Libre() );
		aldeanoObtenido1.realizarTareas();
		aldeanoObtenido1.realizarTareas();
		aldeanoObtenido1.realizarTareas();

		Assert.assertTrue( aldeanoObtenido1.Libre() );
		Cuartel cuartel = (Cuartel)jugador1.obtenerEdificio(zonaAconstruir);
		Assert.assertTrue( cuartel.estaEnPosicion(zonaAconstruir) );
		Assert.assertTrue(jugador1.poblacion()==4);

		cuartel.crearArquero(new Celda(1,2));
		Assert.assertTrue(jugador1.poblacion()==5);

	

	

	}
	
}
