package com.uluru.test;

import org.glassfish.jersey.server.mvc.Viewable;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 * Created by ukawa on 15/11/07.
 */
@Path("/jsptest")
public class JspTestResource {

    /**
     * jsp作成用のモック。<br>
     * TestBeanクラスを指定のjspに渡す。
     * @param jspname jspファイル名
     * @return jsp
     */
    @GET
    @Path("/{jspname}")
    public Viewable showJsp(@PathParam("jspname") String jspname) {
        return new Viewable("/WEB-INF/test/" + jspname, new TestBean());
    }
}
