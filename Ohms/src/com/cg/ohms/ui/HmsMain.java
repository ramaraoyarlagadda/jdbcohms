
package com.cg.ohms.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.cg.ohms.dto.HotelDetailsDTO;
import com.cg.ohms.service.IHotel;
import com.cg.ohms.service.impl.HotelDetailsImpl;
import com.cg.ohms.utility.ValidateHotelDetails;

public class HmsMain {
	public static void main(String[] args) {
		 
		do {
			
		System.out.println("Hotel Management provides four operations for admin");
		System.out.println("1.Adding new hotel details\n2.View hotel details\n3.Modify hotel details\n4.Delete hotel details");
		System.out.println("Enter above mentioned number for performing that particular operation");
		Scanner scanner=new Scanner(System.in);
		String option=scanner.next();
		IHotel hotel=new HotelDetailsImpl();
		boolean flag;
		HotelDetailsDTO hotelDetailsDTO=new HotelDetailsDTO();
		ValidateHotelDetails validate=new ValidateHotelDetails();
			try {
				switch (option) {
				case "1":
					System.out.println("you entered option for adding hotel details");
					System.out.println("First for adding hotel you need to enter hotelid,hotelname,hoteladdress and numberofrooms");
					System.out.println("1.Enter HotelId for adding hotel");
					String hotelId=scanner.next();
					
					System.out.println("2.Enter HotelName for adding hotel");
					String hotelName=scanner.next();
					
					System.out.println("3.Enter HotelAddress for adding hotel");
					String hotelAddress=scanner.next();
					
					System.out.println("4.Enter Number of Rooms for adding hotel");
					int numOfRooms=scanner.nextInt();
					
					hotelDetailsDTO.setHotelId(hotelId);
					hotelDetailsDTO.setHotelName(hotelName);
					hotelDetailsDTO.setHotelAddress(hotelAddress);
					hotelDetailsDTO.setNumOfRooms(numOfRooms);
					hotel.addHotelDetails(hotelDetailsDTO);
			        System.out.println("Hotel Details added successfully");
					break;
				case "2": 
					System.out.println("You Entered option for viewing hotel details");
					System.out.println("Enter hotelid for viewing hotel");
					String viewId=scanner.next();
					hotel.viewHotelDetails(viewId);
				    hotelDetailsDTO.setHotelId(viewId);
				    
				    System.out.println(viewlist);
					break;
				case "3":
					System.out.println("You Entered option for modifing hotel details");
					System.out.println("Enter your option for modifing");
					System.out.println("1.Modify HotelName\n2.Modify HotelAddress\n3.Modify NumberOfRooms");
					String choice=scanner.next();
					switch(choice) {
					case "1":
						System.out.println("Enter HotelId  for modification");
						String modifyId1=scanner.next();
						 validate.isValidHotelId(modifyId1);
						 System.out.println("Enter new Hotelname  for modification");
						String modifyName=scanner.next();
						  validate.isValidHotelName(modifyName);
						hotel.modifyByHotelName(modifyId1, modifyName);
						flag=hotel.modifyByHotelName(modifyId1,modifyName);
                         if(flag==true) {
                        	 System.out.println("modification done successfully");
                         }
                         else {
                        	 System.out.println("Modification not done successfully");
                         }
     					break;
					case"2":
						System.out.println("Enter HotelId for modification");
						String modifyId2=scanner.next();
						validate.isValidHotelId(modifyId2);
						String modifyAddress=scanner.next();
						System.out.println("Enter new Hoteladdress  for modification");
						validate.isValidHotelAddress(modifyAddress);
						hotel.modifyByHotelAddress(modifyId2, modifyAddress);
						flag=hotel.modifyByHotelAddress(modifyId2,modifyAddress);
                        if(flag==true) {
                       	 System.out.println("modification done successfully");
                        }
                        else {
                       	 System.out.println("Modification not done successfully");
                        }					
						break;
					case"3":
						System.out.println("Enter HotelId for modification");
						String modifyId3=scanner.next();
						validate.isValidHotelId(modifyId3);
						int modifyNumOfRooms=scanner.nextInt();
						System.out.println("Enter new Number of rooms for modification");
						validate.isValidNumberOfRooms(modifyNumOfRooms);
						hotel.modifyByNumOfRooms(modifyId3, modifyNumOfRooms);
						flag=hotel.modifyByNumOfRooms(modifyId3,modifyNumOfRooms);
                        if(flag==true) {
                       	 System.out.println("modification done successfully");
                        }
                        else {
                       	 System.out.println("Modification not done successfully");
                        }
						break;
						default:
							System.err.println("Enter valid option for modification");
							break;
					}
					
					break;
				case "4":
					System.out.println("You Entered option for deleting hotel details");
					System.out.println("Enter hotelid for deleting hotel details");
					String deleteid=scanner.next();
					List<HotelDetailsDTO> deletehotel=hotel.deleteHotelDetails(deleteid);
					System.out.println(deletehotel);

				default:
					System.err.println("Enter valid option for performing operations");
					break;
				}
			}
			catch (Exception e) {
				System.err.println(e.getMessage());
			}
			scanner.close();
		
	}while(true);
		
	}
}
