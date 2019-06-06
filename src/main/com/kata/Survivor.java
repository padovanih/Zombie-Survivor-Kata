package com.kata;

public class Survivor {
    private String name;
    private int wounds;
    private int turns;

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
}
