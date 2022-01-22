package beans;

public class Chambre {
	 protected int id;
	    protected String numero;
	    protected String type;
	    protected String prix;
	    protected String image;

	    public String getImage() {
			return image;
		}

		public void setImage(String image) {
			this.image = image;
		}

		public Chambre(int id, String numero, String type, String prix,String image) {
	        this.id = id;
	        this.numero = numero;
	        this.type = type;
	        this.prix = prix;
	        this.image = image;
	    }


	    public int getId() {
	        return id;
	    }

	    public void setId(int id) {
	        this.id = id;
	    }

	    public String getNumero() {
	        return numero;
	    }

	    public void setNumero(String numero) {
	        this.numero = numero;
	    }

	    public String getType() {
	        return type;
	    }

	    public void setType(String type) {
	        this.type = type;
	    }

	    public String getPrix() {
	        return prix;
	    }

	    public void setPrix(String prix) {
	        this.prix = prix;
	    }

}
