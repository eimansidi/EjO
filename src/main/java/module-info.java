module com.eiman.ejo {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.eiman.ejo to javafx.fxml;
    exports com.eiman.ejo;
}