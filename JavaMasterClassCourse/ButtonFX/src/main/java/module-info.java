module com.example.buttonfx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.buttonfx to javafx.fxml;
    exports com.example.buttonfx;
}