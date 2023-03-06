module com.example.cw_fx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.example.cw_fx to javafx.fxml;
    exports com.example.cw_fx;
}