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
public class ChildDemo extends ExtendDemo{

        static {
            System.out.println("static child");
        }
        {
            System.out.println("class child");
        }
    ChildDemo() {
            System.out.println("child");
        }
    ChildDemo(String name) {
        System.out.println(name);
        new ExtendDemo(name + "father");
    }

    public static void main(String[] args) {
        System.out.println("start");
        new ChildDemo("test");
        System.out.println("end");
    }
    }
