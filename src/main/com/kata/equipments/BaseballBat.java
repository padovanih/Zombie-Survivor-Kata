package com.kata.equipments;

public class BaseballBat implements Equipment {
    final String name = "BaseballBat";
    
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
        return name;
    }
    
    @Override
    public void use() {
        /* probably hit someone */
    }
}
