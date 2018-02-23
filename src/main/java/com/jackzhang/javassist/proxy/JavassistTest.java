package com.jackzhang.javassist.proxy;

public class JavassistTest {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        /*System.out.println("*******************方式一*******************");
        JavassistProxyFactory<ProductService> jpf = new JavassistProxyFactory<ProductService>();
        ProductService productService = new ProductService();
        jpf.setTarget(productService);
        ProductService proxy = jpf.getProxy();
        proxy.del();*/

        System.out.println("*******************方式二*******************");
        JavassistProxyFactory02 jpf02 = new JavassistProxyFactory02();
        ProductService productService2 = (ProductService) jpf02.getProxy(ProductService.class);
        productService2.del();
        productService2.save();



    }

}