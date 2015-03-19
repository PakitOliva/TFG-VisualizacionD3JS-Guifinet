package cnmlToJSON;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.Element;

public class Zona {
	private Element zona;
	private List<Element> subzonas;
	private ArrayList ZonaGlobal;
	public Zona(Element zona, ArrayList zonaGlobal) {
		this.zona = zona;
		this.subzonas = zona.getChildren();
		ZonaGlobal = zonaGlobal;
		repetir();
	}
	private void repetir() {
		for(int i=0; i<subzonas.size();i++){
			ZonaGlobal.add(Integer.parseInt(subzonas.get(i).getAttributeValue("id")));
			Zona zona=new Zona(subzonas.get(i),ZonaGlobal);
		}
	}
	
}
