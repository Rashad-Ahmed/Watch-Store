package com.mindtree.store.client;

import java.util.ArrayList;

import com.mindtree.store.entity.Type;
import com.mindtree.store.entity.Watch;
import com.mindtree.store.exceptions.ServiceException;
import com.mindtree.store.service.Service;
import com.mindtree.store.service.ServiceImpl;
import com.mindtree.store.utility.ScannerUtils;

public class Client {
	private static Service service = new ServiceImpl();
	private static Client client = new Client();

	public static void main(String[] args) {

		boolean choice = true;
		while (choice) {
			client.menu();
			int op = ScannerUtils.getInt();
			switch (op) {
			case 1:
				client.addType();
				break;
			case 2:
				client.dispType();
				client.addWatch();
				break;
			case 3:
				client.updateWatch();
				break;
			case 4:
				client.sortByPrice();
				break;
			case 5:
				client.deleteType();
				break;
			case 6:
				choice = false;
				break;
			default:
				System.err.println("invalid option");
				break;
			}
		}
	}

	private boolean dispType() {
		System.out.println("TYPES OF WATCH");
		try {
			System.out.println(service.getType());
		} catch (ServiceException e) {
			System.err.println(e.getMessage());
		}
		return true;
	}

	private boolean addWatch() {
		System.out.println("enter the watch id");
		int watch_id = ScannerUtils.getInt();
		System.out.println("enter the model no:");
		int modelNumber = ScannerUtils.getInt();
		System.out.println("enter the price");
		float price = ScannerUtils.getFloat();
		System.out.println("enter the type id");
		int id = ScannerUtils.getInt();
		Type t = new Type(id);

		boolean s = false;
		try {
			s = service.validate(id);
		} catch (ServiceException e1) {
			System.err.println(e1.getMessage());
		}
		if (s) {
			try {
				Watch watch = new Watch(watch_id, modelNumber, price, t);
				service.insertWatch(watch);
			} catch (ServiceException e) {
				System.out.println(e.getMessage());
			}
			System.out.println("watch addded successfully");
		} else
			System.err.println("type id does not exist");
		return true;
	}

	private boolean sortByPrice() {
		System.out.println("The sorted list is");
		ArrayList<Watch> watchTable = null;
		try {
			watchTable = service.sort();
			for (Watch watch : watchTable)
				System.out.println(watch);
		} catch (ServiceException e) {
			System.err.println(e.getMessage());
		}
		return true;
	}

	private boolean deleteType() {
		ArrayList<Watch> disp = null;
		try {
			disp = service.getWatch();
		} catch (ServiceException e) {
			System.err.println(e.getMessage());
		}
		for (Watch a : disp)
			System.out.println(a);
		System.out.println("enter the type id");
		int typeId = ScannerUtils.getInt();
		boolean s = false;
		try {
			s = service.validateId(typeId);

		} catch (ServiceException e1) {
			System.err.println(e1.getMessage());
		}
		if (s) {
			try {
				service.delete(typeId);
			} catch (ServiceException e) {
				System.err.println(e.getMessage() + "type not found");
			}
		} else {
			System.err.println("id does not exist");
		}
		return true;
	}

	private boolean updateWatch() {
		System.out.println("UPDATING THE WATCH LIST");
		ArrayList<Watch> disp = null;
		try {
			disp = service.getWatch();
		} catch (ServiceException e) {
			System.err.println(e.getMessage());
		}
		for (Watch a : disp)
			System.out.println(a);
		System.out.println("enter the type id");
		int userId = ScannerUtils.getInt();
		try {
			boolean present = service.validate(userId);
			if (!present) {
				System.out.println("This type is not found");
			} else {
				System.out.println("enter the model number to update");
				int watch_id = ScannerUtils.getInt();
				try {

					service.updateWatch(watch_id, userId);

				} catch (ServiceException e) {
					System.err.println(e.getMessage());
				}
			}
		} catch (ServiceException e) {
			System.err.println(e.getMessage());
		}
		return true;

	}

	private boolean addType() {
		try {
			System.out.println(service.getType());
		} catch (ServiceException e1) {
			System.out.println(e1.getMessage());
		}
		System.out.println("enter the type id");
		int id = ScannerUtils.getInt();
		System.out.println("enter the type name");
		String name = ScannerUtils.getString();
		Type type = new Type(id, name);
		boolean s = false;
		try {
			s = service.insertType(type);
		} catch (ServiceException e) {
			System.err.println(e.getMessage());
		}
		if (s)
			System.out.println("type addded successfully");
		return true;
	}

	private boolean menu() {
		System.out.println("WATCH STORE");
		System.out.println("1.ADD TYPE OF WATCH");
		System.out.println("2.ADD WATCH");
		System.out.println("3.UPDATE WATCH ID USING TYPE ID");
		System.out.println("4.SORT THE WATCHS BASED ON PRICE");
		System.out.println("5.DELETE TYPE OF THE WATCH");
		System.out.println("6.EXIT");
		System.out.println("enter option:");
		return true;

	}
}
