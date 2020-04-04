package test.mail;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Meza W.
 * @version $Revision: 1.0 $
 */
@XmlRootElement(name = "cabecera")
public class Cabecera {
	private String codigo;
	private String mensaje;

	public Cabecera() {
	}

	public Cabecera(String codigo, String mensaje) {
		this.codigo = codigo;
		this.mensaje = mensaje;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
}
