package com.kata;

import com.kata.equipments.Equipment;

import java.util.ArrayList;
import java.util.List;

public class Survivor {
    private String name;
    private int wounds;
    private int turns;
    private List<Equipment> equipments = new ArrayList<Equipment>();

    public Survivor(String name) {
        this.name = name;
        this.wounds = 0;
        turns = 3;
    }

    public int getWounds() {
        return wounds;
    }

    public void wound() {
        this.wounds++;
    }

    public boolean isAlive() {
        return this.wounds < 2;
    }
    
    public int getTurns() {
        return this.turns;
    }

    public void pickEquipment(Equipment equipment) {
        this.equipments.add(equipment);
    }

    public List<Equipment> getEquipments() {
        return this.equipments;
    }
}
