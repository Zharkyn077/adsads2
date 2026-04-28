import java.util.*;

public class Main {

    public static void anagramChecker(Scanner sc) {
        String s1 = sc.next();
        String s2 = sc.next();

        char[] a = s1.toCharArray();
        char[] b = s2.toCharArray();

        Arrays.sort(a);
        Arrays.sort(b);

        if (Arrays.equals(a, b)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    public static void kthSmallest(Scanner sc) {
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int k = sc.nextInt();

        Arrays.sort(arr);
        System.out.println(arr[k - 1]);
    }

    public static void medianElement(Scanner sc) {
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        System.out.println(arr[n / 2]);
    }

    public static boolean canShip(int[] weights, int days, int capacity) {
        int current = 0;
        int neededDays = 1;

        for (int i = 0; i < weights.length; i++) {
            if (current + weights[i] > capacity) {
                neededDays++;
                current = 0;
            }

            current += weights[i];
        }

        return neededDays <= days;
    }

    public static int shipWithinDays(int[] weights, int days) {
        int left = 0;
        int right = 0;

        for (int i = 0; i < weights.length; i++) {
            if (weights[i] > left) {
                left = weights[i];
            }

            right += weights[i];
        }

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (canShip(weights, days, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    public static void shippingTask(Scanner sc) {
        int n = sc.nextInt();
        int[] weights = new int[n];

        for (int i = 0; i < n; i++) {
            weights[i] = sc.nextInt();
        }

        int days = sc.nextInt();

        System.out.println(shipWithinDays(weights, days));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int task = sc.nextInt();

        switch (task) {
            case 1:
                anagramChecker(sc);
                break;
            case 2:
                kthSmallest(sc);
                break;
            case 3:
                medianElement(sc);
                break;
            case 4:
                shippingTask(sc);
                break;
        }

        sc.close();
    }
}
