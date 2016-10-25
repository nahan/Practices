package facebook.point;

//    http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=206905&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3086%5D%5Bvalue%5D%3D6%26searchoption%5B3086%5D%5Btype%5D%3Dradio%26searchoption%5B3087%5D%5Bvalue%5D%3D4%26searchoption%5B3087%5D%5Btype%5D%3Dradio%26searchoption%5B3089%5D%5Bvalue%5D%5B3%5D%3D3%26searchoption%5B3089%5D%5Btype%5D%3Dcheckbox%26searchoption%5B3046%5D%5Bvalue%5D%3D2%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311
//    
//    2016(10-12月) 码农类 硕士 全职@Facebook - 内推 - Onsite |Passfresh grad应届毕业生
//    今天刚收到fb的offer。进度条：8.23内推 - 9.20约 on campus - 9.23 on campus面试 - 9.26 通知onsit - 10.14 on site - 10.21 收到offer
//    由于签了NDA，这里就只说一下我个人觉得比较有意思的题目。
//    climbing stairs， rotate matrix
//    Populating Next Right Pointers in Each Node II, regex matching, decoding ways, two sums
//    我碰到了两轮behavior...应该有一轮是加面
//    ----------------------------------------
//    其实完全没想到能拿到Offer，只能说感谢behavior的三哥没有黑我吧，当然还有其他的面试官手下留情。

// https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/
// 117
public class PopulatingNextRightPointersInEachNodeII {

    // recursive solution
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            if (root.right != null) {
                root.left.next = root.right;
            } else {
                TreeLinkNode node = root.next;
                while (node != null && node.left == null && node.right == null) {
                    node = node.next;
                }
                if (node != null) {
                    root.left.next = node.left != null ? node.left : node.right;
                }
            }
        }
        if (root.right != null) {
            TreeLinkNode node = root.next;
            while (node != null && node.left == null && node.right == null) {
                node = node.next;
            }
            if (node != null) {
                root.right.next = node.left != null ? node.left : node.right;
            }
        }
        // recur right subtree first
        // we must settle down all right nodes before connect left nodes
        connect(root.right);
        connect(root.left);
        
    }
}
