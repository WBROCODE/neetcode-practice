class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList<>();

        int numOne = 0;
        int numTwo = 0;
        int countOne = 0;
        int countTwo = 0;

        for(int n : nums){
            if(numOne == n){
                countOne++;
            }else if( numTwo == n){
                countTwo++;
            }else if(countOne == 0){
                numOne = n;
                countOne++;
            }else if(countTwo == 0){
                numTwo = n;
                countTwo++;
            }else {
                countOne--;
                countTwo--;
            }
        }
    
        int n = nums.length;
        countOne = 0;
        countTwo = 0;

        for(int num : nums){
            if(num == numOne){
                countOne++;
            }
            if(num == numTwo){
                countTwo++;
            }
        }

        if(countOne > n /3 ) ans.add(numOne);
        if(countTwo > n /3 && numOne != numTwo) ans.add(numTwo);

        return ans;
    }
}