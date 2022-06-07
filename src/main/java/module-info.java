module com.wadaaaa.matri.matrix {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires javafx.swing;


    opens com.wadaaaa.matri.matrix to javafx.fxml;
    exports com.wadaaaa.matri.matrix;
}