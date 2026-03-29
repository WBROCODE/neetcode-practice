class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length; 

        for(int i= 0 ; i <= n - 3; i++){

            if(i > 0 && nums[i - 1] == nums[i]) continue;
            int j = i + 1;
            int k = n - 1;

            while(j < k){

                int sum = nums[i] + nums[j] + nums[k];

                if(sum == 0){
                    ans.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k])));
                    while(j < k && nums[j] == nums[j + 1]) j++;
                    while(j < k && nums[k] == nums[k - 1]) k--;
                    j++;
                    k--;
                }

                if(sum < 0) j++;
                else if(sum > 0) k--;
            }
        }
        return ans;
        

    }
}
