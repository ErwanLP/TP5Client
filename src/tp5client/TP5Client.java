/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp5client;

import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author Erwan
 */
public class TP5Client {

    /**
     * @param args the command line arguments
     */
    static Traitement traitement;
    public static void main(String[] zero) {

        TP5Client.traitement = new Traitement();
    }

}
