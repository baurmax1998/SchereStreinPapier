package de.barmer.gui;

import de.barmer.game.Spiel;
import de.barmer.game.SpielAktionen;
import de.barmer.game.SpielAktionenController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by BE82688 on 08.06.2017.
 */
public class SpielmodusWahlActionListener implements ActionListener{
    private Spiel spiel;
    private JComboBox comboBoxMoeglichkeiten;
    private SpielAktionenController spielAktionenControllerKlassisch;

    public SpielmodusWahlActionListener(Spiel spiel, JComboBox comboBoxMoeglichkeiten, SpielAktionenController spielAktionenControllerKlassisch) {
        this.spiel = spiel;
        this.comboBoxMoeglichkeiten = comboBoxMoeglichkeiten;
        this.spielAktionenControllerKlassisch =  spielAktionenControllerKlassisch;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        spiel.setSpielAktionenController(spielAktionenControllerKlassisch);
        comboBoxMoeglichkeiten.removeAllItems();
        for (SpielAktionen spielAktionen : spiel.getSpielAktionenController().values()) {
            comboBoxMoeglichkeiten.addItem(spielAktionen.getKlarText());
        }
    }
}
