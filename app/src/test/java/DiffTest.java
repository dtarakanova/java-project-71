import hexlet.code.Diff;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DiffTest {
    public static final String FILE1_JSON_FILEPATH1 =
            "src/test/resources/JSONfiles/file1J.json";
    public static final String FILE2_JSON_FILEPATH2 =
            "src/test/resources/JSONfiles/file2J.json";
    public static final String FILE1_YAML_FILEPATH1 =
            "src/test/resources/YAMLfiles/file1Y.yaml";
    public static final String FILE2_YAML_FILEPATH2 =
            "src/test/resources/YAMLfiles/file2Y.yaml";

    public static final String JSON_CORRECT_RESULT_LINK =
            "src/test/resources/jsonFormatExpected.json";

    private static final String DEFAULT_CORRECT_RESULT = """
            {
                chars1: [a, b, c]
              - chars2: [d, e, f]
              + chars2: false
              - checked: false
              + checked: true
              - default: null
              + default: [value1, value2]
              - id: 45
              + id: null
              - key1: value1
              + key2: value2
                numbers1: [1, 2, 3, 4]
              - numbers2: [2, 3, 4, 5]
              + numbers2: [22, 33, 44, 55]
              - numbers3: [3, 4, 5]
              + numbers4: [4, 5, 6]
              + obj1: {nestedKey=value, isNested=true}
              - setting1: Some value
              + setting1: Another value
              - setting2: 200
              + setting2: 300
              - setting3: true
              + setting3: none
            }""";

    private static final String PLAIN_CORRECT_RESULT = """
            Property 'chars2' was updated. From [complex value] to false
            Property 'checked' was updated. From false to true
            Property 'default' was updated. From null to [complex value]
            Property 'id' was updated. From 45 to null
            Property 'key1' was removed
            Property 'key2' was added with value: 'value2'
            Property 'numbers2' was updated. From [complex value] to [complex value]
            Property 'numbers3' was removed
            Property 'numbers4' was added with value: [complex value]
            Property 'obj1' was added with value: [complex value]
            Property 'setting1' was updated. From 'Some value' to 'Another value'
            Property 'setting2' was updated. From 200 to 300
            Property 'setting3' was updated. From true to 'none'
            """;


    @Test
        public void testRightComparisonJSON() throws Exception {
        String result = Diff.generate(FILE1_JSON_FILEPATH1, FILE2_JSON_FILEPATH2);
        assertThat(result).isEqualTo(DEFAULT_CORRECT_RESULT);
    }

    @Test
    public void testRightComparisonYAML() throws Exception {
        String result = Diff.generate(FILE1_YAML_FILEPATH1, FILE2_YAML_FILEPATH2);
        assertThat(result).isEqualTo(DEFAULT_CORRECT_RESULT);
    }

    @Test
    public void testRightComparisonPlainJSON() throws Exception {
        String result = Diff.generate(FILE1_JSON_FILEPATH1, FILE2_JSON_FILEPATH2, "plain");
        assertThat(result).isEqualTo(PLAIN_CORRECT_RESULT);
    }

    @Test
    public void testRightComparisonPlainYAML() throws Exception {
        String result = Diff.generate(FILE1_YAML_FILEPATH1, FILE2_YAML_FILEPATH2, "plain");
        assertThat(result).isEqualTo(PLAIN_CORRECT_RESULT);
    }

    @Test
    public void testRightComparisonFormatJSON() throws Exception {
        Path expectedPath = Paths.get(JSON_CORRECT_RESULT_LINK);
        var expected = Files.readString(expectedPath);
        var actual = Diff.generate(FILE1_YAML_FILEPATH1, FILE2_YAML_FILEPATH2, "json");
        assertEquals(expected, actual);
    }
}
