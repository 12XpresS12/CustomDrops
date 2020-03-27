package sk.xpress.majncraft.handler;

import org.bukkit.Material;

import java.util.ArrayList;
import java.util.List;

public class Drops {

    private Material mat;
    private List<Drop> drops = new ArrayList<Drop>();

    public Drops(Material mat, List<Drop> drops){
        this.mat = mat;
        this.drops = drops;
    }

    public Material getMaterial() {
        return mat;
    }

    public List<Drop> getDrops() {
        return drops;
    }

    public void setMaterial(Material mat) {
        this.mat = mat;
    }

    public void setDrops(List<Drop> drops) {
        this.drops = drops;
    }
}
