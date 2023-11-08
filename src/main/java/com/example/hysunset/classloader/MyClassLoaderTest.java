package com.example.hysunset.classloader;

/**
 * 自定义类加载器示例
 */
public class MyClassLoaderTest {
    static class  MyClassLoader extends  ClassLoader{
        private String classPath;

        public MyClassLoader(String classPath) {
           this.classPath = classPath;
        }

    }
}
