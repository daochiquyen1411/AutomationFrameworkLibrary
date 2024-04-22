package automationframework.support.helper.extensions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CommandLineHelper {
    private static final String NEWLINE = System.getProperty("line.separator");

    public static String execCmd(String... command) throws IOException
    {
        ProcessBuilder pb = new ProcessBuilder(command).redirectErrorStream(true);
        Process process = pb.start();
        StringBuilder results = new StringBuilder(80);
        try (BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream())))
        {
            while (true)
            {
                String line = in.readLine();
                if (line == null)
                    break;
                results.append(line).append(NEWLINE);
            }
        }
        return results.toString();
    }
}
