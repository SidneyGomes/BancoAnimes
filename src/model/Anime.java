/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author sidne
 */
public class Anime {

    private int id;
    private String name;
    private int qtdEpisodios;
    private String link;
    private int exibicao;
    private String image;
    
    ArrayList<Episodio> episodios = new ArrayList<Episodio>();

    public Anime(int id, String name, int qtdEpisodios, String link, String image) {
        this.id = id;
        this.name = name;
        this.link = link;
        this.qtdEpisodios = qtdEpisodios;
        this.image = image;
        
        criarEpisodios();
    }
    
    public Anime(int qtdEpisodios){
        this.qtdEpisodios = qtdEpisodios;
    
    }
    
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    
     public int getExibicao() {
        return exibicao;
    }

    public void setExibicao(int exibicao) {
        this.exibicao = exibicao;
    }
    
    
    private void criarEpisodios(){
        for (int i = 0; i < this.qtdEpisodios; i++) {
            int aux = i + 1;
            episodios.add(new Episodio(this.name + " " + aux, false));
        }
        
    }

    public ArrayList getEpisodios() {
        return episodios;
    }

    public void setEpisodios(ArrayList episodios) {
        this.episodios = episodios;
    }
    
    
    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
    
    public Anime() {
        //Classe para criação sem passar parametros.
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQtdEpisodios() {
        return qtdEpisodios;
    }

    public void setQtdEpisodios(int qtdEpisodios) {
        this.qtdEpisodios = qtdEpisodios;
    }
    
    @Override
    public String toString(){
    
        return this.name;
    }
}
