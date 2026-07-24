/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int si=1;
        int ei=n;

        while(si<=ei){
            int mi=si+(ei-si)/2;
            int call=guess(mi);

            if(call == 0){
                  return mi;
            }else if(call == -1){
                ei=mi-1;
            }else{
                si=mi+1;
            }
        }
        return -1;
    }
}