package quyendc.helper.extensions;

import org.junit.Test;
import java.io.IOException;

public class CommandLineTest {

    @Test
    public void commandLineTest() throws IOException {
        String[] commands = {"java"};
        System.out.println(CommandLineHelper.execCmd(commands));
    }
}
