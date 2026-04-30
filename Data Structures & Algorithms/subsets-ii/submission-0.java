class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backtracking(result,nums, 0, new ArrayList<>());
        return result;
    }

    private void backtracking(List<List<Integer>> result, int[] nums, int index, List<Integer> curr) {
        result.add(new ArrayList<>(curr));

        for (int i = index ; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i-1]) {
                continue;
            }

            curr.add(nums[i]);
            backtracking(result, nums, i+1, curr);
            curr.remove(curr.size()-1);
        }
    }
}
