package com.uluru.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by ukawa on 15/11/08.
 * デフォルトサーブレットみたいなもの
 */
@Path("{path:.+}")
public class DefaultResource {

    /**
     * webapp以下のjsやcssなんかをbyteで返す。
     * @param path リソースへのパス
     * @return リソース
     */
    @GET
    public byte[] getResource(@PathParam("path") String path) {
        return readResource("src/main/webapp/" + path);
    }

    /**
     * ファイルの中を読んでbyte配列で返す。
     * @param path ファイルへのパス
     * @return ファイルの中身
     */
    private byte[] readResource(String path) {
        int max = 100;
        byte[] b = new byte[max];
        try ( FileInputStream fileStream = new FileInputStream(path)) {
            try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
                int len = 0;
                while ((len = fileStream.read(b, 0, max)) > 0) {
                    baos.write(b, 0, len);
                }
                return baos.toByteArray();
            } catch (IOException e) {
                throw new RuntimeException("resource couldn't read. ", e);
            }
        } catch (IOException e) {
            throw new RuntimeException("resource couldn't read. ", e);
        }
    }

}
