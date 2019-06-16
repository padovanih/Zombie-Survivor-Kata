package com.kata.equipments;

public class BottledWater implements Equipment {
    final String name = "BottledWater";
    
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
        return "BottledWater";
    }
    
    @Override
    public void use() {
        /* probably refresh someone */
    }
}
