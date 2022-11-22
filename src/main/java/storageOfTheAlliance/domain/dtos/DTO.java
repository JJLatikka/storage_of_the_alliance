package storageOfTheAlliance.domain.dtos;

public class DTO {

	private String alert;

	public DTO(String s) {
		this.alert = s;
	}

	public String getAlert() {
		return alert;
	}

	public void setAlert(String s) {
		this.alert = s;
	}

	@Override
	public String toString() {
		return String.format("DTO{ alert: %s }", alert);
	}

}
