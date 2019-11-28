package aplikacjeinternetowe.ai.services;

import aplikacjeinternetowe.ai.loginForms.LoginForm;
import aplikacjeinternetowe.ai.loginForms.LoginFormResponse;

public interface LoginService {

    LoginFormResponse login(LoginForm loginForm);

}
