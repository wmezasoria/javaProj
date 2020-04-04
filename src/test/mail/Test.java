package test.mail;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.xml.bind.JAXB;


public class Test {

	public static void main(String[] args) {
		HttpURLConnection conn = null;
		SalidaEnvioCorreo salidaCorreo = null;
		 
		 
		 try {
			 /*FileInputStream fileInputStream = null;
			 File file = new File("C:\\test.pdf");
			 byte[] bFile = new byte[(int) file.length()];
			 System.out.println("" + file.toURI()+" file pesa "+file.length()/1024 +" KB");
			 fileInputStream = new FileInputStream(file);
			 fileInputStream.read(bFile);
			 System.out.println("byte length " + bFile.length/1024 + " KB" );
			 fileInputStream.close();*/
			 
//			 Path path1 = Paths.get("C:\\test.pdf");
//			 byte[] bFile1 = Files.readAllBytes(path1);
//			 System.out.println("Paths "+bFile1.length/1024+" KB");
			 
//			 Path path2 = Paths.get("C:\\test 2.doc");
//			 byte[] bFile2 = Files.readAllBytes(path2);
//			 System.out.println("Paths "+bFile2.length/1024+" KB");
			 
//			String entradaXml = "<entradaEnvioCorreo><remitente>jorge.villaruel@funcionjudicial.gob.ec</remitente><destino>rocio.cervantes@funcionjudicial.gob.ec</destino><copia>anibal.bravo@funcionjudicial.gob.ec</copia>"
			String entradaXml = "<entradaEnvioCorreo><remitente>jorge.villaruel@funcionjudicial.gob.ec</remitente><destino>wmezasoria@yahoo.com</destino><copia>william.meza@funcionjudicial.gob.ec</copia>"					
					+ "<asunto>Fritadas</asunto>"
					+ "<contenido><![CDATA[<head><meta httpequiv=\"ContentType\" content=\"text/html; charset=UTF-8\"/></head>"
					+ "<html><body>Estimados, es para mi un placer y me complace de sobre manera en este dia poder invitarlos a una fritadita, previo a las fiestas de la capital. Lastima que mi torrido romance, mi gara�oncito, no este. PD: si no les molesta me gustaria invitar al sr padre de chichico de B�ltran <br/> Regards Att Comadre Vaca Loca!!!</body></html>]]></contenido>"
					+ "<adjunto>"
//					+ "<nombreArchivo>"+path1.getFileName().toString() +"</nombreArchivo>"
//						+ "<data>"+new String(com.sun.jersey.core.util.Base64.encode(bFile1))+"</data>"
//					+ "</adjunto>"
//					+ "<adjunto>"
//					+ "<nombreArchivo>"+path2.getFileName().toString() +"</nombreArchivo>"
//						+ "<data>"+new String(com.sun.jersey.core.util.Base64.encode(bFile2))+"</data>"
					+ "</adjunto>"
					+ "</entradaEnvioCorreo>";
			URL url;
			OutputStream oSalida = null;

//			url = new URL("http://10.1.13.126:8080/mensajero/enviarCorreo");//servidor de testing
			url = new URL("http://10.2.13.22:8081/mensajero/enviarCorreo");//servidor de desarrollo
//			url = new URL("http://localhost:8080/mensajero/enviarCorreo");
			conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/xml;charset=utf8");
			conn.setRequestProperty("Accept", "application/xml;charset=utf8");

			oSalida = conn.getOutputStream();

			if (entradaXml != null && entradaXml.length() > 0) {
				oSalida.write(entradaXml.getBytes("UTF-8"));
			}

			oSalida.flush();

			if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED && conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
				throw new RuntimeException("Error -> c�digo Http: " + conn.getResponseCode());
			}

			salidaCorreo = (SalidaEnvioCorreo) JAXB.unmarshal(conn.getInputStream(), SalidaEnvioCorreo.class);

			if (conn != null) {
				conn.disconnect();
			}

			System.out.println("salidaCorreo codigo: " + salidaCorreo.getCabecera().getCodigo());
			System.out.println("salidaCorreo descripcion: " + salidaCorreo.getCabecera().getMensaje());
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
}
