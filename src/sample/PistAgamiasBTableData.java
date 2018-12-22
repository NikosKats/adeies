package sample;

import javafx.beans.property.SimpleStringProperty;

public class PistAgamiasBTableData {
    SimpleStringProperty id;
    private final SimpleStringProperty field2,field3,field4,field7,field10,field11,field12,field13;

    public PistAgamiasBTableData(String id, String field2, String field3, String field4, String field7, String field10, String field11, String field12, String field13) {
        this.id = new SimpleStringProperty(id);
        this.field2 = new SimpleStringProperty(field2);
        this.field3 = new SimpleStringProperty(field3);
        this.field4 = new SimpleStringProperty(field4);
        this.field7 = new SimpleStringProperty(field7);
        this.field10 = new SimpleStringProperty(field10);
        this.field11 = new SimpleStringProperty(field11);
        this.field12 = new SimpleStringProperty(field12);
        this.field13 = new SimpleStringProperty(field13);
    }

    public String getId() {
        return id.get();
    }

    public SimpleStringProperty idProperty() {
        return id;
    }

    public void setId(String id) {
        this.id.set(id);
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

    public String getField11() {
        return field11.get();
    }

    public SimpleStringProperty field11Property() {
        return field11;
    }

    public void setField11(String field11) {
        this.field11.set(field11);
    }

    public String getField12() {
        return field12.get();
    }

    public SimpleStringProperty field12Property() {
        return field12;
    }

    public void setField12(String field12) {
        this.field12.set(field12);
    }

    public String getField13() {
        return field13.get();
    }

    public SimpleStringProperty field13Property() {
        return field13;
    }

    public void setField13(String field13) {
        this.field13.set(field13);
    }
}
