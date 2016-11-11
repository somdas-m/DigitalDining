package com.digital.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import com.digital.util.HibernateUtil;

@Path("/rest")
public class TestService {
	@GET
	@Path("/test")
	public String testWorking(){
		HibernateUtil.getSessionFactory();
		return "Test Successfull";
	}
}
