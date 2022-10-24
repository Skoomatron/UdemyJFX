module com.example.udemyjfx {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.udemyjfx to javafx.fxml;
    exports com.example.udemyjfx;
}