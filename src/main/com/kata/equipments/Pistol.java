package com.kata.equipments;

public class Pistol implements Equipment {
    final String name = "Pistol";
    
    @Override
    public boolean equals(Object equipment) {
        if (this.name == ((Equipment)equipment).getName() ){
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
        return "Pistol";
    }
    
    @Override
    public void use() {
        /* probably shot someone */
    }
}
