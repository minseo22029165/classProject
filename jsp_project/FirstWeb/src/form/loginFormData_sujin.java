package form;

public class loginFormData_sujin {
	String userId;
	String userPw;
	String idChk;
	
	public loginFormData_sujin() {
	}

	public loginFormData_sujin(String userId, String userPw, String idChk) {
		this.userId = userId;
		this.userPw = userPw;
		this.idChk = idChk;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setIdChk(String idChk) {
		this.idChk = idChk;
	}

	public String getUserPw() {
		return userPw;
	}

	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}

	public String getIdChk() {
		return idChk;
	}

	@Override
	public String toString() {
		return "loginFormData_sujin [userId=" + userId + ", userPw=" + userPw + ", idChk=" + idChk + "]";
	}

	
}
