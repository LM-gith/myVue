package com.lm.jiecheng.test.jiecheng;

public class JieCheng {

    /**
     * 计算进位
     *
     * @param bit 数组
     * @param pos 用于判断是否是数组的最高位
     */
    private Integer carry(int[] bit, int pos) {

        //m:计算本次新增位数；carry：保存进位
        int i, m = 0, carray = 0;

        //处理进位
        for (i = 0; i <= pos; i++) {
            //累加进位
            bit[i] += carray;
            if (bit[i] <= 9) {
                carray = 0;
            } else if (bit[i] > 9 && i < pos) {
                carray = bit[i] / 10;
                bit[i] = bit[i] % 10;
            } else if (i >= pos) {
                //一直算到最高位不大于9为止
                while (bit[i] > 9) {
                    m++;
                    carray = bit[i] / 10;
                    bit[i] = bit[i] % 10;
                    i++;
                    bit[i] = carray;
                }
            }
        }
        return pos + m;
    }

    /**
     * 大整数阶乘
     *
     * @param bigInteger 所计算的大整数
     */
    private void bigFactorial(int bigInteger) {

        //pos:最高位；sum1:阶乘位数和；digit:数组长度
        int pos = 0, sum1 = 0, digit, i, j;

        //sum2:阶乘位数
        double sum2 = 0;

        //计算阶乘位数
        for (i = 1; i <= bigInteger; i++) {
            sum2 += Math.log10(i);
        }

        digit = (int) sum2 + 1;
        int[] fact = new int[digit];
        fact[0] = 1;

        //2~bigInteger依次相乘
        for (i = 2; i <= bigInteger; i++) {

            for (j = 0; j <= pos; j++) {
                fact[j] *= i;
            }
            pos = carry(fact, pos);
        }

        //计算阶乘位数和
        for (i = pos; i >= 0; i--) {
            sum1 += fact[i];
        }
        System.out.println(bigInteger + "阶乘结果位数和为：" + sum1);
        System.out.println("\n" + "阶乘共有: " + digit + " 位");
    }

    public void doBigFactorial(int bigInteger) {

        long timeBegin = System.currentTimeMillis();
        this.bigFactorial(bigInteger);
        long timeFinishi = System.currentTimeMillis();
        long time = timeFinishi - timeBegin;
        System.out.println("计算耗时: " + time + "毫秒");
    }

    public static void main(String[] args) {
        JieCheng bi = new JieCheng();
        bi.doBigFactorial(50000);
    }

}
