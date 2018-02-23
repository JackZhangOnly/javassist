package com.jackzhang.javassist;

import javassist.*;

/**
 * Created by Jack
 */
public class JavassistDemo {

    public static void main(String[] args) throws NotFoundException, CannotCompileException, IllegalAccessException, InstantiationException {
        ClassPool classPool=new ClassPool(true);
        //插入类路径，通过类路径去搜索我们要的类
        //true == classPool.insertClassPath(new LoaderClassPath(JavassistDemo.class.getClassLoader()));
        //构建CtClass对象
        CtClass ctClassStu=classPool.makeClass("com.jackzhang.javassist.Student");
        ctClassStu.addInterface(classPool.get(Person.class.getName()));

        //返回类型
        CtClass returnType=classPool.get(void.class.getName());
        //方法名
        String mname="sayHello";
        //参数
        CtClass[] parameters=new CtClass[]{classPool.get(String.class.getName())};
        //定义方法
        CtMethod ctMethod=new CtMethod(returnType,mname,parameters,ctClassStu);

        String mBody="{" +
                "System.out.println(\"hello,\"+$1);\n" +
                "}";
        ctMethod.setBody(mBody);
        ctClassStu.addMethod(ctMethod);

        //转换成Class对象、构建实例对象
        Class classStu=ctClassStu.toClass();
        Person person=(Person)classStu.newInstance();
        person.sayHello("JackZhang");

    }
    public interface Person{
        public void sayHello(String name);
    }
}
