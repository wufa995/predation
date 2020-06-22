/**
 * 2020八阶段 predation
 *
 * @author: wufa995<wufa995.git>
 * @date: 2020/5/1
 * @Copyright: 2020
 */

/**
 * @description: 例子 - 大整数乘法
 * @author: wufa995<wufa995.git>
 * @date: 2020/6/21
 * @version: V1.0
 */
public class MulDemo {

    public static void main(String[] args) {
        // System.out.println(jian("7405926","2468642"));
        Long beginTime = System.currentTimeMillis();
        String a = "111111111111111";
        String b = "222222222222222";
        String x = nul(a, b, Math.max(a.length(), b.length()) / 2);
        System.out.println("结果 = " + x);
        System.out.println(System.currentTimeMillis() - beginTime);
    }
    public static  String nul(String a, String b, int n) {
        if("0".equals(a) || "0".equals(b)) {
            return "0";
        }
        if(n <= 2 ) {
            return "" + Integer.valueOf(a) * Integer.valueOf(b);
        }
        // a1b1(nn) + a1b2(n) + a2b1(n) + a2b2
        String a1 = a.length() - n <= 0 ? "0" : a.substring(0,a.length() - n);
        String a2 = a.substring(a.length() - n < 0 ? 0 : a.length() - n, a.length());
        String b1 = b.length() - n <= 0 ? "0" : b.substring(0,b.length() - n);
        String b2 = b.substring(b.length() - n < 0 ? 0 : b.length() - n, b.length());

        String a1b1 = nul(a1, b1, n / 2);

        String a2b2 = nul(a2, b2, n / 2);
        String a1ja2 = jia(a1, a2);
        String bijb2 = jia(b1, b2);
        String a1ja2b1jb2 = nul(a1ja2, bijb2, Math.max(a1ja2.length(), bijb2.length()) / 2);
        String a1b2ja2b1 = jian(jian(a1ja2b1jb2, a1b1),a2b2);
        if(!"0".equals(a1b1)) {
            for(int i = 0; i < n; i++) {
                a1b1 += "00";
            }
        }
        if(!"0".equals(a1b2ja2b1)) {
            for (int i = 0; i < n; i++) {
                a1b2ja2b1 += "0";
            }
        }
        String result = jia(jia(a1b1, a2b2),a1b2ja2b1);
        System.out.println(a + " * " + b + " = " + a1b1 + " + " + a2b2 + " + " + a1b2ja2b1 + " = " + result);
        return result;
    }

    public static  String jia(String a, String b) {
        int[] c = new int[1000];
        int index = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;
        int flag = 0;
        for(;i >= 0 && j >= 0;) {
            int n1 = a.charAt(i) - '0';
            int n2 = b.charAt(j) - '0';
            int sum = n1 + n2 + flag;
            if(sum >= 10) {
                flag = 1;
                c[index++] = sum % 10;
            } else {
                flag = 0;
                c[index++] = sum;
            }
            i--;
            j--;
        }
        if(i >= 0) {
            for(;i >= 0; i--) {
                int sum = a.charAt(i) - '0' + flag;
                if(sum >= 10) {
                    flag = 1;
                    c[index++] = sum % 10;
                } else {
                    flag = 0;
                    c[index++] = sum;
                }
            }
        }
        if(j >= 0) {
            for(;j >= 0; j--) {
                int sum = b.charAt(j) - '0' + flag;
                if(sum >= 10) {
                    flag = 1;
                    c[index++] = sum % 10;
                } else {
                    flag = 0;
                    c[index++] = sum;
                }
            }
        }
        String reuslt = "";
        for(int k = index - 1; k >= 0; k--) {
            reuslt += c[k];
        }
        return reuslt;
    }

    public static  String jian(String a, String b) {
        int[] c = new int[1000];
        int index = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;
        int flag = 0;
        for(;i >= 0 && j >= 0;) {
            int n1 = a.charAt(i) - '0';
            int n2 = b.charAt(j) - '0';
            int sum = n1 - n2;
            c[index++] = sum;
            i--;
            j--;
        }
        if(i >= 0) {
            for(;i >= 0; i--) {
                int sum = a.charAt(i) - '0';
                c[index++] = sum;
            }
        }
        if(j >= 0) {
            for(;j >= 0; j--) {
                int sum = 0 - (b.charAt(j) - '0');
                c[index++] = sum % 10;
            }
        }
        String reuslt = "";
        // 绝对是正数
        for(int k = 0; k < index ; k++) {
            if(c[k] < 0) {
                c[k + 1]--;
                c[k] += 10;
            }
        }
        for(int k = index - 1; k >= 0; k--) {
            if(!(k == index - 1 && c[k] == 0)) {
                reuslt += c[k];
            }
        }
        return reuslt;
    }
}
