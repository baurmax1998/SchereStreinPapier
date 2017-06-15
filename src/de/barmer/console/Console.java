package de.barmer.console;

import de.barmer.echse_spock.SpielAktionenControllerErweitert;
import de.barmer.game.Rundenlog;
import de.barmer.game.Spiel;
import de.barmer.game.SpielAktionen;
import de.barmer.game.SpielAktionenController;
import de.barmer.klassisch.SpielAktionenControllerKlassisch;

import java.util.Scanner;


/**
 * Created by BE82688 on 08.06.2017.
 */
public class Console {
    public static void main(String[] args) {
        boolean inGame = true;
        Spiel spiel = new Spiel();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Willkommen beim Schere Stein Papier gegen eine Ki");
        while(inGame == true) {
            System.out.println("Menu:");
            System.out.println("1.Go");
            System.out.println("2.Spielmodus");
            System.out.println("3.Beenden");
            String eingabe = scanner.nextLine();
            if (eingabe.equals("1")|| eingabe.equals("Go")){
                System.out.println("Deine Auswahlmoeglichkeiten:");
                for (SpielAktionen spielAktionen : spiel.getSpielAktionenController().values()) {
                    System.out.println(spielAktionen.getKlarText());
                }
                System.out.println("Gebe deine Auswahl an:");
                String eingabeAuswahl = scanner.nextLine();
                Rundenlog ausgangSpiel = spiel.spieleRunde(eingabeAuswahl);
                System.out.println("Auswahl der KI:" + ausgangSpiel.getAuswahlKI());
                System.out.println("Der Gewinner ist:" + ausgangSpiel.getGewinnAusgabe());

            }else if(eingabe.equals("2")|| eingabe.equals("Spielmodus")){
                SpielAktionenController spielAktionenController;
                System.out.println("Spielmodi:");
                System.out.println("1.Klassisch");
                System.out.println("2.Echse-Spock");
                String eingabeSpielmodus = scanner.nextLine();
                if (eingabeSpielmodus.equals("Klassisch") || eingabeSpielmodus.equals("1")) {
                    System.out.println("Spielmodus: Klassisch");
                    spielAktionenController = new SpielAktionenControllerKlassisch();
                    spiel.setSpielAktionenController(spielAktionenController);
                } else if( eingabeSpielmodus.equals("Echse-Spock")|| eingabeSpielmodus.equals("2")) {
                    System.out.println("Spielmodus: Echse-Spock");
                    spielAktionenController = new SpielAktionenControllerErweitert();
                    spiel.setSpielAktionenController(spielAktionenController);

                }else{
                    System.out.println("ungueltige Eingabe");
                }

            } else if (eingabe.equals("3")|| eingabe.equals("Beenden")) {
               inGame = false;
            }else{
                System.out.println("ungueltige Eingabe");
            }


        }

    }
}
