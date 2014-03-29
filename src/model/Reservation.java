/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author Erwan
 */
public class Reservation implements Serializable{

    static private final long serialVersionUID = 192L;
    Piece pieceSelected;
    int nombreSelected;

    public Reservation(Piece pieceSelected, int nombreSelected) {
        this.pieceSelected = pieceSelected;
        this.nombreSelected = nombreSelected;

    }

    
    
    public String toString(){
        String s = "la piece : "+this.pieceSelected.nom+" est selectionnée avec une reservation de "+this.nombreSelected+" place(s)";
        return s;
        
    }
}
