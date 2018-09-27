package com.example.demo.publish;

import java.util.Arrays;

public class UnsafePublish {

    //该属性是这个类私有的，原本是属于它的 不希望被外界修改
    private String[] states = {"a","b","c"};

    public String[] getStates(){
        return states;
    }

    public static void main(String[] args) {
        UnsafePublish unsafePublish = new UnsafePublish();
        System.out.println(Arrays.toString(unsafePublish.getStates()));  //[a, b, c]

        unsafePublish.getStates()[0] = "d";
        System.out.println(Arrays.toString(unsafePublish.getStates())); //[d, b, c]

        //可见 states被别人修改了
    }
}
