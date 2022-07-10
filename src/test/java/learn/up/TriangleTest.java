package learn.up;


import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.junit.jupiter.api.Assertions.*;

@Disabled("Перенесены в параметризированные тесты")
public class TriangleTest
{
    @Test
    @DisplayName("Периметр египетского треугольника")
    @Disabled("Перенесены в параметризированный тест")
    public void countPerimeterEgyptTriangleTest()
    {
        Triangle triangle = new Triangle(3, 4, 5);
        int perimeter = triangle.countPerimetr();
        assertEquals(12, perimeter);
    }
    @Test
    @DisplayName("Периметр тупоугольного треугольника")
    @Disabled ("Перенесены в параметризированный тест")
    public void countPerimeterTriangleWithAngleGreaterThan90Test()
    {
        Triangle triangle = new Triangle(3, 4, 6);
        int perimeter = triangle.countPerimetr();
        assertEquals(13, perimeter);
    }
    @Test
    @DisplayName("Периметр правильного треугольника")
    @Disabled ("Перенесены в параметризированный тест")
    public void countPerimeterRightTriangTest()
    {
        Triangle triangle = new Triangle(3, 3, 3);
        int perimeter = triangle.countPerimetr();
        assertEquals(9, perimeter);
    }
    @Test
    @DisplayName("Периметр невалидного треугольника со стороной, большей, чем сумма двух других сторон")
    public void countPerimeterInvalidTriangWithSideEqualsSumOthersTest()
    {
        Triangle triangle = new Triangle(3, 3, 6);
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> triangle.countPerimetr());
        assertEquals("Triangle is invalid: one side is greater than sum of others", illegalArgumentException.getMessage());
    }
    @Test
    @DisplayName("Периметр невалидного треугольника со стороной, большей, чем сумма двух других сторон")
    public void countPerimeterInvalidTriangWithSideGreaterSumOthersTest()
    {
        Triangle triangle = new Triangle(3, 3, 9);
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> triangle.countPerimetr());
        assertEquals("Triangle is invalid: one side is greater than sum of others", illegalArgumentException.getMessage());
    }
    @Test
    @DisplayName("Периметр невалидного треугольника: отрицательная сторона")
    public void countPerimeterInvalidTriangWithNegativeASideTest()
    {
        Triangle triangle = new Triangle(-3, 3, 3);
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> triangle.countPerimetr());
        assertEquals("Triangle is invalid: sides must be positive", illegalArgumentException.getMessage());
    }
    @Test
    @DisplayName("Периметр невалидного треугольника: отрицательная сторона")
    public void countPerimeterInvalidTriangWithNegativeBSideTest()
    {
        Triangle triangle = new Triangle(3, -3, 3);
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> triangle.countPerimetr());
        assertEquals("Triangle is invalid: sides must be positive", illegalArgumentException.getMessage());
    }
    @Test
    @DisplayName("Периметр невалидного треугольника: отрицательная сторона")
    public void countPerimeterInvalidTriangWithNegativeCSideTest()
    {
        Triangle triangle = new Triangle(3, 3, -3);
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> triangle.countPerimetr());
        assertEquals("Triangle is invalid: sides must be positive", illegalArgumentException.getMessage());
    }
    @Test
    @DisplayName("Периметр невалидного треугольника: нулевая сторона")
    public void countPerimeterInvalidTriangWithZeroASideTest()
    {
        Triangle triangle = new Triangle(0, 3, 3);
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> triangle.countPerimetr());
        assertEquals("Triangle is invalid: sides must be positive", illegalArgumentException.getMessage());
    }
    @Test
    @DisplayName("Периметр невалидного треугольника: нулевая сторона")
    public void countPerimeterInvalidTriangWithZeroBSideTest()
    {
        Triangle triangle = new Triangle(3, 0, 3);
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> triangle.countPerimetr());
        assertEquals("Triangle is invalid: sides must be positive", illegalArgumentException.getMessage());
    }
    @Test
    @DisplayName("Периметр невалидного треугольника: нулевая сторона")
    public void countPerimeterInvalidTriangWithZeroCSideTest()
    {
        Triangle triangle = new Triangle(3, 3, 0);
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> triangle.countPerimetr());
        assertEquals("Triangle is invalid: sides must be positive", illegalArgumentException.getMessage());
    }

}
