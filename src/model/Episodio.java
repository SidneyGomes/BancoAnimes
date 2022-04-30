/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author sidne
 */
public class Episodio {
    
    private int id;
    private int idAnime;
    private String name;
    private boolean complete;

    public Episodio(String name, boolean complete) {
        this.name = name;
        this.complete = complete;
    }
    

    public int getId() {
        return id;
    }

    public int getIdAnime() {
        return idAnime;
    }

    public void setIdAnime(int idAnime) {
        this.idAnime = idAnime;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public Episodio(){
        // Criaçao do episodio para o banco de dados; 
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }
   
}
