package com.iheida.util;

import java.util.UUID;

public class UserUtil {
     public static String generateID() {
		
		//UUID---Java ≤ª÷ÿ∏¥–Ú¡–
		String uuid = UUID.randomUUID().toString();
		int hashcode = Math.abs(uuid.hashCode());
		
		return "customer-" + hashcode;
	}
	public static void main(String[] args) {
		System.out.println(generateID());
	}
}
