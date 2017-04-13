package calenderJavaFx;

import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;

import dayGrapics.CalenderBuilderContainer;
import dayGrapics.CalenderBuilderContainer.view;
import dayGrapics.CalenderEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class CalenderGui {
	
	private HashMap<LocalDate, CalenderBuilderContainer> days = new HashMap<>();
//	private Has
	private ArrayList<CalendarEvent> calenderEvents = new ArrayList<>();
	private LocalDate from = null;
	private LocalDate to = null;
	private int numberOfDays;
	private Node toppen;
	
	public CalenderGui(LocalDate from,int numberOfDays) {
		this(from, from.plusDays(numberOfDays));
	}
	
	public CalenderGui(LocalDate from, LocalDate to) {
		this.from = from;
		this.to= to;
		turnFromToRight();
		numberOfDays = numberOfDaysBetwen(from, to);
	}
	
	public Node getGUIObjekt() throws IOException{
		if(toppen == null){
			toppen = FXMLLoader.load(getClass().getResource("InterfaceCalender.fxml"));
			Text infotext = (Text) toppen.lookup("#infoText");
			infotext.setText("hello world stuff is working");
			fillUppWhitDayViews();
			setButtonActions();
			setShowInfoAndButtons(showInfoAndButtons);
		}
		return toppen;
	}

	private void setButtonActions() {
		Button goToErlyer = (Button) toppen.lookup("#");
	}

	private void fillUppWhitDayViews() {
		LocalDate datOnRightNow = from;
		for(int i =0; i < numberOfDays;i++){
			GridPane calenderPanel = new GridPane();
			calenderPanel.setId(datOnRightNow.toString());
			CalenderBuilderContainer calenderController = new CalenderBuilderContainer(calenderPanel, view.dayView);
			days.put(datOnRightNow, calenderController);
			VBox box = new VBox(new Text(datOnRightNow.toString()), calenderPanel);
			box.setId(datOnRightNow.toString());
			HBox calenderBox = (HBox) toppen.lookup("#CalnderSpace");
			calenderBox.getChildren().add(box);
			calenderBox.setHgrow(box, Priority.ALWAYS);
			datOnRightNow = datOnRightNow.plusDays(1);
		}
	}

	private void turnFromToRight() {
		if(from.isBefore(to)){
			
		}else{
			LocalDate temp = from;
			from = to;
			to = temp;
		}
	}
	
	public int numberOfDaysBetwen(LocalDate from, LocalDate to){
		return (int) ChronoUnit.DAYS.between(from, to); 
	}
	
	public void addEvent(CalendarEvent event){
		calenderEvents.add(event);
//		for(CalenderEvent eventPrimitiv : event.getCalenderEventsConnected()){
		for(LocalDate eventDate : event.getDatesForEvent()){
			if(days.get(eventDate)!=null)
				days.get(eventDate).addEvent(event.getEventObjektForDay(eventDate));
		}
		
	}

	private BorderPane topPane;
	private boolean showInfoAndButtons = true;
	public CalenderGui setShowInfoAndButtons(boolean activ) {
		showInfoAndButtons = activ;
		if(!activ){
			if(toppen !=null){
				topPane = (BorderPane) ((BorderPane) toppen.lookup("#MainTopBorder")).getTop();
				((BorderPane)toppen.lookup("#MainTopBorder")).setTop(null);
			}
		}else{
			if(topPane!=null)
				((BorderPane)toppen.lookup("#MainTopBorder")).setTop(topPane);
		}
		return this;
	}
}
