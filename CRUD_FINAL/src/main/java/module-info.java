module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires com.almasb.fxgl.all;
    requires java.management;
    requires java.desktop;
    requires jakarta.persistence;
    requires org.hibernate.orm.core;
    requires javafx.base;
    requires javafx.graphics;
    requires com.example.demo;

    opens com.example.demo to javafx.fxml;
    opens controller to javafx.fxml;
    exports com.example.demo;
    exports controller;
}