package array;

public class IsMonotonic {

    public boolean isMonotonic(int[] A) {
        if (A.length < 2) return true;
        Boolean asc = null;
        for (int i = 1; i < A.length; i++) {
            while (A[i-1] == A[i]) {
                i++;
                if (i == A.length) return true;
            }
            if (asc == null) {
                asc = A[i] > A[i-1];
            } else if (asc && A[i] < A[i-1]) {
                return false;
            } else if (!asc && A[i] > A[i-1]) {
                return false;
            }
        }
        return true;
    }

    public boolean isMonotonic2(int[] A) {
        boolean asc = true, desc = true;
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] > A[i+1]) {
                asc = false;
            }
            if (A[i] < A[i+1]) {
                desc = false;
            }
        }
        return asc || desc;
    }
}
