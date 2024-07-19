package buppan;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CartController
 */
public class CartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<String, String> commands;
       
	private String commandsTable[][] = {
			{"init", "CommandIninCart"},
			{"add", "CommandAdd"},
			{"buy", "CommandBuy"},
			{"remove", "CommandRemove"},
			{"removeall", "CommandRemoveAll"}
	};
	
	public void init() throws ServletException{
		
		commands = new HashMap<String, String>();
		for(int i=0; i < commandsTable.length; i++){
			commands.put(commandsTable[i][0], commandsTable[i][1]);
		}
	}
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String action = request.getParameter("action");
		if(action == null) action = "init";
		
		String className = commands.get(action);
		Command command;
		
		try{
			
				command = (Command) (Class.forName("buppan." + className).getDeclaredConstructor().newInstance());
			
			String url = command.execute(request, response);
			
			ServletContext context = getServletContext();
			RequestDispatcher rd = context.getRequestDispatcher(url);
			rd.forward(request, response);
			
		}catch (InstantiationException e){
			e.printStackTrace();
		}catch (IllegalAccessException e){
			e.printStackTrace();
		}catch (ClassNotFoundException e){
			e.printStackTrace();
		} catch (IllegalArgumentException | InvocationTargetException | NoSuchMethodException
				| SecurityException e) {
			e.printStackTrace();
		}
	}

}
