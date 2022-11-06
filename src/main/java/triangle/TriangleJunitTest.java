package triangle;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static triangle.TrianglesAreaForTest.triangleArea;

class TriangleTest {
    @Test
    void FirstTriangleTest() throws Exception {
        Assertions.assertEquals(0.9682,triangleArea(1,2,2),0.001);
    }

    @Test
    void NegativeTriangleTest() {
        Assertions.assertThrows(Exception.class, () -> triangleArea(-1,2,2));
    }
}
