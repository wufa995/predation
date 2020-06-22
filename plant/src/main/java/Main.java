/**
 * 2020八阶段 predation
 *
 * @author: wufa995<wufa995.git>
 * @date: 2020/5/19
 * @Copyright: 2020
 */

import java.util.Scanner;

/**
 * @description:
 * @author: wufa995<wufa995.git>
 * @date: 2020/5/19 18:30
 * @version: V1.0
 */
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] flag = new int[200];
        int index = 0;
        for(int i = 0; i < n; i++) {
            int num = scan.nextInt();
            for(int j = 0; j < num; j++) {
                flag[index] = 1;
                index++;
            }
            flag[index++] = 0;
        }
        int i = 0;
        scan.nextLine();
        while(true) {
            String str = scan.nextLine();
            if("End".equals(str)) {
                break;
            }
            System.out.print(flag[i % index] + " ");
            if("ChuiZi".equals(str)) {
                if(flag[i % index] == 1) {
                    System.out.println("Bu");
                } else {
                    System.out.println("JianDao");
                }
            } else if("Bu".equals(str)) {
                if(flag[i % index] == 1) {
                    System.out.println("JianDao");
                } else {
                    System.out.println("ChuiZi");
                }
            } else if("JianDao".equals(str)) {
                if(flag[i % index] == 1) {
                    System.out.println("ChuiZi");
                } else {
                    System.out.println("Bu");
                }
            }
            i++;
        }
    }
}
