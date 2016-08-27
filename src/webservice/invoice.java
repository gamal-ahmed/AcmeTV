package webservice;
import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/rest")
public class invoice extends Application {
	private Set<Object> singletons = new HashSet<Object>();

	public invoice() {
	}

	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}
}
