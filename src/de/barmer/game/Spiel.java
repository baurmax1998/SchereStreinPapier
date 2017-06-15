package de.barmer.game;

import de.barmer.klassisch.SpielAktionenControllerKlassisch;

import java.util.Random;

/**
 * Created by BE82688 on 07.06.2017.
 */
public class Spiel {
    private SpielAktionenController spielAktionenController = new SpielAktionenControllerKlassisch();

    private int punkteSP = 0;
    private int punkteCP = 0;

    public int getPunkteSP() {
        return punkteSP;
    }

    public int getPunkteCP() {
        return punkteCP;
    }

    public SpielAktionenController getSpielAktionenController() {
        return spielAktionenController;
    }

    public void setSpielAktionenController(SpielAktionenController spielAktionenController) {
        this.spielAktionenController = spielAktionenController;
    }

    public Rundenlog spieleRunde(String auswahl) {
        SpielAktionen auswahlUser = spielAktionenController.fromKlarText(auswahl);
        int auswahlKiAlsZahl = getKIZahl(spielAktionenController.values().length);
        SpielAktionen auswahlKI = spielAktionenController.values()[auswahlKiAlsZahl];

        Rundenlog rundenlog = new Rundenlog();
        rundenlog.setAuswahlUser(auswahlUser.getKlarText());
        rundenlog.setAuswahlKI(auswahlKI.getKlarText());
        rundenlog.setGewinnAusgabe(getGewinnAusgabe(auswahlUser.getNummer(), auswahlKI.getNummer()));
        return rundenlog;


    }

    private int getKIZahl(int n) {
        Random random = new Random();
        return random.nextInt(n);
    }

    private String getGewinnAusgabe(int auswahlUserAlsZahl, int auswahlKiAlsZahl) {
        String gewinnAusgabe = "";
        int differenzAuswahl = auswahlUserAlsZahl - auswahlKiAlsZahl;
        if (auswahlKiAlsZahl == auswahlUserAlsZahl) {
            gewinnAusgabe = "Unentschieden";
        } else if (differenzAuswahl > 0) {
            if (differenzAuswahl % 2 == 0) {
                gewinnAusgabe = "Computer";
                punkteCP++;
            } else {
                gewinnAusgabe = "Spieler";
                punkteSP++;
            }
        } else {
            if (differenzAuswahl % 2 == -1) {
                gewinnAusgabe = "Computer";
                punkteCP++;
            } else {
                gewinnAusgabe = "Spieler";
                punkteSP++;
            }
        }
        return gewinnAusgabe;
    }

}
