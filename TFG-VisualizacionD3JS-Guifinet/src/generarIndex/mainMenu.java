package generarIndex;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;


public class mainMenu {
	public void ejecutarMenu(){
		 SAXBuilder builder = new SAXBuilder();
		 	//World http://guifi.net/es/guifi/cnml/3671/zones
		    File xmlFile = new File( "cnml/CNML3671.xml" );
		    try
		    {
		        //Se crea el documento a traves del archivo
		        Document document = (Document) builder.build( xmlFile );
		 
		        //Se obtiene la raiz 'cnml'
		        Element rootNode = document.getRootElement();
		        
		        //System.out.println(rootNode.getChild("network").getChild("zone").toString());
		       
		        Element elementWord=rootNode.getChild("network").getChild("zone");
		        
		        crearhtml html=new crearhtml();
		        Zona zonaWorld=new Zona(elementWord, 0, html);
		        html.publicar();
		     
		        
		    }catch ( IOException io ) {
		        System.out.println( io.getMessage() );
		    }catch ( JDOMException jdomex ) {
		        System.out.println( jdomex.getMessage() );
		    }
	}

}
