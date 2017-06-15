package de.barmer.echse_spock;

import de.barmer.game.SpielAktionen;
import de.barmer.game.SpielAktionenController;

/**
 * Created by BE82688 on 08.06.2017.
 */
public class SpielAktionenControllerErweitert implements SpielAktionenController {
    @Override
    public SpielAktionen[] values() {
        return SpielAktionenSchereSteinPapierEchseSpock.values();
    }

    @Override
    public SpielAktionen fromKlarText(String auswahl) {
        for (SpielAktionenSchereSteinPapierEchseSpock spielAktionen : SpielAktionenSchereSteinPapierEchseSpock.values()) {
            if (auswahl.equals(spielAktionen.getKlarText())) {
                return spielAktionen;
            }
        }
        return null;

    }
}
