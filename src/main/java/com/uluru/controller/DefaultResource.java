package com.uluru.controller;

import javax.servlet.ServletContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import java.io.*;

/**
 * Created by ukawa on 15/11/08.
 * デフォルトサーブレットみたいなもの
 */
@Path("{path:.+}")
public class DefaultResource {

    @Context
    ServletContext context;

    /**
     * webapp以下のjsやcssなんかをbyteで返す。
     * @param path リソースへのパス
     * @return リソース
     */
    @GET
    public byte[] getResource(@PathParam("path") String path) {
        return readResource(path);
    }

    /**
     * ファイルの中を読んでbyte配列で返す。
     * @param path ファイルへのパス
     * @return ファイルの中身
     */
    private byte[] readResource(String path) {
        int max = 100;
        byte[] b = new byte[max];

        InputStream inputStream = context.getResourceAsStream(path);
        if ( inputStream != null ) {
            try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
                int len = 0;
                while ((len = inputStream.read(b, 0, max)) > 0) {
                    baos.write(b, 0, len);
                }
                return baos.toByteArray();
            } catch (IOException e) {
                throw new RuntimeException("resource couldn't read. ", e);
            }
        } else {
            throw new RuntimeException("resource couldn't read. path = " + path);
        }
    }

}
