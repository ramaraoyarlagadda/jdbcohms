package com.cg.ohms.sevice.impl;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import com.cg.ohms.exceptions.HotelException;
import com.cg.ohms.exceptions.InValidHotelAddressException;
import com.cg.ohms.exceptions.InValidHotelIdException;
import com.cg.ohms.exceptions.InValidHotelNameException;
import com.cg.ohms.exceptions.InValidNumberOfRoomsException;
import com.cg.ohms.utility.ValidateHotelDetails;

public class HotelDetailsImplTest {

	ValidateHotelDetails validation= new ValidateHotelDetails();

	@Test
	public void testHotelIdValidation() throws HotelException {
		boolean actual= validation.isValidHotelId("12354");
		assertEquals(true, actual);
	}
	@Test(expected = InValidHotelIdException.class)
	public void testForWrongid() throws HotelException {
		validation.isValidHotelId("1235477556");
		
	}
	@Test
	public void testHotelNameValidation() throws HotelException{
		boolean actual=validation.isValidHotelName("royalparl");
		assertEquals(true, actual);
	}
	@Test(expected = InValidHotelNameException.class)
	public void testForWrongHotelName() throws HotelException{
		validation.isValidHotelName("09865546");
	}
	@Test
	public void testHotelAddressValidation() throws HotelException{
		boolean actual=validation.isValidHotelAddress("kakinada,andharpradesh");
		assertEquals(true, actual);
	}
	@Test(expected = InValidHotelAddressException.class)
	public void testForWrongHotelAddress() throws HotelException{
		validation.isValidHotelAddress("568,/gya,");
	}
	@Test
	public void testForNumberOfRooms() throws HotelException{
		boolean actual=validation.isValidNumberOfRooms(789);
		assertEquals(true, actual);
	}
	@Test(expected = InValidNumberOfRoomsException.class)
	public void testForWrongNumberOfRooms() throws HotelException{
		validation.isValidNumberOfRooms(467788);
	}
}
