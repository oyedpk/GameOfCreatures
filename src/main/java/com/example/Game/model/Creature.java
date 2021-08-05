package com.example.Game.model;

public class Creature {

    private CreatureType creatureType;

    private Integer strength;
    private Integer armour;
    private Integer health;
    private Integer intellect;

    private boolean isAlive;
    private Integer prevHealth;
    private Integer leadership;
    private WeaponType weaponType;



    public Creature(CreatureType creatureType, Integer strength, Integer armour, Integer health, Integer intellect) {
        this.creatureType = creatureType;
        this.strength = strength;
        this.armour = armour;
        this.health = health;
        this.intellect = intellect;
        isAlive=true;
    }

    public CreatureType getCreatureType() {
        return creatureType;
    }

    public Integer getStrength() {
        return strength;
    }

    public void setStrength(Integer strength) {
        this.strength = strength;
    }

    public Integer getArmour() {
        return armour;
    }

    public void setArmour(Integer armour) {
        this.armour = armour;
    }

    public Integer getHealth() {
        return health;
    }

    public void setHealth(Integer health) {
        this.health = health;
    }

    public Integer getIntellect() {
        return intellect;
    }

    public void setIntellect(Integer intellect) {
        this.intellect = intellect;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public Integer getPrevHealth() {
        return prevHealth;
    }

    public void setPrevHealth(Integer prevHealth) {
        this.prevHealth = prevHealth;
    }

    public void setLeadership(Integer leadership) {
        this.leadership = leadership;
    }

    public WeaponType getWeaponType() {
        return weaponType;
    }

    public void setWeaponType(WeaponType weaponType) {
        this.weaponType = weaponType;
    }

    public Integer getLeadership() {
        int positiveCount=0;
        if(armour>=5) positiveCount++;
        if(intellect>=5) positiveCount++;
        if(health>=5) positiveCount++;
        if(strength>=5) positiveCount++;

        int total =0;
        if(creatureType==CreatureType.TROLL) total=31;
        else
            total=40;
        if(positiveCount>=3) {
            leadership=((armour+intellect+health+strength)/total)*100;
        } else {
            leadership=(((armour+intellect+health+strength)/total)*100)-100;
        }
        return leadership;
    }
}
/*

 */