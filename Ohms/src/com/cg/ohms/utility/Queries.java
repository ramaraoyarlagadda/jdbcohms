package com.cg.ohms.utility;

public class Queries {

	public static final String ADDDETAILS = "insert into hoteldetails values(?,?,?,?)";
	public static final String CHECKHOTELID = "select hotelid from hoteldetails ";
	public static final String VIEWDETAILS = "select hotelid,hotelname,hoteladdress,numberofrooms from hoteldetails where hotelid=?"; 

}
