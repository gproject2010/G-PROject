package buppan;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;

public interface Command {
	
	abstract String execute(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException;

}
