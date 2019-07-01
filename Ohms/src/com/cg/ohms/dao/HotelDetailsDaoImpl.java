package com.cg.ohms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cg.ohms.dto.HotelDetailsDTO;
import com.cg.ohms.exceptions.HotelException;
import com.cg.ohms.utility.Connect;
import com.cg.ohms.utility.ExceptionMessages;
import com.cg.ohms.utility.Queries;

public class HotelDetailsDaoImpl implements IHotelDetailsDao {
	boolean check=false;
	 HotelDetailsDTO hotelDetails=new HotelDetailsDTO();
	
	@Override
	public HotelDetailsDTO viewDetails() throws HotelException {
		Connection connection=Connect.getConnection();
		 String sql=Queries.VIEWDETAILS;
		 try {
		 PreparedStatement preparedStatement=connection.prepareStatement(sql);
		 ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				hotelDetails.setHotelId(resultSet.getString(1));
				hotelDetails.setHotelName(resultSet.getString(2));
				hotelDetails.setHotelAddress(resultSet.getString(3));
				hotelDetails.setNumOfRooms(resultSet.getInt(4));
				
			}
			return hotelDetails;
			
		} catch (SQLException e) {
			throw new HotelException(ExceptionMessages.MESSAGE1);
		}
		
	}
	public boolean addDetails(HotelDetailsDTO hotelDetailsDTO) throws HotelException {
		Connection connection=Connect.getConnection();
		String sql=Queries.ADDDETAILS;
	    
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement(sql);
//			 ResultSet resultSet=preparedStatement.executeQuery();
			
				 preparedStatement.setString(1, hotelDetailsDTO.getHotelId());
				 preparedStatement.setString(2, hotelDetailsDTO.getHotelName());
				 preparedStatement.setString(3, hotelDetailsDTO.getHotelAddress());
				 preparedStatement.setLong(4, hotelDetailsDTO.getNumOfRooms());
			    int check=preparedStatement.executeUpdate();
			    if(check==1) {
			    	System.out.println("hello");
			    	connection.commit();
			    	
			    	return true;	
			    }
		} catch (SQLException e) {
	     throw new HotelException(ExceptionMessages.MESSAGE2);
		}
		return false;
		
	}
 

//	public HotelDetailsDTO addHotelDetails(HotelDetailsDTO hotelDetailsDTO) {
//		 Connection connection=Connect.getConnection();
//		 String sql=Queries.AddDetails;
//		 HotelDetailsDTO hotelDetails=new HotelDetailsDTO();
//		 try {
//			PreparedStatement preparedStatement=connection.prepareStatement(sql);
//			ResultSet resultSet=preparedStatement.executeQuery();
//			while(resultSet.next()) {
//				hotelDetails.setHotelId(resultSet.getString(1));
//				hotelDetails.setHotelName(resultSet.getString(2));
//				hotelDetails.setHotelAddress(resultSet.getString(3));
//				hotelDetails.setNumOfRooms(resultSet.);
//			}
//		} catch (SQLException e) {
//			
//			
//		}
//		return null;
//	}
	
	
}
