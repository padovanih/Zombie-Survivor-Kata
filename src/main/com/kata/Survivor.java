package com.kata;

public class Survivor {
    private String name;
    private int wounds;

    public Survivor(String name) {
        this.name = name;
        this.wounds = 0;
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
}
