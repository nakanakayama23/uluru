package com.uluru.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by ukawa on 15/10/24.
 */
public class StationDao {
    /**
     * PostgreSQLにアクセスし、表を作って削除するテスト用クラス
     * DB:hellodbを用意。
     */
    public void testDbAccess() {
        Connection db = null; // DB接続オブジェクト
        Statement st = null; // SQL文オブジェクト
        ResultSet rs = null; // 問合せ結果オブジェクト

        String url = "jdbc:postgresql:hellodb"; // URL
        String usr = "postgres"; // ユーザ名
        String pwd = "passw0rd";

        try {
            Class.forName("org.postgresql.Driver");

            // データベース接続
            System.out.println("Connecting to " + url);
            db = DriverManager.getConnection(url, usr, pwd);
            st = db.createStatement();

            // 表の作成
            st.executeUpdate("create table hellotbl (item varchar(16))");

            // データの登録
            st.executeUpdate("insert into hellotbl values ('Hello world!')");
            st.executeUpdate("insert into hellotbl values ('ようこそ！')");

            // データの検索
            rs = st.executeQuery("select * from hellotbl");
            if (rs != null) {
                while (rs.next()) {
                    String item = rs.getString("item");
                    System.out.println(item);
                }
            }
            rs.close();

            // 表の削除
            st.executeUpdate("drop table hellotbl");

            // データベース切断
            st.close();
            db.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
