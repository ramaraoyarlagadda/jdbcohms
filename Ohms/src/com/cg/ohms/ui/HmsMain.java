
package com.cg.ohms.ui;

import java.util.Scanner;

import com.cg.ohms.dto.HotelDetailsDTO;
import com.cg.ohms.exceptions.HotelException;
import com.cg.ohms.service.IHotel;
import com.cg.ohms.service.impl.HotelDetailsImpl;

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
					hotelDetailsDTO =hotel.viewHotelDetails(viewId);
					System.out.println(hotelDetailsDTO.getHotelId());
					System.out.println(hotelDetailsDTO.getHotelName());
					System.out.println(hotelDetailsDTO.getHotelAddress());
					System.out.println(hotelDetailsDTO.getNumOfRooms());
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
						 System.out.println("Enter new Hotelname for modification");
						String modifyName=scanner.next();
						System.out.println("-=-=-=-=-==main1");
						hotel.modifyByHotelName(modifyId1, modifyName);
						System.out.println("-=-=-=-=-==main2");
						flag=hotel.modifyByHotelName(modifyId1,modifyName);
						System.out.println("-=-=-=-=-==main3");
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
						String modifyAddress=scanner.next();
						System.out.println("Enter new Hoteladdress  for modification");
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
						int modifyNumOfRooms=scanner.nextInt();
						System.out.println("Enter new Number of rooms for modification");
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
					flag=hotel.deleteHotelDetails(deleteid);
					if(flag==true) {
						System.out.println("Deletion doen successfully");
					}
					else {
						System.out.println("Deletion unsuccessfull");
					}

				default:
					System.err.println("Enter valid option for performing operations");
					break;
				}
			}
			catch (HotelException e) {
				System.err.println(e.getMessage());
			}
			
		
	}while(true);
		
	}
}
