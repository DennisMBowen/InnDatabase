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
 * Servlet implementation class AddCustomerServlet
 */
@WebServlet("/addCustomerServlet")
public class AddCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCustomerServlet() {
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
		HotelRoomHelper hrh = new HotelRoomHelper();
		CustomerHelper ch = new CustomerHelper();
		
		// TODO Auto-generated method stub
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String phoneNumber = request.getParameter("phoneNumber");
		String email = request.getParameter("email");
		
		String stringRoomId = request.getParameter("id");
		int roomId = Integer.parseInt(stringRoomId);
		HotelRoom customerRoom = hrh.findHotelRoom(roomId);
		
		Customer newCustomer = new Customer(firstName, lastName, phoneNumber, email, customerRoom);
		ch.insertCustomer(newCustomer);
		
		customerRoom.setGuest(newCustomer);
		hrh.updateRoom(customerRoom);
		
		getServletContext().getRequestDispatcher("/viewAllRoomsServlet").forward(request, response);
	}

}
