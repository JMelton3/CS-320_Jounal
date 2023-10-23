package appointment;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

import java.util.Date;

public class AppointmentService {

	private static AtomicLong idGenerator = new AtomicLong();
	private ArrayList<Appointment> appointmentList = new ArrayList<Appointment>();
	
	public void AddAppointment(Date appointmentDate, String description) {
		String appointmentID = String.valueOf(idGenerator.getAndIncrement());
		
		if(ValidateAppointment(appointmentID, appointmentDate, description)) {
			Appointment appointment = new Appointment(appointmentID, appointmentDate, description);
			appointmentList.add(appointment);
		}
	}
	
	public Appointment getAppointment(String appointmentID) {
		for (Appointment a : appointmentList) {
            if (a.get_appointmentID().equals(appointmentID)) {
            	return a;
            }
		}
		return null;
	}
	
	public boolean ValidateAppointment(String appointmentID, Date appointmentDate, String description) {
		boolean isValid = true;
		
		Date currDate = new Date();
		
		if(appointmentID == null || appointmentID.length() > 10) {isValid = false;}
		if(appointmentDate == null || appointmentDate.before(currDate)) {isValid = false;}
		if(description == null || description.length() > 50) {isValid = false;}
		
		if(!isValid) {
			throw new IllegalArgumentException("Appointment is not valid");
		}		
		return isValid;
	}
	
	public void DeleteAppoinment(String appointmentID) {
		for (Appointment a : appointmentList) {
            if (a.get_appointmentID().equals(appointmentID)) {
            	appointmentList.remove(a);
            	break;
            }
		}
	}
}
