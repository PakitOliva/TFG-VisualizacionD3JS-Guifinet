package descargarCNMLyGML;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class GMLdownload {
	private String urlBase, carpetaLocal;
	private int idGML;

	public GMLdownload(String urlBase, String carpetaLocal, int idGML) {
		this.urlBase = urlBase;
		this.carpetaLocal = carpetaLocal;
		this.idGML = idGML;
	}

	public void descargarGML() {
		try {
			// Url con la foto
			URL url = new URL(urlBase + idGML + "/nodes");

			// establecemos conexion
			URLConnection urlCon = url.openConnection();

			// Sacamos por pantalla el tipo de fichero
			//System.out.println(urlCon.getContentType());

			// Se obtiene el inputStream de la foto web y se abre el fichero
			// local.
			InputStream is = urlCon.getInputStream();
			FileOutputStream fos = new FileOutputStream(carpetaLocal
					+ "/NodosZona" + idGML + ".xml");

			// Lectura de la foto de la web y escritura en fichero local
			byte[] array = new byte[1000]; // buffer temporal de lectura.
			int leido = is.read(array);
			while (leido > 0) {
				fos.write(array, 0, leido);
				leido = is.read(array);
			}

			// cierre de conexion y fichero.
			is.close();
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			// Url con la foto
			URL url = new URL(urlBase + idGML + "/links");

			// establecemos conexion
			URLConnection urlCon = url.openConnection();

			// Sacamos por pantalla el tipo de fichero
			System.out.println(urlCon.getContentType());

			// Se obtiene el inputStream de la foto web y se abre el fichero
			// local.
			InputStream is = urlCon.getInputStream();
			FileOutputStream fos = new FileOutputStream(carpetaLocal
					+ "/LinksZona" + idGML + ".xml");

			// Lectura de la foto de la web y escritura en fichero local
			byte[] array = new byte[1000]; // buffer temporal de lectura.
			int leido = is.read(array);
			while (leido > 0) {
				fos.write(array, 0, leido);
				leido = is.read(array);
			}

			// cierre de conexion y fichero.
			is.close();
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
