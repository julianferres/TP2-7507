package Modelo;
import java.lang.Math;

public class Celda implements Posicion{
	
	int x;
	int y;
	
	public Celda(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Celda crearCeldaIgual() {
		return(new Celda(this.x, this.y));
	}
	
	public boolean igualA(Celda unaPosicion) {
		return (unaPosicion.mismo(this.x, this.y));
	}

	private boolean mismo(int x, int y) {
		return (this.x == x && this.y == y);
	}

	public boolean enRango(int altura, int base) {
		return (this.xEnRango(base) && this.yEnRango(altura));
	}

	private boolean xEnRango(int base) {
		return (0 <= this.x && this.x <= base);
	}

	private boolean yEnRango(int altura) {
		return (0 <= this.y && this.y <= altura);
	}

	@Override
	public boolean igualA(Posicion unaPosicion) {
		return unaPosicion.igualA(this);
	}

	@Override
	public boolean igualA(Zona unaZona) {
		return unaZona.igualA(this);
	}

	public void desplazarArriba(){
		
		this.y = this.y + 1;
	}
	
	public void desplazarAbajo(){
		
		this.y = this.y - 1;
	}
	
	public void desplazarDerecha(){
		
		this.x = this.x + 1;
	}
	
	public void desplazarIzquierda(){
		
		this.x = this.x - 1;
	}
	
	public void desplazarArribaIzquierda() {
		this.desplazarArriba();
		this.desplazarIzquierda();
	}
	
	public void desplazarArribaDerecha() {
		this.desplazarArriba();
		this.desplazarDerecha();
	}
	
	public void desplazarAbajoIzquierda() {
		this.desplazarAbajo();
		this.desplazarIzquierda();
	}
	
	public void desplazarAbajoDerecha() {
		this.desplazarAbajo();
		this.desplazarDerecha();
	}
	
	public void desplazarHorizontalmente(int desplazamiento){
		this.x = this.x + desplazamiento;
	}
	
	public void desplazarVerticalmente(int desplazamiento){
		this.y = this.y + desplazamiento;
	}

	public boolean estaAlLadoDe(Celda otraCelda) {
		return otraCelda.estaAlLadoDe(this.x,this.y);
	}

	private boolean estaAlLadoDe(int x, int y) {
		return distanciaEntreX(x) < 2 && distanciaEntreY(y) < 2 && !mismo(x,y);
	}

	private int distanciaEntreY(int y) {
		return Math.abs(y - this.y);
	}

	private int distanciaEntreX(int x) {
		return Math.abs(x - this.x);
	}


}
