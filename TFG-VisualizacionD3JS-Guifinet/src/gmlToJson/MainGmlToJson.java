package gmlToJson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.Namespace;
import org.jdom2.input.SAXBuilder;
import org.jdom2.util.NamespaceStack;
import org.xml.sax.helpers.NamespaceSupport;

public class MainGmlToJson {

	public static void main(String[] args) {
		SAXBuilder builder = new SAXBuilder();
	 	//World http://guifi.net/es/guifi/cnml/3671/zones
	    File xmlFileNodes = new File( "nodes.xml" );
	    try
	    {
	        //Se crea el documento a traves del archivo
	        Document documentNodes = (Document) builder.build( xmlFileNodes );
	 
	        //Se obtiene la raiz 'cnml'
	        Element rootNodes = documentNodes.getRootElement();
	        
	        //System.out.println(rootNode.getChild("network").getChild("zone").toString());	       
	        List<Element> elementZonaNodes=rootNodes.getChildren("featureMember",Namespace.getNamespace("http://www.opengis.net/gml"));
	        //Zona Abla http://www.opengis.net/gml
	        Zona zona=new Zona(elementZonaNodes, 31453);
	        
	        
	    }catch ( IOException io ) {
	        System.out.println( io.getMessage() );
	    }catch ( JDOMException jdomex ) {
	        System.out.println( jdomex.getMessage() );
	    }
	}

}
