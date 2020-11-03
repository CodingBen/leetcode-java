package window;

import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring {


  public static void main(String args[]){

    String test = "aaabbbccc";

    System.out.println(lengthOfLongestSubstring(test));
  }

  //滑动
  public static int lengthOfLongestSubstring(String s) {
//    Set<Character> occ = new HashSet<Character>();
//
//    int n = s.length();
//    // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
//    int rk = -1, ans = 0;
//    for (int i = 0; i < n; i++) {
//      if (i != 0) {
//        // 左指针向右移动一格，移除一个字符
//        occ.remove(s.charAt(i - 1));
//      }
//      while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
//        // 不断地移动右指针
//        occ.add(s.charAt(rk + 1));
//        ++rk;
//      }
//      // 第 i 到 rk 个字符是一个极长的无重复字符子串
//      ans = Math.max(ans, rk - i + 1);
//    }
//    return ans;

    Set<Character> characters = new HashSet<>();
    int length = s.length();

    //右指针从下标0开始遍历
    int rk = 0, ans =0;
    //其实整个循环就是左指针动一下，右指针遍历一边
    for (int i = 0; i < length; i++){

      //第一轮右指针动，左指针不动。左指针从0开始
      if (i != 0){
        //第一个左指针，也是不断右移动，从0开始，但是为0的时候不remove串，因为没有啊。
        characters.remove(s.charAt(i -1));
      }
      //已经加入set集合中的字母不包含右边指针正在指向的字母，且右指针不超过其length。
      while (rk < length && !characters.contains(s.charAt(rk))){
        characters.add(s.charAt(rk));
        //移动右指针
        rk++;
      }
      //rk -i 代表右指针到左边指针到距离，代表该循环中最长子串的长度。ans代表历史上最长子串长度
      ans = Math.max(ans, rk - i);
    }
    return ans;
  }

}
