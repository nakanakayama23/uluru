package com.uluru.controller;

import org.glassfish.jersey.server.mvc.Viewable;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * Created by ukawa on 16/02/03.
 */
@Path("/intro")
public class IntroResource {
    @GET
    public Viewable getJSP() {
        return new Viewable("/WEB-INF/jsp/intro");
    }
}
