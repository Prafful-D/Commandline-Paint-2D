package com.cs.test.paint.service;

import com.cs.test.paint.Canvas;
import com.cs.test.paint.commands.Command;
import com.cs.test.paint.commands.CreateCanvas;
import com.cs.test.paint.commands.DrawLine;
import com.cs.test.paint.commands.Paint;
import com.cs.test.paint.commands.Quit;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author PraffulD
 */
public class CommandExecutor {

    private static CommandExecutor instance;

    private static Canvas canvas;

    private static Map<String, Command<? extends Paint>> commandMap = null;

    private CommandExecutor() {
        canvas = new Canvas();
        Command[] DEFAULT = new Command[]
                {new CreateCanvas(canvas), new DrawLine(canvas), new Quit(canvas)};
        commandMap = new HashMap<>();
        registerServices(DEFAULT);
    }

    public static final CommandExecutor getInstance() {
        if (instance == null) {
            instance = new CommandExecutor();
        }
        return instance;
    }

    public int execute(String input) {

        if (input != null && input.trim().length() > 0) {
            String[] arg = input.split(" ");
            String commandStr = arg[0];

            Command command = commandMap.get(commandStr.toUpperCase());
            if (command == null) {
                System.out.println("Invalid Command, Try again");
                return 0;
            }
            return command.executeCommand(Arrays.copyOfRange(arg, 1, arg.length));
        } else {
            System.out.println("No Command Entered, Try again");
            return 0;
        }
    }

    private static void registerServices(Command... services) {
        for (Command service : services) {
            commandMap.put(service.serviceCommand(), service);
        }
    }

    public void register(Class<? extends Paint> clazz) {

        Command service = null;
        try {
            Constructor<? extends Command> constructor = clazz.getConstructor(Canvas.class);
            service = constructor.newInstance(new Object[]{canvas});
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException |
                 InvocationTargetException e) {
            System.out.println("Not able to register given command");
            System.exit(-1);
        }

        // commandMap.get(service.serviceCommand())
        commandMap.put(service.serviceCommand(), service);
    }
}