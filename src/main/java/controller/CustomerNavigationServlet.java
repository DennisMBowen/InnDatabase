package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Customer;
import model.HotelRoom;

/**
 * Servlet implementation class CustomerNavigationServlet
 */
@WebServlet("/customerNavigationServlet")
public class CustomerNavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerNavigationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		CustomerHelper ch = new CustomerHelper();
		HotelRoomHelper hrh = new HotelRoomHelper();
		String act = request.getParameter("doThisToItem");
		
		String path = "/viewAllCustomersServlet";
		
		if (act.equals("Delete Customer from Database")) {
			try {
				Integer customerId = Integer.parseInt(request.getParameter("id"));
				ch.deleteCustomer(customerId);
			} catch (NumberFormatException e) {
				System.out.println("Forgot to select customer");
			}
		} else if (act.equals("Remove Hotel Room")) {
			try {
				Integer customerId = Integer.parseInt(request.getParameter("id"));
				Customer customer = ch.findCustomer(customerId);
				HotelRoom room = hrh.findHotelRoom(customer.getRoom().getId());
				customer.setRoom(null);
				room.setGuest(null);
				hrh.updateRoom(room);
				ch.updateCustomer(customer);
			} catch (NumberFormatException e) {
				System.out.println("Forgot to select customer");
			}
		
		} else if (act.equals("View Hotel Rooms")) {
			path = "/viewAllRoomsServlet";
		}

		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

}
