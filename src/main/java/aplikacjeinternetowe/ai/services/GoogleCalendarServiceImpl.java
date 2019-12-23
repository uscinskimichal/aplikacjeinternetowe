package aplikacjeinternetowe.ai.services;

import aplikacjeinternetowe.ai.controllers.GoogleCalendarController;
import aplikacjeinternetowe.ai.dtos.EventDTOResponse;
import aplikacjeinternetowe.ai.util.AuthorizationCodeInstalledAppCustom;
import aplikacjeinternetowe.ai.dtos.EventDTOInput;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.calendar.Calendar;
import com.google.api.services.calendar.CalendarScopes;
import com.google.api.services.calendar.model.Event;
import com.google.api.services.calendar.model.EventDateTime;
import com.google.api.services.calendar.model.Events;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class GoogleCalendarServiceImpl implements GoogleCalendarService {
    public static String APPLICATION_NAME = "Google Calendar API Java Quickstart";
    public static JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
    public static String TOKENS_DIRECTORY_PATH = "tokens";
    public static List<String> SCOPES = Collections.singletonList(CalendarScopes.CALENDAR_EVENTS);
    public static String CREDENTIALS_FILE_PATH = "/credentials.json";
    public static Calendar service;

    @Override
    public Event addEvent(EventDTOInput eventDTOInput) throws IOException {
        Event event = new Event()
                .setSummary(eventDTOInput.getSummary())
                .setLocation(eventDTOInput.getLocation())
                .setDescription(eventDTOInput.getDescription());

        EventDateTime start = new EventDateTime()
                .setDateTime(eventDTOInput.getDateStart())
                .setTimeZone("Europe/Warsaw");
        event.setStart(start);

        EventDateTime end = new EventDateTime()
                .setDateTime(eventDTOInput.getDateEnd())
                .setTimeZone("Europe/Warsaw");
        event.setEnd(end);

        String calendarId = "primary";
        event = service.events().insert(calendarId, event).execute();
        System.out.printf("Event created: %s\n", event.getHtmlLink());

        return event;
    }


    @Override
    public List<EventDTOResponse> showEvents() throws IOException {
        String pageToken = null;
        List<Event> eventsList = new ArrayList<>();
        List<EventDTOResponse> finalEvents = new ArrayList<>();
        try {
            do {
                Events events = service.events().list("primary").setPageToken(pageToken).execute();
                eventsList.addAll(events.getItems());
                pageToken = events.getNextPageToken();
            } while (pageToken != null);
            eventsList.forEach(a -> System.out.println(a.getStart().getDateTime()));
            eventsList.stream().map(a -> {
                finalEvents.add(new EventDTOResponse(a.getSummary(), a.getDescription(), a.getStart().getDateTime().toString(), a.getEnd().getDateTime().toString(), a.getLocation()));
                return finalEvents;
            }).collect(Collectors.toList());
            return finalEvents;
        } catch (NullPointerException npe) {
            return null;
        }
    }

    @Override
    public void loginCalender(String user) {
        final NetHttpTransport HTTP_TRANSPORT;
        try {
            HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
            service = new Calendar.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT, user))
                    .setApplicationName(APPLICATION_NAME)
                    .build();
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Credential getCredentials(final NetHttpTransport HTTP_TRANSPORT, String user) throws IOException {
        // Load client secrets.
        InputStream in = GoogleCalendarController.class.getResourceAsStream(CREDENTIALS_FILE_PATH);
        if (in == null) {
            throw new FileNotFoundException("Resource not found: " + CREDENTIALS_FILE_PATH);
        }
        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));

        // Build flow and trigger user authorization request.
        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
                HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES)
                .setDataStoreFactory(new FileDataStoreFactory(new java.io.File(TOKENS_DIRECTORY_PATH)))
                .setAccessType("offline")
                .build();

        LocalServerReceiver receiver = new LocalServerReceiver.Builder().setPort(8888).build();
        return new AuthorizationCodeInstalledAppCustom(flow, receiver).authorize(user);
    }

    @Override
    public void logout() {
        Runtime runtime = Runtime.getRuntime();
        try {
            runtime.exec("rundll32 url.dll,FileProtocolHandler https://www.google.com/accounts/Logout?continue=https://appengine.google.com/_ah/logout?continue=http://google.pl");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
