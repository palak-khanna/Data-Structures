class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1=nums1.length;
        int n2=nums2.length;

        // i want first arr to be less length as BS performed on 1st arr
        if(n1>n2) return findMedianSortedArrays(nums2, nums1);

        int low=0, high=n1;
        int left=(n1+n2+1)/2;
        int n=n1+n2;

        while(low<=high){
            int mid1=(low+high)/2;
            int mid2=left-mid1;

            int l1=Integer.MIN_VALUE, l2=Integer.MIN_VALUE;
            int r1=Integer.MAX_VALUE, r2=Integer.MAX_VALUE;

            if(mid1<n1) r1=nums1[mid1];
            if(mid2<n2) r2=nums2[mid2];

            if(mid1-1>=0) l1=nums1[mid1-1];
            if(mid2-1>=0) l2=nums2[mid2-1];

            // [1,2,3]
            // [1,3,5,6,8,10]
            if(l1<=r2 && l2<=r1){
                if(n%2==1) return Math.max(l1,l2);
                return (double) (Math.max(l1,l2)+Math.min(r1,r2))/2;
            }
            else if(l1>r2){
                high=mid1-1;
            }else low=mid1+1;
        }
        return 0;
    }
}
