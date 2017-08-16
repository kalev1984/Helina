package ee.helina.main;

import java.io.IOException;

import ee.helina.utilities.Utilities;

public class Naltu {

	public static void main(String[] args) throws IOException {
		Utilities utils = new Utilities();
		String[] order = utils.getOrder();
		int quantity = utils.getQuantity(order, 5);
		
		System.out.println(quantity);
		for(int i = 0; i < order.length; i++) {
			System.out.println(order[i]);
		}
	}

}
