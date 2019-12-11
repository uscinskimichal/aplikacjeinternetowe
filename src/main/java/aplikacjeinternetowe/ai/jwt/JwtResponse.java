package aplikacjeinternetowe.ai.jwt;

import java.io.Serializable;

public class JwtResponse implements Serializable {

    private static final long serialVersionUID = -8091879091924046844L;
    private final String jwttoken;
    private int userId;
    private String role;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public JwtResponse(String jwttoken, int userId, String role) {
        this.jwttoken = jwttoken;
        this.userId = userId;
        this.role = role;
    }

    public String getToken() {
        return this.jwttoken;
    }
}
