package people;

public class Dentist {
	private String username;
	private String password;
	
	public Dentist(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "Dentist [username=" + username + ", password=" + password + "]";
	}
	public void Print() {
		System.out.println(toString());	}
	
	public boolean validLogin(String inputName, String inputPassword) {
		if(inputName.toUpperCase().equals(getUsername().toUpperCase()) && inputPassword.toUpperCase().equals(getPassword().toUpperCase())) {
			System.out.println("Login Successful\n");
			return true;
		}
		else return false;
	}
}

