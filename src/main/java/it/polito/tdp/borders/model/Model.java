package it.polito.tdp.borders.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.alg.connectivity.ConnectivityInspector;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleGraph;


import it.polito.tdp.borders.db.BordersDAO;

public class Model {
	
	BordersDAO dao;
	Graph<Country, DefaultEdge> grafo;
	Map<Integer, Country> idMap;
	
	public Model() {
		
		this.grafo = new SimpleGraph<Country, DefaultEdge>(DefaultEdge.class);
		this.dao = new BordersDAO();
		this.idMap = new HashMap<>();
		
	}
	
	public Graph<Country, DefaultEdge> creaGrafo(int anno) {
		
		Map<Integer, Country> country = dao.countryCollegate(anno);
		
		//vertici aggiunti al grafo in base all'anno
		Graphs.addAllVertices(this.grafo, country.values());
		

		//aggiunta degli archi
		List<Border> edges = dao.isCollegate(anno);
		
		for(Border b: edges) {
			this.grafo.addEdge(country.get(b.getS1()), country.get(b.getS2()));
		}
		
		System.out.println("questo grafo contiente: " + grafo.edgeSet().size() + " archi");
		System.out.println("questo grafo contiente: " + grafo.vertexSet().size() + " vertici");
		
		return this.grafo;
	}
	
	public int componenteConnessa() {
		
		//idMap = dao.countryCollegate(anno);
		ConnectivityInspector<Country, DefaultEdge> inspector = new ConnectivityInspector<>(this.grafo);

		return inspector.connectedSets().size();
	}
}
