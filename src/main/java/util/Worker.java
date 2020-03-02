package util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Worker {

    private InputStream in;

    private OutputStream out;

    private Worker() {
    }

    public Worker(String in, String out) throws FileNotFoundException {
        this.in = new FileInputStream(in);
        this.out = new FileOutputStream(out);
    }

    public List<List<Object>> getFile() {
        List<List<Object>> file = new ArrayList<>(new ArrayList<>());
        Scanner sc = new Scanner(in);
        int i = 0;
        while (sc.hasNext()) {
            file.add(new ArrayList<>());
            String str = sc.nextLine();
            if (!str.isEmpty()) {
                Scanner tmp = new Scanner(str);
                while (tmp.hasNext()) {
                    String qwe = tmp.next();
                    try {
                        file.get(i).add(Double.parseDouble(qwe));
                    } catch (Exception e) {
                        file.get(i).add(qwe);
                    }
                }
                tmp.close();
            } else {
                file.get(i).add("");
            }
            i++;
        }
        sc.close();
        return file;
    }

    public void printAnswer(List<List<Object>> lists) {
        String nextLine = "";
        String nextElem = "";
        PrintStream printStream = new PrintStream(out);
        for (List<Object> row : lists) {
            printStream.print(nextLine);
            nextLine = "\n";
            nextElem = "";
            for (Object it : row) {
                if (it instanceof Double && (Double) it - ((Double) it).longValue() == 0) {
                    it = ((Double) it).longValue();
                }
                printStream.print(nextElem + it);
                nextElem = " ";
            }
        }
    }

    public void start() {
        List<List<Object>> file = getFile();
        file.sort(new Sorting());
        printAnswer(file);
    }
}
