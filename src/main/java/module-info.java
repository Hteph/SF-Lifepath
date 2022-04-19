module com.github.drhteph.sflifepath {
    requires javafx.controls;
    requires javafx.fxml;
    
    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires lombok;
    requires VNameGenerator;
    requires org.slf4j;
    
    opens com.github.drhteph.sflifepath to javafx.fxml;
    exports com.github.drhteph.sflifepath;
}