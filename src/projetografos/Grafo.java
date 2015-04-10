
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projetografos;

import java.util.List;

/**
 *
 * @author Serrano
 */
public class Grafo 
{
    private final List<Vertice> vertices;
    private final List<Aresta> arestas;

    public Grafo(List<Vertice> vertices, List<Aresta> arestas) {
        this.vertices = vertices;
        this.arestas = arestas;
    }

    public List<Vertice> getVertices() {
        return vertices;
    }

    public List<Aresta> getArestas() {
        return arestas;
    }

   
    
    
    
    
}
