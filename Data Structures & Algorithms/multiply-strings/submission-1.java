class Solution {
    public String multiply(String num1, String num2) {
        long nums1=0;
        long nums2=0;

        for(int i=0;i<num1.length();i++){
            nums1=nums1*10+(num1.charAt(i)-'0');
        }
        for(int i=0;i<num2.length();i++){
            nums2=nums2*10 +(num2.charAt(i)-'0');
        }
        long nums3=nums1 * nums2;

        return String.valueOf(nums3);
    }
}
