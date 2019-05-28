package com.kata;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private int currentPlayer;
    private List<Survivor> players;

    public Board() {
        this.players = new ArrayList<Survivor>();
        this.currentPlayer = 0;
    }

    public void insertSurvivor(Survivor player) {
        this.players.add(player);
    }

    public List<Survivor> getSurvivors(){
        return this.players;
    }

    public Survivor getActiveSurvivor() {
        return this.players.get(this.currentPlayer);
    }
}
