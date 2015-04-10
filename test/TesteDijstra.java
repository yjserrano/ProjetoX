/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import projetografos.Aresta;
import projetografos.Dijkstra;
import projetografos.Grafo;
import projetografos.Vertice;

/**
 *
 * @author Serrano
 */
public class TesteDijstra {

   

        private List<Vertice> nos;
        private List<Aresta> arestas;

        @Test
        public void testExcute() 
        {
            nos = new ArrayList<Vertice>();
            arestas = new ArrayList<Aresta>();
            for (int i = 0; i < 11; i++) 
            {
                Vertice localizacao = new Vertice("Nó_" + i, "Nó_" + i);
                nos.add(localizacao);
            }

            addFaixa("Aresta_0", 0, 1, 85);
            addFaixa("Aresta_1", 0, 2, 217);
            addFaixa("Aresta_2", 0, 4, 173);
            addFaixa("Aresta_3", 2, 6, 186);
            addFaixa("Aresta_4", 2, 7, 103);
            addFaixa("Aresta_5", 3, 7, 183);
            addFaixa("Aresta_6", 5, 8, 250);
            addFaixa("Aresta_7", 8, 9, 84);
            addFaixa("Aresta_8", 7, 9, 167);
            addFaixa("Aresta_9", 4, 9, 502);
            addFaixa("Aresta_10", 9, 10, 40);
            addFaixa("Aresta_11", 1, 10, 600);

            
            Grafo grafo = new Grafo(nos, arestas);
            Dijkstra dijkstra = new Dijkstra(grafo);
            dijkstra.executarDijkstra(nos.get(0));
            LinkedList<Vertice> caminho = dijkstra.getCaminho(nos.get(10));

            assertNotNull(caminho);
            assertTrue(caminho.size() > 0);

            for (Vertice vertice : caminho) 
            {
                System.out.println(vertice);
            }

        }

        private void addFaixa(String faixaId, int inicio, int destino,int duracao) 
        {
            Aresta faixa = new Aresta(faixaId, nos.get(inicio), nos.get(destino), duracao);
            arestas.add(faixa);
        }
    }

