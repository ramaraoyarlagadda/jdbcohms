package com.cg.ohms.service.impl;

import com.cg.ohms.dao.HotelDetailsDaoImpl;
import com.cg.ohms.dao.IHotelDetailsDao;
import com.cg.ohms.dto.HotelDetailsDTO;
import com.cg.ohms.exceptions.HotelException;
import com.cg.ohms.service.IHotel;
import com.cg.ohms.utility.ExceptionMessages;
import com.cg.ohms.utility.ValidateHotelDetails;

public class HotelDetailsImpl implements IHotel {
	HotelDetailsDTO hotelDetailsDTO=new HotelDetailsDTO();
	ValidateHotelDetails validate=new ValidateHotelDetails();
	public boolean addHotelDetails(HotelDetailsDTO hotelDetailsEntity) throws HotelException{
		HotelDetailsDaoImpl dtoImpl=new HotelDetailsDaoImpl();
        String hotelId=hotelDetailsEntity.getHotelId();
		validate.isValidHotelId(hotelId);
       String hotelName=hotelDetailsEntity.getHotelName();
       validate.isValidHotelName(hotelName);
       String hotelAddress=hotelDetailsEntity.getHotelAddress();
       validate.isValidHotelAddress(hotelAddress);
       int noofRooms=hotelDetailsEntity.getNumOfRooms();
       validate.isValidNumberOfRooms(noofRooms);
       boolean flag= dtoImpl.addDetails(hotelDetailsEntity);
      	if(!flag) {
      			throw new HotelException(ExceptionMessages.ADDINGERROR);
      	}
      	
      	else {
      		return true;
      	}
   }
    public  HotelDetailsDTO viewHotelDetails(String viewId) throws  HotelException {
    	
		validate.isValidHotelId(viewId);
		IHotelDetailsDao hotelDetailsDao=new HotelDetailsDaoImpl();
		 HotelDetailsDTO hotelDetailsDTO=hotelDetailsDao.viewDetails(viewId);
		 
		 if(hotelDetailsDTO.getHotelId()==null) {
			 throw new HotelException(ExceptionMessages.EMPTYLIST);
		 }
		 else {
		 return hotelDetailsDTO; }
        
    }
	@Override
	public boolean modifyByHotelName(String hotelId, String hotelName) throws HotelException {
		validate.isValidHotelId(hotelId);
		validate.isValidHotelName(hotelName);
        IHotelDetailsDao hotelDetailsDao=new HotelDetailsDaoImpl();
        boolean result= hotelDetailsDao.modifyName(hotelId, hotelName);
		if(!result) {
			throw new HotelException(ExceptionMessages.MODIFYERROR);
		}
		return result;
	}
	@Override
	public boolean modifyByHotelAddress(String hotelId, String hotelAddress) throws HotelException{
		validate.isValidHotelId(hotelId);
		validate.isValidHotelAddress(hotelAddress);
		IHotelDetailsDao hotelDetailsDao=new HotelDetailsDaoImpl();
		boolean flag=hotelDetailsDao.modifyAddress(hotelId, hotelAddress);
	    if(!flag) {
	    	throw new HotelException(ExceptionMessages.MODIFYERROR);
	    }
		return flag;
	}
	@Override
	public boolean modifyByNumOfRooms(String hotelId, int numOfRooms) throws HotelException {
		validate.isValidHotelId(hotelId);
		validate.isValidNumberOfRooms(numOfRooms);
		IHotelDetailsDao hotelDetailsDao=new HotelDetailsDaoImpl();
		boolean flag=hotelDetailsDao.modifyRooms(hotelId, numOfRooms);
	    if(!flag) {
	    	throw new HotelException(ExceptionMessages.MODIFYERROR);
	    }
	
		
		return flag;
	}
	@Override
	public boolean deleteHotelDetails(String hotelId) throws  HotelException {
		validate.isValidHotelId(hotelId);
		IHotelDetailsDao hotelDetailsDao=new HotelDetailsDaoImpl();
		boolean flag=hotelDetailsDao.deleteDetails(hotelId);
		if(!flag) {
			throw new HotelException(ExceptionMessages.EMPTYLIST);
		}
		return flag;
	}
}
