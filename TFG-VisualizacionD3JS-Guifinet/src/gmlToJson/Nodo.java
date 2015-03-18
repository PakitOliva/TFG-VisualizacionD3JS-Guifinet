package gmlToJson;

import org.jdom2.Element;

public class Nodo {
	private int id, weight;
	private String status, type, name, coordinates;
	public Nodo(Element element) {
		this.id=Integer.parseInt(element.getChild("dnodes").getAttributeValue("fid"));
		this.weight=id;
	}

}
