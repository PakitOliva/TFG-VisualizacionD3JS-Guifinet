package gmlToJson;

import java.io.IOException;
import java.io.Writer;
import java.util.LinkedHashMap;

import org.jdom2.Element;
import org.jdom2.Namespace;
import org.json.simple.JSONStreamAware;
import org.json.simple.JSONValue;

public class Link implements JSONStreamAware{
	private int id,target,source;
	private double kms;
	private String status, type, node1, node2, coordenadas;
	public Link(Element element) {
		this.id = Integer.parseInt(element.getChild("dlinks").getAttributeValue("fid"));
		this.kms = Double.parseDouble(element.getChild("dlinks").getChild("KMS").getText());
		this.target = Integer.parseInt(element.getChild("dlinks").getChild("NODE2_ID").getText());;
		this.source = Integer.parseInt(element.getChild("dlinks").getChild("NODE1_ID").getText());;
		this.status = element.getChild("dlinks").getChild("STATUS").getText();
		this.type = element.getChild("dlinks").getChild("LINK_TYPE").getText();
		this.node1 = element.getChild("dlinks").getChild("NODE1_NAME").getText();
		this.node2 = element.getChild("dlinks").getChild("NODE2_NAME").getText();
		this.coordenadas = element.getChild("dlinks").getChild("geometryProperty",Namespace.getNamespace("http://ogr.maptools.org/")).getChild("LineString", Namespace.getNamespace("http://www.opengis.net/gml")).getChildText("coordinates", Namespace.getNamespace("http://www.opengis.net/gml"));
	}
	@Override
	public void writeJSONString(Writer out) throws IOException {
		LinkedHashMap obj = new LinkedHashMap();
		 	obj.put("id",id);
		 	obj.put("KMS", kms);
			obj.put("STATUS",status);
			obj.put("target",target);
			obj.put("source", source);
			obj.put("type", type);
			obj.put("NODE1_NAME", node1);
			obj.put("NODE2_NAME", node2);
			obj.put("coordinates", coordenadas);
        JSONValue.writeJSONString(obj, out);
	}
	
}
