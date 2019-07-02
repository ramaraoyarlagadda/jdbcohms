package com.cg.ohms.service;

import java.util.List;

import com.cg.ohms.dto.HotelDetailsDTO;
import com.cg.ohms.exceptions.HotelException;

public interface IHotel {
	
	public boolean addHotelDetails(HotelDetailsDTO hotelDetailsEntity) throws  HotelException;
	public boolean deleteHotelDetails(String hotelId) throws HotelException;
	public HotelDetailsDTO viewHotelDetails(String viewId) throws  HotelException;
	public boolean modifyByHotelName(String hotelId, String hotelName) throws  HotelException;
	public boolean modifyByHotelAddress(String hotelId, String hotelAddress) throws HotelException;
	public boolean modifyByNumOfRooms(String hotelId,int modifyNumOfRooms) throws HotelException;
	

}
