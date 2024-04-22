package automationframework.support.helpers.extensions;

import automationframework.support.helper.extensions.CommandLineHelper;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CommandLineTest {

    @Test
    public void commandLineTest() throws IOException {
        String[] commands = {"java", "-version"};
        System.out.println(CommandLineHelper.execCmd(commands));
    }
}
