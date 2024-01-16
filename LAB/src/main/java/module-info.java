module org.example.lab {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.lab to javafx.fxml;
    exports org.example.lab;
}