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



    // Path compression method
    public static int pathCompression(int A, int[] roots) {
        int X = A;

        // Traverse up the tree to find the root
        while (X != roots[X]) {
            X = roots[X];
        }

        // Compress the path using path compression
        // Make every city on the path from A to the root point directly to the root
        // This flattens down the current branch to be at one level in depth
        while (A != roots[A]) {
            int temp = roots[A];
            roots[A] = X;
            A = temp;
        }
        return X;
    }

    public static long cost(int n, int hospitalCost, int highwayCost, int cities[][]) {

        // If the hospital cost is less than the highway cost build a hospital at every city
        // This is a unique scenario when it is cheaper to build hospitals in every city
        if (hospitalCost <= highwayCost) {
            return (long) n*hospitalCost;
        }

        // Array to keep track of the roots of each city
        int[] roots = new int[n];
        for (int i = 0; i < n; i++) {
            // Make each city its own root to start
            roots[i] = i;
        }

        // Process all the highways (paired connections between cities)
        for (int i = 0; i < cities.length; i++) {
            // Shifting each cities index to 0
            int cityA = cities[i][0] - 1;
            int cityB = cities[i][1] - 1;

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
        // Count the number of components
        int components = 0;
        for (int i = 0; i < n; i++) {
            if (pathCompression(i, roots) == i) {
                components++;
            }
        }

        // Calculate the total cost and return it
        return (long) hospitalCost * components + (long) highwayCost * (n - components);
    }
}
