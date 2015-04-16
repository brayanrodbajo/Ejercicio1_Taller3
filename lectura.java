import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;
import java.util.Vector;

public class lectura{
	File archivo = null;
   	FileReader fr = null;
  	BufferedReader br = null;
  	
  	
	public String[] leerArchivo(File pa_archivo){
		String [] resultado = {};
 
    	try {
         // Apertura del fichero y creacion de BufferedReader para poder
         // hacer una lectura comoda (disponer del metodo readLine()).
    	    archivo = pa_archivo;
    	    fr = new FileReader (archivo);
         	br = new BufferedReader(fr);
 
         // Lectura del fichero
         	String linea, linea1="";
			Vector<Double> puntos = new Vector<>();
			if ((linea=br.readLine())!=null){
				linea1= linea;
			}
         	while((linea=br.readLine())!=null){
				String[] parts = linea.split(", ");
				double punto = Double.parseDouble(parts[0].substring(1));
				puntos.add(punto);
				punto = Double.parseDouble(parts[1].substring(0,parts[1].length()-1));
				puntos.add(punto);
			}
		String[] cirs = linea1.split(" ; ");
		String[] ryp1 = cirs[0].split(" ");
		String[] ryp2 = cirs[1].split(" ");
		double r1 = Double.parseDouble(ryp1[2]);
		double x1 = Double.parseDouble(ryp1[0].substring(1, ryp1[0].length()-1));
		double y1 = Double.parseDouble(ryp1[1].substring(0, ryp1[1].length()-1));
		double r2 = Double.parseDouble(ryp2[2]);
		double x2 = Double.parseDouble(ryp2[0].substring(1, ryp2[0].length()-1));
		double y2 = Double.parseDouble(ryp2[1].substring(0, ryp2[1].length()-1));
		logica objLog = new logica();
		int tamano = puntos.size();
		
		double [] coordenadas = new double [puntos.size()];
		for (int i=0; i<puntos.size();i++)
		{
			coordenadas [i] = puntos.get (i);
		}
	    resultado = objLog.algoritmo(x1,y1,r1,x2,y2,r2,coordenadas);
      	}catch(Exception e){
         	e.printStackTrace();
	    }finally{
         // En el finally cerramos el fichero, para asegurarnos
         // que se cierra tanto si todo va bien como si salta 
         // una excepcion.
         	try{                    
            	if(fr  !=  null ){   
               		fr.close();     
            	}                  
         	}catch (Exception e2){ 
            	e2.printStackTrace();
         	}
      	}
	return resultado;
	}

	/**public static void main(String[] args){
		File file = new File("archivo.txt");
		lectura la = new lectura();
		la.leerArchivo(file);
		

	}**/

}
