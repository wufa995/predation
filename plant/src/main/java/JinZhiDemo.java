/**
 * 2020八阶段 predation
 *
 * @author: wufa995<wufa995.git>
 * @date: 2020/5/1
 * @Copyright: 2020
 */

/**
 * @description: 进制转化
 * @author: wufa995<wufa995.git>
 * @date: 2020/6/21
 * @version: V1.0
 */
public class JinZhiDemo {

    public static void main(String[] args) {
        Long beginTime = System.currentTimeMillis();
        String a = "99999";
        String x = jinzhi(a);
        System.out.println("结果 = " + x);
        System.out.println(System.currentTimeMillis() - beginTime);
    }
    public static  String jinzhi(String a) {
        String str = "0123456789ABCDEF";
        char[] flags = new char[100];
        int num = 0;
        int index = 0;
        for(int i = a.length() - 1; i >= 0; i--) {
            num += (a.charAt(i) - '0') * Math.pow(10,index++);
        }
        index = 0;
        while(num != 0) {
            int n = num / 16;
            int m = num % 16;
            flags[index++] = str.charAt(m);
            num = n;
        }
        String result = "";
        for(int i = index - 1; i >=0; i--) {
            result += flags[i];
        }
        if(result.length() == 1) {
            return "0x0" + result;
        }
        if (result.length() == 2) {
            return "0x" + result;
        }
        return result;
    }
}
