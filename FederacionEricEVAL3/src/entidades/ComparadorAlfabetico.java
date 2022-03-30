package entidades;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;

import utils.Datos;


public class ComparadorAlfabetico implements Comparator<DatosPersona> {
	@Override
	public int compare(DatosPersona n1, DatosPersona n2) {
		return n1.getNombre().compareToIgnoreCase(n2.getNombre());
	}


		
		public void nombreOrdenado_ejercicio1() {
			
			LinkedList<DatosPersona> ret = new LinkedList<DatosPersona>();
			for (DatosPersona n : Datos.PERSONAS) {
				ret.add(n);
		
			}
			
			Collections.sort(ret, new ComparadorAlfabetico() ) ;
			System.out.println("La lista ordenada de todos los nombres es:");
			Iterator<DatosPersona> it = ret.iterator();
			
			while (it.hasNext()) {
				DatosPersona per =(DatosPersona) it.next();
				try {
					File f = new File("atletas_alfabetico.txt");
					FileWriter fw = new FileWriter(f);
					fw.write(per.data()+"\n");
				} catch (IOException e) {
					
					e.printStackTrace();
				}
				
			}
		}
}
		
		
		


