package de.barmer.game;

import de.barmer.game.SpielAktionen;

/**
 * Created by BE82688 on 08.06.2017.
 */
public interface SpielAktionenController {

    public SpielAktionen[] values();
    public SpielAktionen fromKlarText(String auswahl);
}
