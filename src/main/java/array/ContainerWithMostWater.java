package array;

public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int max = 0, h = 0;
        int left = 0, right = height.length - 1;
        while (left < right) {
            h = Math.min(height[left], height[right]);
            max = Math.max(max, h * (right-left));
            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        ContainerWithMostWater target = new ContainerWithMostWater();
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(target.maxArea(height) == 49);
        int[] height2 = {1,2,1};
        System.out.println(target.maxArea(height2) == 2);
        int[] height3= {4,3,2,1,4};
        System.out.println(target.maxArea(height3) == 16);
    }
}
