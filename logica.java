//logica
public class logica{
	
	
	public logica () 
	{
		
	}
	//**************************************************************************************//
	public String [] algoritmo (double cx1, double cy1, double r1 , double cx2, double cy2, double r2, double [] puntos)
	{
		int tamano = puntos.length;
		String [] respuestas = new  String [tamano / 2];
		for (int indice =0 ; indice < puntos.length; indice+=2)
		{
			double px = puntos[indice];
			double py = puntos[indice+1];
			String str_px =Double.toString (px);
			String str_py =Double.toString (py);
			String punto = "(" + str_px + ", " + str_py + ") -> "; 
			if ((distancia (cx1,cy1,px,py) > r1) && (distancia (cx2,cy2,px,py) > r2))
			{
				respuestas [indice / 2] = punto + "Fuera de los dos circulos";
			}
			else
			{
				if  (distancia (cx1,cy1,px,py) <= r1)
				{
					if  (distancia (cx2,cy2,px,py) <= r2)
					{
						respuestas [indice / 2] = punto + "Dentro de los dos circulos";
					}
					else
					{
						respuestas [indice / 2] = punto + "Dentro del circulo 1";
					}
				}
				else
				{
					respuestas [indice / 2] = punto + "Dentro del circulo 2";
				}
			}
			
			//System.out.println (respuestas [indice / 2]);
		}
		
		return respuestas;
	}
	//**************************************************************************************//
	public double distancia (double cx, double cy, double px,  double py)
	{
		double dis_x = px-cx;
		double dis_y = py-cy;
		double dist = Math.sqrt (Math.pow (dis_x,2) + Math.pow (dis_y,2));
		return dist;
	}
	 
	//**************************************************************************************//
	/**
	public static void main (String [] args)
	{
		double [] puntos = {2.0,2.0,  4.0,4.0,  0.0,4.0,  2.0,0.0, 4.0,5.0, 1.0,2.0,  -2.0,1.0,  -2.0,-2.0, 0.0,0.0};
		logica log = new logica ();
		log.algoritmo (0,0,2,0,1,2,puntos);
	} 
	* **/
}

