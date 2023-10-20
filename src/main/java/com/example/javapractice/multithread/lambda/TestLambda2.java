package com.example.javapractice.multithread.lambda;

/**
 * @author: Junqi Chen
 * @time:2023/10/19
 * @Email:junqiqi77_chen@foxmail.com
 * @desc:
 */
public class TestLambda2 {

    public static void main(String[] args) {

        // 1、lambda表达式简化
        ILove love = (int a) -> {
            System.out.println("I love you-->" + a);
        };

        // 简化1：参数类型
        love = (a) -> {
            System.out.println("I love you-->" + a);
        };

        // 简化2：简化括号
        love = a -> {
            System.out.println("I love you-->" + a);
        };

        // 简化3：简化花括号
        love = a -> System.out.println("I love you-->" + a);

        // 总结：
        // lambda表达式只能有一行代码的情况下才能简化成为一行，如果有多行，那么就用代码块包裹
        // 前提是接口为函数式接口
        // 多个参数也可以去掉参数类型，要去掉就都去掉，必须加上括号
        // lambda表达式的本质就是作为接口的实现，所以接口中只能有一个方法

        love.love(521);
    }

}

interface ILove {
    void love(int a);
}


