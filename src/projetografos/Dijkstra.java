/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetografos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Serrano
 */
public class Dijkstra {

    private final List<Vertice> nos;
    private final List<Aresta> arestas;
    private Set<Vertice> nossetados;
    private Set<Vertice> nsetados;
    private Map<Vertice, Vertice> pd;
    private Map<Vertice, Integer> distancia;

    public Dijkstra(Grafo grafo) 
    {

        this.nos = new ArrayList<Vertice>(grafo.getVertices());
        this.arestas = new ArrayList<Aresta>(grafo.getArestas());
    }
    
    
    public void executarDijkstra(Vertice ini)
    {
        nossetados = new HashSet<Vertice>();
        nsetados = new HashSet<Vertice>();
        distancia = new HashMap<Vertice,Integer>();
        pd = new HashMap<Vertice,Vertice>();
        
        distancia.put(ini, 0);
        nsetados.add(ini);
        
        while(nsetados.size() > 0)
        {
            Vertice no = getMinimo(nsetados);
            nossetados.add(no);
            nsetados.remove(no);
            distanciaMinima(no);
        }
    }
    
    
    private void distanciaMinima(Vertice no) 
    {
        List<Vertice> nosAdjacentes = getVizinhos(no);
        for (Vertice alvo : nosAdjacentes) 
        {
            if (getDistanciaCurta(alvo) > getDistanciaCurta(no)  + getDistancia(no, alvo)) 
            {
                distancia.put(alvo, getDistanciaCurta(no) + getDistancia(no, alvo));
                pd.put(alvo, no);
                nsetados.add(alvo);
      }
    }

  }

  private int getDistancia(Vertice no, Vertice alvo) {
    for (Aresta aresta : arestas) 
    {
      if (aresta.getInicio().equals(no) && aresta.getDestino().equals(alvo)) 
      {
        return aresta.getPeso();
      }
    }
    throw new RuntimeException("Nada ocorreu com o grafo");
  }

  private List<Vertice> getVizinhos(Vertice no) 
  {
    List<Vertice> vizinhos = new ArrayList<Vertice>();
    for (Aresta aresta : arestas) 
    {
      if (aresta.getInicio().equals(no)&& !isConfirmado(aresta.getDestino())) 
      {
        vizinhos.add(aresta.getDestino());
      }
    }
    return vizinhos;
  }

  private Vertice getMinimo(Set<Vertice> vertices) 
  {
    Vertice minimo = null;
    for (Vertice vertice : vertices) 
    {
        if (minimo == null) 
        {
            minimo = vertice;
        } 
        else 
        {
            if (getDistanciaCurta(vertice) < getDistanciaCurta(minimo)) 
            {
                minimo = vertice;
            }
      }
    }
    return minimo;
  }

  private boolean isConfirmado(Vertice vertice) 
  {
    return nossetados.contains(vertice);
  }

  private int getDistanciaCurta(Vertice destino) 
  {
        Integer d = distancia.get(destino);
        if (d == null) 
        {
            return Integer.MAX_VALUE;
        } 
        else 
        {
            return d;
        }
  }

  
  public LinkedList<Vertice> getCaminho(Vertice alvo) 
  {
    LinkedList<Vertice> caminho = new LinkedList<Vertice>();
    Vertice proxpasso = alvo;
    
    if (pd.get(proxpasso) == null) 
    {
      return null;
    }
    caminho.add(proxpasso);
    while (pd.get(proxpasso) != null) 
    {
      proxpasso = pd.get(proxpasso);
      caminho.add(proxpasso);
    }
    
    Collections.reverse(caminho);
    return caminho;
  }


}
