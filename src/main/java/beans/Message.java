package beans;

public class Message {
	 	protected int id;
		protected String fullname;
		protected String email;
	    protected String phone;
	    protected String message;

	    public Message(int id, String fullname, String email, String phone, String message) {
			this.id = id;
			this.fullname = fullname;
			this.email = email;
			this.phone = phone;
			this.message = message;
		}
	    
	    public Message(String fullname, String email, String phone, String message) {
			this.fullname = fullname;
			this.email = email;
			this.phone = phone;
			this.message = message;
		}
	    
	    public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getFullname() {
			return fullname;
		}

		public void setFullname(String fullname) {
			this.fullname = fullname;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

}
