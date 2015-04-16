import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;
import java.util.Vector;

public class lectura{
	File archivo = null;
   	FileReader fr = null;
  	BufferedReader br = null;
	public void leerArchivo(File pa_archivo){
		
 
    	try {
         // Apertura del fichero y creacion de BufferedReader para poder
         // hacer una lectura comoda (disponer del metodo readLine()).
    	    archivo = pa_archivo;
    	    fr = new FileReader (archivo);
         	br = new BufferedReader(fr);
 
         // Lectura del fichero
         	String linea;
			Vector<Integer> puntos = new Vector<>();
			if ((linea=br.readLine())!=null){
				String linea1= linea;
			}
         	while((linea=br.readLine())!=null){
				String[] parts = linea.split(", ");
				int punto = Integer.parseInt(parts[0].substring(1));
				puntos.add(punto);
				punto = Integer.parseInt(parts[1].substring(0,parts[1].length()-1));
				puntos.add(punto);
			}
		String[] cirs = linea1.split(" ; ");
		String[] ryp1 = cirs[0].split(" ");
		String[] ryp2 = cirs[1].split(" ");
		int r1 = Integer.parseInt(ryp1[2]);
		int x1 = Integer.parseInt(ryp1[0].substring(1, ryp1[0].length()-1));
		int y1 = Integer.parseInt(ryp1[1].substring(0, ryp1[1].length()-1));
		int r2 = Integer.parseInt(ryp2[2]);
		int x2 = Integer.parseInt(ryp2[0].substring(1, ryp2[0].length()-1));
		int y2 = Integer.parseInt(ryp2[1].substring(0, ryp2[1].length()-1));
		logica objLog = new logica(x1,y1,r1,x2,y2,r2,puntos.toArray());
		objLog.algoritmo();
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
	}

	public static void main(String[] args){
		File file = new File("archivo.txt");
		lectura la = new lectura();
		la.leerArchivo(file);
		

	}

}
