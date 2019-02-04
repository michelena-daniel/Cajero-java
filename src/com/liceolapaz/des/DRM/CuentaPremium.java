package com.liceolapaz.des.DRM;

public class CuentaPremium extends CuentaBancaria{
	private double saldo;
	
	public CuentaPremium(double saldo) {
		this.saldo = saldo;
	}
	
	public void ingresarDinero(double cantidad) {
		if (cantidad < 0) {
			System.out.println("\r\nLa cantidad no debe ser negativa.");
			return;
		}
		saldo = saldo + cantidad;
	}
	
	public void retirarDinero(double cantidad) {
		if (cantidad < 0) {
			System.out.println("\r\nLa cantidad no debe ser negativa.");
			return;
		}
		saldo = saldo - cantidad;
	}
	
	public double consultarSaldo() {
		return saldo;
		
	}	

}
