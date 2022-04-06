package entidades;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.Scanner;
import utils.Utilidades;
import validaciones.Validaciones;

public class Patrocinador implements Comparable<Patrocinador> {

	private long id;
	private String nombre;
	private String web;
	private double dotacion;

	// CONSTRUCTOR POR DEFECTO

	public Patrocinador() {
	}

	// CONSTRUCTOR CON TODOS LOS CAMPOS OBLIGATORIOS
	public Patrocinador(long id, String nombre, String web, double dotacion) {

		this.dotacion = dotacion;
		this.id = id;
		this.nombre = nombre;
		this.web = web;

	}

	// CONSTRUCTOR DE COPIA

	Patrocinador(Patrocinador c) {
		System.out.println("Constructor de copia llamado");

		id = c.id;
		nombre = c.nombre;
		web = c.web;
		dotacion = c.dotacion;

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getWeb() {
		return web;
	}

	public void setWeb(String web) {
		this.web = web;
	}

	public double getDotacion() {
		return dotacion;
	}

	public void setDotacion(double dotacion) {
		this.dotacion = dotacion;
	}

	public static Patrocinador nuevoPatrocinador() {
		Patrocinador ret = null;
		Scanner in;
		long id = -1;
		String nombre = "";
		String web = "";
		double dotacion = -1.1;
		boolean valido = false;
		do {
			System.out.println("Introduzca el id del nuevo patrocinador:");
			in = new Scanner(System.in);
			id = in.nextInt();
			valido = Validaciones.validarId(id);
			if (!valido)
				System.out.println("ERROR: Valor incorrecto para el identificador.");
			else
				valido = true;
		} while (!valido);
		valido = false;
		do {
			System.out.println("Introduzca el nombre del patrocinador:");
			in = new Scanner(System.in);
			nombre = in.nextLine();
			valido = Validaciones.validarNombre(nombre);
			if (!valido)
				System.out.println("ERROR: El valor introducido para el nombre no es válido. ");
		} while (!valido);
		do {
			System.out.println("Introduzca la web del patrocinador:");
			in = new Scanner(System.in);
			web = in.nextLine();
			valido = Validaciones.validarweb(web);
			if (!valido)
				System.out.println("ERROR: El valor introducido para la web no es válido. ");
		} while (!valido);
		System.out.println("Introduzca la dotacion del patrocinador");
		in = new Scanner(System.in);
		valido = Validaciones.validardotacion(dotacion);
		if (!valido)
			System.out.println("ERROR: El valor introducido para la dotacion no es válido. ");
		while (!valido)
			;

		ret = new Patrocinador(id, nombre, web, dotacion);
		return ret;
	}

	public String data() {
		return "" + this.getId() + "|" + this.getNombre() + "|" + this.getWeb() + "|" + this.getDotacion();
	}

	@Override
	public int compareTo(Patrocinador o) {
		int comparacion = Double.compare(this.getDotacion(), o.getDotacion());
		if(comparacion==0) {
			
			
		}
		else
			
		return comparacion;
		return comparacion;

	}

}
