import java.util.Arrays;
import java.util.Calendar;

/**
 * Created by yuriy on 9/5/15.
 */
public class SumArrayApp {

    public static void main(String[] args) throws InterruptedException {
        int [] ints = new int[10004];


        for (int i = 0; i < ints.length; i++) {
            ints[i] = i;
        }

        //System.out.println(Arrays.toString(ints));
        long currentTime = Calendar.getInstance().getTimeInMillis();
        System.out.println("Single thread:"+new SumArraySinle().getSum(ints));
        long period = Calendar.getInstance().getTimeInMillis() - currentTime;
        System.out.println("Single thread time is :"+period);
        SumArrayThread sumArrayThread = new SumArrayThread(ints);
        currentTime = Calendar.getInstance().getTimeInMillis();
        System.out.println(sumArrayThread.getSumByThread(4));
        period = Calendar.getInstance().getTimeInMillis() - currentTime;
        System.out.println("Multi thread time is :"+period);

    }
}
