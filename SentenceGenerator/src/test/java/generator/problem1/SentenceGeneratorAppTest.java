package generator.problem1;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SentenceGeneratorAppTest {

  private String[] config;
  private String[] configNull;
  private String[] configNoneExist;

  @BeforeEach
  void setUp() {
    config = new String[]{"Grammar"};
    configNoneExist = new String[]{"none exist"};

    configNull = new String[]{};
  }

  @Test
  void main() throws IOException {
    InputStream in = System.in;
    System.setIn(new ByteArrayInputStream("q\n".getBytes()));
    generator.problem1.SentenceGeneratorApp.main(config);
    System.setIn(in);
  }

  @Test
  void testValidateArgument() throws IOException {
    assertThrows(RuntimeException.class, () -> {
      generator.problem1.SentenceGeneratorApp.main(configNull);
    });
    assertThrows(RuntimeException.class, () -> {
      SentenceGeneratorApp.main(configNoneExist);
    });


  }
}