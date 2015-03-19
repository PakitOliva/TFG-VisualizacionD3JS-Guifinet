package descargarCNMLyGML;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class CNMLdownload {
	private String urlCNML, carpetaLocal;
	private int idCNML;
	
	public CNMLdownload(String urlCNML, String carpetaLocal, int idCNML) {
		super();
		this.urlCNML = urlCNML;
		this.carpetaLocal = carpetaLocal;
		this.idCNML = idCNML;
	}

	public void descargarCNML() {
		try {
			// Url con la foto
			URL url = new URL(urlCNML + idCNML + "/zones");

			// establecemos conexion
			URLConnection urlCon = url.openConnection();

			// Sacamos por pantalla el tipo de fichero
			System.out.println(urlCon.getContentType());

			// Se obtiene el inputStream de la foto web y se abre el fichero
			// local.
			InputStream is = urlCon.getInputStream();
			FileOutputStream fos = new FileOutputStream(carpetaLocal
					+ "/CNML" + idCNML+ ".xml");

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
