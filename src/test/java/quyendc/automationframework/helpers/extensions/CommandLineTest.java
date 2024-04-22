package quyendc.automationframework.helpers.extensions;

import org.quyendc.automationframework.helper.extensions.CommandLineHelper;
import java.io.IOException;

public class CommandLineTest {

    public static void main(String[] args) throws IOException {
        String[] commands = {"java", "-version"};
        System.out.println(CommandLineHelper.execCmd(commands));
    }
}
