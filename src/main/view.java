package main;

import java.util.concurrent.Semaphore;

import controller.cozinha;

public class view {

	public static void main(String[] args) {
		
		Semaphore farol = new Semaphore (1);
		
		for(int pratos = 1; pratos <= 5; pratos ++) {
			Thread cozinha = new cozinha(pratos, farol);
			cozinha.start();
		}
	}

}
