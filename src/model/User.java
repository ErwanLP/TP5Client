/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.net.*;

/**
 *
 * @author Erwan
 */
public class User implements Serializable {

    static private final long serialVersionUID = 192L;
    public String prenom;
    public String nom;
    public String action;

    public User(String prenom, String nom, String action) {
        this.prenom = prenom;
        this.nom = nom;
        this.action = action;
    }

}
