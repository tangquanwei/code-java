package algorithms;

import java.util.*;
import java.util.LinkedList;

// * 写递归算法的关键是要明确函数的「定义」是什么，然后相信这个定义，利用这个定义推导最终结果，绝不要跳入递归的细节
// * 写树相关的算法，简单说就是，先搞清楚当前 root 节点「该做什么」以及「什么时候做」，然后根据函数定义递归调用子节点
public class BT {
    private BT() {
    }

    /**
     * *先要搞清楚 root 节点它自己要做什么
     * 
     * *然后根据题目要求选择使用前序，中序，后续的递归框架
     * 
     * @param root
     */
    @SuppressWarnings("all")
    private void traverse(TreeNode root) {
        // *base case
        if (root == null)
            return;
        // *preorder traversal
        traverse(root.left);
        // *inorder traversal
        traverse(root.right);
        // *postorder traversal
    }

    static int count = 0;

    public static void printIndent(int count) {
        for (int i = 0; i < count; i++)
            System.out.print("  ");
    }

    public static void inOrderTraverse(TreeNode root) {
        printIndent(count++);
        if (root == null) {
            printIndent(--count);
            System.out.println("null");
            return;
        }
        inOrderTraverse(root.left);
        inOrderTraverse(root.right);
        printIndent(--count);
        System.out.println(root.val);
    }

    /**
     * @param root 树根
     * @return 以root为根的节点个数
     */
    public static int count(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + count(root.left) + count(root.right);
    }

    /**
     * 将整棵树节点反转
     */
    public static TreeNode invertTreee(TreeNode root) {
        if (root == null)
            return null;
        // 反转自己
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        // 反转左右
        invertTreee(root.left);
        invertTreee(root.right);
        return root;
    }

    /**
     * 定义：将以 root 为根的树拉平为链表
     */
    public static void flatten(TreeNode root) {
        // base case
        if (root == null)
            return;

        // recursive
        flatten(root.left);
        flatten(root.right);

        // 1. 左右子树已经被拉成一条链表
        TreeNode left = root.left;
        TreeNode right = root.right;

        // 2. 将左子树作为右子树
        root.left = null;
        root.right = left;

        // 3. 原右子树接到现右子树末端
        TreeNode p = root;
        while (p.right != null)
            p = p.right;
        p.right = right;

    }

    /**
     * 
     * @param nums
     * @return
     */
    TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    /**
     * *将 nums[lo..hi] 构造成符合条件的树，返回根节点
     * 
     * @param nums
     * @param lo
     * @param hi
     * @return
     */
    TreeNode build(int[] nums, int lo, int hi) {
        // base case
        if (lo > hi)
            return null;
        // 从nums中找到最大的值的下标
        int maxVal = Integer.MIN_VALUE, index = -1;
        for (int i = lo; i <= hi; i++) {
            if (nums[i] > maxVal) {
                maxVal = nums[i];
                index = i;
            }
        }
        // 用最大值构造节点
        TreeNode root = new TreeNode(maxVal);
        // 递归构造左右
        root.left = build(nums, lo, index - 1);
        root.right = build(nums, index + 1, hi);

        return root;
    }

    /**
     * 我要知道以自己为根的子树长啥样，是不是得先知道我的左右子树长啥样，再加上自己 使用「后序遍历」框架
     * 
     * @param root
     * @return
     */
    List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        return null;
    }

    /**
     * 把一棵二叉树序列化成字符串
     */
    public static String serialize(TreeNode root) {
        // base case
        if (root == null)
            return "#";
        // recursive
        String left = serialize(root.left);
        String right = serialize(root.right);
        return root.val + ", " + left + ", " + right;
    }

    /**
     * 把字符串反序列化成二叉树
     * 
     * @param data
     * @return
     */
    public static TreeNode deserialize(String data) {
        LinkedList<String> nodes = new java.util.LinkedList<>();
        for (String s : data.split(", ")) {
            nodes.addLast(s);
        }
        return deserialize(nodes);
    }

    private static TreeNode deserialize(LinkedList<String> nodes) {
        if (nodes.isEmpty())
            return null;

        /****** 前序遍历位置 ******/
        // 列表最左侧就是根节点
        String first = nodes.removeFirst();
        if (first.equals("#"))
            return null;
        TreeNode root = new TreeNode(Integer.parseInt(first));
        /***********************/

        root.left = deserialize(nodes);
        root.right = deserialize(nodes);

        return root;
    }

 
}
