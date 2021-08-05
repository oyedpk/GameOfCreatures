package com.example.Game;

import com.example.Game.model.Creature;
import com.example.Game.model.CreatureType;
import com.example.Game.model.WeaponType;


public class GameService {


    public void attack(Creature creature1, Creature creature2) {
        if(!creature2.isAlive()) {
            System.out.println("You can not attack a dead Creature");
            return;
        }
        int newHealth=creature2.getHealth()-
                creature1.getStrength();

        if(creature1.getWeaponType()!=null){
            if(creature1.getWeaponType()== WeaponType.KNIFE) {
                newHealth-=1;
            } else{
                newHealth-=2;
            }
        }

        if(newHealth==1) {
            creature2.setPrevHealth(creature2.getHealth());
            creature2.setAlive(false);
        }
        creature2.setHealth(newHealth);
    }

    public void heal(Creature creature1, Creature creature2) {
        if(!CreatureType.WIZARD.equals(creature1.getCreatureType())) {
            System.out.println("Only Wizard can perform the heal actions");
            return;
        }

        if(creature2.isAlive()) {
            creature2.setHealth(10);
        } else {
            creature2.setAlive(true);
            creature2.setHealth(creature2.getPrevHealth());
        }
    }

}


/*
1 -- heal , attack, attack
2 -- attack , heal


atack(creature1,creature2)

heal(cretaure1,creature2)
 */