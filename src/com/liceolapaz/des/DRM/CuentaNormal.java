package com.liceolapaz.des.DRM;

public class CuentaNormal extends CuentaBancaria{	
	private double saldo;
	
	public CuentaNormal(double saldo) {
		
		this.saldo = saldo;
		
	}
	
	public void ingresarDinero(double cantidad) {
		if (cantidad < 0) {
			System.out.println("\r\nLa cantidad no debe ser negativa.");
			return;
		}
		this.saldo = saldo + cantidad;
	}
	
	public void retirarDinero(double cantidad) {
		if (cantidad < 0) {
			System.out.println("\r\nLa cantidad no debe ser negativa.");
			return;
		}
		if (cantidad > saldo) {
			System.out.println("\r\nSi usted desea trabajar en números rojos, actualice a nuestra nueva cuenta Premium.");
			return;
		}
		this.saldo = saldo - cantidad;
	}
	
	public double consultarSaldo() {
		return saldo;
		
	}	

}
