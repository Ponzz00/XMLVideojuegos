package acceso_de_datos;
import java.util.Objects;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.Reader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class EjercicioDOM{
	static Document doc;//CARGAMOS EL ARCHIVO
	public static Document CargarXML(String xml) throws ParserConfigurationException, 
			SAXException, IOException, TransformerException {
		
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.parse(new File(xml));
		return doc;
	}
	
	public static void ModificarTitulo (String titulo1, String titulo2) {
		//METODO PARA MODIFICAR UN VIDEOJUEGO YA EXISTENTE
		NodeList elements = doc.getElementsByTagName("videojoc");
		int i=0;
		Node node = elements.item(i);
		Element element = (Element) node;
		String escribir = element.getElementsByTagName("titol").item(0).getTextContent();
		while (!Objects.equals(escribir, titulo1)) {
			i++;
			node = elements.item(i);
			element = (Element) node;
			escribir = element.getElementsByTagName("titol").item(0).getTextContent();
		
		}
		element.getElementsByTagName("titol").item(0).setTextContent(titulo2);
	
	}
	public static void EliminarJuego (String Eliminar) {
		NodeList elementos = doc.getElementsByTagName("videojoc");
	
		int i = 0;
		Node node = elementos.item(0);
		Element element = (Element) node;
		String NuevoTitulo = element.getElementsByTagName("titol").item(0).getTextContent();
		while (!Objects.equals(NuevoTitulo, Eliminar)) {
			i++;
			node = elementos.item(i);
			element = (Element) node;
			NuevoTitulo = element.getElementsByTagName("titol").item(0).getTextContent();	
			}
		element.getParentNode().removeChild(element);
		}
	
	public static void ModificarArchivoXML (Document doc) throws TransformerException { //modificar el xml
		TransformerFactory tf = TransformerFactory.newInstance();
        Transformer t = tf.newTransformer();
        t.setOutputProperty(OutputKeys.ENCODING,"UTF-8");
        t.setOutputProperty(OutputKeys.INDENT, "yes");
        DOMSource source = new DOMSource(doc);
        StreamResult file = new StreamResult(new File("modificat.xml"));//SE CREARA AUTMATICAMENTE ESTE ARCHIVO 
        																//CON ESTE NOMBRE JUNTO A LOS CAMBIOS REALIZADOS
        t.transform(source, file);
    }
		
	
	
	public static void MostrarArbol (Document doc) { //EL METODO QUE NOS AYUDARA A MOSTRAR EL XML EN CONSOLA
		NodeList nodes = doc.getElementsByTagName("videojoc");
		for (int i=0; i<nodes.getLength();i++) {
			System.out.println("_______________________________________________");//PONGO BARRAS PARA SEPARAR LOS JUEGOS
			Node node = nodes.item(i);
			Element Elemento = (Element) node;//Element= CADA ETIQUETA DEL XML
			System.out.println("\nCreado en: "+ Elemento.getAttribute("creat_en"));
			System.out.println("Titulo: "+ Elemento.getElementsByTagName("titol").item(0).getTextContent());
			System.out.println("Creador: "+ Elemento.getElementsByTagName("creador").item(0).getTextContent());
			System.out.println("Sinopsis; "+ Elemento.getElementsByTagName("sinopsis").item(0).getTextContent());
			System.out.println("Plataforma: "+ Elemento.getElementsByTagName("plataforma").item(0).getTextContent());
			
		}
		}

	
public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, TransformerException {
		
		Scanner sc=new Scanner(System.in);//CREAMOS EL SCANNER PARA LEER LA OPCION (TECLADO) DEL SWITCH
		int opcion;//VARIABLE QUE NOS AYUDARA A UTILIZAR EL SCANNER EN EL SWITCH
		
		do { //USO EL DO--> WHILE PARA QUE CADA VEZ MUESTRE DE NUEVO EL MENU DESPUES DE ELEGIR UNA OPCION
		System.out.println("\n------------ELIGE-UN-PROCESO--------------\n"
				+ "  \n\t\t1.CARGAR XML "
				+ "  \n\t\t2.MOSTRAR XML"
				+ "  \n\t\t3.EDITAR TITULO XML"
				+ "  \n\t\t4.ELIMINAR TITULO XML"
				+ "  \n\t\t5.GUARDAR CAMBIOS EN NUEVO XML"
				+ "  \n\t\t6.SALIR\n"
				+ "\n--------------------------------------------");
		
		
		opcion=sc.nextInt();//IGUALAMOS PARA QUE LA VARIABLE ADQUIERA EL METODO	
		switch (opcion) {//USO EL SWITCH PARA FACILITAR AL USUARIO EL PROCESO DE 
						//ELECCION DE ACCIONES Y MEJORAR LA ESTETICA
		case 1:
			try {
				//LLAMADA AL METODO CARGAR XML
				doc = CargarXML("videojocs.xml");
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			System.out.println("Archivo cargado satisfactoriamente.");
			break;
		case 2:
			//LLAMADA AL METODO DE MOSTRAR ARCHIVO XML
			MostrarArbol(doc); 
			
			break;
		case 3:
			//LLAMADAS AL METODO DE MODIFICACION DE TITULO
			ModificarTitulo("FIFA 15", "PES 15");
			ModificarTitulo("XMen Evolve", "X MEN Adventures");
			System.out.println("Datos de: [FIFA 15]/[XMen Evolve] Editados satisfactoriamente.");
			break;
				
		case 4:
			//LLAMADA AL METODO DE ELIMINACION DE JUEGO
			EliminarJuego("League Of Legends");
			System.out.println("Datos de [League Of Legends] eliminados satisfactoriamente.");
			break;
			
		case 5:
			//LLAMADA AL METODO DE CREACION DE NUEVO ARCHIVO CON LOS CAMBIOS REALIZADOS
			ModificarArchivoXML(doc);
			System.out.println("Datos modificados en nuevo XML(modificat.xml) Satisfactoriamente.");
			break;
			
			
		case 6:
			//LLAMADA AL METODO DE FINALIZAR PROCESO
			System.out.println("Proceso finalizado.");

		}
		
		}while(opcion!=6);	// EL PROCESO DE REPETICION DE MENU NO FINALIZARA 
							//HASTA QUE SE PULSE LA TECLA 6	
		}


}
				
				
				
				
				
				
				
				
				