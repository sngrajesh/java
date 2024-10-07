package Day9.labs.second;

public class SyncCounter {
    private int count = 0;

    synchronized void incerement() {
        count++;
    }

    int getCount() {
        return count;
    }

}
