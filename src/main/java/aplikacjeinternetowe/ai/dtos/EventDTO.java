package aplikacjeinternetowe.ai.dtos;

import com.google.api.client.util.DateTime;
import com.google.api.services.calendar.model.EventDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EventDTO {
    private String summary;
    private String description;
    private DateTime dateStart;
    private DateTime dateEnd;
    private String status;
    private String location;
}
