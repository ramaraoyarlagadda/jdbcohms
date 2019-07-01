package com.cg.ohms.dao;

import com.cg.ohms.dto.HotelDetailsDTO;
import com.cg.ohms.exceptions.HotelException;

public interface IHotelDetailsDao {
	public HotelDetailsDTO viewDetails() throws HotelException;
	public boolean addDetails(HotelDetailsDTO hotelDetailsDTO) throws HotelException;

}
