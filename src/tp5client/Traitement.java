/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp5client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import static java.lang.System.in;
import static java.lang.System.out;
import java.net.Socket;
import javax.swing.JFrame;
import model.Pieces;
import model.Piece;
import model.User;
import model.Reservation;
import view.Fenetre;

/**
 *
 * @author Erwan
 */
public class Traitement implements java.io.Serializable {

    JFrame jf;
    Fenetre f;
    private long timeout;
    Pieces pieces;
    Socket socket;
    ObjectInputStream ois;
    InputStream is;
    OutputStream os;
    ObjectOutputStream oos;

    public Traitement() {
        jf = new JFrame();
        f = new Fenetre(jf, this);
        timeout = 1000;
    }

    public void link(String prenom, String nom, String action) throws InterruptedException, ClassNotFoundException {

        System.out.println("function link");

        try {
            socket = new Socket("localhost", 2009);

            System.out.println("envoi user");
            os = socket.getOutputStream();
            oos = new ObjectOutputStream(os);
            User user = new User(prenom, nom, action);
            oos.writeObject(user);
            oos.flush();
//            os.close();

            System.out.println("reception boolean");
            is = socket.getInputStream();
            ois = new ObjectInputStream(is);
            boolean isconnect = ois.readBoolean();
            //regarde si l'utiliateur est conencté
            if (isconnect) {
                System.out.println("true");
                //on recupere le pieces
                this.pieces = (Pieces) ois.readObject();
//                System.out.println(pieces.listePieces.get(1).nom);
                f.affichePieces(pieces);
            } else {
                System.out.println("false");
                socket.close();
            }
//            ois.close();
//            is.close();

            

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //focntion appeler lorsque l'utilisateur clique sur reserver
    public Piece choixPieces(Object item) {
        for (int i = 0; i < this.pieces.listePieces.size(); i++) {
            if (item.toString().equalsIgnoreCase(this.pieces.listePieces.get(i).toString())) {
//                System.out.println("on a choisi la piece : " + i);
                return this.pieces.listePieces.get(i);
            }
        }
        return this.pieces.listePieces.get(0); // inutile return
    }

    //envoi la reservation vers le serveur.
    public void newReservation(Piece pieceSelected, int nombreSelected) throws IOException {
        Reservation reservation = new Reservation(pieceSelected, nombreSelected);
        System.out.println(reservation.toString());
        oos.writeObject(reservation);
        boolean isReserve = ois.readBoolean();
        System.out.println("is reserve = "+isReserve);
        f.afficheConfirme(isReserve);
        
        
    }

    public void finish() {
        f.afficheFinish();
    }

}
