package com.fortnight.todoist;

import java.awt.Desktop;
import java.awt.Desktop.Action;
import java.io.IOException;
import java.net.URI;
import java.util.logging.Level;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fortnight.cmdline.Command;


public class LinkTodoistAccount implements Command {
	public static final String ACCESS_TOKEN_URL="https://todoist.com/oauth/access_token";
	public static final String SERVICE_URL="https://todoist.com/oauth/authorize";
	public static final Logger LOGGER = LoggerFactory.getLogger(LinkTodoistAccount.class);

	public ClientDetails clientDetails;
	
	public ClientDetails getClientDetails() {
		return clientDetails;
	}

	public void setClientDetails(ClientDetails clientDetails) {
		this.clientDetails = clientDetails;
	}
	
	public String getAuthroizeURL() {
		String url = SERVICE_URL+"/"+"client_id="+clientDetails.getClientId();
		url+="&scope="+clientDetails.getScope()+"&state="+clientDetails.getState();
		return url;
	}

	@Override
	public void execute() throws IOException {
		String authorizeURL = getAuthroizeURL();
		openBrowser(authorizeURL);
		LocalServerReceiver localServerReceiver=new LocalServerReceiver();
		localServerReceiver.getRedirectUri();
		String code=localServerReceiver.waitForCode();
		
	}
	
	public void openBrowser(String url) {
	    System.out.println("Please open the following address in your browser:");
	    System.out.println("  " + url);
	    // Attempt to open it in the browser
	    try {
	      if (Desktop.isDesktopSupported()) {
	        Desktop desktop = Desktop.getDesktop();
	        if (desktop.isSupported(Action.BROWSE)) {
	          System.out.println("Attempting to open that address in the default browser now...");
	          desktop.browse(URI.create(url));
	        }
	      }
	    } catch (IOException e) {
	      LOGGER.warn("Unable to open browser,{}", e);
	    } catch (InternalError e) {
	      // A bug in a JRE can cause Desktop.isDesktopSupported() to throw an
	      // InternalError rather than returning false. The error reads,
	      // "Can't connect to X11 window server using ':0.0' as the value of the
	      // DISPLAY variable." The exact error message may vary slightly.
	      LOGGER.warn("Unable to open browser", e);
	    }
	}

}
