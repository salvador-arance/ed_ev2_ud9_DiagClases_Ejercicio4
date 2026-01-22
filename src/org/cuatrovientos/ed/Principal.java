package org.cuatrovientos.ed;

public class Principal {

	public static void main(String[] args) {
		int option = 0;
		Invoice factura = new Invoice("Ander");
		
		do {
			option = Utils.show_menu();
			Utils.state_machine(option, factura);
		}while(option != 0);
		
	}

}
