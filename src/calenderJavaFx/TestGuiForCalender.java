package calenderJavaFx;

import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TestGuiForCalender extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		LocalDate theEnd = LocalDate.of(2017, 04, 9);
		LocalDate theStart = LocalDate.of(2017, 04, 06);
		
		CalenderGui gui = new CalenderGui(theStart, theEnd).setShowInfoAndButtons(false);
        Parent root = (Parent) gui.getGUIObjekt();
		primaryStage.setTitle("FXML Welcome");
		primaryStage.setScene(new Scene(root, 300, 275));
		primaryStage.show();
		
		LocalDateTime theEndNumber2 = LocalDateTime.of(2017, 04, 8, 02, 55);
		LocalDateTime startTime = LocalDateTime.of(2017, 04, 8, 02, 10);
		gui.addEvent(new CalendarEvent(startTime, theEndNumber2, "heder hello", "The body for the event is her and is working hopoly"));
		gui.addEvent(new CalendarEvent(LocalDateTime.of(2017, 04, 7, 1, 10), LocalDateTime.of(2017, 04, 7, 03, 45), "heder hello", "The body for the event is her and is working hopoly"));
		gui.addEvent(new CalendarEvent(LocalDateTime.of(2017, 04, 7, 2, 10), LocalDateTime.of(2017, 04, 7, 04, 45), "heder hello", "The body for the event is her and is working hopoly"));
		gui.addEvent(new CalendarEvent(LocalDateTime.of(2017, 04, 6, 1, 10), LocalDateTime.of(2017, 04, 6, 03, 45), "heder hello", "The body for the event is her and is working hopoly"));
		gui.addEvent(new CalendarEvent(LocalDateTime.of(2017, 04, 6, 4, 10), LocalDateTime.of(2017, 04, 6, 5, 45), "heder hello", "The body for the event is her and is working hopoly"));
		gui.addEvent(new CalendarEvent(LocalDateTime.of(2017, 04, 6, 3, 10), LocalDateTime.of(2017, 04, 6, 4, 45), "heder hello", "The body for the event is her and is working hopoly"));
		gui.addEvent(new CalendarEvent(LocalDateTime.of(2017, 04, 6, 2, 10), LocalDateTime.of(2017, 04, 6, 4, 45), "heder hello", "The body for the event is her and is working hopoly"));

		gui.setShowInfoAndButtons(true);
	}

	 public static void main(String[] args) {
//		 TestGuiForCalender.launch(FXMLExample.class, args);
		 TestGuiForCalender.launch();
	    }
	
}
