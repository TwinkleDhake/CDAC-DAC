package fi.springrest.FlightBookingDTO;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import fi.springrest.FlightBookingController.FlightBookingController;

public interface FlightBookingDTO extends JpaRepository<FlightBookingController, Integer> {
	Optional<FlightBookingController> findById(int id);

	Optional<FlightBookingController> getTicketDetails(int id);

	FlightBookingController bookTicket(FlightBookingController booking);

	List<FlightBookingController> getAllTicektBooking();
}
