/**
 * 2020八阶段 predation
 *
 * @author: wufa995<wufa995.git>
 * @date: 2020/5/19
 * @Copyr: 2020
 */

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @description:
 * @author: wufa995<wufa995.git>
 * @date: 2020/5/19 18:30
 * @version: V1.0
 */
public class Main2 {

    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        double x = a * 1.0 / b;
        System.out.print(String.format("%d/%.1f=%d", a, x, b));
    }

    public static void main2(String[] args) {
        Scanner scan = new Scanner(System.in);
        int x = scan.nextInt();
        if (x > 89) {
            System.out.print(String.format("gong xi ni kao le %d fen!", x));
        } else {
            System.out.println(String.format("kao le %d fen bie xie qi!", x));
        }
    }

    public static void main3(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n =  scan.nextInt();
        int socre0 = 0;
        int score1 = 0;
        int num0 = 0;
        int num1 = 0;
        while(n-- > 0) {
            int num = scan.nextInt();
            if(num == 1) {
                score1 += scan.nextInt();
                num1++;
            } else if(num == 0) {
                socre0 += scan.nextInt();
                num0++;
            }
        }
        System.out.print(String.format("%.1f ", (score1 + socre0) * 1.0 / (num1 + num0)));
        System.out.print(num1 == 0 ? "X " : String.format("%.1f ", score1 * 1.0 / num1));
        System.out.print(num0 == 0 ? "X" : String.format("%.1f", socre0 * 1.0 / num0));
    }

    public static void main4(String[] args) {
        Scanner scan = new Scanner(System.in);
        int sum = scan.nextInt() + scan.nextInt();
        if(sum == 0) {
            System.out.print(0);
        }
        Boolean fu = sum < 0;
        if(fu) {
            System.out.println("-");
            sum = 0 - sum;
        }
        int[] array = new int[100];
        int i = 0;
        while(sum != 0) {
            array[i++] = sum % 10;
            sum /= 10;
        }
        while(i-- > 0) {
            System.out.println(array[i]);
        }
    }

    public static void main5(String[] args) {
        Scanner scan = new Scanner(System.in);
        String answer = scan.nextLine();
        int notMatchNum;
        while(true) {
            String string = scan.nextLine();
            if("-1".equals(string)) {
                break;
            }
            if(answer.length() != string.length()) {
                System.out.println("No");
                continue;
            }
            notMatchNum = 0;
            for(int i = 0; i < answer.length(); i++) {
                char a = answer.charAt(i);
                char s = string.charAt(i);
                if(a != s) {
                    notMatchNum++;
                    if(Math.abs(answer.charAt(i) - string.charAt(i)) > 1) {
                        notMatchNum++;
                        break;
                    }
                }
                if(notMatchNum >= 2) {
                    break;
                }
            }
            System.out.println(notMatchNum <= 1 ? "Yes" : "No");
        }
    }

    public static void sort(int[] arr ,int l,int r){
        if(l > r) {
            return;
        }
        int b = arr[l];
        int low = l;
        int h = r;
        while (l<r){
            while (r>l && arr[r]> b){
                r--;
            }
            while (l<r && arr[l]<= b){
                l++;
            }
            if(l<r){
                int temp = arr[l];
                arr[l] = arr[r];
                arr[r] = temp;
            }
        }
        int p = b;
        arr[low] = arr[l];
        arr[l] = p;
        sort(arr,low,l-1);
        sort(arr,l+1,h);
    }
    
    public static void main8(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int p = scan.nextInt();
        int[] arr = new int[n + 10];
        for(int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }
        sort(arr, 0, n - 1);
        int num = 0;
        for(int i = 0; i < n - 1; i++) {
            for(int j = i + 1; j < n; j++) {
                Integer num1 = arr[i];
                Integer num2 = arr[j];
                if(num1 + num2 < p) {
                    continue;
                }
                if(num1 + p < num2) {
                    break;
                }
                num++;
            }
        }
        System.out.println(num);
    }

    private static int zeroNum = 0;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int p = scan.nextInt();
        System.out.print(String.format("%0" + p + "d", fun(n,p)));
        System.out.println(" " + zeroNum);
    }

    public static int fun(int num, int k) {
        int sum = 1;
        for(int i = 2; i <= num; i++) {
            sum = numUpdate(sum, i, k);
        }
        return sum;
    }

    public static int numUpdate(int num1, int num2, int k) {
        BigDecimal num = new BigDecimal(num1).multiply(new BigDecimal(num2));
        while(true) {
            BigDecimal[] c = num.divideAndRemainder(new BigDecimal(10));
            if (c[1].compareTo(new BigDecimal(0)) == 0) {
                num = num.divide(new BigDecimal(10));
                zeroNum++;
            } else {
                break;
            }
        }
        return num.divideAndRemainder(new BigDecimal(Math.pow(10,k)))[1].intValue();
    }
}
