package com.example.demo.publish;

public class Escape {
    private int thisCanBeEscape = 0;

    public Escape(){
        new InnerClass();
    }

    private class InnerClass{
        public InnerClass(){
//            System.out.println(this.thisCanBeEscape);
        }
    }

    public static void main(String[] args) {
        new Escape();
    }
}
