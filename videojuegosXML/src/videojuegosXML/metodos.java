

package videojuegosXML;

import java.io.File;
import java.io.FileInputStream;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.Scanner;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class metodos {
	
	private static String Titulo;
	
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
		
		//-----------------------------------------------------------------
		
		f.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
				
				+"\n"
		
				+"<Videojuego>\n"
	
				+"\t<Titulo creado_en=\"???\">"+"???"+"</Titulo>\n"
		
				+"\t<Creador>"+"???"+"</Creador>\n"
		
				+"\t<Sinopsis>"+"???"+"</Sinopsis>\n"
	
				+"\t<Plataforma>"+"???"+"</Plataforma>\n"
		
				+"</Videojuego>\n");
		
		//-----------------------------------------------------------------
		
		f.close();//METODO PARA TERMINAR EL PROCESO
		
	}
	public static void CopiarRenombrar(String videojocs,
										String modificado) {
		 
     
		FileInputStream fInput= null;
		FileOutputStream fOuput= null;
		
		try {
			fInput = new FileInputStream (videojocs);
			fOuput = new FileOutputStream(modificado);
			
			int b;
			int cont=0;
			int TamFichero= fInput.available();
			
			while ((b=fInput.read())!=-1) {
				fOuput.write((byte)b);
			}
		
    }
		catch (IOException e) {
			System.out.print("Ha ocurrido un error"
					+ " al procesar el archivo");
			e.printStackTrace();
		}
		finally{
			try {
			if(fInput != null)fInput.close();	
			if(fOuput != null)fOuput.close();
		}
			catch (IOException e2) {
				System.out.print("Ha ocurrido un error"
						+ " al procesar el archivo");
				e2.printStackTrace();
			}
		}
		}
	
		public static void MostrarDatos() throws IOException {
			//CREAMOS VARIABLE PARA LEER EL .txt
			FileReader f=new FileReader(new File("videojocs.xml"));
		//PROCESO DE LECTURA
		int data=f.read();//INTRODUCIMOS VARIABLE (data) nos ayudara en el proceso
		while(data != -1) {
		System.out.print((char)data);
		System.out.print("");
		data=f.read();	
}
		}
		
		
		public static void EditarDatos() throws IOException {
			
			System.out.print("Introduce un Titulo:");
			Scanner s1=new Scanner(System.in);
			Titulo=s1.next();
			
			
			FileWriter f2=new FileWriter(new File("modificado.xml"));
			
			//-----------------------------------------------------------------
			
			f2.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
					
					+"\n"
			
					+"<Videojuego>\n"
		
					+"\t<Titulo creado_en=\"???\">"+Titulo+"</Titulo>\n"
			
					+"\t<Creador>"+"???"+"</Creador>\n"
			
					+"\t<Sinopsis>"+"???"+"</Sinopsis>\n"
		
					+"\t<Plataforma>"+"???"+"</Plataforma>\n"
			
					+"</Videojuego>\n");
			
			//-----------------------------------------------------------------
			
			f2.close();//METODO PARA TERMINAR EL PROCESO
			
		}
}