package cnmlToJSON;

import java.util.ArrayList;

public class MainPrueba {

	public static void main(String[] args) {
		//No est� terminado, falta generar el json para crear el men�.
		ArrayList todasZonas=new ArrayList();
		cnmlToJSON cnml=new cnmlToJSON(todasZonas);
		cnml.generarJSON();
	}

}
