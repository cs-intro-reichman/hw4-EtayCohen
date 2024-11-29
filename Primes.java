public class Primes {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);

        int arrSize = n + 1;
        boolean[] arr = new boolean[arrSize];

        for (int i = 2; i < arrSize; i++) {
            arr[i] = true;
        }

        for (int i = 2; i < Math.sqrt(n); i++) {
            if (arr[i]) {
                for (int j = 1; i + i * j <= n; j++) {
                    arr[i + i * j] = false;
                }
            }
        }

        System.out.println("Prime numbers up to " + n + ":");

        int primesCount = 0;

        for (int i = 0; i < arrSize; i++) {
            if (arr[i] == true) {
                System.out.println(i);
                primesCount++;
            }
        }

        int primePercentage = (int) ((primesCount * 100.0) / n);

        String formattedResult = String.format(
                "There are %d primes between 2 and %d (%d%% are primes) ",
                primesCount, n, primePercentage);

        System.out.println(formattedResult);
    }
}