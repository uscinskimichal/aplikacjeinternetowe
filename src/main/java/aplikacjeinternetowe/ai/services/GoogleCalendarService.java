package aplikacjeinternetowe.ai.services;

import aplikacjeinternetowe.ai.dtos.EventDTOInput;
import aplikacjeinternetowe.ai.dtos.EventDTOResponse;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.services.calendar.model.Event;

import java.io.IOException;
import java.util.List;

public interface GoogleCalendarService {

    Event addEvent(EventDTOInput eventDTOInput) throws IOException;

    List<EventDTOResponse> showEvents() throws IOException;

    void loginCalender(String user);

    Credential getCredentials(final NetHttpTransport HTTP_TRANSPORT, String user) throws IOException;

    void logout();
}
