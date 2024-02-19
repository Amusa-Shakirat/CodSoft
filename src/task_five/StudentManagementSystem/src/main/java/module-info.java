module com.bajidan.managementsystem {
    requires javafx.controls;
    requires javafx.fxml;
            
            requires com.dlsc.formsfx;
            requires net.synedra.validatorfx;
                requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    opens com.codsoft.managementsystem to javafx.fxml;

    //opens com.bajidan.managementsystem.veiw;
    opens com.codsoft.managementsystem.controller;

    exports com.codsoft.managementsystem;
    exports com.codsoft.managementsystem.controller;
}