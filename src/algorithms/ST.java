package algorithms;
//线段树 SegmentTree
public class ST {
    // a:储存数据, pos:正在访问的下标, 乐翻天,right:当前区间的左右端点, num:待插入数据
    public void insert(int[] a, int pos, int left, int right, int num) {
        ++a[pos];
        if (num == right && num == left)// 当前区间是单位区间且正好对应num
            return;
        int mid = (left + right) / 2;
        int leftChild = pos * 2 + 1;
        int rightChild = pos * 2 + 2;
        if (num <= mid) {
            insert(a, leftChild, left, mid, num);
        } else {
            insert(a, rightChild, mid + 1, right, num);
        }

    }

    public int search(int[] a, int pos, int left, int right, int num) {
        if (num == left && num == right)
            return a[pos];
        int mid = (left + right) / 2;
        int leftChild = pos * 2 + 1;
        int rightChild = pos * 2 + 2;
        if (num <= mid) {// insert <=
            return search(a, leftChild, left, mid, num);
        } else {
            return search(a, rightChild, mid + 1, right, num);
        }
    }

    public void print(int[] a, int pos, int left, int right) {
        System.out.printf("[%d, %d] a[%2d] = %d\n", left, right, pos, a[pos]);
        if (left == right)
            return;
        int mid = (left + right) / 2;
        print(a, pos * 2 + 1, left, mid);
        print(a, pos * 2 + 2, mid + 1, right);
    }

    public static void main(String[] args) {
        ST st = new ST();
        int[] a = new int[20];
        int left = 0;
        int right = 5;
        st.insert(a, 0, left, right, 3);
        st.insert(a, 0, left, right, 5);
        st.insert(a, 0, left, right, 2);
        for (int i = 0; i <= 5; i++)
            System.out.println("search " + i + " : " + st.search(a, 0, left, right, i));
        st.print(a, 0, left, right);
    }
}