package exer;

public class Test {
    private static double alpha = 0.33;

    public static void main(String[] args) {
        double[] h_data = new double[]{1180, 1097, 987, 1097, 1292, 1279, 1125, 1193, 1041, 1012, 963, 846, 772, 738, 624};
        System.out.println(getCesPridictedValue(h_data));
        System.out.println(h_data.hashCode());
    }

    public static int[] merge(int[] a, int[] b){
        int[] result = new int[a.length+b.length];
        int index_a = 0, index_b = 0, i;
        for(i=0; i<result.length; i++){
            if(index_a >= a.length || index_b >= b.length)
                break;
            else if(a[index_a] > b[index_b])
                result[i] = b[index_b++];
            else
                result[i] = a[index_a++];
        }

        if(index_a >= a.length){
            a = b;
            index_a = index_b;
        }

        for(; i<result.length; i++){
            result[i] = a[index_a++];
        }

        return result;
    }

    protected static double getCesPridictedValue(double[] historyData){
        /* time step to predict, i.e., 1 for 11th value, 2 for 12th value....*/
        int futureStep = 1;
        double s_1, s_2, s_3;
        s_1 = s_2 = s_3 = (historyData[0] + historyData[1] + historyData[2]) / 3;
        System.out.printf("%f %f %f\n", s_1, s_2, s_3);

        for(int i=1; i < historyData.length; i++){
            s_1 = alpha * historyData[i] + (1 - alpha) * s_1;
            s_2 = alpha * s_1 + (1 - alpha) * s_2;
            s_3 = alpha * s_2 + (1 - alpha) * s_3;
        }

        double a_t = 3 * s_1 - 3 * s_2 + s_3;
        double b_t = ((6-5*alpha)*s_1 - 2*(5-4*alpha)*s_2 + (4-3*alpha)*s_3) * alpha / Math.pow(1-alpha, 2) / 2;
        double c_t = (s_1 - 2*s_2 + s_3) * Math.pow(alpha, 2) / Math.pow(1-alpha, 2) / 2;

        System.out.printf("%f %f %f\n", a_t, b_t, c_t);
        return a_t + b_t * futureStep + c_t * Math.pow(futureStep, 2);
    }

}

