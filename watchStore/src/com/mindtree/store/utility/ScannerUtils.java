package com.mindtree.store.utility;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ScannerUtils {
	public static int getInt() {
		//@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int a = 0;
		try {
			a = sc.nextInt();
		} catch (InputMismatchException e) {

			System.out.println("enter proper input:");
			return getInt();

		}
		return a;
	}

	public static String getString() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String a = null;
		try {
			a = sc.nextLine();
		} catch (InputMismatchException e) {
			System.out.println("enter proper input:");
			return getString();
		}

		return a;
	}

	public static boolean getBoolean() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		boolean a = true;
		try {
			a = sc.nextBoolean();
		} catch (InputMismatchException e) {
			System.out.println("enter proper input:");
			return getBoolean();
		}

		return a;
	}

	public static float getFloat() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		float a = 0;
		try {
			a = sc.nextFloat();
		} catch (InputMismatchException e) {
			System.out.println("enter proper input:");
			return getFloat();
		}

		return a;
	}

}
