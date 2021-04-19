package application;
public class Ingredient {
	public String nomin;
	private float qte;
	private String unite;
	public Ingredient(String nomin, float qte, String unite) {
		super();
		this.nomin = nomin;
		this.qte = qte;
		this.unite = unite;
	}
	
	public String toString() {
		return this.qte+" "+this.unite+" "+this.nomin;
		
	}
}
