package com.uluru;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.mvc.MvcFeature;
import org.glassfish.jersey.server.mvc.jsp.JspMvcFeature;
import com.uluru.resource.SampleResource;

/**
 * jerseyのアプリケーションクラス。
 * リソースクラスを登録する。
 * @author Ukawa Shohei
 * @since 1.0
 */
public class MyApplication extends ResourceConfig {
  
  /**
   * リソースを登録するコンストラクタ。
   */
  public MyApplication() {
    this.packages(SampleResource.class.getPackage().getName())
        .register(JspMvcFeature.class);
  }
}