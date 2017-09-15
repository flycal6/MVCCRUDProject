package data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Component
public class LostTeamDAOImpl implements LostTeamDAO {
	@Autowired
	private WebApplicationContext wac;
	
	@Override
	public String getHello() {
		return "Hello";
	}
}
