package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;


@Command(name = "gendiff", mixinStandardHelpOptions = true,
        description = "Compares two configuration files and shows a difference.")

class App {

    @Parameters(index = "0", paramLabel = "filepath1", description = "path to first file")
    String filepath1;

    @Parameters(index = "1", paramLabel = "filepath2", description = "path to second file")
    String filepath2;

    @Option(names = {"-f", "--format"}, paramLabel = "format", description = "output format [default: stylish]")
    private String format;

    public static void main(String... args) throws Exception {
        BasicFiles.createFiles();

       // int exitCode = new CommandLine(new App()).execute(args);
      //  System.exit(exitCode);
    }
}

