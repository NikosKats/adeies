package sample;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class BaptisiTableData {
    SimpleIntegerProperty id;
    private final SimpleStringProperty field2,field3,field4,field6,field7,field8,field11,field12,field23,field31;

    public BaptisiTableData(int id, String field2,String field3,String field4,String field6,String field7,String field8,String field11,String field12,String field23,String field31)
    {
        this.id = new SimpleIntegerProperty(id);
        this.field2 = new SimpleStringProperty(field2);
        this.field3 = new SimpleStringProperty(field3);
        this.field4 = new SimpleStringProperty(field4);
        this.field6 = new SimpleStringProperty(field6);
        this.field7 = new SimpleStringProperty(field7);
        this.field8 = new SimpleStringProperty(field8);
        this.field11 = new SimpleStringProperty(field11);
        this.field12 = new SimpleStringProperty(field12);
        this.field23 = new SimpleStringProperty(field23);
        this.field31 = new SimpleStringProperty(field31);
    }


     public SimpleIntegerProperty getId() {
         return id;
     }

     public String getField2() {
         return field2.get();
     }


     public String getField3() {
         return field3.get();
     }



     public String getField4() {
         return field4.get();
     }



     public String getField6() {
         return field6.get();
     }



     public String getField7() {
         return field7.get();
     }



     public String getField8() {
         return field8.get();
     }



     public String getField11() {
         return field11.get();
     }

     public String getField12() {
         return field12.get();
     }


     public String getField23() {
         return field23.get();
     }

     public String getField31() {
         return field31.get();
     }


     public void setId(SimpleIntegerProperty id) {
         this.id = id;
     }

     public void setField2(String field2) {
         this.field2.set(field2);
     }

     public void setField3(String field3) {
         this.field3.set(field3);
     }

     public void setField4(String field4) {
         this.field4.set(field4);
     }

     public void setField6(String field6) {
         this.field6.set(field6);
     }

     public void setField7(String field7) {
         this.field7.set(field7);
     }

     public void setField8(String field8) {
         this.field8.set(field8);
     }

     public void setField11(String field11) {
         this.field11.set(field11);
     }

     public void setField12(String field12) {
         this.field12.set(field12);
     }

     public void setField23(String field23) {
         this.field23.set(field23);
     }

     public void setField31(String field31) {
         this.field31.set(field31);
     }
 }

