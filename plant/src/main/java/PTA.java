/**
 * 2020八阶段 predation
 *
 * @author: wufa995<wufa995.git>
 * @date: 2020/5/1
 * @Copyright: 2020
 */

import java.util.Scanner;

/**
 * @description: 例子
 * @author: wufa995<wufa995.git>
 * @date: 2020/5/1 16:08
 * @version: V1.0
 */
public class PTA {

    public static void main(String[] args) {
        Long beginTime = System.currentTimeMillis();
        run1();
        System.out.println(System.currentTimeMillis() - beginTime);
    }

    private static void run1() {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        int sum = 0;
        String[] pinyin = {"ling","yi", "er", "san", "si", "wu", "liu", "qi", "ba", "jiu", "ling"};
        for(int i = 0; i < str.length(); i++) {
            sum += str.charAt(i) - '0';
        }
        int[] num = new int[130];
        int indes = 0;
        // System.out.println(sum);
        if(sum == 0) {
            System.out.print(pinyin[0]);
        }
        while(sum != 0) {
            num[indes++] = sum % 10;
            sum /= 10;
        }
        for(int i = indes - 1; i >= 0; i--) {
            System.out.print(pinyin[num[i]]);
            if(i != 0) {
                System.out.print(" ");
            }
        }
    }
}
