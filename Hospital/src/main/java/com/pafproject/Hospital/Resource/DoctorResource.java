package com.pafproject.Hospital.Resource;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.ProcessingException;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.pafproject.Hospital.Repository.DoctorRepository;
import com.pafproject.Hospital.model.Doctor;





@Path("/doctor")

public class DoctorResource {
	
DoctorRepository doc = new DoctorRepository();
	
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Doctor> getDoctors()
	{
		return doc.getDoctors();
	}
	
	
	
	@GET
	@Path("/{did}")
	@Produces(MediaType.APPLICATION_JSON)
	public Doctor getDoctor(@PathParam("did") int did)
	{
		return doc.getDoctor(did);
	
	}
	

	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Doctor createDoctor(Doctor d1)
	{
		doc.createDoctor(d1);
		
		return d1;
	}
	
	
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Doctor updateDoctor(Doctor d1)
	{
		
		if(doc.getDoctor(d1.getId()).getId()==0) {
			doc.createDoctor(d1);
			
		}
		else
		{
			doc.updateDoctor(d1);
			
		}
		
		return d1;
	}
	
	
	@DELETE
	@Path("/{did}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Doctor deleteDoctor(@PathParam("did") int did)
	{
		Doctor a = doc.getDoctor(did);
		
		if(a.getId()!=0)
			doc.deleteDoctor(did);
		return null;
	}

}
