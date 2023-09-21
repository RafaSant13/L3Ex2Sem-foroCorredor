package view;

import java.util.concurrent.Semaphore;

import controller.ThreadCorredor;

public class Principal {

	public static void main(String[] args) {
		int permissao = 1;
		Semaphore semaforo = new Semaphore(permissao);
		int i;
		for (i = 1;i<5;i++) {
			Thread corredor = new ThreadCorredor(i, semaforo);
			corredor.start();
		}
		

	}

}
