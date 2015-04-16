
public class logica{
	
	
	public logica () 
	{
		
	}
	//**************************************************************************************//
	public String [] algoritmo (int cx1, int cy1, int r1 , int cx2, int cy2, int r2, int [] puntos)
	{
		int tamano = puntos.length;
		String [] respuestas = new  String [tamano / 2];
		for (int indice =0 ; indice < puntos.length; indice+=2)
		{
			int px = puntos[indice];
			int py = puntos[indice+1];
			if ((distancia (cx1,cy1,px,py) > r1) && (distancia (cx2,cy2,px,py) > r2))
			{
				respuestas [indice / 2] = "Fuera de los dos circulos";
			}
			else
			{
				if  (distancia (cx1,cy1,px,py) <= r1)
				{
					if  (distancia (cx2,cy2,px,py) <= r2)
					{
						respuestas [indice / 2] = "Dentro de los dos circulos";
					}
					else
					{
						respuestas [indice / 2] = "Dentro del circulo 1";
					}
				}
				else
				{
					respuestas [indice / 2] = "Dentro del circulo 2";
				}
			}
			
			//System.out.println (respuestas [indice / 2]);
		}
		
		return respuestas;
	}
	//**************************************************************************************//
	public double distancia (int cx, int cy, int px,  int py)
	{
		int dis_x = px-cx;
		int dis_y = py-cy;
		double dist = Math.sqrt (Math.pow (dis_x,2) + Math.pow (dis_y,2));
		return dist;
	}
	 
	//**************************************************************************************//
	
	/**
	public static void main (String [] args)
	{
		int [] puntos = {2,2,  4,4,  0,4,  2,0, 4,5, 1,2,  -2,1,  -2,-2, 0,0};
		logica log = new logica (0,0,2,0,1,2,puntos);
	} **/
}

