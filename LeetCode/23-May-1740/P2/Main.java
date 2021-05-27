import java.util.ArrayDeque;
import java.util.Deque;

class Main
{
    public static void main(String[] args) {
        
        String s = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext";

        System.out.println(lengthLongestPath(s));
    }

    public static int lengthLongestPath(String input) {
        
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);

        int maxlen = 0;
        for(String s : input.split("\n"))
        {
            int lev = s.lastIndexOf('\t')+1;
            while(lev+1<stack.size())
                stack.pop();

            int len = stack.peek()+s.length()+1;
            stack.push(len);

            if(s.contains("."))
                maxlen = Math.max(maxlen, len-1);

        }
        return maxlen;

    }
}