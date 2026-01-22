package org.cuatrovientos.ed;

import java.util.Scanner;

public class Utils {
	public static int show_menu(){
		Scanner scan = new  Scanner(System.in);
		System.out.println("---Welcome---");
		System.out.println("0. Exit");
		System.out.println("1. Add Product");
		System.out.println("2. Remove Product");
		System.out.println("3. Show total");
		
		System.out.print("Choose an option (0-3): ");
		return Integer.parseInt(scan.nextLine());
	}
	
	public static void state_machine(int opt, Invoice factura) {
		switch (opt) {
		case 1: {
			Scanner scan = new Scanner(System.in);
			Product productAux;
			String nameAux = "";
			String input = "";
			int qtyAux = 0;
			float priceAux = 0;
			boolean isNumber = false;
			
			System.out.print("Product Name: ");
			nameAux = scan.nextLine();
			
			do {
				System.out.print("Product Price: ");
				input = scan.nextLine();
				try {
					priceAux = Float.parseFloat(input);
					isNumber = true;
				} catch (NumberFormatException e) {
					isNumber = false;
				}
				if (!isNumber){
					System.out.println("Please, input a valid price.");
				}
			} while (!isNumber);
			
			isNumber = false;
			
			do {
				System.out.print("Product Qty: ");
				input = scan.nextLine();
				try {
					qtyAux = Integer.parseInt(input);
					isNumber = true;
				} catch (NumberFormatException e) {
					isNumber = false;
				}
				if (!isNumber){
					System.out.println("Please, input a valid qty.");
				}
			} while (!isNumber);
			
			productAux = new Product(nameAux, qtyAux, priceAux);
			
			factura.add(productAux);
			break;
		}
		case 2: {
			Scanner scan = new Scanner(System.in);
		    System.out.print("Input the index of the product you want to remove: ");
		    try {
		        int index = Integer.parseInt(scan.nextLine());
		        factura.remove(index);
		        System.out.println("Product removed.");
		    } catch (Exception e) {
		        System.out.println("Invalid index.");
		    }
		    break;
		}
		case 3: {
			System.out.println(factura.total());
			break;
		}
		}
	}
}
