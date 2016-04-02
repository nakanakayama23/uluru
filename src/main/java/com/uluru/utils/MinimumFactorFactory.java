package com.uluru.utils;

/**
 * Created by ukawa on 16/04/02.
 * MinimumFactorを作るんだけど、ファクトリ作るメリットってなんだっけ？
 * いらないかもしんない。
 * MinimumFactorの実装クラス作るたびにメンテしないといけないし。
 */
public class MinimumFactorFactory {
    public static final Integer VAR = 1;
    public static final Integer MINMAX = 2;

    public static MinimumFactor createMinimumFactor(Integer type) {
        if (type == VAR) {
            return new MinimumFactor.VarFactor();
        } else if (type == MINMAX) {
            return new MinimumFactor.MinMaxFactor();
        }
        throw new IllegalArgumentException("MinimumFactor needs decleared type");
    }
}
