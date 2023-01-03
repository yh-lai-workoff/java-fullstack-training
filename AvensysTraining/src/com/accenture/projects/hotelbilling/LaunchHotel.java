package com.accenture.projects.hotelbilling;

import java.util.ArrayList;
import java.util.Scanner;

class Hotel {
	String clientName;
	Scanner scanner = new Scanner(System.in);
	MenuItem[] menu = new MenuItem[] { new MenuItem("Water", 10), new MenuItem("Pepsi", 25), new MenuItem("Pizza", 50),
			new MenuItem("Fries", 35), new MenuItem("Burger", 60) };
	ArrayList<OrderItem> currentOrder = new ArrayList<>();

	void welcome() {
		System.out.println("Welcome to Shangri-La Hotel!");
		System.out.println("Please enter your name: ");

		clientName = scanner.nextLine();
		System.out.println("Welcome %s! Please Order from the Menu below.\n".formatted(clientName));
	}

	boolean takeOrder() {
		
		displayMenu();
		int id = scanner.nextInt();
		while (id < 1 || id > menu.length) {
			System.out.println("Invalid Item ID. Please Try Again: ");
			id = scanner.nextInt();
		}
		System.out.println("Enter Quantity of %s to Order: ".formatted(menu[id - 1].getName()));
		int amount = scanner.nextInt();
		OrderItem newOrder = new OrderItem(menu[id - 1], amount);
		currentOrder.add(newOrder);
		printLineBreak();
		System.out.println("Your Order is %s x%d.\nSubtotal: $%d".formatted(newOrder.getName(), amount,
				newOrder.getSubtotalPrice()));
		printLineBreak();
		System.out.println("Would you like to order more? ('y' to Continue)");
		String check = scanner.next().toLowerCase();
		return (check.charAt(0) == 'y');
	}

	boolean checkOrder() {
		
		printReceipt();
		System.out.println("Would you like to change your order? ('y' to change')");
		String check = scanner.next().toLowerCase();
		if (check.charAt(0) == 'y') {
			boolean unfinished = true;
			System.out.println("Actions:\n1) Remove Order\n2) Add Order\n3) Edit Quantity\nPlease select an Action to take (1-3):");
			int action = scanner.nextInt();
			switch (action) {
			case 1:
				while (unfinished) {
					unfinished = deleteOrder();
				}
				break;

			case 2:
				while (unfinished) {
					unfinished = takeOrder();
				}
				break;
				
			case 3:
				while (unfinished) {
					unfinished = editOrder();
				}
				break;

			default:
				break;
			}
			return true;
		}
		return false;
			
	}
	boolean deleteOrder() {
		printCurrentOrder();
		System.out.println("Please enter Order ID to delete: ");
		int delIndex = scanner.nextInt();
		currentOrder.remove(delIndex-1);
		System.out.println("Delete more? ('y' to accept)");
		String check = scanner.next();
		
		return (check.charAt(0) == 'y');
	}
	
	boolean editOrder() {
		printCurrentOrder();
		System.out.println("Please enter Order ID to edit: ");
		int editIndex = scanner.nextInt();
		System.out.println("Please enter new Quantity:");
		int newQuantity = scanner.nextInt();
		currentOrder.get(editIndex-1).setQuantity(newQuantity);
		System.out.println("Edit more? ('y' to accept)");
		String check = scanner.next();
		
		return (check.charAt(0) == 'y');
	}

	private void displayMenu() {
		printLineBreak();
		System.out.println("Item ID\t\tItem\t\tItemPrice");
		printLineBreak();

		for (int i = 0; i < menu.length; i++) {
			printMenuLine(i + 1, menu[i]);
		}

		printLineBreak();

		System.out.println("Please Enter Item ID of your Order: ");
	}

	private void printReceipt() {
		int grandTotal = 0;
		float gst = 0f;
		System.out.println("Current Order:");
		printLineBreak();
		System.out.println("ItemName\tQuantity\tSubtotal");

		printLineBreak();
		for (OrderItem oi : currentOrder) {
			printReceiptLine(oi);
			grandTotal += oi.getSubtotalPrice();
		}
		printLineBreak();
		gst = grandTotal * 0.07f;
		System.out.println("GST (7%%): \t\t\t$ %.2f".formatted(gst));
		System.out.println("Grandtotal: \t\t\t$ %.2f".formatted(grandTotal + gst));
		printLineBreak();
	}
	
	private void printCurrentOrder() {
		printLineBreak(60);
		System.out.println("Item ID\t\tItem\t\tQuantity\tItemPrice");
		printLineBreak(60);
		for (int i =0 ; i< currentOrder.size(); i++) {
			printEditLine(i+1, currentOrder.get(i));
		}
		printLineBreak(60);
	}

	private void printMenuLine(int index, String itemName, int price) {
		System.out.println("%d\t\t%s\t\t$ %d".formatted(index, itemName, price));
	}

	private void printMenuLine(int index, MenuItem mi) {
		System.out.println("%d\t\t%s\t\t$ %d".formatted(index, mi.getName(), mi.getPrice()));
	}

	private void printReceiptLine(String name, int quantity, int subTotal) {
		System.out.println("%s\t\t%d\t\t$ %d".formatted(name, quantity, subTotal));
	}

	private void printReceiptLine(OrderItem oi) {
		System.out.println("%s\t\t%d\t\t$ %d".formatted(oi.getName(), oi.getQuantity(), oi.getSubtotalPrice()));
	}
	
	private void printEditLine(int index, OrderItem oi) {
		System.out.println("%d\t\t%s\t\t%d\t\t$ %d".formatted(index,oi.getName(),oi.getQuantity(),oi.getPrice()));
	}

	private void printLineBreak() {
		System.out.println("------------------------------------------");
	}
	private void printLineBreak(int length) {
		StringBuilder dashBuilder = new StringBuilder();
		while(length > 0 ) {
			dashBuilder.append("-");
			length--;
		}
		System.out.println(dashBuilder.toString());
	}
}

class Item {
	protected String name;
	protected int price;

	Item(String name, int price) {
		this.name = name;
		this.price = price;
	}
	
	Item(Item i){
		this.name = i.getName();
		this.price = i.getPrice();
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}
}

class MenuItem extends Item {
	int id;

	MenuItem(String name, int price) {
		super(name, price);
		this.id = -1;
	}

	@Deprecated
	MenuItem(int id, String name, int price) {
		super(name, price);
		this.id = id;
	}

}

class OrderItem extends Item {
	int quantity;
	int subtotalPrice;

	OrderItem(String name, int price, int quantity) {
		super(name, price);
		this.quantity = quantity;
		this.subtotalPrice = price * quantity;
	}
	
	OrderItem(MenuItem mi, int quantity){
		super(mi);
		this.quantity = quantity;
		this.subtotalPrice = price * quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
		this.subtotalPrice = this.price * quantity;
	}

	public int getQuantity() {
		return quantity;
	}

	public int getSubtotalPrice() {
		return subtotalPrice;
	}

}

public class LaunchHotel {
	public static void main(String[] args) {
		Hotel h = new Hotel();

		boolean unfinished = true;

		h.welcome();

		while (unfinished) {
			unfinished = h.takeOrder();

		}
		
		unfinished = true;
		while(unfinished) {
			unfinished = h.checkOrder();
		}
		System.out.println("Thank you for ordering!");
//		h.printReceipt();
//		h.checkOrder();

	}
}