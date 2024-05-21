package org.generation.italy;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Scanner;

import org.generation.italy.model.Studente;

public class Main {

	public static void main(String[] args) {
		ArrayList<Studente> elencoStudenti=new ArrayList<Studente>();
		Scanner sc=new Scanner(System.in);
		int nrStudenti;
		Studente s;	//dichiarazione
		DateTimeFormatter df=DateTimeFormatter.ofPattern("dd/MM/yyyy");		//formato data: dd (giorno 2 cifre), MM (mese 2 cifre), yyyy (anno 4 cifre)
		
		System.out.print("Quanti studenti vuoi inserire? ");
		nrStudenti=sc.nextInt();
		sc.nextLine();
		
		for (int i=1;i<=nrStudenti;i++) {
			System.out.println("\nStudente nr: "+i);
			//Creo un nuovo studente
			s=new Studente();	//inizializzazione
			
			//inizializzo lo studente
			System.out.print("Inserisci il nome: ");
			s.nome=sc.nextLine();
			System.out.print("Inserisci il cognome: ");
			s.cognome=sc.nextLine();
			System.out.print("Inserisci l'altezza: ");
			s.altezza=sc.nextDouble();
			sc.nextLine();
			
			System.out.print("Inserisci la data di nascita: ");
			s.dataNascita=LocalDate.parse(sc.nextLine(),df);		//leggi una stringa (sc.nextLine()) e convertila in data (parse) usando la formattazione custom (df)
			//aggiungo lo studente alla lista
			elencoStudenti.add(s);
			
		}
		
		//elaborazioni
		
		System.out.println("\n\nStudenti inseriti:");
		//visualizzo gli studenti inseriti
		for (int i=0;i<elencoStudenti.size();i++) {
			
			System.out.println("Nome: "+
				elencoStudenti			//arraylist
				.get(i)					//casella in posizione i (studente)
				.nome);					//singolo dato dello studente
			
			System.out.println("Cognome: "+
				elencoStudenti.get(i).cognome);	
			
			System.out.println("Altezza: "+
				elencoStudenti.get(i).altezza);	
			
			System.out.println("Data di nascita: "+
				elencoStudenti.get(i).dataNascita.format(df));	//.format:  converte la stringa utilizzando il formato df
		
			//dato ricavato dalla data di nascita
			System.out.println("Età: "+ 
					ChronoUnit.YEARS.between(	
							elencoStudenti.get(i).dataNascita, 
							LocalDate.now())); 		//differenza in anni tra la data di nascita e la data attuale (LocalDate.now())
		}
		sc.close();
	}

}
