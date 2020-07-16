package union.find;

import utils.StandarInput;

public class QuickFind {

    private int id[];
    private int count;

    public QuickFind(int n) {
        if(n <= 0) {
            throw new IllegalArgumentException("Argument must a positive integer number");
        }

        count = n;
        id = new int[n];
        for(int i = 0; i < n; i++) {
            id[i] = i;
        }
    }

    public int count() {
        return count;
    }

    public int find(int p) {
        validate(p);
        return id[p];
    }

    public boolean connected(int p, int q) {
        validate(p);
        validate(q);
        return id[p] == id[q];
    }

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

    private void validate(int p) {
        int n = id.length;
        if(p < 0 && p >= n) {
            throw new IllegalArgumentException("Index " + p + " is not in between 0 and " + (n-1));
        }
    }

    public static void main(String[] args) {
        int n = StandarInput.readInt();
        QuickFind quickFind = new QuickFind(n);
        while (!StandarInput.isEmpty()) {
            int p = StandarInput.readInt();
            int q = StandarInput.readInt();
            if(quickFind.find(p) == quickFind.find(q)) continue;
            quickFind.union(p, q);
            System.out.println(p + " " + q);
            System.out.println(quickFind.count() + " components");
        }
    }
}
