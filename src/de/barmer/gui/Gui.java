package de.barmer.gui;

import de.barmer.echse_spock.SpielAktionenControllerErweitert;
import de.barmer.game.Rundenlog;
import de.barmer.game.Spiel;
import de.barmer.game.SpielAktionen;
import de.barmer.klassisch.SpielAktionenControllerKlassisch;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Created by BE82688 on 06.06.2017.
 */
public class Gui {
    private JPanel panel1;
    private JTextField textFieldSpieler;
    private JTextField textFieldComputer;
    private JTextField textFieldPunkte;
    private JTextField textFieldPunkteSP;
    private JTextField textFieldPunkteCP;
    private JTextField textFieldVS;
    private JTextField textFieldAuswahlSP;
    private JTextField textFieldAuswahlCP;
    private JRadioButton radioButtonSchere;
    private JRadioButton radioButtonStein;
    private JRadioButton radioButtonPapier;
    private JTextField textFieldGewinner;
    private JTextField textFieldGewinnerausgeben;
    private JButton spielStarten;
    private JComboBox comboBoxMoeglichkeiten;
    private Spiel spiel = new Spiel();

    public Gui(JFrame unsereGui) {
        erzeugeMenue(unsereGui);

        for (SpielAktionen spielAktionen : spiel.getSpielAktionenController().values()) {
            this.comboBoxMoeglichkeiten.addItem(spielAktionen.getKlarText());
        }


        spielStarten.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String auswahl = (String) Gui.this.comboBoxMoeglichkeiten.getSelectedItem();

                Rundenlog ausgangSpiel = spiel.spieleRunde(auswahl);
                textFieldGewinnerausgeben.setText(ausgangSpiel.getGewinnAusgabe());
                textFieldAuswahlSP.setText(ausgangSpiel.getAuswahlUser());
                textFieldAuswahlCP.setText(ausgangSpiel.getAuswahlKI());
                textFieldPunkteCP.setText("Punkte: "+spiel.getPunkteCP());
                textFieldPunkteSP.setText("Punkte: "+spiel.getPunkteSP());
            }
        });

    }

    private void erzeugeMenue(JFrame frame) {
        JMenuBar jMenuBar = new JMenuBar();

        JMenu zeichenwahl = new JMenu("Zeichenwahl");

        jMenuBar.add(zeichenwahl);

        JMenuItem klassisch = new JMenuItem("Klassisch");
        klassisch.addActionListener(new SpielmodusWahlActionListener(spiel,comboBoxMoeglichkeiten,  new SpielAktionenControllerKlassisch()));
        zeichenwahl.add(klassisch);

        JMenuItem erweitert = new JMenuItem("Erweitert");
        erweitert.addActionListener(new SpielmodusWahlActionListener(spiel,comboBoxMoeglichkeiten, new SpielAktionenControllerErweitert()));
        zeichenwahl.add(erweitert);

        JMenu gegner = new JMenu("Gegner");
        jMenuBar.add(gegner);

        JMenuItem ki = new JMenuItem("KI");
        ki.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        gegner.add(ki);

        JMenuItem multi = new JMenuItem("Spieler vs. Spieler");
        multi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        gegner.add(multi);

        JMenu regeln = new JMenu("Spielregeln");
        jMenuBar.add(regeln);
        JMenuItem regelnklassisch = new JMenuItem("Klassisch");
        regeln.add(regelnklassisch);
        JMenuItem regelnerweitert = new JMenuItem("Erweitert");
        regeln.add(regelnerweitert);


        frame.setJMenuBar(jMenuBar);
    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("Gui");


        frame.setContentPane(new Gui(frame).panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }


}
