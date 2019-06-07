import java.util.ArrayList;
import java.util.Scanner;

public class MeasuringProblemDifficulty {
    private static class Checker implements Runnable {
        final private int[][] permutations;
        final private int a, b;
        final private int problems;
        final private int distance;

        public boolean doesRepeat = false;
        public boolean finished = false;

        public Checker(int[][] permutations, int a, int b) {
            this.permutations = permutations;
            this.a = a;
            this.b = b;
            this.distance = b - a;
            this.problems = permutations[0].length;
        }

        public void run() {
            final int valA = permutations[0][a];
            final int valB = permutations[0][b];


            for (int member = 1; member < 3; member++) {
                boolean repeatsInPermutation = false;
                int tmpA = 0;
                int tmpB = distance;
                while (tmpB < problems) {
                    if (permutations[member][tmpA] == valA && permutations[member][tmpB] == valB) {
                        repeatsInPermutation = true;
                        break;
                    }
                    ++tmpB;
                    ++tmpA;
                }
                if (!repeatsInPermutation) {
                    synchronize(false);
                    return;
                }
            }
            synchronize(true);
            return;
        }

        private void synchronize(boolean repeats) {
            synchronized(this) {
                doesRepeat = repeats;
                finished = true;
                this.notifyAll();
            }
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int problms = 0;
        while ((problms = scan.nextInt()) != 0) {
            final int[][] permutations = new int[3][problms];
            for (int member = 0; member < 3; member++) {
                for (int index = 0; index < problms; index++) {
                    permutations[member][index] = scan.nextInt();
                }
            }
            final long pairs = repeatedPairs(permutations, problms);
            System.out.println(pairs);
        }
        scan.close();
    }

    private static long repeatedPairs(final int[][] permutations, final int problems) {
        final int maxThreads = (problems*(problems-1))/2;        
        long pairs = 0;

        ArrayList<Checker> checkersList = new ArrayList<Checker>(maxThreads);
        for (int a = 0; a < problems - 1; a++) {
            for (int b = a + 1; b < problems; b++ ) {
                Checker checker = new Checker(permutations, a, b);
                Thread thread = new Thread(checker);
                thread.start();
                checkersList.add(checker);
            }
        }
        
        for (int index = 0; index < checkersList.size(); index++) {
            Checker checker = checkersList.get(index);
            while (!checker.finished) {
                try {
                    synchronized(checker) {
                        checker.wait();
                    }
                } catch (InterruptedException ie) {
                    ie.printStackTrace();
                    return pairs;
                }
            }

            boolean isRepeated = checker.doesRepeat;
            if (isRepeated) {
                ++pairs;
            }
        }
        return pairs;
    }
}