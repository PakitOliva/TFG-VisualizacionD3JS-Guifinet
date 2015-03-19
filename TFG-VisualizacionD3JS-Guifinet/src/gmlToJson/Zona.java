package gmlToJson;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.jdom2.Element;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Zona {
	private JSONArray nodes;
	private JSONArray links;
	
	public Zona(List<Element> elementZonaNode,List<Element> elementZonaLink , int id) {
		nodes=new JSONArray();
		links=new JSONArray();
		for(int i=0; i<elementZonaNode.size();i++){
			nodes.add(new Nodo(elementZonaNode.get(i)));
		}
		for(int i=0; i<elementZonaLink.size(); i++){
			links.add(new Link(elementZonaLink.get(i)));
		}
	}
	public String zonaJSONtoString(){
		JSONArray listaNodes=new JSONArray();
		JSONObject obj = new JSONObject();
		obj.put("nodes", nodes);
		obj.put("links", links);
		StringWriter out = new StringWriter();
		  try {
			obj.writeJSONString(out);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return out.toString();
		//return obj.toJSONString();
	}

}
