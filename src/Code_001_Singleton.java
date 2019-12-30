
//面试题2
public class Code_001_Singleton {
    private Code_001_Singleton(){}

    //类的静态属性只会在第一次加载类的时候初始化
    // JVM帮助我们保证了线程的安全性，在类进行初始化时，别的线程是无法进入的。
    private static class SingletonInstance{
        private static final Code_001_Singleton INSTANCE =
                new Code_001_Singleton();
    }

    public static Code_001_Singleton getInstance(){
        return SingletonInstance.INSTANCE;
    }


}
