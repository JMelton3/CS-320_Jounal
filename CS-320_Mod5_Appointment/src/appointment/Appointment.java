package appointment;

import java.util.Date;

public class Appointment {

	private String _appointmentID;
	private Date _appointmentDate;
	private String _description;
	
	public Appointment(String appointmentID, Date appointmentDate, String description) {
		set_appointmentID(appointmentID);
		set_appointmentDate(appointmentDate);		
		set_description(description);
	}

	public String get_appointmentID() {
		return _appointmentID;
	}

	public void set_appointmentID(String _appointmentID) {
		this._appointmentID = _appointmentID;
	}

	public Date get_appointmentDate() {
		return _appointmentDate;
	}

	public void set_appointmentDate(Date _appointmentDate) {
		this._appointmentDate = _appointmentDate;
	}

	public String get_description() {
		return _description;
	}

	public void set_description(String _description) {
		this._description = _description;
	}	
}