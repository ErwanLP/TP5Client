/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import tp5client.Traitement;

/**
 *
 * @author Erwan
 */
public class Fenetre {

    Connexion connexion;
    CardLayout c;
    String[] listContent = {"Connexion", "Pieces", "Confirmation"};
    Pieces pieces;
    JPanel content;
    Confirme confirme;

    public Fenetre(JFrame jf, Traitement traitement) {
        final int hauteurFenetre = 500;
        final int largeurFenetre = 500;
        jf.setTitle("Client TP5 By Erwan Le Poder");
        jf.setSize(largeurFenetre, hauteurFenetre);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setLocationRelativeTo(null);
        content = new JPanel();
        connexion = new Connexion(traitement);
        pieces = new Pieces(traitement);
        confirme = new Confirme(traitement);
        c = new CardLayout();
        content.setLayout(c);
        content.add(connexion, listContent[0]);
        content.add(pieces, listContent[1]);
        content.add(confirme, listContent[2]);
        jf.getContentPane().add(content, BorderLayout.CENTER);
        jf.setVisible(true);

    }

    public void errorConnexion() {
        connexion.errorConnexion.setText("Prenom et Nom non présent dans le base");
    }

    public void resetErrorConnexion() {
        connexion.errorConnexion.setText("");
    }

    public void affichePieces(model.Pieces pieces) {
        c.show(content, listContent[1]);
        this.pieces.initPieces(pieces);
    }

    public void afficheConfirme(Boolean test) {
        c.show(content, listContent[2]);
        confirme.test = test;
        confirme.affichetext();
    }

    public void afficheFinish() {
        c.show(content, listContent[0]);
    }

}
