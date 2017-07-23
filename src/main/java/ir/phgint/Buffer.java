
package ir.phgint;

public class Buffer {

    private int primeNumber;
    private boolean flag = true;

    public Buffer(boolean flag) {
        this.flag = flag;
    }

    public  boolean isFlag() {
        return flag;
    }

    public  void setFlag(boolean flag) {
        this.flag = flag;
    }

    public  void setPrimeNumber(int i) {
         primeNumber = i;
    }

    public  int getPrimeNumber() {

        return primeNumber;
    }
}

