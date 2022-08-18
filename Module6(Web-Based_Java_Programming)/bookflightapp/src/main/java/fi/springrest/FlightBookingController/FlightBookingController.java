package fi.springrest.FlightBookingController;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import fi.springrest.FlightBookingDTO.FlightBookingDTO;

@RestController
@RequestMapping("/TodaysArlines")

public class FlightBookingController {
	@Autowired
	private FlightBookingDTO service;
	

	@GetMapping("/all")
	public ResponseEntity<?> getAllTicketDetails()
	{
		List<FlightBookingController> booking = service.getAllTicektBooking();
		if(booking.isEmpty())
		{
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(booking, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getBookTicketDetails(@PathVariable int id)
	{
		Optional<FlightBookingController> ticketDetails = service.getTicketDetails(id);
		if(ticketDetails.isPresent())
		{
		return new ResponseEntity<>(ticketDetails.get(), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	
	 //c./book – Used for booking the ticket accepting all the parameters
	@PostMapping("/book")
	public ResponseEntity<?> bookTicket(@RequestBody FlightBookingController booking)
	{
		try {
			FlightBookingController Ticket = service.bookTicket(booking);
			return new ResponseEntity<>(Ticket, HttpStatus.OK);

		} catch (RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}