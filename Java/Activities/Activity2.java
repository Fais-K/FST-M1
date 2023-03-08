package activities;

public class Activity2 {
    public static void main(String[] args) {

        int[] nums = {10, 77, 10, 54, -11, 10};

        System.out.println(checker(nums));
    }
    public static boolean checker(int[] nums){
        int sum = 0;
        for (int elem: nums){
            if (elem==10){
                sum = sum + 10;
                if (sum>30){
                    return false;
                }
            }
        }
        if (sum==30){
            return true;
        }
        return false;
    }
}

