package comparadores;

import java.security.Principal;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import entidades.Tiempo;
import utils.Datos;

public class ComparadorTiempos implements Comparator<Tiempo> {

	public int compare(Tiempo t1, Tiempo t2) {
		return t1.compareTo(t2);
	}

}
