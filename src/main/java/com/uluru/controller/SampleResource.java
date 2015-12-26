package com.uluru.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.glassfish.jersey.server.mvc.Viewable;

/**
 * jsp返却用のテストリソースクラス。
 * のちのち消すことになるのかなあ。
 * @author Ukawa Shohei
 * @since 1.0
 */
@Path("/resource")
public class SampleResource {
  /**
   * テスト用jspを返却する。
   */
  @Path("/jsp")
  @GET
  @Produces({MediaType.TEXT_HTML})
  public Viewable getJSP() {
    return new Viewable("/WEB-INF/jsp/index", "testaaa");
  }

  @GET
  public String getResponse() { return "server is running."; }
}