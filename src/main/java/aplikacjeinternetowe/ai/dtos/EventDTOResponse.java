package aplikacjeinternetowe.ai.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EventDTOResponse {
    private String summary;
    private String description;
    private String dateStart;
    private String dateEnd;
    private String location;

    public EventDTOResponse(String summary, String description, String dateStart, String dateEnd, String location) {
        this.summary = summary;
        this.description = description;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.location = location;
    }
}