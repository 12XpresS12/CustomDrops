package sk.xpress.majncraft.handler;

import org.bukkit.Material;

public class Drop {

    private int chance;
    private Material mat;

    public Drop(Material mat, int chance){
        this.chance = chance;
        this.mat = mat;
    }

    public void setChance(int chance){
        this.chance = chance;
    }

    public void setMat(Material mat){
        this.mat = mat;
    }

    public int getChance() {
        return chance;
    }

    public Material getMat() {
        return mat;
    }
}
