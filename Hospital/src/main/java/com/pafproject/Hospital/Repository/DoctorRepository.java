package com.pafproject.Hospital.Repository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.pafproject.Hospital.Database.DoctorDB;
import com.pafproject.Hospital.model.Doctor;

import java.sql.*;

public class DoctorRepository {
Connection con = DoctorDB.connector();
	

	public List<Doctor>getDoctors(){
	   	 
	   	 List<Doctor> doctor = new ArrayList<>();
	   	 String sql = "select * from doctor";
	   	 try 
	   	   {
	   		 
				  Statement st = con.createStatement();
				  ResultSet rs = st.executeQuery(sql);
				  
				  while(rs.next())
				  {
					  Doctor a = new Doctor();
					  a.setId(rs.getInt(1));
					  a.setName(rs.getString(2));
					  a.setAge(rs.getInt(3));
					  a.setAddress(rs.getString(4));
					  a.setPhone(rs.getInt(5));
					  a.setEmail(rs.getString(6));
					  a.setSpecialization(rs.getString(7));

					  
					   			  
					  doctor.add(a);
				  }
				
			    } 
	   	 catch (Exception e) 
	   	  {
				
			   System.out.println(e);
	   	  }
	   	  
	   	 return doctor;
	   	 
	    }
	    
	    
	    
	    
	    
	    
	    public Doctor getDoctor(int did)
	    
	    {
	   	 String sql = "select * from doctor where id="+did;
	   	Doctor a = new Doctor();
	   	 try 
	   	   {
				  Statement st = con.createStatement();
				  ResultSet rs = st.executeQuery(sql);
				  if(rs.next())
				  {
					
					  a.setId(rs.getInt(1));
					  a.setName(rs.getString(2));
					  a.setAge(rs.getInt(3));
					  a.setAddress(rs.getString(4));
					  a.setPhone(rs.getInt(5));
					  a.setEmail(rs.getString(6));
					  a.setSpecialization(rs.getString(7));
				  }
				
			    } 
	   	 catch (Exception e) 
	   	  {
				
			   System.out.println(e);
	   	  } 
	   	 
	   	 return a;
	   	 
	    }
	    

	    
	   
		public void createDoctor(Doctor d1) 
		{
			String sql = "insert into doctor values(?,?,?,?,?,?,?)";
	  	 try 
		   {
			  PreparedStatement st = con.prepareStatement(sql);
			  st.setInt(1, d1.getId());
			  st.setString(2, d1.getName());
			  st.setInt(3, d1.getAge());
			  st.setString(4, d1.getAddress());
			  st.setInt(5, d1.getPhone());
			  st.setString(6, d1.getEmail());
			  st.setString(7, d1.getSpecialization());
			  
			  st.executeUpdate();
		
			
		    } 
		 catch (Exception e) 
		  {
			
		   System.out.println(e);
		  } 
			
		}
		
		
		public void updateDoctor(Doctor d1) 
		{
			String sql = "update doctor set name=?,age=?,address=?,phone=?,email=?,specialization=? where id=?";
	  	 try 
		   {
			  PreparedStatement st = con.prepareStatement(sql);

			  st.setInt(7, d1.getId());
			  st.setString(1, d1.getName());
			  st.setInt(2, d1.getAge());
			  st.setString(3, d1.getAddress());
			  st.setInt(4, d1.getPhone());
			  st.setString(5, d1.getEmail());
			  st.setString(6, d1.getSpecialization());
	         st.executeUpdate();
		
			
		    } 
		 catch (Exception e) 
		  {
			
		   System.out.println(e);
		  } 
			
		}



		public void deleteDoctor(int did) {

			String sql = "delete from doctor where id = ?";
	  	 try 
		   {
			  PreparedStatement st = con.prepareStatement(sql);
			  st.setInt(1, did);
	         st.executeUpdate();
		
			
		    } 
		 catch (Exception e) 
		  {
			
		   System.out.println(e);
		  } 

		}



}
