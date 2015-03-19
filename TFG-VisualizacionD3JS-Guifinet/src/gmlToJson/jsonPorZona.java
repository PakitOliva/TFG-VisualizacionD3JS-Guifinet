package gmlToJson;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.Namespace;
import org.jdom2.input.SAXBuilder;

public class jsonPorZona {
	private String archivoNodo,archivoLinks;
	private int idZona;
	public jsonPorZona(String archivoNodo, String archivoLinks, int idZona) {
		this.archivoNodo = archivoNodo;
		this.archivoLinks = archivoLinks;
		this.idZona = idZona;
	}
	public void generarJSON(){
		SAXBuilder builder = new SAXBuilder();
		File xmlFileNodes = new File( archivoNodo);
	    File xmlFileLinks = new File( archivoLinks );
	    try
	    {
	        //Se crea el documento a traves del archivo
	        Document documentNodes = (Document) builder.build( xmlFileNodes );
	        Document documentLinks = (Document) builder.build( xmlFileLinks );

	        //Se obtiene la raiz 'cnml'
	        Element rootNodes = documentNodes.getRootElement();
	        Element rootLinks = documentLinks.getRootElement();

	        //System.out.println(rootNode.getChild("network").getChild("zone").toString());	       
	        List<Element> elementZonaNodes=rootNodes.getChildren("featureMember",Namespace.getNamespace("http://www.opengis.net/gml"));
	        List<Element> elementZonaLinks=rootLinks.getChildren("featureMember",Namespace.getNamespace("http://www.opengis.net/gml"));

	        
	        //Zona Abla http://www.opengis.net/gml
	        Zona zona=new Zona(elementZonaNodes,elementZonaLinks, 31453);
	        crearArchivoJSON(zona.zonaJSONtoString());
	        
	    }catch ( IOException io ) {
	        System.out.println( io.getMessage() );
	    }catch ( JDOMException jdomex ) {
	        System.out.println( jdomex.getMessage() );
	    }
	}
	private void crearArchivoJSON(String texto){
		FileWriter fichero = null;
        try
        {
            fichero = new FileWriter("guifi-zona-"+idZona+".json");
            fichero.write(texto);
            fichero.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           // Nuevamente aprovechamos el finally para 
           // asegurarnos que se cierra el fichero.
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
	}
	
}
