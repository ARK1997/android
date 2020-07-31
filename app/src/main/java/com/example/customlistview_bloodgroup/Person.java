package com.example.customlistview_bloodgroup;

class Person {

    private String name;
    private String description;
    private String blood_grp;
   // private int id;



    public Person(String name, String description, String blood_grp) {
        this.name = name;
        this.description = description;
        this.blood_grp= blood_grp;
      //  this.id=id;

    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getBlood_grp() {
        return blood_grp;
    }

//    public int getId() {
//        return id;
//    }
}
