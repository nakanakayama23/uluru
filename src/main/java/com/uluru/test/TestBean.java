package com.uluru.test;

/**
 * Created by ukawa on 15/11/07.
 * jspテスト用に渡したいオブジェクトを定義する。
 * デフォルトコンストラクタでセットしてね。
 * プロパティはgetter必要やで。
 */
public class TestBean {
    private String testString;
    public String getTestString() { return testString; }

    public TestBean() {
        testString = "test string";
    }

}
