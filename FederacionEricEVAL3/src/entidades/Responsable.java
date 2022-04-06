package entidades;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import utils.Utilidades;
import validaciones.Validaciones;

public class Responsable {

	private long id;
	private String telefonoProf;
	private LocalDateTime horarioini;
	private LocalDateTime horariofin;

	// CONSTRUCTOR POR DEFECTO

	public Responsable() {
	}

	// CONSTRUCTOR CON TODOS LOS CAMPOS OBLIGATORIOS
	public Responsable(long id, String telefonoProf, LocalDateTime horarioini, LocalDateTime horariofin) {

		this.id = id;
		this.telefonoProf = telefonoProf;
		this.horarioini = horarioini;
		this.horariofin = horariofin;

	}

	// CONSTRUCTOR DE COPIA

	Responsable(Responsable c) {
		System.out.println("Constructor de copia llamado");

		id = c.id;
		telefonoProf = c.telefonoProf;
		horarioini = c.horarioini;
		horariofin = c.horariofin;

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTelefonoProf() {
		return telefonoProf;
	}

	public void setTelefonoProf(String telefonoProf) {
		this.telefonoProf = telefonoProf;
	}

	public LocalDateTime getHorarioini() {
		return horarioini;
	}

	public void setHorarioini(LocalDateTime horarioini) {
		this.horarioini = horarioini;
	}

	public LocalDateTime getHorariofin() {
		return horariofin;
	}

	public void setHorariofin(LocalDateTime horariofin) {
		this.horariofin = horariofin;
	}
	
	
	
	
	
	
	public static Responsable nuevoResponsable() {
		Responsable ret = null;
		Scanner in;
		long id = -1;
		String telefonoProf = "";
		boolean valido = false;
		do {
			System.out.println("Introduzca el id del nuevo responsable:");
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
			System.out.println("Introduzca el telefono profesional del responsable:");
			in = new Scanner(System.in);
			telefonoProf = in.nextLine();
			valido = Validaciones.validartelefonoProf(telefonoProf);
			if (!valido)
				System.out.println("ERROR: El valor introducido para el telefono no es válido. ");
		} while (!valido);
		
		System.out.println("Introduzca la fecha del horario de inicio");
		LocalDateTime horarioini = Utilidades.leerFechaHora();
		
		System.out.println("Introduzca la fecha del horario de fin");
		LocalDateTime horariofin = Utilidades.leerFechaHora();

		

		ret = new Responsable(id, telefonoProf, horariofin, horariofin);
		return ret;
	}
	
	public String data() {
		return "" + this.getId() + "|" + this.getTelefonoProf() + "|" +   this.horariofin.format(DateTimeFormatter.ofPattern("HH/mm/ss")) + "|" 
				+ this.horariofin.format(DateTimeFormatter.ofPattern("HH/mm/ss"));
	}

}
