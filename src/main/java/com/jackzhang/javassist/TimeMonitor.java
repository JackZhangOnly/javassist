package com.jackzhang.javassist;

import javassist.*;

/**
 * Created by Jack
 */
public class TimeMonitor {
    public static void main(String[] args) throws NotFoundException, CannotCompileException {
        ClassPool classPool=new ClassPool(true);
        String targetClassName="com.jackzhang.javassist.BitStringUtil";

        CtClass targetClass=classPool.get(targetClassName);
        CtMethod ctMethod=targetClass.getDeclaredMethod("addString");
        //复制方法
        CtMethod agentMethod= CtNewMethod.copy(ctMethod,ctMethod.getName()+"$agent",targetClass,null);
        //添加代理方法
        targetClass.addMethod(agentMethod);

        String src="{"
                + "long begin = System.nanoTime();"
                + "Object result="+ ctMethod.getName()+"$agent($$);"
                + "long end = System.nanoTime();"
                + "System.out.println(end-begin);"
                + "return ($r)result;"
                + "}";
        ctMethod.setBody(src);
        //载入到当前ClassLoader
        targetClass.toClass();
        BitStringUtil bitStringUtil=new BitStringUtil();
        bitStringUtil.addString(100);


    }
}
