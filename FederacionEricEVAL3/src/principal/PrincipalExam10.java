package principal;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import entidades.Atleta;
import entidades.Patrocinador;
import utils.Datos;

public class PrincipalExam10 {

	public static void main(String[] args) {

	}

	public static void exportarPatrocinadores() {
		String path = "patrocinadores.dat";
		try {
			FileOutputStream fichero = new FileOutputStream(path, false);
			ObjectOutputStream escritor = new ObjectOutputStream(fichero);
			for (Patrocinador p : Datos.PATROCINADOR) {

			}
			escritor.close();
		} catch (FileNotFoundException e) {
			System.out.println("Se ha producido una FileNotFoundException" + e.getMessage());
		} catch (IOException e) {
			System.out.println("Se ha producido una IOException" + e.getMessage());
		} catch (Exception e) {
			System.out.println("Se ha producido una Exception" + e.getMessage());
		}

	}

}
