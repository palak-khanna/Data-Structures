class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        // sort array
        Arrays.sort(tokens);
        int maxscore=0, score=0, i=0, j=tokens.length-1;

        while(i<=j){
            if(power>=tokens[i]){
                power-=tokens[i];
                score++;
                maxscore=Math.max(score,maxscore);
                i++;
            } else if(score>=1){
                power+=tokens[j];
                j--;
                score--;
            }else{
                break;
            }
        }
        return maxscore;
    }
}
