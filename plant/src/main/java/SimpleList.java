/**
 * 2020八阶段 predation
 *
 * @author: wufa995<wufa995.git>
 * @date: 2020/6/22
 * @Copyright: 2020
 */

/**
 * @description:
 * @author: wufa995<wufa995.git>
 * @date: 2020/6/21
 * @version: V1.0
 */
public class SimpleList<T> {

    private SimpleList<T> before;
    private SimpleList<T> next;
    private T data;

    SimpleList() {
        before = null;
        next = null;
        data = null;
    }

    SimpleList(SimpleList<T> before, SimpleList<T> next, T data) {
        this.before = before;
        this.next = next;
        this.data = data;
    }

    /**
     * 按序号获取数据 从0开始
     * @param i 序号
     * @return SimpleList<T>
     */
    public SimpleList<T> get(int i){
        return null;
    }

    /**
     * 按data获取数据 返回第一个data相同的值
     * @param data
     * @return SimpleList<T>
     */
    public SimpleList<T> get(T data){
        return null;
    }

    /**
     * 尾插 插入到指定位置
     * @param data
     * @param i
     * @return SimpleList<T>
     */
    public SimpleList<T> insert(T data, int i){
        // 如果i等于0 头插
        // else 如果i等于-1 或者 >=List的长度 尾插
        // else 按i的位置插入
        return null;
    }

    /**
     * 删除第一个于data值相等的对象
     * @param data
     * @return SimpleList<T>
     */
    public SimpleList<T> earse(T data){
        return null;
    }

    /**
     * 删除指定位置的对象
     * @param i
     * @return SimpleList<T>
     */
    public SimpleList<T> earse(int i){
        return null;
    }

}
