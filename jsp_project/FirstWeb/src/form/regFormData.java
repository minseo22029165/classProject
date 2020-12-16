package form;

public class regFormData {
	String userId;
	String userPw;
	String userName;
	String userPhoto;
	
	public regFormData() {
	}

	public regFormData(String userId, String userPw, String userName, String userPhoto) {
		this.userId = userId;
		this.userPw = userPw;
		this.userName = userName;
		this.userPhoto = userPhoto;
	}
	
	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getUserPw() {
		return userPw;
	}


	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getUserPhoto() {
		return userPhoto;
	}


	public void setUserPhoto(String userPhoto) {
		this.userPhoto = userPhoto;
	}

	@Override
	public String toString() {
		return "regFormData [userId=" + userId + ", userPw=" + userPw + ", userName=" + userName + ", userPhoto="
				+ userPhoto + "]";
	}
}
