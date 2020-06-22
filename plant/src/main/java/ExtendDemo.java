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
public class ExtendDemo {

    static {
        System.out.println("static father");
    }
    {
        System.out.println("class father");
    }
    ExtendDemo() {
        System.out.println("father");
    }

    ExtendDemo(String name) {
        System.out.println(name);
    }
}
