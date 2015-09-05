/**
 * Created by yuriy on 9/5/15.
 */
public class SumArraySinle {
    public long getSum(final int [] values){
        long result = 0;
        for (int i = 0; i < values.length; i++) {
           result +=values[i];
        }
        return result;
    }
}
