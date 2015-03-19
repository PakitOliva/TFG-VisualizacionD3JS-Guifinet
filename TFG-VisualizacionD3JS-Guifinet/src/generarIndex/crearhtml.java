package generarIndex;
import java.io.FileWriter;
import java.io.PrintWriter;


public class crearhtml {
	private String texto;
	public crearhtml(){
		//texto=" <ul class="+"menu"+"> \n <li><a>Guifi.net World</a></li> \n";
		texto=" <link href='menuperfecto/jquery-ui.css' rel='stylesheet'> \n <script src='menuperfecto/external/jquery/jquery.js'></script> \n <script src='menuperfecto/jquery-ui.js'></script> \n <script> $(function() { $( "+'"'+"#menu"+'"'+" ).menu();});</script> \n <style>  .ui-menu { width: 200px; } </style> \n <ul id="+"menu"+"> <li><a href=#>Guifi.net World</a>  \n";
	}
	public void anair(String texto){
		this.texto+=texto;
	}
	 public void publicar(){
		 texto+="</ul>";
		 FileWriter fichero = null;
	        PrintWriter pw = null;
	        try
	        {
	            fichero = new FileWriter("webmitad/prueba.html");
	            pw = new PrintWriter(fichero);
	                pw.print(texto);
	 
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
		 System.out.println(texto);
	 }
}
