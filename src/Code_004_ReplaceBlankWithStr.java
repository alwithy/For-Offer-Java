import com.sun.xml.internal.bind.v2.TODO;

public class Code_004_ReplaceBlankWithStr {
    //需要O(n)额外空间，时间复杂度O(n)
    //寻找不需要额外空间的解决方法，待续
    //难点是String没法用下标来控制
    public static void main(String[] args){
        String str1 = "Hello Word!";
        str1 = str1.replace(" ","%20");
        System.out.println(str1);
    }


}
