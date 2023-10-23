package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer;

import appointment.AppointmentService;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AppointmentServiceTest {
	AppointmentService service = new AppointmentService();
		
	// Testing invalid length
	@SuppressWarnings("deprecation")
	@Order(6)
	@Test
	void testDescriptionLength() {
		// Exactly 50 length
		service.AddAppointment(new Date(2023, 12, 14, 15, 12, 10), "This will be mowing the lawn and it will look good");
		assertEquals(new Date(2023, 12, 14, 15, 12, 10), service.getAppointment("6").get_appointmentDate());
		assertEquals("This will be mowing the lawn and it will look good", service.getAppointment("6").get_description());	
		
		// Over 50 length
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.AddAppointment(new Date(2023, 12, 12, 12, 12, 10), "This will be mowing the lawn and it will look good.");
		});
	}
	
	@SuppressWarnings("deprecation")
	@Order(5)
	@Test
	void testPastDate() {		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.AddAppointment(new Date(50, 05, 0, 0, 0, 0), "date with Sandy");
		});
	}
	
	//Testing nulls
	@SuppressWarnings("deprecation")
	@Order(4)
	@Test
	void testNullDescription() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.AddAppointment(new Date(2024, 05, 14, 15, 12, 10), null);
		});
	}
	
	@Order(3)
	@Test
	void testNullDate() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.AddAppointment(null, "Yearly checkup");
		});
	}
	
	// testing update and delete.
	@SuppressWarnings("deprecation")
	@Order(2)
	@Test
	public void testDeleteAppointment() {
		
		service.AddAppointment(new Date(2024, 05, 14, 15, 12, 10), "Foot Doctor");
		
		assertEquals("Foot Doctor", service.getAppointment("2").get_description());
		assertEquals(new Date(2024, 05, 14, 15, 12, 10), service.getAppointment("2").get_appointmentDate());
		
		service.DeleteAppoinment("2");
		
		assertNull(service.getAppointment("2"));			
	}
	
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
