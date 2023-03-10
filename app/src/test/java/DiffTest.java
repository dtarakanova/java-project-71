import hexlet.code.Diff;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DiffTest {
    public static final String FILE1_JSON_FILEPATH1 =
            "/home/pelmen/java-project-71/app/src/test/resources/JSONfiles/file1J.json";
    public static final String FILE2_JSON_FILEPATH2 =
            "/home/pelmen/java-project-71/app/src/test/resources/JSONfiles/file2J.json";

    public static final String EMPTYFILE_JSON_PATH =
            "/home/pelmen/java-project-71/app/src/test/resources/JSONfiles/emptyfile.json";
    private static final String DEFAULT_CORRECT_RESULT = "{\n"
            + "- age : 18"
            + "+ faculty : computer science"
            + "- internship : false"
            + "+ internship : true"
            + "  lastname: petrova"
            + "  name: sasha"
            + "- student : true"
            + "}";
    private static final String EMPTY_FILE_COMPARISON_RESULT = "{\n"
            + "+ age : 18"
            + "+ internship : false"
            + "+ lastname: petrova"
            + "+ name: sasha"
            + "+ student : true"
            + "}";


    @Test
        public void testRightComparison() throws Exception {
        String result = Diff.generate(FILE1_JSON_FILEPATH1, FILE2_JSON_FILEPATH2);
        assertEquals(result, DEFAULT_CORRECT_RESULT);
    }

    @Test
        public void emptyFile() throws Exception {
        String result = Diff.generate(FILE1_JSON_FILEPATH1, EMPTYFILE_JSON_PATH);
        assertEquals(result, EMPTY_FILE_COMPARISON_RESULT);
    }
}
