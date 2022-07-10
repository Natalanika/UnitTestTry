package learn.up;


import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ParameterizedTriangleTest {

    public static Stream<Arguments> triangles() {
        return Stream.of(Arguments.of(new Triangle(3, 4, 5), 12),
                Arguments.of(new Triangle(3, 4, 6), 13), Arguments.of(new Triangle(3, 3, 3), 9));
    }

    @ParameterizedTest(name = "Периметр треугольника {0} должен быть равен {1}")
    @MethodSource("triangles")
    @DisplayName("Периметр треугольника: позитивный сценарий")
    public void countPerimeterTriangleSuccessfulTest(Triangle triangle, int expectedPerimeter) {
        int perimeter = triangle.countPerimetr();
        assertEquals(expectedPerimeter, perimeter);
    }
    public static Stream<Arguments> invalidTriangles() {
        return Stream.of(Arguments.of(new Triangle(3, 3, 6), "Triangle is invalid: one side is greater than sum of others"),
                Arguments.of(new Triangle(3, 3, 9), "Triangle is invalid: one side is greater than sum of others"),
                Arguments.of(new Triangle(3, 9, 3), "Triangle is invalid: one side is greater than sum of others"),
                Arguments.of(new Triangle(-3, 3, 3), "Triangle is invalid: sides must be positive"),
                Arguments.of(new Triangle(3, -3, 9), "Triangle is invalid: sides must be positive"),
                Arguments.of(new Triangle(3, 3, -3), "Triangle is invalid: sides must be positive"),
                Arguments.of(new Triangle(3, 3, 0), "Triangle is invalid: sides must be positive"),
                Arguments.of(new Triangle(3, 0, 3), "Triangle is invalid: sides must be positive"),
                Arguments.of(new Triangle(0, 3, 3), "Triangle is invalid: sides must be positive"));
    }

    @ParameterizedTest(name = "Периметр треугольника {0} должен быть равен {1}")
    @MethodSource("invalidTriangles")
    @DisplayName("Периметр треугольника: негативные сценарии")
    public void countPerimeterInvalidTriangleErrorTest(Triangle triangle, String errorText) {
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> triangle.countPerimetr());
        assertEquals(errorText, illegalArgumentException.getMessage());
    }
    public static Stream<Arguments> areaTriangles() {
        return Stream.of(Arguments.of(new Triangle(3, 4, 5), 6.0),
                Arguments.of(new Triangle(3, 4, 6), 5.33), Arguments.of(new Triangle(3, 3, 3), 3.9));
    }

    @ParameterizedTest(name = "Площадь треугольника {0} должна быть равна {1}")
    @MethodSource("areaTriangles")
    @DisplayName("Площадь треугольника: позитивный сценарий")
    public void countAreaTriangleSuccessfulTest(Triangle triangle, double expectedArea) {
        double area = triangle.countArea();
        assertEquals(expectedArea, area);
    }
    public static Stream<Arguments> invalidAreaTriangles() {
        return Stream.of(Arguments.of(new Triangle(3, 3, 6), "Triangle is invalid: one side is greater than sum of others"),
                Arguments.of(new Triangle(3, 3, 9), "Triangle is invalid: one side is greater than sum of others"),
                Arguments.of(new Triangle(3, 9, 3), "Triangle is invalid: one side is greater than sum of others"),
                Arguments.of(new Triangle(-3, 3, 3), "Triangle is invalid: sides must be positive"),
                Arguments.of(new Triangle(3, -3, 9), "Triangle is invalid: sides must be positive"),
                Arguments.of(new Triangle(3, 3, -3), "Triangle is invalid: sides must be positive"),
                Arguments.of(new Triangle(3, 3, 0), "Triangle is invalid: sides must be positive"),
                Arguments.of(new Triangle(3, 0, 3), "Triangle is invalid: sides must be positive"),
                Arguments.of(new Triangle(0, 3, 3), "Triangle is invalid: sides must be positive"));
    }

    @ParameterizedTest(name = "Площадь треугольника {0} должен быть равен {1}")
    @MethodSource("invalidAreaTriangles")
    @DisplayName("Площадь треугольника: негативные сценарии")
    public void countAreaInvalidTriangleErrorTest(Triangle triangle, String errorText) {
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> triangle.countArea());
        assertEquals(errorText, illegalArgumentException.getMessage());
    }

@ParameterizedTest()
@CsvSource (value = {"BLUE, WHITE", "GREY, YELLOW", "YELLOW, BLUE"})
void paintTriangleTest (Colour colourBefore, Colour colourAfter) {
    Triangle triangle = new Triangle(3, 3, 3, colourBefore);
    triangle.paint(colourAfter);
    assertEquals(colourAfter, triangle.getColour());
}
@Nested
class CreateTriangleBeforeTest {
        Triangle triangle;
    @BeforeEach
    void setUp() {
        triangle = new Triangle(3, 3, 3);
    }
    @ParameterizedTest()
    @EnumSource(Colour.class)
    void paintTest (Colour colour) {
        Assumptions.assumeFalse(triangle.getColour().equals(colour));
        triangle.paint(colour);
        assertEquals(colour, triangle.getColour());
    }
    @ParameterizedTest()
    @ValueSource(strings = {"BLUE", "GREY", "YELLOW"})
    void paintStringTest (String colour) {
        triangle.paint(colour);
        assertEquals(colour, triangle.getColour().toString());
    }

}
}