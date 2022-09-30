package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.HotelRoom;

/**
 * @author Dennis Bowen - dmbowen
 * CIS175 - Fall 2022
 * Sep 28, 2022
 */

/**
 * Servlet implementation class AddRoomServlet
 */
@WebServlet("/addRoomServlet")
public class AddRoomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddRoomServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String stringRoomNumber = request.getParameter("roomNumber");
		int roomNumber = Integer.parseInt(stringRoomNumber);
		String stringNumberOfBeds = request.getParameter("numberOfBeds");
		int numberOfBeds = Integer.parseInt(stringNumberOfBeds);
		String bedSize = request.getParameter("bedSize");
		String vacancy = request.getParameter ("isVacant");
		
		boolean isVacant = true;
		if (vacancy.equals("n")){
			isVacant = false;
		}
		
		HotelRoom hr = new HotelRoom (roomNumber, numberOfBeds, bedSize, isVacant);
		HotelRoomHelper hrh = new HotelRoomHelper();
		hrh.insertItem(hr);
		
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
	}

}
