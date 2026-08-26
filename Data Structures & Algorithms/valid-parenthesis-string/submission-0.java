class Solution {
    public boolean checkValidString(String s) {
        int n = s.length();
        int open=0;

        for(int i=0;i<n;i++){
            char ch = s.charAt(i);

            if(ch == '(') open++;
            else if(ch == ')') open--;
            else open++;

            if(open < 0) return false;
            
        }

        int closed=0;

        for(int i=n-1;i>=0;i--){
            char ch = s.charAt(i);

            if(ch == ')') closed++;
            else if(ch == '(') closed--;
            else closed++;

            if(closed < 0) return false;
        }

        return true;
    }
}
