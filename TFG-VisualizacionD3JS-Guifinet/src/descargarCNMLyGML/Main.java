package descargarCNMLyGML;

public class Main {

	public static void main(String[] args) {
		//GML de Abla
		GMLdownload gml=new  GMLdownload("http://guifi.net/es/guifi/gml/", "gml", 31453);
		gml.descargarGML();
		//cnml world
		CNMLdownload cnml=new CNMLdownload("http://guifi.net/es/guifi/cnml/", "cnml", 3671);
		cnml.descargarCNML();
	}

}
