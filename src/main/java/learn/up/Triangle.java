package learn.up;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Triangle {
    private int a;
    private int b;
    private int c;
    private Colour colour;

    public Triangle(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
        colour = Colour.WHITE;
    }

    private void checkSidesArePositive() {
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new IllegalArgumentException("Triangle is invalid: sides must be positive");
        }
    }

    private void checkValidTriangle() {
        if (a >= b + c || b >= a + c || c >= a + b) {
            throw new IllegalArgumentException("Triangle is invalid: one side is greater than sum of others");
        }
    }

    public int countPerimetr() {
        checkSidesArePositive();
        checkValidTriangle();
        return a + b + c;
    }

    public double countArea() {
        checkSidesArePositive();
        checkValidTriangle();
        double pp = (a + b + c) / 2.0;
        return Math.round(Math.sqrt(pp * (pp - a) * (pp - b) * (pp - c))*100)/100.00;
    }

    public void paint(Colour colour) {
        if (this.colour == colour) {
            throw new IllegalArgumentException("New colour must not be equal to old colour");
        }
        this.colour = colour;
    }

    public void paint(String colour) {
        paint(Colour.valueOf(colour));
    }
    public Triangle createSimilarTreangle (int coef) {
        return new Triangle(a*coef, b*coef, c*coef);
    }

    public static void main(String[] args) {
        Triangle triangle = new Triangle(3, 3, 3);
        System.out.println(triangle.countArea());
    }
}