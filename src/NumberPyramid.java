public class NumberPyramid {
    public static void main(String[] args) {
//        int row = 5, i, j, k = 1;
//        for (i = 1; i <= row; i++) {
//            for (j = 1; j <= row - i; j++) {
//                System.out.print(k + " ");
//                k++;
//            }
//            System.out.println();
//        }

//        int row = 5, i, j, k = 1;
//        for (i = 1; i <row; i++) {
//            for (j = 1; j<i+1; j++) {
//                System.out.print(k + " ");
//                k++;
//            }
//            System.out.println();
//        }

//        int row = 5, i, j, k = 1;
//        for (i = 1; i <row; i++) {
//            for (j = 1; j<i+1; j++) {
//                System.out.print(j + " ");
//            }
//            System.out.println();
//        }

        int row = 5, i, j, k = 1;
        for (i = 1; i <row; i++) {
            for (j = 1; j<i+1; j++) {
                System.out.print(3*k + " ");
                k++;
            }
            System.out.println();
        }
    }
}
