module com.app.magicsquarejava {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.app.magicsquarejava to javafx.fxml;
    exports com.app.magicsquarejava;
}