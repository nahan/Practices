package facebook.point;

// http://www.1point3acres.com/bbs/thread-203983-1-1.html

//        一个完全树。node有parent指针。
//        每个node的值为 0或 1
//        每个parent的值为两个子node的 “and” 结果
//        现在把一个leaf翻牌子（0变1或者1变0）. visit 1point3acres.com for more.
//        把树修正一遍

/**
 * Created by Han on 11/2/16.
 */
public class TurnoverTree {

    public void turnoverTree(ParentTreeNode root, ParentTreeNode leaf) {
        if (root == null || leaf == null) {
            return;
        }
        leaf.val = !leaf.val;
        ParentTreeNode parent = leaf.parent;
        while (parent != null) {
            parent.val = parent.left.val && parent.right.val;
            parent = parent.parent;
        }
    }
}

class ParentTreeNode {
    boolean val;
    ParentTreeNode parent;
    ParentTreeNode left;
    ParentTreeNode right;
    public ParentTreeNode(boolean v) {
        val = v;
    }
}
