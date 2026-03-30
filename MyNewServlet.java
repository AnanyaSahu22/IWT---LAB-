import java.io.IOException;


/**
 * Servlet implementation class MyNewServlet
 */
@WebServlet("/MyNewServlet")
public class MyNewServlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public MyNewServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		out.println("Hello,Welcome to the world of servlets");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}





