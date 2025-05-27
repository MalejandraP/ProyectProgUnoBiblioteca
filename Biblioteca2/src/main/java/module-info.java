module co.edu.uniquindio.poo.biblioteca2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;

    opens co.edu.uniquindio.poo.biblioteca2.viewController to javafx.fxml;
    opens co.edu.uniquindio.poo.biblioteca2.model to javafx.base;

    exports co.edu.uniquindio.poo.biblioteca2.model;
    exports co.edu.uniquindio.poo.biblioteca2.viewController;
    exports co.edu.uniquindio.poo.biblioteca2;
}
