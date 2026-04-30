class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        recursion(result, nums, 0, target, new ArrayList<>(),0);
        return result;
    }

    private void recursion(List<List<Integer>> result, int[] nums, int sum, int target, List<Integer> curr, int index) {
        if (sum == target) {
            result.add(new ArrayList<>(curr));
            return;
        }

        for (int i = index; i < nums.length; i++) {
            if(sum + nums[i] > target) {
                return;
            }
            curr.add(nums[i]);
            recursion(result,nums, sum + nums[i], target, curr, i);
            curr.remove(curr.size()-1);
        }
    }
}
