/**
 * 2020八阶段 predation
 *
 * @author: wufa995<wufa995.git>
 * @date: 2020/5/1
 * @Copyright: 2020
 */

/**
 * @description: 例子
 * @author: wufa995<wufa995.git>
 * @date: 2020/5/1 16:08
 * @version: V1.0
 */
public class Demo {

    public static void main(String[] args) {
        Long beginTime = System.currentTimeMillis();
        run();
        System.out.println(System.currentTimeMillis() - beginTime);
    }

    private static void run() {
        System.out.println(maxVowels("ibpbhixfiouhdljnjfflpapptrxgcomvnb", 33));
    }

    public static  int maxVowels(String s, int k) {
        int result = 0;
        int max = 0;
        int[] arr = new int[s.length() + 30];
        int t = 0;
        for(int i =0; i < s.length(); i++) {
            t =0;
            if(s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o' || s.charAt(i) == 'u') {
                t = 1;
            }
            max += t;
            if(i < k) {
                arr[i] = t;
                result = Math.max(arr[i],result);
                if(result >= k) {
                    return k;
                }
            } else {
                arr[i] = max;
                result = Math.max(arr[i] - arr[i - k],result);
                if(result >= k) {
                    return k;
                }
            }
        }
        return result;
    }
}
