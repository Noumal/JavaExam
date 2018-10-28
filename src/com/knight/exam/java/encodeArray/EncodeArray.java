import java.util.Arrays;
/**
 * Created by sachinkeshavé on 1/3/15.  
 *  Modified by noumal on 28/10/2018
 */
public class Exo {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(encodeArray(0)));
        System.out.println(Arrays.toString(encodeArray(1)));
        System.out.println(Arrays.toString(encodeArray(-1)));
        System.out.println(Arrays.toString(encodeArray(100001)));
        System.out.println(Arrays.toString(encodeArray(999)));
    }

    static int[] encodeArray(int n) {
        if (n == 0)
            return new int[]{1};

        int size = n < 0 ? 1 : 0;
        int nCopy = n < 0 ? -n : n;
        int nbDigit = 0;

        while (nCopy > 0) {
            int digit = nCopy % 10;
            nCopy /= 10;
            nbDigit++;
            size += digit + 1;
        }

        int[] result = new int[size];
        int[] temp = new int[nbDigit];

        nCopy = n < 0 ? -n : n;

        for (int x = temp.length - 1; x >= 0; x--) {
            temp[x] = nCopy % 10;
            nCopy /= 10;
        }

        for (int i = 0; i < size; i++) {
            if (i == 0 && n < 0) {
                result[i] = -1;
                i++;
            }

            for (int y = 0; y < temp.length; y++) {

                for (int j = 0; j < temp[y]; j++) {
                    result[i] = 0;
                    i++;
                }
                result[i] = 1;
                i++;
            }
        }
        return result;
    }
}



