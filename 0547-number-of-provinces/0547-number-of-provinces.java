class Solution {
    public int findCircleNum(int[][] isConnected) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i=0; i<isConnected.length; i++) {
            list.add(new ArrayList<>());
        }
        
        convertGraph(isConnected, list);
        return findProvinces(list);
    }

    public void convertGraph(int[][] arr, ArrayList<ArrayList<Integer>> list) {
        for(int i=0; i<arr.length; i++) {
            for(int j=0; j<arr[0].length; j++) {
                if(arr[i][j] == 1) {
                    list.get(i).add(j);
                }
            }
        }
    }

    public int findProvinces(ArrayList<ArrayList<Integer>> list) {
        boolean[] visited = new boolean[list.size()];
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;
        for(int i=0; i<list.size(); i++) {
            if(!visited[i]) {
                count++;
                queue.add(i);
                while(!queue.isEmpty()) {
                    int rv = queue.poll();
                    
                    if(visited[rv]) {
                        continue;
                    }
                    
                    visited[rv] = true;
                    
                    for(int k : list.get(rv)) {
                        if(!visited[k]) {
                            queue.add(k);
                        }
                    }
                }
            }
        }
        return count;
    }
}