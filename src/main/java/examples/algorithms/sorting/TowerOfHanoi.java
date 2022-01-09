package examples.algorithms.sorting;

public class TowerOfHanoi {

    public static void main(String[] args) {
        move(4, 'A', 'C', 'B');
    }

    public static void move(int n, char from, char to, char inter) {
        if (n==1) {
            System.out.printf("Move disk %d from %c to %c%n", n, from, to);
        } else {
            move(n-1, from, inter, to); // move disks from 1 to n-1 from FROM to INTER stack
            System.out.printf("Move disk %d from %c to %c%n", n, from, to);
            move(n-1, inter, to, from); // move disks from 1 to n-1 from INTER to TO stack
        }
    }
}
