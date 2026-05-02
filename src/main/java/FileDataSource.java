import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Lớp chịu trách nhiệm đọc dữ liệu số nguyên từ một tệp văn bản.
 * <p>
 * Trong phiên bản "legacy" ban đầu, chúng ta dùng chuỗi đường dẫn
 * và phụ thuộc vào ký tự phân cách của hệ điều hành.
 * </p>
 */
public class FileDataSource {

    private static final Logger logger = LoggerFactory.getLogger(FileDataSource.class);

    /**
     * Đọc các số nguyên từ tệp, mỗi dòng chứa một số.
     *
     * @param filePath đường dẫn tới tệp (phụ thuộc OS)
     * @return danh sách số nguyên
     * @throws IOException nếu xảy ra lỗi I/O
     */
    public List<Integer> readIntegers(String filePath) throws IOException {
        logger.info("Reading integers from file: {}", filePath);
        List<Integer> numbers = new ArrayList<>();
        List<String> lines = Files.readAllLines(Path.of(filePath));
        for (String line : lines) {
            line = line.strip();
            if (!line.isEmpty()) {
                numbers.add(Integer.parseInt(line));
            }
        }
        logger.debug("Read {} numbers", numbers.size());
        return numbers;
    }
}