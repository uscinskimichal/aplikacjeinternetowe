package aplikacjeinternetowe.ai.controllers;

import aplikacjeinternetowe.ai.services.GoogleCalendarServiceImpl;
import aplikacjeinternetowe.ai.dtos.EventDTO;
import com.google.api.services.calendar.model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;




@RestController
public class GoogleCalendarController {


    @Autowired
    GoogleCalendarServiceImpl googleCalendarService;

    @GetMapping("/calendar/logout")
    public void exit() {
        googleCalendarService.logout();
    }

    @GetMapping("/calendar/login")
    public void loginCalendar(@RequestParam String user) {
        googleCalendarService.loginCalender(user);
    }

    @PostMapping("/calendar/addEvent")
    public ResponseEntity<Event> setEvent(@RequestBody EventDTO eventDTO) throws IOException {
        return new ResponseEntity<>(googleCalendarService.addEvent(eventDTO), HttpStatus.OK);
    }

    @GetMapping("/calendar/events")
    public ResponseEntity<List<Event>> getEvents() throws IOException {
        return new ResponseEntity<>(googleCalendarService.showEvents(), HttpStatus.OK);
    }
}