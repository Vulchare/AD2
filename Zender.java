package getTextClass;


public class Zender {

	private String id = "";
	private String naam = "";
	private String kortNaam = "";
	
	public Zender(String id, String naam, String kortNaam) {
		this.id = id;
		this.naam = naam;
		this.kortNaam = kortNaam;		
	}
	
	public String getId() {
		return id;
	}

	public String getNaam() {
		return naam;
	}

	public String getKortNaam() {
		return kortNaam;
	}
}
