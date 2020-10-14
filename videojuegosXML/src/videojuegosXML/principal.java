package videojuegosXML;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class principal {

		public static void main(String[] args) {
					metodos juego= new metodos();
					Scanner sc=new Scanner(System.in);//CREAMOS EL SCANNER PARA LEER LA OPCION (TECLADO) DEL SWITCH
					int opcion;//VARIABLE QUE NOS AYUDARA A UTILIZAR EL SCANNER EN EL SWITCH
					do {
					System.out.println("\n------------SIGUE-ESTOS-PASOS---------------\n"
							+ "  \n\t\t1.CARGAR XML "
							+ "  \n\t\t2.RELLENAR XML "
							+ "  \n\t\t3.MOSTRAR XML"
							+ "  \n\t\t4.Salir\n"
							+ "\n--------------------------------------------");
					
					
					opcion=sc.nextInt();//IGUALAMOS PARA QUE LA VARIABLE ADQUIERA EL METODO	
					switch (opcion) {
					case 1:
						try {
							juego.cargarDatos();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						System.out.println("Archivo cargado satisfactoriamente");
						break;
					case 2:
						try {
							juego.RellenarDatos();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						System.out.println("Datos Rellenados satisfactoriamente");
						break;
					case 3:
						try {
							juego.MostrarDatos();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						break;
					case 4:
						System.out.println("Proceso finalizado");

					}
					
					} while(opcion!=4);		
				
		}
				
				}