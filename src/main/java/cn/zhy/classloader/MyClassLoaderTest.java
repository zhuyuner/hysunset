package cn.zhy.classloader;

/**
 * 自定义类加载器示例
 * @author zhy
 */
public class MyClassLoaderTest {
    static class  MyClassLoader extends  ClassLoader{
        private String classPath;
        public MyClassLoader(String classPath) {
           this.classPath = classPath;
        }

    }
}
