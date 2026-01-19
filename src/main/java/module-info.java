module com.learn.oop {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.learn.oop to javafx.fxml;
    exports com.learn.oop;
}
