package aplikacjeinternetowe.ai.services;

import org.springframework.stereotype.Service;

@Service
public interface RemindPasswordService {

    String remindPassword(String email);
}
