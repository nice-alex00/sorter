package main;

import util.Worker;

public class Main {
    public static void main(String[] args) {
        try {
            Worker worker = new Worker("in.txt", "out.txt");
            worker.start();
        } catch (Exception e) {
            System.out.println("Check input file");
        }
    }
}
