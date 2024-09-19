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

    // Path compression function
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
            // Shifting each cities index to start at 0
            int cityA = cities[i][0] - 1;
            int cityB = cities[i][1] - 1;

            // Find the root of each city using path compression
            int rootA = pathCompression(cityA, roots);
            int rootB = pathCompression(cityB, roots);

            // If cities A and B are not already connected, connect them (union)
            if (rootA != rootB) {
                // Merge city B's root into city A's root
                roots[rootB] = rootA;
            }
        }
        // Count the number of unique components
        int components = 0;
        for (int i = 0; i < n; i++) {
            if (pathCompression(i, roots) == i) {
                components++;
            }
        }

        // Calculate the total cost using the equation from class and return it
        return (long) hospitalCost * components + (long) highwayCost * (n - components);
    }
}
