class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        /**
        
        -1,0,1,2,-1,-4
        

        -4 -1 -1 0 1 2 
        i
            j
                     k

        */
        int n = nums.length;
        for(int i = 0; i <= n - 3; i++){   
            if(i > 0 && nums[i] == nums[i - 1]) continue; 
            
            for(int j = i + 1, k = n - 1; j < k ;){
                if(nums[i] + nums[j] + nums[k] == 0){
                    List<Integer> temp = List.of(nums[i], nums[j], nums[k]);
                    ans.add(temp);
                    while(j < k && nums[j] == nums[j + 1]) j++;
                    while(j < k && nums[k] == nums[k - 1]) k--;
                    j++;
                    k--;
                }else if(nums[i] + nums[j] + nums[k] < 0){
                    j++;
                }else{
                    k--;
                }
            }    
        }
        return ans;
    }
}
