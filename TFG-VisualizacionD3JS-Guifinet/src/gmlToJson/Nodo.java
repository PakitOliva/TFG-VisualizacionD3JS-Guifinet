package gmlToJson;

import java.io.IOException;
import java.io.Writer;
import java.util.LinkedHashMap;
import org.jdom2.Element;
import org.jdom2.Namespace;
import org.json.simple.JSONStreamAware;
import org.json.simple.JSONValue;

public class Nodo implements JSONStreamAware{
	private int id, weight;
	private String status, type, name, coordinates;
	public Nodo(Element element) {
		this.id=Integer.parseInt(element.getChild("dnodes").getAttributeValue("fid"));
		this.weight=id;
		this.coordinates=element.getChild("dnodes").getChild("geometryProperty",Namespace.getNamespace("http://ogr.maptools.org/")).getChild("Point", Namespace.getNamespace("http://www.opengis.net/gml")).getChildText("coordinates", Namespace.getNamespace("http://www.opengis.net/gml"));
		this.name= element.getChild("dnodes").getChild("NODE_NAME").getText();
		this.type=element.getChild("dnodes").getChild("NODE_TYPE").getText();
		this.status= element.getChild("dnodes").getChild("STATUS").getText();
	}
	@Override
	public void writeJSONString(Writer out) throws IOException {
		 LinkedHashMap obj = new LinkedHashMap();
		 obj.put("id",id);
			obj.put("STATUS",status);
			obj.put("weight",weight);
			obj.put("type", type);
			obj.put("name", name);
			obj.put("coordinates", coordinates);
         JSONValue.writeJSONString(obj, out);
	}

}
