package webpackage;

import java.util.Random;

import org.httpobjects.DSL;
import org.httpobjects.HttpObject;
import org.httpobjects.Request;
import org.httpobjects.Response;
import org.httpobjects.jetty.HttpObjectsJettyHandler;
import org.joda.time.LocalDate;

/**
 * Hello world!
 *
 */

public class App {
	public static void main(String[] args){
		HttpObject root = new HttpObject("/"){
			@Override
			public Response get(Request req) {
				return OK(Text("Hello World"));
			}
		};
		
//		HttpObject nextMessage = new HttpObject("/nextMessage"){
//			@Override
//			public Response get(Request req) {
//				String[] possibleMessages = {"You're special!",
//											 "You're incredibly pathetic!",
//											 "You're alright, I guess.  Get better tho."};
//				int idx = new Random().nextInt(possibleMessages.length);
//				String message = possibleMessages[idx];
//				return OK(Text(message));
//			}
//		};
		
		
		HttpObject staticContent = DSL.classpathResourcesAt("/webpackage")
									  .servedAt("/");
		HttpObjectsJettyHandler.launchServer(8080, root, staticContent);
//		HttpObjectsJettyHandler.launchServer(8080, root, nextMessage, staticContent);
	}
}
