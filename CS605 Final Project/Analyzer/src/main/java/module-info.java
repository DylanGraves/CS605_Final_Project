module query.analyzer {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;

    opens query.analyzer to javafx.fxml;
    exports query.analyzer;
}