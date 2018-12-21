package sample;

import javafx.beans.property.SimpleStringProperty;

public class GamosTableData {
    SimpleStringProperty id;
    private final SimpleStringProperty field2,field3,field4,field6,field7,field8,field11,field12,field23,field31;

    public GamosTableData(SimpleStringProperty id, SimpleStringProperty field2, SimpleStringProperty field3, SimpleStringProperty field4, SimpleStringProperty field6, SimpleStringProperty field7, SimpleStringProperty field8, SimpleStringProperty field11, SimpleStringProperty field12, SimpleStringProperty field23, SimpleStringProperty field31) {
        this.id = id;
        this.field2 = field2;
        this.field3 = field3;
        this.field4 = field4;
        this.field6 = field6;
        this.field7 = field7;
        this.field8 = field8;
        this.field11 = field11;
        this.field12 = field12;
        this.field23 = field23;
        this.field31 = field31;
    }


}
