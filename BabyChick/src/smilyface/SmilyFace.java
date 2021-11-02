package babychick;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Ellipse;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.geometry.Insets;


public class Babychick extends Application {

    @Override

    public void start(Stage primaryStage) {

        // Create a stack pane
        StackPane stackPane = new StackPane();
        StackPane stackPane2 = new StackPane();

// Crate a pane
        Pane pane = new Pane();
        stackPane2.setPadding(new Insets(40, 40, 40, 40));

// Create a circle and place it in a stack pane
        Circle circle = getCircle();
        stackPane.getChildren().add(circle);

// Create two ellipse
        Ellipse ellipse1 = getEllipse(circle);
        ellipse1.setCenterX(circle.getRadius() - circle.getRadius() / 2);
        Ellipse ellipse2 = getEllipse(circle);
        ellipse2.setCenterX(circle.getRadius() + circle.getRadius() / 2);

// Create two circles
        Circle circle2 = getCircle(ellipse1);
        Circle circle3 = getCircle(ellipse2);

// Create an Arc
        Arc arc = beak(circle);// اضفت المنقار الاول
        Arc eyebrow = beak2(circle);// اضفت المنقار الثاني
        Arc eyebrow1 = nose(circle);// اضفت الانف
        Arc eyebrow2 = hair(circle);// اضفت الشعرة


// Place nodes in a pane
        pane.getChildren().addAll(stackPane, ellipse1,
                ellipse2, circle2, circle3, arc, eyebrow, eyebrow1,eyebrow2);

// Place pane in a stack pane
        stackPane2.getChildren().add(pane);

// Create a scene and place it in the stage
        Scene scene = new Scene(stackPane2);
        // Set the stage title
        primaryStage.setTitle("Smily Face");
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }

    /**
     * Return a Arc of specified properties
     */
    private Arc beak(Circle c) {// ميثود عشان المنقار بدال الفم
        Arc a = new Arc(c.getRadius(), c.getRadius() * 1.30,
                c.getRadius() / 2, c.getRadius() / 4, 0, -180);
        a.setType(ArcType.OPEN);
        a.setFill(Color.RED);// غيرت اللون
        a.setStroke(Color.BLACK);
        return a;
    }// انتهى الجزء السفلي من المنقار

    private Arc beak2(Circle c) {
        Arc a = new Arc(c.getRadius(), c.getRadius() * 1.30,
                c.getRadius() / 2, c.getRadius() / 4, 0, 180);
        a.setType(ArcType.CHORD);// نوع مختلف من ال Arc 
        a.setFill(Color.RED);// غيرت اللون
        a.setStroke(Color.BLACK);
        return a;
    }// انتهى الجزء السفلي من المنقار
// شلت ميثود المضلع

    private Arc nose(Circle c) {
        Arc a = new Arc(c.getRadius(), c.getRadius() * 0.75,
                c.getRadius() / 4, c.getRadius() / 8, 100, 180);// غيرت الزاوية والحجم والاحداثيات عشان موقع الانف وشكله
        a.setType(ArcType.OPEN);
        a.setFill(Color.YELLOW);
        a.setStroke(Color.BLACK);
        return a;
    }

    private Arc hair(Circle c) {
        Arc a = new Arc(c.getRadius(), c.getRadius() * 0.1,
                c.getRadius() / 4, c.getRadius() / 8, 140, -200);// غيرت الزاوية والحجم والاحداثيات لانه شعرة
        a.setType(ArcType.OPEN);
        a.setFill(Color.YELLOW);
        a.setStroke(Color.BLACK);
        return a;
    }

    /**
     * Return a circle of specified properties
     */
    private Circle getCircle(Ellipse e) {
        Circle c = new Circle(e.getCenterX(), e.getCenterY(),
                e.getRadiusY() - (e.getRadiusX() - e.getRadiusY()));
        return c;
    }

    /**
     * Return an Ellipse of specified properties
     */
    private Ellipse getEllipse(Circle c) {
        Ellipse e = new Ellipse();
        e.setCenterY(c.getRadius() - c.getRadius() / 3);
        e.setRadiusX(c.getRadius() / 4);
        e.setRadiusY(c.getRadius() / 3 - 20);
        e.setStroke(Color.BLACK);
        e.setFill(Color.WHITE);
        return e;
    }



    /**
     * Returns a circle of specified properties
     */
    private Circle getCircle() {
        Circle c = new Circle();
        c.setRadius(150);
        c.setStroke(Color.BLACK);
        c.setFill(Color.YELLOW);
        return c;
    }

    public static void main(String[] args) {
        launch(args);
    }

}
