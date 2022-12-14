package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.HotelRoom;

/**
 * Servlet implementation class EditRoomServlet
 */
@WebServlet("/editRoomServlet")
public class EditRoomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditRoomServlet() {
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
		
		String stringNumberOfBeds = request.getParameter("numberOfBeds");
		int numberOfBeds = Integer.parseInt(stringNumberOfBeds);
		String bedSize = request.getParameter("bedSize");
		String stringRoomId = request.getParameter("id");
		int roomId = Integer.parseInt(stringRoomId);
		
		HotelRoom roomToEdit = hrh.findHotelRoom(roomId);
		roomToEdit.setNumberOfBeds(numberOfBeds);
		roomToEdit.setBedSize(bedSize);
		
		hrh.updateRoom(roomToEdit);
		
		getServletContext().getRequestDispatcher("/viewAllRoomsServlet").forward(request, response);
	}

}
