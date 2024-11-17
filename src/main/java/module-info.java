module lk.ijse.Bookshop {
    requires javafx.controls;

    requires javafx.fxml;

    requires org.kordamp.ikonli.javafx;
    requires com.jfoenix;
    requires static lombok;
    requires java.sql;
    requires net.sf.jasperreports.core;
    requires java.desktop;

    opens lk.ijse.Bookshop.dto.tm to javafx.base;
    opens lk.ijse.Bookshop.controller to javafx.fxml;
    exports lk.ijse.Bookshop;
    opens view to javafx.fxml;
}