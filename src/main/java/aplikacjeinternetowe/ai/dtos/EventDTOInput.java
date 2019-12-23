package aplikacjeinternetowe.ai.dtos;

import com.google.api.client.util.DateTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EventDTOInput {
    private String summary;
    private String description;
    private DateTime dateStart;
    private DateTime dateEnd;
    private String location;

}
