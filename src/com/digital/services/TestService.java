package com.digital.services;

import java.util.HashMap;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import com.digital.pojo.Item;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/rest")
public class TestService {
	@GET
	@Path("/test")
	public HashMap<String, String> testWorking(Item item){
		System.out.println(item);
		System.out.println("Gonna start test");
				
		HashMap<String, String> result = new HashMap<>();
		result.put("status", "success");
		result.put("msg", "Job Application Submitted");
		return result;
	}
	
	}
	@GET
	@Path("/ping")
	public String ping(){
		return "working" ;
	}
}
