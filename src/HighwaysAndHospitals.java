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

        // Path compression method
        int pathCompression(int A) {
            int X = A;

            // While city X is not its root, find the root
            while (X != roots[X]) {
                X = roots[X];
            }

            // While city A is not its root
            // Compress the path
            while (A != roots[A]) {
                int temp = roots[A];
                roots[A] = X;
                A = temp;
            }
            return X;
        }

        for (int i = 0; i < cities.length; i++) {

            int cityA =
            int cityB =

            while (cityA != roots[cityA]) {
                cityA = roots[cityA];
            }

            while (cityB != roots[cityB]) {
                cityB = roots[cityB];
            }
            // Connect the roots if they are different (union them)
            if (cityA != cityB) {
                roots[cityB] = cityA;
            }
        }
        // Calculate component sizes
        int [] componentSize = new int[n];
        for (int i = 0; i < n; i++) {
            // Find the root of the city
            int root = pathCompression(i);
            // Increment the size of the component for that root
            componentSize[root]++;
        }

        // Calculate the total cost



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
