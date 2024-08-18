package clases;

public class DTCliente {
	private String nickname;
	private String email;
	
	//constructor
	public DTCliente(String nickname, String email) {
		super();
		this.nickname = nickname;
		this.email = email;
	}
		
	//getters y setters
	public String getNickname() {
		return nickname;
	}
	
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmall(String email) {
		this.email = email;
	}
	
}
