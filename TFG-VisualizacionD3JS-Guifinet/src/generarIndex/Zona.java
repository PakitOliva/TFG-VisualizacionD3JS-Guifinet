package generarIndex;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public class Zona {
	private Element zona;
	private List<Element> subzonas;
	private int num;
	private crearhtml html;
	
	public Zona(Element zona, int num, crearhtml html){
	this.zona=zona;
	this.subzonas=zona.getChildren();
	this.num=num;
	this.html=html;
	repetir();
	}
	
	private void repetir(){
		String guion="";
		for(int j=0; j<num;j++)
			guion+="-";
		if (subzonas.size()>0)
		html.anair("<ul> \n");
		for (int i = 0; i < subzonas.size(); i++) {
			html.anair("<li><a href='javascript:void(0)' onclick='updateDataSet("+'"'+subzonas.get(i).getAttributeValue("id")+'"'+")'>"+subzonas.get(i).getAttributeValue("title")+"</a> \n");
			//href="+'"'+'#'+'"'+" 
			//System.out.println(guion+">"+subzonas.get(i).getAttributeValue("title"));    
			Zona zona=new Zona(subzonas.get(i), num+1, html);
			}
		if (subzonas.size()>0)
		html.anair("</li> \n </ul> \n");
	}
	
	@Override
	public String toString() {
		String aux=zona.getAttributeValue("title");	
				for(int i=0; i<subzonas.size();i++)
				aux+="\n -" + subzonas.get(i).getAttributeValue("title");
		return aux;
	}	
}
