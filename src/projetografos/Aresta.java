/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetografos;

/**
 *
 * @author Serrano
 */
public class Aresta {

    private final String id;
    private final Vertice inicio;
    private final Vertice destino;
    private final int peso;

    public Aresta(String id, Vertice inicio, Vertice destino, int peso) {
        this.id = id;
        this.inicio = inicio;
        this.destino = destino;
        this.peso = peso;
    }

    public String getId() {
        return id;
    }

    public Vertice getInicio() {
        return inicio;
    }

    public Vertice getDestino() {
        return destino;
    }

    public int getPeso() {
        return peso;
    }

    @Override
    public String toString() {
        return inicio + " " + destino;
    }

}
