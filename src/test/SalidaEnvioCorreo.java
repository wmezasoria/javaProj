package com.test;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "salidaEnvioCorreo")
public class SalidaEnvioCorreo {
	private Cabecera cabecera;

	public SalidaEnvioCorreo() {
	}

	public Cabecera getCabecera() {
		return cabecera;
	}

	public void setCabecera(Cabecera cabecera) {
		this.cabecera = cabecera;
	}

}
