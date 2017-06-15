package de.barmer.klassisch;

import de.barmer.game.SpielAktionen;
import de.barmer.game.SpielAktionenController;

/**
 * Created by BE82688 on 08.06.2017.
 */
public class SpielAktionenControllerKlassisch implements SpielAktionenController {
    private String[] spielAktionen = {"Schere","Stein","Papier"};
    @Override
    public SpielAktionen[] values() {
        SpielAktionen[] rueckgabe = new SpielAktionen[spielAktionen.length];


        for (int i = 0; i < spielAktionen.length; i++) {
            rueckgabe[i] = new SpielAktionenSchereSteinPapier(spielAktionen[i], i+1);
        }
        return rueckgabe;
    }

    @Override
    public SpielAktionen fromKlarText(String auswahl) {
        for (int i = 0; i < spielAktionen.length; i++) {
            if (spielAktionen[i].equals(auswahl))
                return new SpielAktionenSchereSteinPapier(spielAktionen[i], i+1);
        }
       return null;

    }
}
