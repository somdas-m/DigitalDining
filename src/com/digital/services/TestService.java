package com.digital.services;

import java.util.HashMap;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import com.digital.pojo.Item;

import org.hibernate.Session;

import com.digital.util.HibernateUtil;

@Path("/rest")
public class TestService {
	@GET
	@Path("/test")
	public HashMap<String, String> testWorking(){
		Item item = new Item();
		item.setItemNumber("S101");
		item.setItemName("TEST_ITEM");
		item.setItemPrice(2);
		item.setCategory("TEST_CAT");
		System.out.println(item);
		System.out.println("Gonna start test");
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.saveOrUpdate(item);
		session.getTransaction().commit();
		session.close();
		
		HashMap<String, String> result = new HashMap<>();
		result.put("status", "success");
		result.put("msg", "Job Application Submitted");
		return result;
	}
	
	@GET
	@Path("/getAll")
	@Produces(MediaType.APPLICATION_JSON)
	public Item getJobApplicationModel(){
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Item> items = session.createQuery("FROM ITEMS").list();
		session.close();
		return items;
	}
}
