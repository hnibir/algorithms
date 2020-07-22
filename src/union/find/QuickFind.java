package union.find;

/**
 *
 * Implementation of Quick-Find algorithm
 *
 * @author Nibir Hossain
 */

import utils.StandardInput;

public class QuickFind {

    private int id[];
    private int count;

    public QuickFind(int n) {
        initialize(n);
    }

    /**
     * Initializes an empty union-find data structure with n number of elements.
     * Components are created for each of the elements.
     *
     * @param n number of elements
     */
    private void initialize(int n) {
        if(n <= 0) {
            throw new IllegalArgumentException("Argument must be a positive integer number");
        }

        count = n;
        id = new int[n];
        for(int i = 0; i < n; i++) {
            id[i] = i;
        }
    }

    /**
     * Returns the number of sets (components).
     *
     * @return the number of sets
     */
    public int count() {
        return count;
    }

    /**
     * Returns the element of the set containing element.
     *
     * @param  p an element
     * @return the element of the set containing
     */
    public int find(int p) {
        validate(p);
        return id[p];
    }

    /**
     * Returns true if the two elements are in the same set.
     *
     * @param  p one element
     * @param  q the other element
     * @return true if p and are in the same set, false otherwise
     */
    public boolean connected(int p, int q) {
        validate(p);
        validate(q);
        return id[p] == id[q];
    }

    /**
     * Merges the set containing element p with the set containing element q.
     *
     * @param  p one element
     * @param  q the other element
     */
    public void union(int p, int q) {
        validate(p);
        validate(q);
        int pId = id[p];
        int qId = id[q];

        if(pId == qId) return;

        for(int i = 0; i < id.length; i++) {
            if(pId == id[i]) {
                id[i] = qId;
            }
        }
        count--;
    }

    /**
     * Validates whether p is a valid index (between 1 and <= n)
     * @param p
     */
    private void validate(int p) {
        int n = id.length;
        if(p < 0 && p >= n) {
            throw new IllegalArgumentException("Index " + p + " is not in between 0 and " + (n-1));
        }
    }

    public static void main(String[] args) {
        int n = StandardInput.readInt();
        QuickFind quickFind = new QuickFind(n);
        while (!StandardInput.isEmpty()) {
            int p = StandardInput.readInt();
            int q = StandardInput.readInt();
            if(quickFind.find(p) == quickFind.find(q)) continue;
            quickFind.union(p, q);
            System.out.println(p + " " + q);
            System.out.println(quickFind.count() + " components");
        }
    }
}
