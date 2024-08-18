package clases;

public class DTProveedor {
	private String nickname;
	private String email;
	
	//constructor
	public DTProveedor(String nickname, String email) {
		super();
		this.nickname = nickname;
		this.email = email;
	}
		
	//setters y getters
	public String getNickname() {
		return nickname;
	}
	
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
		
}
