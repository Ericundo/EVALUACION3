package entidades;

import java.util.Scanner;

import utils.Utilidades;
import validaciones.Validaciones;

public class Participante implements Comparable<Participante>{
	protected long id;
	protected int dorsal; // valor entre 001 y 150
	protected char calle;
	protected Tiempo tiempo;
	protected boolean penalizacion;
	protected String otros;

	public Participante(long id, int dorsal, char calle, Tiempo tiempo, boolean penalizacion, String otros) {
		super();
		this.id = id;
		this.dorsal = dorsal;
		this.calle = calle;
		this.tiempo = tiempo;
		this.penalizacion = penalizacion;
		this.otros = otros;
	}

	public Participante() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getDorsal() {
		return dorsal;
	}

	public void setDorsal(int dorsal) {
		this.dorsal = dorsal;
	}

	public char getCalle() {
		return calle;
	}

	public void setCalle(char calle) {
		this.calle = calle;
	}

	public Tiempo getTiempo() {
		return tiempo;
	}

	public void setTiempo(Tiempo tiempo) {
		this.tiempo = tiempo;
	}

	public boolean isPenalizacion() {
		return penalizacion;
	}

	public void setPenalizacion(boolean penalizacion) {
		this.penalizacion = penalizacion;
	}

	public String getOtros() {
		return otros;
	}

	public void setOtros(String otros) {
		this.otros = otros;
	}

	// Metodo nuevoParticipante
	public static Participante nuevoParticipante() {
		Participante ret = null;
		long id = -1;
		int dorsal = -1;
		char calle = '-';
		Tiempo tiempo = null;
		boolean penalizacion = false;
		String otros = "";

		Scanner in;
		boolean valido = false;
		do {
			System.out.println("Introduzca el id del nuevo participante:");
			in = new Scanner(System.in);
			id = in.nextInt();
			if (id > 0)
				valido = true;
			else
				System.out.println("Valor incorrecto para el identificador.");
		} while (!valido);

		valido = false;

		do {
			System.out.println("Introduzca el dorsal del nuevo participante:");
			in = new Scanner(System.in);
			dorsal = in.nextInt();
			valido = Validaciones.validarDorsal(dorsal);
			if (!valido)
				System.out.println("Valor incorrecto para el dorsal.");
		} while (!valido);

		valido = false;

		do {
			System.out.println("Introduzca la calle del nuevo participante:");
			in = new Scanner(System.in);
			calle = in.next().charAt(0);
			valido = Validaciones.validarCalle(calle);
			if (!valido)
				System.out.println("Valor incorrecto para la calle.");
		} while (!valido);

		valido = false;

		do {
			System.out.println("Introduzca si tiene alguna penalizacion:");
			in = new Scanner(System.in);
			penalizacion = Utilidades.leerBoolean();

			if (penalizacion) {
				otros = in.nextLine();
				valido = Validaciones.validarOtros(otros);
				if (!valido)
					System.out.println("ERROR se ha introducido mal la expliacion.");
			} else
				valido = true;
		} while (!valido);

		valido = false;

		System.out.println("Introduzca ahora el tiempo:");
		in = new Scanner(System.in);
		tiempo = Tiempo.nuevoTiempo();
		ret = new Participante(id, dorsal, calle, tiempo, penalizacion, otros);
		return ret;
	}

	@Override
	public int compareTo(Participante p) {
		return 0;
	}
}
