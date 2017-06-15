package de.barmer.echse_spock;

import de.barmer.game.SpielAktionen;

/**
 * Created by BE82688 on 07.06.2017.
 */
public enum SpielAktionenSchereSteinPapierEchseSpock implements SpielAktionen {
    SCHERE(1, "Schere"), STEIN(4, "Stein"), PAPIER(5, "Papier"), ECHSE(3, "Echse"), SPOCK(2, "Spock");


    private int nummer;
    private String klarText;


    SpielAktionenSchereSteinPapierEchseSpock(int nummer, String klarText) {
        this.nummer = nummer;
        this.klarText = klarText;
    }

    public int getNummer() {
        return nummer;
    }

    public String getKlarText() {
        return klarText;
    }



}
