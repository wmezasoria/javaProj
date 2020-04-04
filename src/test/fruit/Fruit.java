package test.fruit;

/**
 * @author William.Meza
 * @version $Revision: 1.0 $
 */
public class Fruit {
	private String name = null;
	private Long mass = null;
	
	public Fruit(){
	}
	
	/**
	 * @param name
	 * @param mass gr
	 */
	public Fruit(String name, Long mass) {
		super();
		this.name = name;
		this.mass = mass;
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
	 * @return the mass
	 */
	public Long getMass() {
		return mass;
	}
	/**
	 * @param mass the mass to set
	 */
	public void setMass(Long mass) {
		this.mass = mass;
	}
	
	
}
