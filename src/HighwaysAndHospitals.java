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


        // If the hospital cost is less than the highway cost build a hospital at every city
        if (hospitalCost< highwayCost) {
            return (long) n*hospitalCost;
        }

        // Array of the roots to keep track of the roots of each city
        int[] roots = new int[n];
        for (int i = 0; i < n; i++) {
            // Make each city its own root to start
            roots[i] = i;
        }

        // Do path compression method

        //Pseudocode from slides if needed
        // For each edge AB:
        //	X = A
        //	While city X is not its root:
        //		X = roots[X]
        //	While city A is not its root:
        //		temp = roots[A]
        //		roots[A] = X
        //		A = temp

        // For each edge AB:
        //	While city A is not its root:
        //		A = roots[A]
        //	While city B is not its root:
        //		B = roots[B]
        //	If A != B:
        //		roots[B] = A
        //
        //Calculate cost and return


        return 0;
    }
}
