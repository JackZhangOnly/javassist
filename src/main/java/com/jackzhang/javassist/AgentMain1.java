package com.jackzhang.javassist;

import java.lang.instrument.Instrumentation;

/**
 * Created by Jack
 */
public class AgentMain1 {
    public static void main(String[] args) {
        System.out.println("This is main method........");
    }

    /**
     * 预处理方法（VM options:-javaagent:D:\javassist-demo.jar   注:路径中不能有空格）
     * @param args
     * @param instrumentation
     */
    /*public static void premain(String args, Instrumentation instrumentation){
        System.out.println("This is pre main method......");
    }*/
}
