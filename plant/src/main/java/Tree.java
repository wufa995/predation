/**
 * 2020八阶段 predation
 *
 * @author: wufa995<wufa995.git>
 * @date: 2020/5/1
 * @Copyright: 2020
 */

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @description: 二叉树
 * @author: wufa995<wufa995.git>
 * @date: 2020/5/1 16:08
 * @version: V1.0
 */
public class Tree {

    private static class Node {
        Node leftChild;
        Node rightChild;
        int data;

        Node(int newData) {
            leftChild = null;
            rightChild = null;
            data = newData;
        }
    }

    public static void main(String[] args) {
        Long beginTime = System.currentTimeMillis();
        run();
        System.out.println("----------------------------------");
        System.out.println(System.currentTimeMillis() - beginTime);
    }

    private static void run() {
        // Integer[] data = {1,23,99,12,3,132,4,432,333,999,9999,9990};
        Integer[] data = {6,2,1,4,3,5};
        List<Integer> datas = Arrays.asList(data);
        Node root = null;
        for(Integer d : datas) {
            root = insert2(root, d);
        }
        printqx(root);
        System.out.println();
        printzx(root);
        System.out.println();
        printhx(root);
        System.out.println();
        System.out.println("_____________________");

        root = delete(root, 0);
        printqx2(root);
        System.out.println();
        printzx2(root);
        System.out.println();
        printhx2(root);
        System.out.println();
        printcx(root);
        System.out.println();
        System.out.println("_____________________");

        qxzxQhx("ADEFGHMZ", "GDAFEMHZ");
        System.out.println();

        System.out.println("_____________________");

        hxzxQqx("ADEFGHMZ", "AEFDHZMG");
        System.out.println();

        System.out.println("_________LCA_________");

        Node lca = getLCA(root, new Node(2), new Node(5));
        System.out.println(lca.data);
    }

    private static Node insert(Node root, int num) {
        if(root == null) {
            Node p = new Node(num);
            p.leftChild = null;
            p.rightChild = null;
            root = p;
        } else if(num < root.data) {
            root.leftChild = insert(root.leftChild, num);
        } else {
            root.rightChild = insert(root.rightChild, num);
        }
        return root;
    }

    private static Node insert2(Node root, int num) {
        Node p = new Node(num);
        p.leftChild = null;
        p.rightChild = null;
        if(root == null) {
            root = p;
        } else {
            Node n = root;
            Node temp = n;
            while(true) {
                if(n == null) {
                    if(num < temp.data) {
                        temp.leftChild = p;
                    } else {
                        temp.rightChild = p;
                    }
                    break;
                }
                temp = n;
                if(num < n.data) {
                    n  = n.leftChild;
                } else {
                    n = n.rightChild;
                }
            }
        }
        return root;
    }

    private static void printqx(Node root) {
        if(root == null) {
            return;
        }
        System.out.print(root.data + " ");
        printqx(root.leftChild);
        printqx(root.rightChild);
    }

    private static void printzx(Node root) {
        if(root == null) {
            return;
        }
        printzx(root.leftChild);
        System.out.print(root.data + " ");
        printzx(root.rightChild);
    }

    private static void printhx(Node root) {
        if(root == null) {
            return;
        }
        printhx(root.leftChild);
        printhx(root.rightChild);
        System.out.print(root.data + " ");
    }

    private static void printcx(Node root) {
        BlockingQueue<Node> nodes = new ArrayBlockingQueue<>(20);
        if(root != null) {
            nodes.add(root);
        }
        while(!nodes.isEmpty()) {
            Node poll = nodes.poll();
            System.out.print(poll.data);
            if(poll.leftChild != null) {
                nodes.add(poll.leftChild);
            }
            if(poll.rightChild != null) {
                nodes.add(poll.rightChild);
            }
        }
    }

    private static void printqx2(Node root) {
        Stack<Node> nodes = new Stack<>();
        Node cur = root;
        Node top;
        while (cur != null || !nodes.empty())
        {
            while (cur != null)
            {
                System.out.print(cur.data);
                nodes.push(cur);
                cur = cur.leftChild;
            }

            top = nodes.pop();
            cur = top.rightChild;
        }
    }

    private static void printzx2(Node root) {
        Stack<Node> nodes = new Stack<>();
        Node cur = root;
        Node top;
        while (cur != null || !nodes.empty())
        {
            while (cur != null)
            {
                nodes.push(cur);
                cur = cur.leftChild;
            }

            top = nodes.pop();
            System.out.print(top.data);
            cur = top.rightChild;
        }
    }

