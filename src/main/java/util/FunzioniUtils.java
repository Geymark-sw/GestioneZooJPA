package util;

import java.util.Scanner;
import java.util.regex.Pattern;

public class FunzioniUtils {
	
	private static Scanner input = new Scanner(System.in);
	
	public static String verificaEmail() {
		String email = "";
		do {
			try {
				System.out.println("Inserisci l'email:");
				email = input.nextLine();
				if(!Pattern.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$", email)) {
					System.out.println("L'email che hai inserito non ha un formato valido, riprova.");
				}
			} catch (Exception e) {
				System.out.println("L'email che hai inserito non ha un formato valido, riprova.");
			}
			
		}while(!Pattern.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$", email));
		return email;
	}
	
	//public static boolean existsZona?

}
