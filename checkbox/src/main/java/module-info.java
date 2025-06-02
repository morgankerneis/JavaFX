module afpa.checkbox {
    requires javafx.controls;
    requires transitive javafx.graphics;
    requires javafx.fxml;

    opens afpa.checkbox to javafx.fxml;

    exports afpa.checkbox;
}
