package controller;

import java.util.concurrent.Semaphore;

public class cozinha extends Thread {

	int pratos;
	Semaphore farol;

	public cozinha(int pratos, Semaphore farol) {
		this.pratos = pratos;
		this.farol = farol;
	}

	public void run() {
		NomePrato();
		EntregaPratos();
	}
	
	//Decide o Sabor do Prato	
	private void NomePrato() {
		if (pratos % 2 == 0) {
			LasanhaBolonhesa();
		} else {
			SopaCebola();
		}

	}
	
	//Prepara o prato de sopa de cebola
	private void SopaCebola() {
		double total = 0;
		String prato1 = "Sopa de Cebola";
		double tempototal = (double) (Math.random() * 301.0 ) + 500.0;
		System.out.println("O " + pratos + "º prato com sabor " + prato1 + " foi INICIADO" );
		double tempo = (tempototal / 100);
		double quant = 100 / tempo;
		for(int i = 1; i <= (int)tempo; i++) {
			try {
				sleep(100);
				System.out.printf("O " + pratos + "º prato com sabor " + prato1 + " esta em: %.2f %n", (total = total + quant ));
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}	
		}
		System.out.println("O " + pratos + "º prato com sabor " + prato1 + " esta PRONTO");
	}

	//Prepara o prato de lasanha a bolonhesa
	private void LasanhaBolonhesa() {
		double total = 0;
		String prato2 = "Lasanha a Bolonhesa";
		int tempototal = (int) (Math.random() * 601 ) + 600;
		System.out.println("O " + pratos + "º prato com sabor " + prato2 + " foi INICIADO" );
		double tempo = (tempototal / 100);
		double quant = 100 / tempo;
		for(int i = 1; i <= (int)tempo; i++) {
			try {
				sleep(100);
				System.out.printf("O " + pratos + "º prato com sabor " + prato2 + " esta em: %.2f %n", (total = total + quant ));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("O " + pratos + "º prato com sabor " + prato2 + " esta PRONTO");
	}
	
	//Faz a Entrega dos pratos 
	private void EntregaPratos() {
		try {
			farol.acquire();
			sleep(500);
			System.out.println("O " + pratos + "º foi ENTREGUE");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			farol.release();
		}

	}

}
