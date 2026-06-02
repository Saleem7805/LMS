package com.product.lms.students;

public class ResetPasswordDTO {
	
	private String pibId;
	private String oldPassword;
	private String newPassword;
	public String getPibId() {
		return pibId;
	}
	public void setPibId(String pibId) {
		this.pibId = pibId;
	}
	public String getOldPassword() {
		return oldPassword;
	}
	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	
	


}
