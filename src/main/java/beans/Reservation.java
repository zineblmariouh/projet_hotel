package beans;

import java.util.Date;


public class Reservation {
	protected String First_name;
	protected String Last_name;
	protected String Email;
	protected String Country;
	protected String Phone;
	protected String dateDebut;
	protected String dateFin;
	protected String Numero;
	protected int reserved;

	public int getReserved() {
		return reserved;
	}

	public void setReserved(int reserved) {
		this.reserved = reserved;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	protected String image;
	protected String prix;
	protected String id;

	

	public Reservation(String first_name, String last_name, String email, String country, String phone,
			String dateDebut, String dateFin,
			String id, String Numero, String prix, String image, int reserved) {

		this.First_name = first_name;
		this.Last_name = last_name;
		this.Email = email;
		this.Country = country;
		this.Phone = phone;
		
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.id = id;
		this.Numero = Numero;
		this.image = image;
		this.prix = prix;
		this.reserved = reserved;
	
	}

	public Reservation(String id, String first_name, String last_name, String email, String country, String phone,
		 String dateDebut, String dateFin
			) {
		this.id = id;
		this.First_name = first_name;
		this.Last_name = last_name;
		this.Email = email;
		this.Country = country;
		this.Phone = phone;
		
		
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}



	public String getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(String dateDebut) {
		this.dateDebut = dateDebut;
	}

	public String getDateFin() {
		return dateFin;
	}

	public void setDateFin(String dateFin) {
		this.dateFin = dateFin;
	}

	public String getFirst_name() {
		return First_name;
	}

	public void setFirst_name(String first_name) {
		First_name = first_name;
	}

	public String getLast_name() {
		return Last_name;
	}

	public void setLast_name(String last_name) {
		Last_name = last_name;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getCountry() {
		return Country;
	}

	public void setCountry(String country) {
		Country = country;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}
	
	public String getNumero() {
		return Numero;
	}

	public void setNumero(String numero) {
		Numero = numero;
	}

	public String getType() {
		return image;
	}

	public void setType(String image) {
		this.image = image;
	}

	public String getPrix() {
		return prix;
	}

	public void setPrix(String prix) {
		this.prix = prix;
	}

	
	

}
