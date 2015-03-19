package ejecutarProyecto;

import gmlToJson.jsonPorZona;

import java.util.ArrayList;

import cnmlToJSON.cnmlToJSON;
import descargarCNMLyGML.CNMLdownload;
import descargarCNMLyGML.GMLdownload;

public class MainEjecutarProyecto {

	public static void main(String[] args) {
		//Primer paso descargo el cnml World de guifi
		CNMLdownload cnmlWorld=new CNMLdownload("http://guifi.net/es/guifi/cnml/", "cnml", 3671);
		cnmlWorld.descargarCNML();
		
		//****No está terminado, falta generar el json para crear el menú.****
		//Ahora lo utilizo para generar un array con todas las id de las zonas
		ArrayList<Integer> todasZonas=new ArrayList<Integer>();
		cnmlToJSON cnml=new cnmlToJSON(todasZonas);
		cnml.generarJSON();
		
		//Descargar todos los archivos GML de las zonas 
		for(int i =0; i<todasZonas.size();i++){
			GMLdownload gmlDown =new GMLdownload("http://guifi.net/es/guifi/gml/", "gml", todasZonas.get(i));
			gmlDown.descargarGML();
		}
		
		//Genero los JSON de cada zona
		for(int i =0; i<todasZonas.size();i++){
			jsonPorZona jspz=new jsonPorZona("gml/NodosZona"+todasZonas.get(i)+".xml", "gml/LinksZona"+todasZonas.get(i)+".xml", todasZonas.get(i));
			jspz.generarJSON();
		}
		
				
	}

}
