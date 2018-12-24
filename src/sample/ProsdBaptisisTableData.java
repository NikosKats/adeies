package sample;

import javafx.beans.property.SimpleStringProperty;

public class ProsdBaptisisTableData {
    SimpleStringProperty id;
    private final SimpleStringProperty field1,field2,field3,field4,field5,field6,field7,field10,field21,field26;

    public String getId() {
        return id.get();
    }

    public SimpleStringProperty idProperty() {
        return id;
    }

    public void setId(String id) {
        this.id.set(id);
    }

    public String getField1() {
        return field1.get();
    }

    public SimpleStringProperty field1Property() {
        return field1;
    }

    public void setField1(String field1) {
        this.field1.set(field1);
    }

    public String getField2() {
        return field2.get();
    }

    public SimpleStringProperty field2Property() {
        return field2;
    }

    public void setField2(String field2) {
        this.field2.set(field2);
    }

    public String getField3() {
        return field3.get();
    }

    public SimpleStringProperty field3Property() {
        return field3;
    }

    public void setField3(String field3) {
        this.field3.set(field3);
    }

    public String getField4() {
        return field4.get();
    }

    public SimpleStringProperty field4Property() {
        return field4;
    }

    public void setField4(String field4) {
        this.field4.set(field4);
    }

    public String getField5() {
        return field5.get();
    }

    public SimpleStringProperty field5Property() {
        return field5;
    }

    public void setField5(String field5) {
        this.field5.set(field5);
    }

    public String getField6() {
        return field6.get();
    }

    public SimpleStringProperty field6Property() {
        return field6;
    }

    public void setField6(String field6) {
        this.field6.set(field6);
    }

    public String getField7() {
        return field7.get();
    }

    public SimpleStringProperty field7Property() {
        return field7;
    }

    public void setField7(String field7) {
        this.field7.set(field7);
    }

    public String getField10() {
        return field10.get();
    }

    public SimpleStringProperty field10Property() {
        return field10;
    }

    public void setField10(String field10) {
        this.field10.set(field10);
    }

    public String getField21() {
        return field21.get();
    }

    public SimpleStringProperty field21Property() {
        return field21;
    }

    public void setField21(String field21) {
        this.field21.set(field21);
    }

    public String getField26() {
        return field26.get();
    }

    public SimpleStringProperty field26Property() {
        return field26;
    }

    public void setField26(String field26) {
        this.field26.set(field26);
    }

    public ProsdBaptisisTableData(String id, String field1, String field2, String field3, String field4, String field5, String field6, String field7, String field10, String field21, String field26)
    {
        this.id = new SimpleStringProperty(id);
        this.field1 = new SimpleStringProperty(field2);
        this.field2 = new SimpleStringProperty(field3);
        this.field3 = new SimpleStringProperty(field4);
        this.field4 = new SimpleStringProperty(field6);
        this.field5 = new SimpleStringProperty(field5);
        this.field6 = new SimpleStringProperty(field6);
        this.field7 = new SimpleStringProperty(field7);
        this.field10 = new SimpleStringProperty(field10);
        this.field21 = new SimpleStringProperty(field21);
        this.field26 = new SimpleStringProperty(field26);
    }


}
