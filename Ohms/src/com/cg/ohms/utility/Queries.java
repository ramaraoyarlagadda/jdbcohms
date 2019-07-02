package com.cg.ohms.utility;

public class Queries {

	public static final String ADDDETAILS = "insert into hoteldetails(hotelid,hotelname,hoteladdress,numberofrooms) values(?,?,?,?)";
	public static final String VIEWDETAILS = "select hotelid,hotelname,hoteladdress,numberofrooms from hoteldetails where hotelid=?";
	public static final String MODIFYNAME = "update hoteldetails set hotelname=? where hotelid=?";
	public static final String MODIFYADDRESS = "update hoteldetails set hoteladdress=? where hotelid=?";
	public static final String MODIFYROOMS = "update hoteldetails set numberofrooms=? where hotelid=? ";
	public static final String DELETEDETAILS = "delete from hoteldetails where hotelid=?"; 

}
