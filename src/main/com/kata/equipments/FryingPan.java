package com.kata.equipments;

public class FryingPan implements Equipment {
    final String name = "FryingPan";
    
    @Override
    public void use() {
        /* probably hit someone */
    }
    
    @Override
    public boolean equals(Object equipment) {
        if(name == ((Equipment)equipment).getName()) {
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
        return "FryingPan";
    }
}
