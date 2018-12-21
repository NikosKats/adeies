package sample;

import javafx.beans.property.SimpleStringProperty;

public class GamosTableData {
    SimpleStringProperty id;

    private final SimpleStringProperty field2,field5,field10,field12,field13,field14,field18,field19,field28,field29,field88;

    public GamosTableData(String id, String field2, String field5, String field10, String field12, String field13, String field14, String field18, String field19, String field28, String field29, String field88) {
        this.id = new SimpleStringProperty(id);
        this.field2 = new SimpleStringProperty(field2);

        this.field5 = new SimpleStringProperty(field5);
        this.field10 = new SimpleStringProperty(field10);
        this.field12 = new SimpleStringProperty(field12);
        this.field13 = new SimpleStringProperty(field13);
        this.field14 = new SimpleStringProperty(field14);
        this.field18 = new SimpleStringProperty(field18);
        this.field19 = new SimpleStringProperty(field19);
        this.field28 = new SimpleStringProperty(field28);
        this.field29 = new SimpleStringProperty(field29);
        this.field88 = new SimpleStringProperty(field88);
    }


    public String getId() {
        return id.get();
    }

    public SimpleStringProperty idProperty() {
        return id;
    }

    public String getField2() {
        return field2.get();
    }

    public SimpleStringProperty field2Property() {
        return field2;
    }

    public String getField5() {
        return field5.get();
    }

    public SimpleStringProperty field5Property() {
        return field5;
    }

    public String getField10() {
        return field10.get();
    }

    public SimpleStringProperty field10Property() {
        return field10;
    }

    public String getField12() {
        return field12.get();
    }

    public SimpleStringProperty field12Property() {
        return field12;
    }

    public String getField13() {
        return field13.get();
    }

    public SimpleStringProperty field13Property() {
        return field13;
    }

    public String getField14() {
        return field14.get();
    }

    public SimpleStringProperty field14Property() {
        return field14;
    }

    public String getField18() {
        return field18.get();
    }

    public SimpleStringProperty field18Property() {
        return field18;
    }

    public String getField19() {
        return field19.get();
    }

    public SimpleStringProperty field19Property() {
        return field19;
    }

    public String getField28() {
        return field28.get();
    }

    public SimpleStringProperty field28Property() {
        return field28;
    }

    public String getField29() {
        return field29.get();
    }

    public SimpleStringProperty field29Property() {
        return field29;
    }

    public String getField88() {
        return field88.get();
    }

    public SimpleStringProperty field88Property() {
        return field88;
    }

    public void setId(String id) {
        this.id.set(id);
    }

    public void setField2(String field2) {
        this.field2.set(field2);
    }

    public void setField5(String field5) {
        this.field5.set(field5);
    }

    public void setField10(String field10) {
        this.field10.set(field10);
    }

    public void setField12(String field12) {
        this.field12.set(field12);
    }

    public void setField13(String field13) {
        this.field13.set(field13);
    }

    public void setField14(String field14) {
        this.field14.set(field14);
    }

    public void setField18(String field18) {
        this.field18.set(field18);
    }

    public void setField19(String field19) {
        this.field19.set(field19);
    }

    public void setField28(String field28) {
        this.field28.set(field28);
    }

    public void setField29(String field29) {
        this.field29.set(field29);
    }

    public void setField88(String field88) {
        this.field88.set(field88);
    }


}
