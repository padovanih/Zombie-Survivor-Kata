package com.kata.equipments;

public class Katana implements Equipment {
    final String name = "Katana";
    
    @Override
    public void use() {
        /* probably slash someone */
    }
    
    @Override
    public boolean equals(Object equipment) {
        if(name == ((Equipment)equipment).getName()){
            return true;
        }
        return false;
    }
    
    @Override
    public String getName() {
        return name;
    }
    
    @Override
    public String toString() {
        return "Katana";
    }
}
