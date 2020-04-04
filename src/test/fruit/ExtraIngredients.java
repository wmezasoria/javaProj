package test.fruit;

/**
 * @author William.Meza
 * @version $Revision: 1.0 $
 */
public class ExtraIngredients {
	private String name = null;
	private Double volumen = null;
	
	
	/**
	 * @param name
	 * @param volumen
	 */
	public ExtraIngredients(String name, Double volumen) {
		super();
		this.name = name;
		this.volumen = volumen;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the volumen
	 */
	public Double getVolumen() {
		return volumen;
	}
	/**
	 * @param volumen the volumen to set
	 */
	public void setVolumen(Double volumen) {
		this.volumen = volumen;
	}
	
}
