import hexlet.code.Diff;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
public class DiffTest {
    public static final String FILE1_JSON_FILEPATH1 =
            "src/test/resources/JSONfiles/file1J.json";
    public static final String FILE2_JSON_FILEPATH2 =
            "src/test/resources/JSONfiles/file2J.json";
    public static final String FILE1_YAML_FILEPATH1 =
            "src/test/resources/YAMLfiles/file1Y.yaml";
    public static final String FILE2_YAML_FILEPATH2 =
            "src/test/resources/YAMLfiles/file2Y.yaml";
    private static final String DEFAULT_CORRECT_RESULT = """
            {
            - age: 18
            + faculty: computer science
            - internship: false
            + internship: true
              lastname: petrova
              name: sasha
            - student: true
            }""";

    @Test
        public void testRightComparison() throws Exception {
        String result = Diff.generate(FILE1_JSON_FILEPATH1, FILE2_JSON_FILEPATH2);
        assertThat(result).isEqualTo(DEFAULT_CORRECT_RESULT);
    }

    @Test
    public void testRightComparisonYAML() throws Exception {
        String result = Diff.generate(FILE1_YAML_FILEPATH1, FILE2_YAML_FILEPATH2);
        assertThat(result).isEqualTo(DEFAULT_CORRECT_RESULT);
    }
}
