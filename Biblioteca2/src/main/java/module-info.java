module co.edu.uniquindio.poo.biblioteca2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens co.edu.uniquindio.poo.biblioteca2 to javafx.fxml;
    exports co.edu.uniquindio.poo.biblioteca2;
}