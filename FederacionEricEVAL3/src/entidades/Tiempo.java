package entidades;

import java.io.Serializable;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import utils.Datos;
import validaciones.Validaciones;

public class Tiempo implements Comparable<Tiempo>{

	private int horas;
	private int minutos;
	private int segundos;
	private int centesimas;

	// Constructores:

	public Tiempo(Tiempo tiempo) {
	}

	public Tiempo(int horas, int minutos, int segundos, int centesimas) {
		super();
		this.horas = horas;
		this.minutos = minutos;
		this.segundos = segundos;
		this.centesimas = centesimas;

	}

	// Getters y setters:

	

	public int getHoras() {
		return horas;
	}

	public void setHoras(int horas) {
		this.horas = horas;
	}

	public int getMinutos() {
		return minutos;
	}

	public void setMinutos(int minutos) {
		this.minutos = minutos;
	}

	public int getSegundos() {
		return segundos;
	}

	public void setSegundos(int segundos) {
		this.segundos = segundos;
	}

	public int getCentesimas() {
		return centesimas;
	}

	public void setCentesimas(int centesimas) {
		this.centesimas = centesimas;
	}
	
	// toString reimplementado:
	
	public String toString() {
		return "" + horas + ": " + minutos + ":" + segundos + ":"
				+ centesimas;
	}
	
	// Metodo nuevoTiempo:
	
	public static Tiempo nuevoTiempo() {
		Tiempo ret = null;
		int horas = 0;
		int minutos = 0;
		int segundos = 0;
		int centesimas = 0;
		Scanner in;
		boolean valido = false;
		do {
			System.out.println("Introduzca el numero de horas:");
			in = new Scanner(System.in);
			horas = in.nextInt();
			if (horas >= 0)
				valido = true;
			else
				System.out.println("Valor incorrecto para el numero de horas.");
		} while (!valido);

		valido = false;
		do {
			System.out.println("Introduzca el numero de minutos:");
			in = new Scanner(System.in);
			minutos = in.nextInt();
			if (minutos >= 0)
				valido = true;
			else
				System.out.println("Valor incorrecto para el numero de minutos.");
		} while (!valido);

		valido = false;
		do {
			System.out.println("Introduzca el numero de segundos:");
			in = new Scanner(System.in);
			segundos = in.nextInt();
			if (segundos >= 0)
				valido = true;
			else
				System.out.println("Valor incorrecto para el numero de segundos.");
		} while (!valido);

		valido = false;
		do {
			System.out.println("Introduzca el numero de centesimas:");
			in = new Scanner(System.in);
			centesimas = in.nextInt();
			if (centesimas >= 0)
				valido = true;
			else
				System.out.println("Valor incorrecto para el numero de centesimas.");
			
		} while (!valido);

		valido = false;	
		
		ret = new Tiempo(horas, minutos, segundos, centesimas);
		return ret;
	}

	@Override
	public int compareTo(Tiempo t) {
		return 0;
	}

}
