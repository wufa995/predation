/**
 * 2020八阶段 predation
 *
 * @author: wufa995<wufa995.git>
 * @date: 2020/5/1
 * @Copyright: 2020
 */

/**
 * @description: KMP算法学习
 * @author: wufa995<wufa995.git>
 * @date: 2020/5/1 16:08
 * @version: V1.0
 */
public class Kmp {

    public static void main(String[] args) {
        Long beginTime = System.currentTimeMillis();
        run();
        System.out.println("----------------------------------");
        System.out.println(System.currentTimeMillis() - beginTime);
    }

    private static int kmp(String str, String childStr, int[] next) {
        int nextNum = 0;
        for(int i = 0; i < str.length(); i++) {
            // 移动下标数
            for(int j = nextNum; j < childStr.length(); j++) {
                if(str.charAt(i + j) != childStr.charAt(j)) {
                    nextNum = next[j ];
                    break;
                }
                if(j ==  childStr.length() - 1) {
                    return i;
                }
            }
            i += nextNum;
        }
        return 0;
    }

    private static int[] next(String childStr) {
        int length = childStr.length();
        int[] next = new int[length + 30];
        for(int i = 0; i < length; i++) {
            if(i == length - 1 && childStr.charAt(i) == childStr.charAt(length - 1)) {
                next[i] = length - i;
            }
        }
        return next;
    }
    private static void run() {
        String str = "bbc abcdab abcdabcdabde";
        String childStr = "abcdabd";
        int[] next = next(childStr);
        int index = kmp(str, childStr, next);
        System.out.println(index);
    }
}
