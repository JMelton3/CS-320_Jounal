package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import appointment.AppointmentService;

class AppointmentTest {

	// Testing Adding and Getting appointments.
	@SuppressWarnings("deprecation")
	@Order(1)
	@Test
	public void testAddingTask() {
		AppointmentService service = new AppointmentService();
		
		service.AddAppointment(new Date(2026, 12, 14, 0, 0, 0), "Dentist");
		service.AddAppointment(new Date(2023, 12, 14, 0, 0, 0), "Graduation");
		
		assertEquals("Dentist", service.getAppointment("0").get_description());
		assertEquals(new Date(2026, 12, 14, 0, 0, 0), service.getAppointment("0").get_appointmentDate());
		
		assertEquals("Graduation", service.getAppointment("1").get_description());
		assertEquals(new Date(2023, 12, 14, 0, 0, 0), service.getAppointment("1").get_appointmentDate());
	}
}
