package videojuegosXML;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class metodos {
	
	public static void cargarDatos() throws IOException {
		FileWriter f=new FileWriter(new File("videojocs.xml"));
		//CREAMOS VARIABLE PARA ESCRIBIR SOBRE EL .txt
		
		
		
		//PROCESO DE ESCRITURA USANDO (\n)--> PARA COLOCARLO EN COLUMNAS
		//USANDO (\t)--> PARA CREAR LAS TABULACIONES
		f.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"); //METODO DE ESCRITURA
		f.close();//METODO PARA TERMINAR EL PROCESO
	}
	public static void RellenarDatos() throws IOException {
		FileWriter f=new FileWriter(new File("videojocs.xml"));
		
		f.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
		
		f.write("<Videojuegos>\n");
		//-----------------------------------------------------------------
		f.write("\n\t<Videojuego id=\"01\">\n");
		
		f.write("\t\t<Titulo creado_en=\"USA\">\\"+"DOOM"+"</Titulo>\n");
		
		f.write("\t\t<Creador>"+"Treyarch"+"</Creador>\n");
		
		f.write("\t\t<Sinopsis>"+"Shooter futurista"+"</Sinopsis>\n");
	
		f.write("\t\t<Plataforma>"+"PC"+"</Plataforma>\n");

		f.write("\t</Videojuego>\n");
		//-----------------------------------------------------------------
		f.write("\n\t<Videojuego id=\"02\">\n");
		
		f.write("\t\t<Titulo creado_en=\"RUS\">\\"+"METRO"+"</Titulo>\n");
		
		f.write("\t\t<Creador>"+"Activision"+"</Creador>\n");
		
		f.write("\t\t<Sinopsis>"+"RPG modo historia"+"</Sinopsis>\n");
	
		f.write("\t\t<Plataforma>"+"PS4"+"</Plataforma>\n");

		f.write("\t</Videojuego>\n");
		//------------------------------------------------------------------

		f.write("\n\t<Videojuego id=\"03\">\n");
		
		f.write("\t\t<Titulo creado_en=\"ESP\">\\"+"Destiny_2"+"</Titulo>\n");
		
		f.write("\t\t<Creador>"+"Bungie"+"</Creador>\n");
		
		f.write("\t\t<Sinopsis>"+"Shooteer modo historia futurista"+"</Sinopsis>\n");
	
		f.write("\t\t<Plataforma>"+"PC"+"</Plataforma>\n");

		f.write("\t</Videojuego>\n");
		//------------------------------------------------------------------
		f.write("\n</Videojuegos>\n");
		f.close();//METODO PARA TERMINAR EL PROCESO
	}
		public static void MostrarDatos() throws IOException {
			//CREAMOS VARIABLE PARA LEER EL .txt
			FileReader f2=new FileReader(new File("videojocs.xml"));
		//PROCESO DE LECTURA
		int data=f2.read();//INTRODUCIMOS VARIABLE (data) nos ayudara en el proceso
		while(data != -1) {
		System.out.print((char)data);
		System.out.print("");
		data=f2.read();

		
		}
		
}
}