package com.uluru.controller;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.glassfish.jersey.server.mvc.ErrorTemplate;
import org.glassfish.jersey.server.mvc.Viewable;

@Path("/")
public class IndexResource {

	@POST
	public Viewable postJSP() {
		return getJSP();
	}

	@GET
	@ErrorTemplate(name = "/WEB-INF/jsp/error")
	public Viewable getJSP() {
		
		return new Viewable("/WEB-INF/jsp/inputForm");
	}

}
