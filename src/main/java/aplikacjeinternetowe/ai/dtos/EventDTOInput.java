package aplikacjeinternetowe.ai.dtos;

import com.google.api.client.util.DateTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EventDTOInput {
    private String summary;
    private String description;
    private String dateStart;
    private String timeStart;
    private String dateEnd;
    private String timeEnd;
    private String location;
}
