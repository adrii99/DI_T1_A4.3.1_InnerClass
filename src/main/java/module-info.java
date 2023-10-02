module es.ieslosmontecillos.es.innerclass {
    requires javafx.controls;
    requires javafx.fxml;


    opens es.ieslosmontecillos.es to javafx.fxml;
    exports es.ieslosmontecillos.es;
}