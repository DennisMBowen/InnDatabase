package model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author Dennis Bowen - dmbowen
 * CIS175 - Fall 2022
 * Sep 26, 2022
 */


@Entity
@Table(name = "rooms")
public class HotelRoom {
	
	//Instance variables
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	@Column(name = "RoomNumber")
	private int roomNumber;
	@Column(name = "BedsNumber")
	private int numberOfBeds;
	@Column(name = "BedSize")
	private String bedSize;
	@Column(name = "Vacancy")
	private boolean isVacant;
	private Customer guest;
	
	//Getters and Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public int getNumberOfBeds() {
		return numberOfBeds;
	}

	public void setNumberOfBeds(int numberOfBeds) {
		this.numberOfBeds = numberOfBeds;
	}

	public String getBedSize() {
		return bedSize;
	}

	public void setBedSize(String bedSize) {
		this.bedSize = bedSize;
	}

	
	public boolean isVacant() {
		return isVacant;
	}

	public void setVacant(boolean isVacant) {
		this.isVacant = isVacant;
	}
	
	public Customer getGuest() {
		return guest;
	}

	public void setGuest(Customer guest) {
		this.guest = guest;
	}
	

	//Default No_arg Constructor
	public HotelRoom() {
		
	}
	
	//Constructor that uses parameters without the Guest
	public HotelRoom(int roomNumber, int numberOfBeds, String bedSize, boolean isVacant) {
		this.roomNumber = roomNumber;
		this.numberOfBeds = numberOfBeds;
		this.bedSize = bedSize;
		this.isVacant = isVacant;
	}
	
	
	
	public String displayRoomDetails() {
			return "Room Number " + this.roomNumber + ": " + this.numberOfBeds + " " + this.bedSize + " bed(s), Vacancy: " + this.isVacant;
	}
	
}
