package controller;

import java.util.concurrent.Semaphore;

public class ThreadCorredor extends Thread {
	
	public int corredorId;
	public Semaphore semaforo;

	public ThreadCorredor(int corredorId, Semaphore semaforo) {
		this.corredorId = corredorId;
		this.semaforo = semaforo;
	}
	
	public void run() {
		corredor();
		try {
			semaforo.acquire();
			porta();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		} finally {
			semaforo.release();
		}
	}

	private void corredor() {
		int dist = 0, max = 200;
		while(dist<max) {
			try {
				sleep(1000);
				int corrida = (int)((Math.random()*3)+4);
				dist = dist + corrida;
				System.out.println("Corredor #"+corredorId+" => Distância percorrida: "+dist+"m.");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

	private void porta() {
		long tempo = (long)((Math.random()*1001)+1000);
		try {
			sleep(tempo);
			System.out.println("Corredor #"+corredorId+" cruzou a porta");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
}
