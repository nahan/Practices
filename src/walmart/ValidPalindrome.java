package walmart;

//    http://www.1point3acres.com/bbs/thread-202669-1-1.html

//    2016(10-12月) 码农类 硕士 全职@Walmart labs - 内推 - 技术电面 |Otherfresh grad应届毕业生
//    刚才挂了电话，马上上面经。之前找人内推了walmart labs，据说这公司待遇不错。可惜最近不怎么招new grad，就帮我推了个full stack的。。。
//    算法题就考了判断回文。然后就问了一堆背景经验的东西，楼主老实说一直都做java后端的比较多，前端几乎不懂，而且他家用的是node.js，ruby，python，几乎不用java，我就只能说我是个fast learner，只要给个机会，我会学得很快的。。。
//    然后问了一些java里面interface和继承的区别，楼主分别答了一下不同点，竟然忘记了多继承这一点。。。
//    
//    总结一下，地里关于这家的电面面经不多，总结来说就是
//    1. leetcode 266
//    2. 给n个骰子返回所有数字组合
//    3. 给一个random产生0到1的函数和n，随机生成这n个数的一个序列(每次运行结果可能不同，因为随机)
//    4. 还有就是我的判断回文串
//    面跪了就move on吧。。。祝大家offer满满！

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        s = s.toLowerCase();
        while (i < j) {
            char left = s.charAt(i);
            char right = s.charAt(j);
            if (!isAlphNum(left)) {
                i++;
                continue;
            }
            if (!isAlphNum(right)) {
                j--;
                continue;
            }
            if (left != right) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    public boolean isAlphNum(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9');
    }
}
