package ejecutarProyecto;

import generarIndex.generarIndex;
import generarIndex.mainMenu;
import gmlToJson.jsonPorZona;

import java.util.ArrayList;

import cnmlToJSON.cnmlToJSON;
import descargarCNMLyGML.CNMLdownload;
import descargarCNMLyGML.GMLdownload;

public class MainEjecutarProyecto{
	public static ArrayList<Integer> todasZonas;
	public static int i=0;
	public static void main(String[] args) {
		//Primer paso descargo el cnml World de guifi
		CNMLdownload cnmlWorld=new CNMLdownload("http://test.guifi.net/es/guifi/cnml/", "cnml", 3671);
		cnmlWorld.descargarCNML();
		
		//****No est� terminado, falta generar el json para crear el men�.****
		//Ahora lo utilizo para generar un array con todas las id de las zonas
		todasZonas=new ArrayList<Integer>();
		cnmlToJSON cnml=new cnmlToJSON(todasZonas);
		cnml.generarJSON();
		
		//Descargar todos los archivos GML de las zonas
		for( i =1600; i<todasZonas.size();i++){
			GMLdownload gmlDown =new GMLdownload("http://test.guifi.net/es/guifi/gml/", "gml", todasZonas.get(i));
			gmlDown.descargarGML();
			System.out.println(todasZonas.get(i));
		}
		
		//Genero los JSON de cada zona
		for(int i =0; i<todasZonas.size();i++){
			jsonPorZona jspz=new jsonPorZona("gml/NodosZona"+todasZonas.get(i)+".xml", "gml/LinksZona"+todasZonas.get(i)+".xml", todasZonas.get(i));
			jspz.generarJSON();
			System.out.println(todasZonas.get(i));
		}

		//Generar Menu
		mainMenu mm = new mainMenu();
		mm.ejecutarMenu();
		
		//Generar inex.html con men�
		generarIndex gi=new generarIndex();
		gi.unirPublicar();
				
	}


}
