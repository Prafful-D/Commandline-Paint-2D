package com.pd.paint;

import com.pd.paint.paint.commands.DrawRectangle;
import com.pd.paint.paint.commands.BucketFill;
import com.pd.paint.paint.service.CommandExecutor;

import java.util.Scanner;

/**
 * @author PraffulD
 */
public class Application {

    public static void main(String[] args) {

        System.out.println("Starting Console Paint Program...");

        CommandExecutor executor = CommandExecutor.getInstance();
        executor.register(DrawRectangle.class);
        executor.register(BucketFill.class);

        sampleExecution(executor);
        int result = 0;
        while (result == 0) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Type command to execute : ");

            String command = scanner.nextLine();

            result = executor.execute(command);
        }
    }

    private static void sampleExecution(CommandExecutor executor) {
        executor.execute("C 20 4");
        executor.execute("L 1 2 6 2");
        executor.execute("L 6 3 6 4");
        executor.execute("R 14 1 18 3");
        executor.execute("B 10 3 o");
    }
}
