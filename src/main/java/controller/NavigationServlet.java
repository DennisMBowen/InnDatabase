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
 * Servlet implementation class NavigationServlet
 */
@WebServlet("/navigationServlet")
public class NavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NavigationServlet() {
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
		
		HotelRoomHelper hrh = new HotelRoomHelper();
		CustomerHelper ch = new CustomerHelper();
		String act = request.getParameter("doThisToItem");
		
		String path = "/viewAllRoomsServlet";
		
		if (act.equals("Delete Room")) {
			try {
				Integer roomId = Integer.parseInt(request.getParameter("id"));
				hrh.deleteRoom(roomId);
			} catch (NumberFormatException e) {
				System.out.println("Forgot to select room");
			}
		} else if (act.equals("Add Room")){
			path = "/index.html";
			
		} else if (act.equals("Modify Room")) {
			try {
				Integer roomId = Integer.parseInt(request.getParameter("id"));
				HotelRoom roomToEdit = hrh.findHotelRoom(roomId);
				request.setAttribute("roomToEdit", roomToEdit);
				path = "/edit-room.jsp";
			} catch (NumberFormatException e) {
				System.out.println("Forgot to select room");
			}
			
		} else if (act.equals("Add Guest")) {
			try {
				Integer roomId = Integer.parseInt(request.getParameter("id"));
				HotelRoom guestRoom = hrh.findHotelRoom(roomId);
				request.setAttribute("guestRoom", guestRoom);
				path = "/add-customer.jsp";
			} catch (NumberFormatException e) {
				System.out.println("Forgot to select room");
			}
			
		} else if (act.equals("Remove Guest")) {
			try {
				Integer roomId = Integer.parseInt(request.getParameter("id"));
				HotelRoom guestRoom = hrh.findHotelRoom(roomId);
				Customer customer = ch.findGuest(guestRoom.getGuest().getId());
				customer.setRoom(null);
				guestRoom.setGuest(null);
				hrh.updateRoom(guestRoom);
				ch.updateCustomer(customer);
			} catch (NumberFormatException e) {
				System.out.println("Forgot to select room");
			}
			
		} else if(act.equals("View Customer Database")) {
			path = "/viewAllCustomersServlet";
		}
		
		
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

}
