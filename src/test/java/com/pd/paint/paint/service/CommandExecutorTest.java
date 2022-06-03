package com.pd.paint.paint.service;

import com.pd.paint.paint.commands.DrawRectangle;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author PraffulD
 */
public class CommandExecutorTest {

    @Test
    public void testGetInstance() {

        CommandExecutor commandExecutor = CommandExecutor.getInstance();
        Assert.assertNotNull(commandExecutor);
    }

    @Test
    public void testGetInstance_1() {

        CommandExecutor commandExecutor = CommandExecutor.getInstance();
        int res = commandExecutor.execute("c 10 10");

        Assert.assertNotNull(commandExecutor);
        Assert.assertEquals(0, res);
    }

    @Test
    public void testGetInstanceWrongCommand() {

        CommandExecutor commandExecutor = CommandExecutor.getInstance();
        int res = commandExecutor.execute("S 10 10");

        Assert.assertNotNull(commandExecutor);
        Assert.assertEquals(0, res);
    }

    @Test
    public void testGetInstanceNoCommand() {

        CommandExecutor commandExecutor = CommandExecutor.getInstance();
        int res = commandExecutor.execute("");

        Assert.assertNotNull(commandExecutor);
        Assert.assertEquals(0, res);
    }

    @Test
    public void testGetInstanceRegister() {

        CommandExecutor commandExecutor = CommandExecutor.getInstance();
        commandExecutor.register(DrawRectangle.class);
        int res = commandExecutor.execute("R 10 10");

        Assert.assertNotNull(commandExecutor);
        Assert.assertEquals(0, res);
    }
}
