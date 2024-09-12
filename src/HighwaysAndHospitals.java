import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Highways & Hospitals
 * A puzzle created by Zach Blick
 * for Adventures in Algorithms
 * at Menlo School in Atherton, CA
 *
 * Completed by: [Lucas Ying]
 *
 */

public class HighwaysAndHospitals {

    /**
     * TODO: Complete this function, cost(), to return the minimum cost to provide
     *  hospital access for all citizens in Menlo County.
     */
    public static long cost(int n, int hospitalCost, int highwayCost, int cities[][]) {
        // For each city figure out every city it connects to
        // Then BFS from a starting city
        // as you look through the potential solution for if the city is connected with another city
        // and has a hospital, add a hospitalcost or highwaycost to a sum of moneySpent every time you add one
        // at the end of BFS return the money spent

        // If the hospital cost is less than the highway cost build a hospital at every city
        if (hospitalCost< highwayCost) {
            return (long) n*hospitalCost;
        }


            //build array
            //and complete bfs search fo rbest solution
        int[][] graph = new int[n][];
        int[] degrees = new int[n];

        // Count degrees of every city to know how many options each city has
        for (int[] road: cities){
            degrees[road[0]-1]++;
            degrees[road[1]-1]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];

        for (int i = 0; i<n; i++){
            while (!visited[n]){
                // do the bfs
            }
        }


        return 0;
    }
}
