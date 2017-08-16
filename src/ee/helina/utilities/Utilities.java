package ee.helina.utilities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Utilities {
	
	String[] order;
	String[] productList;
	private int quantity;
	
	private String[] Order() throws IOException {
		List<String> theList = new ArrayList<String>();
		BufferedReader br = null;
		String fileName = "tellimus.txt";
		try {
			String sCurrentLine;
			br = new BufferedReader(new FileReader(fileName));
			while ((sCurrentLine = br.readLine()) != null) {
				theList.add(sCurrentLine);
			}
		} catch (IOException e) {
			System.out.println(fileName + " not found!");
			System.exit(0);
		}
		br.close();
		order = theList.toArray(new String[0]);
		return order;
	}
	
	private String[] ProductList() throws IOException {
		List<String> theList = new ArrayList<String>();
		BufferedReader br = null;
		String fileName = "Hinnakiri.txt";
		
		try {
			String sCurrentLine;
			br = new BufferedReader(new FileReader(fileName));
			while ((sCurrentLine = br.readLine()) != null) {
				theList.add(sCurrentLine);
			}
		} catch (IOException e) {
			System.out.println(fileName + " not found!");
			System.exit(0);
		}
		
		br.close();
		order = theList.toArray(new String[0]);
		return order;
	}
	
	private int Quantity(String[] order, int lineNumber) {
		String[] tokens = order[lineNumber].split("\\s+");
		String quantity1 = tokens[tokens.length - 2];
		int quantity2 = 0;
		try {
			quantity2 = Integer.valueOf(quantity1);
		} catch (NumberFormatException e) {
			System.out.println("Error in quantity calculation!");
		}
		return quantity2;
	}
	
	private String[] StringTokens(String s) {
		String[] stringTokens = s.split("\\s+");
		return stringTokens;
	}
	
	private String[] SearchTokens(String[]order, int line) throws IOException{
		int size = 0, percentage = 0;
		List<String>tempList = new ArrayList<String>(); 
		String[] tokens = StringTokens(order[line]); 
		tokens[tokens.length-1] = "";
		
		for (int i = 0; i < tokens.length; i++) {
			//Tuleb kontrollida, et token-i viimane täht oleks L, kõik failis on uppercase
			String searchToken = "L";
			String searchLocation = tokens[i];
			boolean leitud = searchLocation.toLowerCase().contains(searchToken.toLowerCase());
			if (leitud) {
				size = i;
			}
		}
		
		tokens[size] = ""; 
		
		for (int i = 0; i < tokens.length; i++) {
			String searchToken = "%";
			String searchLocation = tokens[i];
			boolean leitud = searchLocation.toLowerCase().contains(searchToken.toLowerCase());
			if (leitud) {
				percentage = i;
			}
		}
		
		tokens[percentage] = "";
		
		for (int i = 0; i < tokens.length; i++) {
			if (tokens[i].length() > 2) {
				String text = tokens[i];
				tempList.add(text);
			}			
		}
		
		tokens = tempList.toArray(new String[0]); 
		return tokens;
	}
	
	public String[] getOrder()throws IOException {
		order = Order();
		return order;
	}
	
	public String[] getProductList() throws IOException {
		productList = ProductList();
		return productList;
	}
	
	public int getQuantity(String[] order, int lineNumber) {
		quantity = Quantity(order, lineNumber);
		return quantity;
	}
	
}
