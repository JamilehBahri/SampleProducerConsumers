package ir.phgint;

import java.util.Queue;

public class PrimeNumber  implements Comparable<PrimeNumber>{

    private final int prime;


    public PrimeNumber(int prime) {

        this.prime = prime;
    }

    public int compareTo(PrimeNumber j) {

        if (this.prime == j.prime)
        return 0;
        else if(this.prime > j.prime)
            return 1;
        else
            return -1;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PrimeNumber{");
        sb.append("prime=").append(prime);
        sb.append('}');
        return sb.toString();
    }
}
