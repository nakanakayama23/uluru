package com.uluru.utils;

/**
 * Created by ukawa on 16/04/02.
 * 最小値を求めるためのインターフェース。
 * 内部クラスに実装クラスを用意している。
 */
public interface MinimumFactor {
    /**
     * 初期化
     */
    public void reset();

    /**
     * データを追加する。
     *
     * @param value データの値
     */
    public void addItem(double value);

    /**
     * 計算結果を返す。
     * 入力に不備がある場合はDouble.MAX_VALUEを返す。
     *
     * @return 最小判定要素の値
     */
    public double getValue();

    /**
     * 分散を計算する。
     */
    public static class VarFactor  implements MinimumFactor {
        double sumx;
        double sumx2;
        int count;

        public VarFactor() {
            reset();
        }

        public void reset() {
            sumx = 0;
            sumx2 = 0;
            count = 0;
        }
        public void addItem(double value) {
            sumx += value;
            sumx2 += value * value;
            count++;
        }

        public double getValue() {
            if (count == 0) {
                return Double.MAX_VALUE;
            }
            return sumx2 / count - (sumx / count) * (sumx / count);
        }
    }

    /**
     * 最大値と最小値の差
     */
    public static class MinMaxFactor implements MinimumFactor {

        double min;
        double max;

        public MinMaxFactor() {
            reset();
        }

        @Override
        public void reset() {
            min = Double.MAX_VALUE;
            max = Double.MIN_VALUE;
        }

        @Override
        public void addItem(double value) {
            if (value < min) {
                min = value;
            }
            if (value > max) {
                max = value;
            }
        }

        @Override
        public double getValue() {
            if (min > max) {
                return Double.MAX_VALUE;
            }
            return max - min;
        }
    }
}