    private static void printhx2(Node root) {
        Stack<Node> nodes = new Stack<>();
        Node cur = root;
        Node top;
        Node last = null;
        while (cur != null || !nodes.empty())
        {
            while (cur != null)
            {
                nodes.push(cur);
                cur = cur.leftChild;
            }

            top = nodes.pop();
            nodes.push(top);
            if (top.rightChild == null || top.rightChild == last){
                nodes.pop();
                System.out.print(top.data);
                last = top;
            }
            else {
                cur = top.rightChild;
            }
        }
    }

    private static Node delete(Node root, int num) {
        Node n = root;
        Node pre = null;
        while(n != null) {
            if(n.data == num) {
                if(n.leftChild == null && n.rightChild == null) {
                    if(pre != null) {
                        if(pre.data > num) {
                            pre.leftChild = null;
                        } else {
                            pre.rightChild = null;
                        }
                    } else {
                        return null;
                    }
                }
                if(n.leftChild == null && n.rightChild != null) {
                    if(pre != null) {
                        pre.rightChild = n.rightChild;
                    } else {
                        root = n.rightChild;
                    }
                }
                if(n.leftChild != null && n.rightChild == null) {
                    if(pre != null) {
                        pre.leftChild = n.leftChild;
                    } else {
                        root = n.leftChild;
                    }
                }
                if(n.leftChild != null && n.rightChild != null) {
                    Node l = n.rightChild;
                    Node lpre = l;
                    while(l.leftChild != null) {
                        lpre = l;
                        l = l.leftChild;
                    }
                    n.data = lpre.leftChild == null ? lpre.data : lpre.leftChild.data;
                    lpre.leftChild = lpre.leftChild == null ? null : lpre.leftChild.rightChild;
                }
                return root;

            } else if (n.data < num) {
                pre = n;
                n = n.rightChild;
            } else {
                pre = n;
                n = n.leftChild;
            }
        }
        return root;
    }

    private static void qxzxQhx(String zx, String qx){
        // qxzxQhx("123456", "621435");
        if("".equals(qx) || "".equals(zx)) {
            return;
        }
        char root = qx.charAt(0);
        int zxLen = zx.indexOf(root);
        qxzxQhx(zx.substring(0,zxLen), qx.substring(1));
        qxzxQhx(zxLen + 1 >= zx.length() ? "" : zx.substring(zxLen + 1), zxLen + 1 >= qx.length() ? "" : qx.substring(zxLen + 1));
        System.out.print(root);
        return;
    }

    private static void hxzxQqx(String zx, String hx){
        // hxzxQqx("ADEFGHMZ", "AEFDHZMG");
        // GDAFEMHZ
        //System.out.println(zx + " " + hx);
        if("".equals(hx) || "".equals(zx)) {
            return;
        }
        char root = hx.charAt(hx.length() - 1);
        System.out.print("[" + root + "]");
        int zxLen = zx.indexOf(root);
        hxzxQqx(zxLen == -1 ? "" :  zx.substring(0,zxLen), zxLen == -1 || hx.length() - 1 <= 0 ? "" : hx.substring(0,zxLen));
        hxzxQqx(zxLen + 1 >= zx.length() ? "" : zx.substring(zxLen + 1), zxLen + 1 >= hx.length() ? "" : hx.substring(zxLen, hx.length() - 1));
        return;
    }

    private static int length(Node root){
        if(root != null) {
            int left = length(root.leftChild);
            int right = length(root.rightChild);
            return Math.max(left + 1, right + 1);
        }
        return 0;
    }

    private static Node AVLpingheng(Node root){
        // LL RR LR RL
        if(length(root.leftChild) >= length(root.rightChild)) {
            if(length(root.leftChild.leftChild) >= length(root.leftChild.rightChild)) {
                Node nl = root.leftChild;
                root.leftChild = nl.rightChild;
                nl.rightChild = root;
                return nl;
            }
        }
        if(length(root.leftChild) < length(root.rightChild)) {
            if(length(root.leftChild.leftChild) < length(root.leftChild.rightChild)) {
                Node nl = root.rightChild;
                root.rightChild = nl.leftChild;
                nl.leftChild = root;
                return nl;
            }
        }
        return root;
    }

    private static Node getLCA(Node root, Node a, Node b) {
        if(root == null) {
            return null;
        }
        if(root.data == a.data || root.data == b.data) {
            return root;
        }
        Node left = getLCA(root.leftChild, a, b);
        Node right = getLCA(root.rightChild, a, b);
        if(left != null && right != null) {
            return root;
        } else if(left != null) {
            return left;
        } else if(right != null) {
            return right;
        } else {
            return null;
        }
    }

}
