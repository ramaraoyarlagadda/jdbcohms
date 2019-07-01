package com.cg.ohms.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.cg.ohms.dao.HotelDetailsDaoImpl;
import com.cg.ohms.dto.HotelDetailsDTO;
import com.cg.ohms.exceptions.EmptyHotelListException;
import com.cg.ohms.exceptions.HotelException;
import com.cg.ohms.exceptions.InValidHotelAddressException;
import com.cg.ohms.exceptions.InValidHotelIdException;
import com.cg.ohms.exceptions.InValidHotelNameException;
import com.cg.ohms.exceptions.InValidNumberOfRoomsException;
import com.cg.ohms.service.IHotel;
import com.cg.ohms.staticdb.HotelDetailsStaticDb;
import com.cg.ohms.utility.ExceptionMessages;
import com.cg.ohms.utility.ValidateHotelDetails;

public class HotelDetailsImpl implements IHotel {
	private boolean flag=false;
	HotelDetailsDaoImpl dtoImpl=new HotelDetailsDaoImpl();
	ValidateHotelDetails validate=new ValidateHotelDetails();
	public HotelDetailsDTO addHotelDetails(HotelDetailsDTO hotelDetailsEntity) throws InValidHotelIdException,
	InValidHotelNameException, InValidHotelAddressException, InValidNumberOfRoomsException {
		List<HotelDetailsDTO> list=new ArrayList<HotelDetailsDTO>();
		
        String hotelId=hotelDetailsEntity.getHotelId();
		validate.isValidHotelId(hotelId);
       String hotelName=hotelDetailsEntity.getHotelName();
       validate.isValidHotelName(hotelName);
       String hotelAddress=hotelDetailsEntity.getHotelAddress();
       validate.isValidHotelAddress(hotelAddress);
       int noofRooms=hotelDetailsEntity.getNumOfRooms();
       validate.isValidNumberOfRooms(noofRooms);
       HotelDetailsStaticDb hotelDetailsStaticDb=new HotelDetailsStaticDb();
       hotelDetailsStaticDb.setHotelList(hotelDetailsEntity);
       try {
		dtoImpl.addDetails(hotelDetailsEntity);
	} catch (HotelException e) {
		 
	}
 
       return hotelDetailsEntity;
   }
    public ArrayList<HotelDetailsDTO> viewHotelDetails( String viewId) throws  HotelException {
    	String hotelId= 

    	
     
    }
	@Override
	public boolean modifyByHotelName(String hotelId, String hotelName) throws HotelException {
		
		
		List<HotelDetailsDTO> hotelList=HotelDetailsStaticDb.getHotelList();
		try {
					for(HotelDetailsDTO hotel: hotelList)
					{
						
						if(hotel.getHotelId().equals(hotelId))
						{
							hotel.setHotelName(hotelName);
							flag=true;
							break;
						}
					}
				}catch (HotelException e) {
			 throw new HotelException(ExceptionMessages.MESSAGE1);
			
		}
		
		return flag;
	}
	@Override
	public boolean modifyByHotelAddress(String hotelId, String hotelAddress) throws HotelException{
		
		List<HotelDetailsDTO> hotelList=HotelDetailsStaticDb.getHotelList();
		if() {
			 throw new HotelException(ExceptionMessages.MESSAGE1);
			}
			else
			{
				for(HotelDetailsDTO hotel: hotelList)
				{
					
					if(hotel.getHotelId().equals(hotelId))
					{
						hotel.setHotelAddress(hotelAddress);
						flag=true;
						break;
					}
				}
			}
		
		return flag;
	}
	@Override
	public boolean modifyByNumOfRooms(String hotelId, int numOfRooms) throws HotelException {
		List<HotelDetailsDTO> hotelList=HotelDetailsStaticDb.getHotelList();
		if() {
			 throw new HotelException(ExceptionMessages.MESSAGE1);
			}
			else
			{
				for(HotelDetailsDTO hotel: hotelList)
				{
					
					if(hotel.getHotelId().equals(hotelId))
					{
						hotel.setNumOfRooms(numOfRooms);
						flag=true;
						break;
					}
				}
			}
	
		
		return flag;
	}
	@Override
	public List<HotelDetailsDTO> deleteHotelDetails(String hotelId) throws EmptyHotelListException {
		// TODO Auto-generated method stub
		return null;
	}
//	@Override
//	public List<HotelDetailsDTO> deleteHotelDetails(String hotelId) throws EmptyHotelListException {
//		List<HotelDetailsDTO> hotelList=new ArrayList<HotelDetailsDTO>();
//		HotelDetailsDTO hotelDetailsDTO=new HotelDetailsDTO();
//		Iterator<HotelDetailsDTO> hotelDeleteList=hotelList.iterator();
//		if(hotelList.isEmpty()) {
//			throw new EmptyHotelListException("sorry hotellist is empty");
//		}
//		while(hotelDeleteList.hasNext()) {
//			HotelDetailsDTO hotelDelete=(HotelDetailsDTO) hotelDeleteList.next();
//			if(hotelDetailsDTO.getHotelId()==hotelId) {
//				hotelDeleteList.remove();
//			}
//		}
//		
//		return ;
//		
//	}
	
	

}
