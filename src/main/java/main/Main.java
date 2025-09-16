package main;

import java.util.Scanner;

import model.Utente;
import service.utente.UtenteService;
import util.FunzioniUtils;
import util.SingletonsFactory;

public class Main {
	
	private static final UtenteService utenteService = SingletonsFactory.getUtenteService();
	private static Utente utente = null;
	private static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		//Presentazione
		System.out.println("-- Benvenuto nel gestionale Zoo --");
		System.out.println("-- Effettua l'accesso --");
		login();
		
	}

	private static void login() {
		String email, password;
		email = FunzioniUtils.verificaEmail();
		password = input.nextLine();
		utente.setEmail(email);
		utente.setPassword(password);
		
		if(utenteService.findByEmail(email) != null && utenteService.findByEmail(email).getPassword().equals(password)) {
			System.out.println("-- Login effettuato con successo! --");
			System.out.println("Ciao " + utente.getNome());
		}else {
			System.out.println("Le credenziali sono errate, riprova.");
		}
	}

}
