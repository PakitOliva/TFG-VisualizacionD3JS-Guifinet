package gmlToJson;

import java.util.ArrayList;
import java.util.List;

import org.jdom2.Element;

public class Zona {
	private ArrayList<Nodo> nodes;
	private ArrayList<Link> links;
	
	public Zona(List<Element> elementZonaNode, int id) {
		for(int i=0; i<elementZonaNode.size();i++){
			nodes.add(new Nodo(elementZonaNode.get(i)));
		}
	}
	

}
