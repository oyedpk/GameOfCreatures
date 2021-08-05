package com.example.Game;

import com.example.Game.model.Creature;
import com.example.Game.model.CreatureType;
import com.example.Game.model.WeaponType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

public class GameServiceTest {

    @Test
    public void testAttack() {
        Creature creatureTroll1= new Creature(CreatureType.TROLL,9,6,9,1);
        Creature creatureTroll2= new Creature(CreatureType.TROLL,6,5,10,1);

        GameService gameService=new GameService();

        gameService.attack(creatureTroll1,creatureTroll2);

        Assertions.assertEquals(1,creatureTroll2.getHealth());
        Assertions.assertFalse(creatureTroll2.isAlive());

    }

    @Test
    public void testHeal() {
        Creature creatureWizard= new Creature(CreatureType.WIZARD,9,6,9,1);
        Creature creatureTroll2= new Creature(CreatureType.TROLL,6,5,5,1);

        GameService gameService=new GameService();

        gameService.heal(creatureWizard,creatureTroll2);

        Assertions.assertEquals(10,creatureTroll2.getHealth());

    }

    @Test
    public void testHealDeadTroll() {
        Creature creatureWizard= new Creature(CreatureType.WIZARD,9,6,9,1);
        Creature creatureTroll1= new Creature(CreatureType.TROLL,4,5,5,1);
        Creature creatureTroll2= new Creature(CreatureType.TROLL,6,5,5,1);

        GameService gameService=new GameService();

        gameService.attack(creatureTroll1,creatureTroll2);
        Assertions.assertEquals(1,creatureTroll2.getHealth());
        Assertions.assertFalse(creatureTroll2.isAlive());

        gameService.heal(creatureWizard,creatureTroll2);
        Assertions.assertEquals(5,creatureTroll2.getHealth());
        Assertions.assertTrue(creatureTroll2.isAlive());
    }

    @Test
    public void testLeadershipAttributes() {
        Creature creatureWizard1= new Creature(CreatureType.TROLL,4,5,5,5);
        Creature creatureWizard2= new Creature(CreatureType.TROLL,4,7,8,9);
        Creature creatureTroll1= new Creature(CreatureType.TROLL,2,5,5,1);
        Creature creatureTroll2= new Creature(CreatureType.TROLL,1,5,4,1);

        if(creatureTroll1.getLeadership()>0 || creatureWizard1.getLeadership()<0 ||
                creatureTroll2.getLeadership()>0 || creatureWizard2.getLeadership()<0 ) {
            Assertions.fail();
        }


        Assertions.assertEquals(calcluateLeadership(creatureWizard1,true)
                ,creatureWizard1.getLeadership());
        Assertions.assertEquals(calcluateLeadership(creatureWizard2,true)
                ,creatureWizard2.getLeadership());

        Assertions.assertEquals(calcluateLeadership(creatureTroll1,false)
                ,creatureTroll1.getLeadership());
        Assertions.assertEquals(calcluateLeadership(creatureTroll2,false)
                ,creatureTroll2.getLeadership());

        if(creatureWizard1.getLeadership()>creatureWizard2.getLeadership() ||
                creatureTroll1.getLeadership()>creatureTroll2.getLeadership()) {
            Assertions.fail();
        }

    }

    @Test
    public void testCreaturesWithWeaponKnife() {
        Creature creatureTroll1= new Creature(CreatureType.TROLL,8,6,9,1);
        creatureTroll1.setWeaponType(WeaponType.KNIFE);
        Creature creatureTroll2= new Creature(CreatureType.TROLL,6,5,10,1);

        GameService gameService=new GameService();

        gameService.attack(creatureTroll1,creatureTroll2);

        Assertions.assertEquals(1,creatureTroll2.getHealth());
        Assertions.assertFalse(creatureTroll2.isAlive());
    }

    @Test
    public void testCreaturesWithWeaponSword() {
        Creature creatureTroll1= new Creature(CreatureType.TROLL,7,6,9,1);
        creatureTroll1.setWeaponType(WeaponType.SWORD);
        Creature creatureTroll2= new Creature(CreatureType.TROLL,6,5,10,1);

        GameService gameService=new GameService();

        gameService.attack(creatureTroll1,creatureTroll2);

        Assertions.assertEquals(1,creatureTroll2.getHealth());
        Assertions.assertFalse(creatureTroll2.isAlive());
    }


    public Integer calcluateLeadership (Creature creature, boolean isPos) {
        int total =0;
        if(creature.getCreatureType()==CreatureType.TROLL) {
            total=31;
        } else {
            total=40;
        }

        if(isPos) {
            return ((creature.getArmour()+creature.getStrength()+creature.getHealth()+creature.getIntellect())/total)*100;
        } else {
            return (((creature.getArmour()+creature.getStrength()+creature.getHealth()+creature.getIntellect())/total)*100)-100;
        }
    }

}
