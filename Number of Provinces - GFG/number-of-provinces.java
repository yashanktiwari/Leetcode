//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int V = Integer.parseInt(read.readLine());
            
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            for(int i=0; i<V; i++)
            {
                String S[] = read.readLine().split(" ");
                ArrayList<Integer> temp = new ArrayList<>();
                for(int j=0; j<V; j++)
                    temp.add(Integer.parseInt(S[j]));
                adj.add(temp);
            }

            Solution ob = new Solution();
            System.out.println(ob.numProvinces(adj,V));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        // code here
        HashSet[] graph = new HashSet[adj.size()+1];
        for(int i=0; i<=adj.size(); i++) {
            graph[i] = new HashSet<Integer>();
        }
        createGraph(adj, graph);
        
        return provinces(graph);
    }
    
    static void createGraph(ArrayList<ArrayList<Integer>> list, HashSet[] graph) {
        for(int i=0; i<list.size(); i++) {
            for(int j=0; j<list.get(i).size(); j++) {
                if(i != j && list.get(i).get(j) == 1) {
                    graph[i+1].add(j+1);
                }
            }
        }
    }
    
    static int provinces(HashSet[] graph) {
        Queue<Integer> queue = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        int count = 0;
        for(int i=1; i<graph.length; i++) {
            if(!visited.contains(i)) {
                count++;
                queue.add(i);
                while(!queue.isEmpty()) {
                    int rv = queue.poll();
                    
                    if(visited.contains(rv)) {
                        continue;
                    }
                    
                    visited.add(rv);
                    
                    HashSet<Integer> set = graph[rv];
                    for(int n : set) {
                        if(!visited.contains(n)) {
                            queue.add(n);
                        }
                    }
                }
            }
        }
        return count;
    }
};