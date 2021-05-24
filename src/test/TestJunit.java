package test;

import org.junit.jupiter.api.Test;

import com.app.startup.TaxiTicketApp;

class TestJunit {

	@Test
	void test() {
		
		TaxiTicketApp.createTicketSystem("pune", "nashik", "2");
	}

}
