class Solution {
    public int addRungs(int[] rungs, int dist) {
        int current=0;
        int sum=0;

        for(int i=0; i<rungs.length; i++){
            if((rungs[i]-current)>dist){
                // [2,4,6,8,10] dist=2
                sum+=(rungs[i]-current-1)/dist;
            }
            current=rungs[i];
        }
        //  to reduce possibility of -ve ans
        if(sum<0) return 0;

        return sum;
    }
}
