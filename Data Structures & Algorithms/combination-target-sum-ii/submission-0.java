class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtracking(candidates, target, result, 0, 0, new ArrayList<>());
        return result;
    }

    private void backtracking(int[] candidates, int target, List<List<Integer>> result
    , int index, int sum, List<Integer> curr) {
        if (target == sum) {
            result.add(new ArrayList<>(curr));
            return;
        }

        if (sum > target) {
            return;
        }

        for (int i = index ; i < candidates.length; i++) {
            if (i  > index && candidates[i] == candidates[i-1]) {
                continue;
            }
            curr.add(candidates[i]);
            backtracking(candidates,target, result, i + 1, sum + candidates[i], curr);
            curr.remove(curr.size()-1);
        }

    }
}
