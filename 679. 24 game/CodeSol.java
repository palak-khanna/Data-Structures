class Solution {
    public double[] compute(double a, double b){
        return new double[]{a+b, a*b, a-b, b-a, a/b, b/a};
    }

    public boolean helper(double[] arr){
        if(arr.length==1) return Math.abs(arr[0]-24)<=0.001;

        for(int i=0; i<arr.length; i++){
            for(int j=i+1; j<arr.length;j++){

                double[] remainele = new double[arr.length-1];
                for(int k=0, index=0; k<arr.length; k++){
                    if(k!=i && k!=j){
                        remainele[index]=arr[k];
                        index++;
                    }
                }

                for(double ele: compute(arr[i],arr[j])){
                    remainele[remainele.length-1]=ele;
                    if(helper(remainele)) return true;
                }
            }
        }
        return false;
    }

    public boolean judgePoint24(int[] cards) {
        double[] value = new double[]{cards[0],cards[1],cards[2],cards[3]};

        return helper(value);
    }
}
