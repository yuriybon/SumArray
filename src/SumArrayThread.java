import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuriy on 9/5/15.
 */
public class SumArrayThread {
    final int [] values;
    int result = 0;
    Object myObject = new Object();

    public SumArrayThread(int[] values) {
        this.values = values;
    }

    class SumArray implements Runnable {
        private int startInd;
        private int endInd;

        public SumArray(int startInd, int endInd) {
            this.startInd = startInd;
            this.endInd = endInd;
        }

        @Override
        public void run() {
            for (int i = startInd; i <= endInd ; i++) {
                synchronized (myObject) {
                    result += values[i];
                }

            }
        }
    }

    public long getSumByThread(int countThread) throws InterruptedException {
        int sizeThread=0;
        List<Thread> arrThread = new ArrayList<Thread>();
        if (countThread >= values.length || countThread == 1) {
            sizeThread = values.length;
        }
        else {
            sizeThread = (int) values.length/countThread;
        }

        int rest = values.length;
        int i = 0;
        while ( rest >= sizeThread ) {
            arrThread.add(new Thread(new SumArray(i,i+sizeThread-1)));
            rest -= sizeThread;
            i +=sizeThread;
        }
        if (rest > 0) {
            arrThread.add(new Thread(new SumArray(i,i+rest-1)));
        }


        for ( i = 0; i < arrThread.size(); i++) {
            arrThread.get(i).start();
            try {
                arrThread.get(i).join();
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }

        return this.result;
    }
}
