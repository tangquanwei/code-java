package algorithms;

import java.util.PriorityQueue;
// import static algorithms.LinkedList.*;



public final class LinkedList {

    private ListNode head;

    public LinkedList() {
        head = new ListNode();
    }

    public LinkedList(int... is) {
        head = new ListNode(is[0]);
        for (int i = is.length - 1; i > 0; --i) {
            ListNode p = new ListNode(is[i]);
            p.next = head.next;
            head.next = p;
        }
    }

    ListNode getListNode() {
        return head;
    }

    ListNode indexOf(int n) {
        ListNode cur = head;
        for (int i = 0; i < n; ++i)
            if (cur.next != null)
                cur = cur.next;
            else
                return null;
        return cur;
    }

    public void print() {
        ListNode p = head;
        while (p != null) {
            System.out.print(p.val);
            if (p.next != null) {
                System.out.print(" -> ");
                p = p.next;
            } else
                break;
        }
    }

    public static void print(ListNode node) {
        ListNode p = node;
        while (p != null) {
            System.out.print(p.val);
            if (p.next != null) {
                System.out.print(" -> ");// 分隔
                p = p.next;
            } else
                break;
        }
    }

    /**
     * 合并 k 个有序链表 使用 优先级队列（二叉堆）
     * 
     * @param lists
     * @return
     */
    ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0)
            return null;
        // 虚拟头结点
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        // 优先级队列，最小堆
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, (a, b) -> (a.val - b.val));
        // 将 k 个链表的头结点加入最小堆
        for (ListNode head : lists) {
            if (head != null)
                pq.add(head);
        }

        while (!pq.isEmpty()) {
            // 获取最小节点，接到结果链表中
            ListNode node = pq.poll();
            p.next = node;
            if (node.next != null) {
                pq.add(node.next);
            }
            // p 指针不断前进
            p = p.next;
        }
        return dummy.next;
    }

    // 返回链表的倒数第 k 个节点
    ListNode findFromEnd(ListNode head, int k) {
        ListNode p1 = head;
        // p1 先走 k 步
        for (int i = 0; i < k; i++) {
            p1 = p1.next;
        }
        ListNode p2 = head;
        // p1 和 p2 同时走 n - k 步
        while (p1 != null) {
            p2 = p2.next;
            p1 = p1.next;
        }
        // p2 现在指向第 n - k 个节点
        return p2;
    }

    /**
     * 删除链表的倒数第 N 个结点
     * 
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 虚拟头结点
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        // 删除倒数第 n 个，要先找倒数第 n + 1 个节点
        ListNode x = findFromEnd(dummy, n + 1);
        // 删掉倒数第 n 个节点
        x.next = x.next.next;
        return dummy.next;
    }

    /**
     * 单链表的中点
     */
    ListNode middleNode(ListNode head) {
        // 快慢指针初始化指向 head
        ListNode slow = head, fast = head;
        // 快指针走到末尾时停止
        while (fast != null && fast.next != null) {
            // 慢指针走一步，快指针走两步
            slow = slow.next;
            fast = fast.next.next;
        }
        // 慢指针指向中点
        return slow;
    }

    /**
     * 判断链表是否包含环
     * 
     * @param head
     * @return
     */
    boolean hasCycle(ListNode head) {
        // 快慢指针初始化指向 head
        ListNode slow = head, fast = head;
        // 快指针走到末尾时停止
        while (fast != null && fast.next != null) {
            // 慢指针走一步，快指针走两步
            slow = slow.next;
            fast = fast.next.next;
            // 快慢指针相遇，说明含有环
            if (slow == fast) {
                return true;
            }
        }
        // 不包含环
        return false;
    }

    /**
     * 计算这个环的起点
     */
    ListNode detectCycle(ListNode head) {
        ListNode fast, slow;
        fast = slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow)
                break;
        }
        // 上面的代码类似 hasCycle 函数
        if (fast == null || fast.next == null) {
            // fast 遇到空指针说明没有环
            return null;
        }

        // 重新指向头结点
        slow = head;
        // 快慢指针同步前进，相交点就是环起点
        while (slow != fast) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    /**
     * 两个链表是否相交
     * 
     * 让 p1 遍历完链表 A 之后开始遍历链表 B，
     * 
     * 让 p2 遍历完链表 B 之后开始遍历链表 A，
     * 
     * 这样相当于「逻辑上」两条链表接在了一起
     */
    ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // p1 指向 A 链表头结点，p2 指向 B 链表头结点
        ListNode p1 = headA, p2 = headB;
        while (p1 != p2) {
            // p1 走一步，如果走到 A 链表末尾，转到 B 链表
            if (p1 == null)
                p1 = headB;
            else
                p1 = p1.next;
            // p2 走一步，如果走到 B 链表末尾，转到 A 链表
            if (p2 == null)
                p2 = headA;
            else
                p2 = p2.next;
        }
        return p1;
    }

    public static ListNode dfs(ListNode head) {
        if (head.next == null)
            return head;
        // 前序遍历位置
        ListNode last = dfs(head.next);// 最后一个
        // 后序遍历位置
        System.out.print(head.val + "  ");
        return last;
    }
    // 不要跳进递归，而是利用明确的定义来实现算法逻辑

    public static ListNode reverseRecursive(ListNode head) {
        if (head.next == null)
            return head;
        ListNode last = reverseRecursive(head.next);// 最后一个

        System.out.print(head.val + "->");
        // 这里的haed是最后一个的前一个
        head.next.next = head;
        head.next = null;
        // 始终返回最后一个
        return last;
    }

    private static ListNode successor = null; // 后驱节点

    // 反转以 head 为起点的 n 个节点，返回新的头结点
    public static ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            // 记录第 n + 1 个节点
            successor = head.next;
            return head;
        }
        // 以 head.next 为起点，需要反转前 n - 1 个节点
        ListNode last = reverseN(head.next, n - 1);

        head.next.next = head;
        // 让反转之后的 head 节点和后面的节点连起来
        head.next = successor;
        return last;
    }

    ListNode reverseBetween(ListNode head, int m, int n) {
        // base case
        if (m == 1) {
            return reverseN(head, n);
        }
        // 前进到反转的起点触发 base case
        head.next = reverseBetween(head.next, m - 1, n - 1);
        return head;
    }

    public static ListNode reverse(ListNode head) {
        ListNode pre, cur, nxt;
        pre = null;
        cur = nxt = head;
        while (cur != null) {
            nxt = cur.next;
            cur.next = pre;// 反转
            // 后移
            pre = cur;
            cur = nxt;
        }
        return pre;
    }

    public static ListNode reverse(ListNode head, ListNode b) {
        ListNode pre, cur, nxt;
        pre = null;
        cur = nxt = head;
        while (cur != b) {// 反转b之前的
            nxt = cur.next;
            cur.next = pre;// 反转
            // 后移
            pre = cur;
            cur = nxt;
        }
        return pre;
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null)
            return head;
        // 区间 [a, b) 包含 k 个待反转元素
        ListNode a, b;
        a = b = head;
        for (int i = 0; i < k; i++) {
            // 不足 k 个，不需要反转，base case
            if (b == null)
                return head;
            b = b.next;
        }

        // 反转前 k 个元素
        ListNode newHead = reverse(a, b);
        // 递归反转后续链表并连接起来
        a.next = reverseKGroup(b, k);
        return newHead;
    }

    /**
     * 判断回文链表1
     */
    ListNode left;

    public boolean isPalindrome(ListNode head) {
        left = head;
        return traverse(head);
    }

    private boolean traverse(ListNode right) {
        if (right == null)
            return true;
        boolean res = traverse(right.next);// 最后一个
        res = res && (right.val == left.val);
        left = left.next;
        return res;
    }

    /**
     * 判断回文链表2
     */
    public boolean isPal(ListNode head) {
        // 快慢指针找中点
        ListNode fast, slow;
        fast = slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode p = slow;
        // 奇数个节点slow后移一位,中点不用判断,不反转
        if (fast != null) {
            slow = slow.next;
        }
        // 反转slow
        ListNode left = head;
        ListNode right = reverse(slow), q = right;
        // 判断回文
        while (right != null) {
            if (right.val != left.val)
                return false;
            right = right.next;
            left = left.next;
        }
        // 还原
        p.next = reverse(q);
        return true;
    }

    public static void main(String[] args) {
        LinkedList l1 = new LinkedList(0, 1, 2, 3, 4, 5, 5, 5, 4, 3, 2, 1, 0);
        ListNode node = l1.getListNode();
        System.out.println(l1.isPal(node));
        print(node);
        // node = reverse(node, l1.indexOf(3));
        // ListNode r = reverseKGroup(node, 2);
        // print(r);
        // reverseRecursive();
        // System.out.println();
        // System.out.println(l1.indexOf(0));
        // System.out.println(l1.indexOf(9));
        // System.out.println(l1.indexOf(10));
        // dfs(node);
    }

}
