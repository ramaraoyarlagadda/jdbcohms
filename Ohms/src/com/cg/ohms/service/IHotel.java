package com.cg.ohms.service;

import java.util.ArrayList;
import java.util.List;

import com.cg.ohms.dto.HotelDetailsDTO;
import com.cg.ohms.exceptions.EmptyHotelListException;
import com.cg.ohms.exceptions.HotelException;
import com.cg.ohms.exceptions.InValidHotelAddressException;
import com.cg.ohms.exceptions.InValidHotelIdException;
import com.cg.ohms.exceptions.InValidHotelNameException;
import com.cg.ohms.exceptions.InValidNumberOfRoomsException;

public interface IHotel {
	
	public HotelDetailsDTO addHotelDetails(HotelDetailsDTO hotelDetailsEntity) throws InValidHotelIdException,InValidHotelNameException,InValidHotelAddressException,InValidNumberOfRoomsException;
	public List<HotelDetailsDTO> deleteHotelDetails(String hotelId) throws EmptyHotelListException;
	public ArrayList<HotelDetailsDTO> viewHotelDetails(String viewId) throws  HotelException;
	public boolean modifyByHotelName(String hotelId, String hotelName) throws  HotelException;
	public boolean modifyByHotelAddress(String hotelId, String hotelAddress) throws HotelException;
	public boolean modifyByNumOfRooms(String hotelId,int modifyNumOfRooms) throws HotelException;
	

}
