package main;

import java.util.List;
import java.util.Scanner;

import model.Animale;
import model.Ruolo;
import model.Utente;
import model.Zona;
import service.utente.UtenteService;
import service.zona.ZonaService;
import util.FunzioniUtils;
import util.SingletonsFactory;

public class Main {

	
	private static final UtenteService utenteService = SingletonsFactory.getUtenteService();
	private static final ZonaService zonaService = SingletonsFactory.getZonaService();
	private static Utente utente = new Utente();
	private static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		//Presentazione
		System.out.println("-- Benvenuto nel gestionale Zoo --");
		System.out.println("-- Effettua l'accesso --");
		login();
		
		if(utente.getRuolo() == Ruolo.dipendente) {
			funzioniDipendente();
		}else if(utente.getRuolo() == Ruolo.admin) {
			funzionAdmin();
		}
		
	}

	private static void funzionAdmin() {
		// TODO Auto-generated method stub
		
	}

	private static void funzioniDipendente() {
		int scelta;
		String exit = "";
		do {
			System.out.println("Ecco le operazioni che puoi eseguire, scegline una:");
			System.out.println("1 - Aggiungi un animale\n" 
								+ "2 - Rimuovi un animale\n" //Stampare prima la lista di animali
								+ "3 - Sposta animale\n" //Stampare prima la lista di animali
								+ "4 - Trova animale per ID\n" + "5 - Visualizza gli aninmali contenuti in una zona\n"
								+ "6 - Visualizza tutti gli animali nello zoo");
								//per ora le zone dello zoo sono predefinite
			scelta = Integer.parseInt(input.nextLine());
			switch(scelta) {
			case 1:
				aggiungiAnimale();
				break;
			}
			
			//Ciclo per ripetere le operazioni
			do {
				System.out.println("Vuoi eseguire un'altra operazione? s/n");
				exit = input.nextLine();
				if(!exit.equalsIgnoreCase("s") || !exit.equalsIgnoreCase("n")) {
					System.out.println("Risposta non valida");
				}
			} while (!exit.equalsIgnoreCase("s") || !exit.equalsIgnoreCase("n"));
			
		} while (exit.equalsIgnoreCase("s"));
	}

	private static void aggiungiAnimale() {
		Animale a = new Animale();
		Zona zona = null;
		List<Zona> zone = zonaService.findAll();
		
		System.out.println("Inserisci la razza:");
		a.setRazza(input.nextLine());
		System.out.println("Inserisci la specie:");
		a.setSpecie(input.nextLine());
		System.out.println("Inserisci l' eta':");
		a.setEta(Integer.parseInt(input.nextLine()));
		System.out.println("Inserisci il peso:");
		a.setPeso(Double.parseDouble(input.nextLine()));
		System.out.println("Inserisci l'altezza");
		a.setAltezza(Double.parseDouble(input.nextLine()));
		
		do {
			//Ciclo per far inserire correttamente la zona
			System.out.println("Inserisci il nome della zona in cui voui inserire l'animale:");
			System.out.println(zone);
			zona = zonaService.findByNome(input.nextLine());
			if(!zone.contains(zona)) {
				System.out.println("La zona che hai inserito non esiste, riprova.");
			}
		}while(!zone.contains(zona));
		
		utenteService.aggiungiAnimale(a, zona);
	}

	private static void login() {
		String email, password;
		email = FunzioniUtils.verificaEmail();
		System.out.println("Inserisci la password:");
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
