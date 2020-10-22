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
					System.out.println("\n------------ELIGE-UN-PROCESO--------------\n"
							+ "  \n\t\t1.CARGAR XML "
							+ "  \n\t\t2.RELLENAR XML "
							+ "  \n\t\t3.MOSTRAR XML"
							+ "  \n\t\t4.EDITAR TITULO XML"
							+ "  \n\t\t5.ELIMINAR TITULO XML"
							+ "  \n\t\t6.COPIAR Y RENOMBRAR XML"
							+ "  \n\t\t7.Salir\n"
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
							
						try {
							
							juego.EditarDatos();
						} catch (IOException e) {
							System.out.print("Ha ocurrido un error"
									+ " al procesar el archivo");
							e.printStackTrace();
						}
						
						break;
						
					case 5:
						
						System.out.println("Datos eliminados satisfactoriamente");
						break;
						
					case 6:
						metodos.CopiarRenombrar("videojocs.xml", "modificado.xml");
						System.out.println("Datos modificados satisfactoriamente");
						break;
						
						
					case 7:
						System.out.println("Proceso finalizado");

					}
					
					} while(opcion!=7);		
				
		}
				
				}