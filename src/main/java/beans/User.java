package beans;

public class User {
	protected int id;
	protected String nom;
	protected String prenom;
	protected String email;
	protected String password;
	protected int identifier;
	protected int admin;
	

	public User(String nom, String prenom, String email, String password, int identifier) {
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.password = password;
		this.identifier = identifier;
		
	}
	public User(int id, String nom, String prenom, String email, String password, int identifier) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.password = password;
		this.identifier = identifier;
		
	}
	public User(int id, String nom, String prenom, String email, String password, int identifier, int admin) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.password = password;
		this.identifier = identifier;
		this.admin = admin;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getIdentifier() {
		return identifier;
	}

	public void setIdentifier(int identifier) {
		this.identifier = identifier;
	}
	
	public int getAdmin() {
		return admin;
	}

	public void setAdmin(int admin) {
		this.admin = admin;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
