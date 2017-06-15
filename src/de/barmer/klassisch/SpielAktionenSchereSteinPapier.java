package de.barmer.klassisch;

import de.barmer.game.SpielAktionen;

/**
 * Created by BE82688 on 08.06.2017.
 */
public class SpielAktionenSchereSteinPapier implements SpielAktionen {

    private String klarText;
    private int nummer;

    public SpielAktionenSchereSteinPapier(String klarText, int nummer) {
        this.klarText = klarText;
        this.nummer = nummer;
    }

    public String getKlarText() {
        return klarText;
    }

    public void setKlarText(String klarText) {
        this.klarText = klarText;
    }

    public void setNummer(int nummer) {
        this.nummer = nummer;
    }

    public int getNummer() {
        return nummer;
    }
}
