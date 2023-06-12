class Solution {
    public List<String> summaryRanges(int[] arr) {
        List<String> list = new ArrayList<>();
        int si = -1, ei = -1;
        for(int i=0; i<arr.length; i++) {
            if(i+1 < arr.length && arr[i] == arr[i+1]-1) {
                if(si == -1) {
                    si = arr[i];
                }
                ei = arr[i+1];
            } else {
                if(si != -1) {
                    String s = si + "->" + ei;
                    list.add(s);
                    si = -1;
                } else {
                    list.add(arr[i] + "");
                }
            }
        }
        return list;
    }
}