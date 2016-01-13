package java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class Task extends RecursiveAction {
    private final List<Student> ss;
    private double result;

    Task(List<Student> ss) {
        this.ss = ss;
    }

    Task rightHalf() {
        return new Task(ss.subList(ss.size() / 2, ss.size()));
    }

    Task leftHalf() {
        return new Task(ss.subList(0, ss.size() / 2));
    }

    double computeSynchronously() {
        double max = Double.MIN_VALUE;
        for (Student s : ss) {
            if (s.score > max) max = s.score;
        }
        return max;
    }
    static final int SEQUENTIAL_THRESHOLD = 1 << 14;

    @Override
    protected void compute() {
        if (ss.size() < SEQUENTIAL_THRESHOLD) {
            result = computeSynchronously();
        } else {
            Task left = leftHalf();
            Task right = rightHalf();
            invokeAll(left, right);
            result = Math.max(left.result, right.result);
        }
    }

    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();

        List<Student> ss = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 100000000; i++) {
            ss.add(new Student("A", 1990 + random.nextInt(20), random.nextInt(100)));
        }
        Task task = new Task(ss);

        long start2 = System.currentTimeMillis();
        task.result = task.computeSynchronously();
        System.out.println("(Synchronous)Task result: " + task.result);
        System.out.printf("duration: %d ms\n", (System.currentTimeMillis() - start2));

        long start1 = System.currentTimeMillis();
        pool.invoke(task);
        System.out.println("(Concurrent)Task result: " + task.result);
        System.out.printf("duration: %d ms\n", (System.currentTimeMillis() - start1));

    }


    static class Student {
        String name;
        int gradYear;
        double score;

        Student(String name, int gradYear, double score) {
            this.name = name;
            this.gradYear = gradYear;
            this.score = score;
        }
    }
}
