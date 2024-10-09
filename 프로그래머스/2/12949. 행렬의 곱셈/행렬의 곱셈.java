class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];
        
        for(int arr1Row = 0; arr1Row < arr1.length; arr1Row++) {
            for(int arr2Col = 0; arr2Col < arr2[0].length; arr2Col++) {
                for(int arr1Col = 0; arr1Col < arr1[0].length; arr1Col++) {
                    answer[arr1Row][arr2Col] += arr1[arr1Row][arr1Col] * arr2[arr1Col][arr2Col];
                }
            }
        }
        
        return answer;
    }
}