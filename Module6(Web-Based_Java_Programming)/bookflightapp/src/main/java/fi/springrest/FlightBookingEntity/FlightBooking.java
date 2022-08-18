package fi.springrest.FlightBookingEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="FlightBooking")

public class FlightBooking {
	@Id
	@Column(name="ticketid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ticketId;
	
	@Column(name="cityfrom")
	private String cityFrom;
	
	@Column(name="cityto")
	private String cityTo;
	
	@Column(name="traveldate")
	private String date;
	
	public FlightBooking()
	{
		
	}
	
	public FlightBooking(int ticketId, String cityFrom, String cityTo, String date) {
		super();
		this.ticketId = ticketId;
		this.cityFrom = cityFrom;
		this.cityTo = cityTo;
		this.date = date;
	}

	public int getTicketId() {
		return ticketId;
	}
	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}
	public String getCityFrom() {
		return cityFrom;
	}
	public void setCityFrom(String cityFrom) {
		this.cityFrom = cityFrom;
	}
	public String getCityTo() {
		return cityTo;
	}
	public void setCityTo(String cityTo) {
		this.cityTo = cityTo;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
}