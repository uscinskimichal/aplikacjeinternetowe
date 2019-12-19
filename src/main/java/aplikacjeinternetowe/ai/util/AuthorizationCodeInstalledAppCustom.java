package aplikacjeinternetowe.ai.util;

import com.google.api.client.auth.oauth2.AuthorizationCodeFlow;
import com.google.api.client.auth.oauth2.AuthorizationCodeRequestUrl;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.auth.oauth2.TokenResponse;
import com.google.api.client.extensions.java6.auth.oauth2.VerificationCodeReceiver;
import com.google.api.client.util.Preconditions;
import java.awt.Desktop;
import java.awt.Desktop.Action;
import java.io.IOException;
import java.net.URI;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AuthorizationCodeInstalledAppCustom {
    private final AuthorizationCodeFlow flow;
    private final VerificationCodeReceiver receiver;
    private static final Logger LOGGER = Logger.getLogger(com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp.class.getName());
    private final com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp.Browser browser;

    public AuthorizationCodeInstalledAppCustom(AuthorizationCodeFlow flow, VerificationCodeReceiver receiver) {
        this(flow, receiver, new com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp.DefaultBrowser());
    }

    public AuthorizationCodeInstalledAppCustom(AuthorizationCodeFlow flow, VerificationCodeReceiver receiver, com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp.Browser browser) {
        this.flow = (AuthorizationCodeFlow)Preconditions.checkNotNull(flow);
        this.receiver = (VerificationCodeReceiver)Preconditions.checkNotNull(receiver);
        this.browser = browser;
    }

    public Credential authorize(String userId) throws IOException {
        Credential var3;
        try {
            Credential credential = this.flow.loadCredential(userId);
            if (credential == null || credential.getRefreshToken() == null && credential.getExpiresInSeconds() != null && credential.getExpiresInSeconds() <= 60L) {
                String redirectUri = this.receiver.getRedirectUri();
                AuthorizationCodeRequestUrl authorizationUrl = this.flow.newAuthorizationUrl().setRedirectUri(redirectUri);
                this.onAuthorization(authorizationUrl);
                String code = this.receiver.waitForCode();
                TokenResponse response = this.flow.newTokenRequest(code).setRedirectUri(redirectUri).execute();
                Credential var7 = this.flow.createAndStoreCredential(response, userId);
                return var7;
            }

            var3 = credential;
        } finally {
            this.receiver.stop();
        }

        return var3;
    }

    protected void onAuthorization(AuthorizationCodeRequestUrl authorizationUrl) throws IOException {
        String url = authorizationUrl.build();
        Preconditions.checkNotNull(url);
        this.browse(url);
    }

    public static void browse(String url) {
        Preconditions.checkNotNull(url);
        System.out.println("Please open the following address in your browser:");
        System.out.println("  " + url);
        if(Desktop.isDesktopSupported()) {

        }
        else {
            Runtime runtime = Runtime.getRuntime();
            try {
                runtime.exec("rundll32 url.dll,FileProtocolHandler " + url);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            if (Desktop.isDesktopSupported()) {
                Desktop desktop = Desktop.getDesktop();
                if (desktop.isSupported(Action.BROWSE)) {
                    System.out.println("Attempting to open that address in the default browser now...");
                    desktop.browse(URI.create(url));
                }
            }
        } catch (IOException var2) {
            LOGGER.log(Level.WARNING, "Unable to open browser", var2);
        } catch (InternalError var3) {
            LOGGER.log(Level.WARNING, "Unable to open browser", var3);
        }

    }

    public final AuthorizationCodeFlow getFlow() {
        return this.flow;
    }

    public final VerificationCodeReceiver getReceiver() {
        return this.receiver;
    }

    public static class DefaultBrowser implements com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp.Browser {
        public DefaultBrowser() {
        }

        public void browse(String url) throws IOException {
            com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp.browse(url);
        }
    }

    public interface Browser {
        void browse(String var1) throws IOException;
    }
}
