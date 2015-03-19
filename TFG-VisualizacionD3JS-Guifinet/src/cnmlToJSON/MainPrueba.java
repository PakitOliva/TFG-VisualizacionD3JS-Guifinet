package cnmlToJSON;

import java.util.ArrayList;

public class MainPrueba {

	public static void main(String[] args) {
		//No está terminado, falta generar el json para crear el menú.
		ArrayList todasZonas=new ArrayList();
		cnmlToJSON cnml=new cnmlToJSON(todasZonas);
		cnml.generarJSON();
	}

}
