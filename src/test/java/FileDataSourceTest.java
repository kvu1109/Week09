import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

public class FileDataSourceTest {

    FileDataSource dataSource = new FileDataSource();

    @Test
    void testReadNumbersFromTempFile(@TempDir Path tempDir) throws IOException {
        // Tạo file test trong thư mục tạm – tương thích mọi OS
        Path testFile = tempDir.resolve("numbers.txt");
        Files.writeString(testFile, "10\n20\n30\n");

        List<Integer> numbers = dataSource.readIntegers(testFile.toString());

        assertEquals(List.of(10, 20, 30), numbers);
    }
}