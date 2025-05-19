package LeetCode;

class LeetCode3024 {
    public String triangleType(int[] nums) {
        int a = nums[0];
        int b = nums[1];
        int c = nums[2];

        if(a+b<=c || b+c<=a || c+a<=b){
            return "none";
        }
        if(a == b && a == c){
            return "equilateral";
        }
        if((a == b && a != c) || (b == c && b!=a) || ( a==c && a!=b )){
            return "isosceles";
        }
        return "scalene";
    }
}