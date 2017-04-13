package calenderJavaFx;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

import dayGrapics.CalenderEvent;
import dayGrapics.Time;

public class CalendarEvent {
	
	HashMap<LocalDate, CalenderEvent> calenderEventParts = new HashMap<>();
	private LocalDateTime from =null;
	private LocalDateTime to = null;
	private String heder;
	private String body;
	public CalendarEvent(LocalDateTime timeOne, LocalDateTime TimeTwo, String hedder, String body) throws Exception {
		from = getFirstDateTime(timeOne, TimeTwo);
		to = getLastDateTime(timeOne, TimeTwo);
		this.heder =hedder;
		this.body = body;
		
		createCalenderEvents();
	}

	private void createCalenderEvents() throws Exception {
		
		if(from.toLocalDate().equals(to.toLocalDate()))
			calenderEventParts.put(from.toLocalDate(), new CalenderEvent(new Time(from.getHour(), from.getMinute()), new Time(to.getHour(),to.getMinute()), heder, body));
		else
			throw new Exception("not impelmented to suport event spaning mor than one day yet!");
		
	}

	private LocalDateTime getLastDateTime(LocalDateTime timeOne, LocalDateTime timeTwo) {
		if(timeOne.isBefore(timeTwo))
			return timeTwo;
		else 
			return timeOne;
	}

	private LocalDateTime getFirstDateTime(LocalDateTime timeOne, LocalDateTime timeTwo) {
		if(timeOne.isBefore(timeTwo))
			return timeOne;
		else 
			return timeTwo;
	}
	
	public ArrayList<CalenderEvent> getCalenderEventsConnected(){
		return new ArrayList<>(calenderEventParts.values());
	}

	public LocalDateTime getFromDateTime() {
		return from;
	}

	public ArrayList<LocalDate> getDatesForEvent() {
		return new ArrayList<>(calenderEventParts.keySet());
	}

	public CalenderEvent getEventObjektForDay(LocalDate eventDate) {
		return  calenderEventParts.get(eventDate);
	}
}
