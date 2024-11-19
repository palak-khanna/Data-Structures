class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n=matrix.length, m=matrix[0].length;
        int low=0, high=(n*m)-1;

        while(low<=high){
            int mid=(low+high)/2;
            int row=mid/m, col=mid%m;

            if(matrix[row][col] == target) return true;
            else if(target>matrix[row][col]) low=mid+1;
            else high=mid-1;
        }

        return false;
    }
}
