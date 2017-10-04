package for_teacher;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        // Create new threads for f1, f2 and f3:
        C1 c1 = new C1(4);  // (for f1)
        C2 c2 = new C2(4);  // (for f2)
        C3 c3 = new C3(4);  // (for f3)

        // Add all threads to "run queue":
        c1.start();
        c2.start();
        c3.start();

        //  Wait until other threads (c1, c2 and c3) finished:
        try {
            c1.join();
            c2.join();
            c3.join();
        } catch (InterruptedException e) {
            // Catch if Main thread is interrupted before c1, c2 and c3 finishes:
            System.out.println("Main thread was interrupted!");
        }

        // Output results of f1, f2 and f3 after all other threads (c1, c2 and c3) finished:
        printResults(c1.getResult(), c2.getResult(), c3.getResult());
    }

    private static void printResults(int c, int[][] matrix, int[] vector) {
        System.out.println("Results:");
        System.out.println("c = " + c);
        System.out.println("MF:");
        Arrays.stream(matrix).peek(row -> System.out.println(" " + Arrays.toString(row))).count();
        System.out.println("T:\n" + Arrays.toString(vector));
    }

    static class C1 extends Thread {

        private int size;
        private int result;

        public C1(int size) {
            this.size = size;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public int getResult() {
            return result;
        }

        public void setResult(int result) {
            this.result = result;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + ": was started.");
            result = MainFunctions.f1(size);
            System.out.println(Thread.currentThread().getName() + ": was finished.");
        }
    }

     static class C2 extends Thread {

        private int size;
        private int[][] result;

        public C2(int size) {
            this.size = size;
        }

         public int getSize() {
             return size;
         }

         public void setSize(int size) {
             this.size = size;
         }

         public int[][] getResult() {
             return result;
         }

         public void setResult(int[][] result) {
             this.result = result;
         }

         @Override
        public void run() {
             System.out.println(Thread.currentThread().getName() + ": was started.");
             result = MainFunctions.f2(size);
             System.out.println(Thread.currentThread().getName() + ": was finished.");
         }
    }

    static class C3 extends Thread {

        private int size;
        private int[] result;

        public C3(int size) {
            this.size = size;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public int[] getResult() {
            return result;
        }

        public void setResult(int[] result) {
            this.result = result;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + ": was started.");
            result = MainFunctions.f3(size);
            System.out.println(Thread.currentThread().getName() + ": was finished.");
        }
    }

}
