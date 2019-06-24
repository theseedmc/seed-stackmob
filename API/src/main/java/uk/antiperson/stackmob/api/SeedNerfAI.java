package uk.antiperson.stackmob.api;

import java.lang.reflect.Field;

import com.google.common.collect.Sets;
import org.bukkit.craftbukkit.v1_13_R2.entity.CraftEntity;
import org.bukkit.entity.Entity;
import net.minecraft.server.v1_13_R2.EntityCreature;
import net.minecraft.server.v1_13_R2.EntityInsentient;
import net.minecraft.server.v1_13_R2.PathfinderGoalSelector;

public class SeedNerfAI {
    public SeedNerfAI(Entity e) { // Remove all pathfinding goals
        EntityCreature c = (EntityCreature) ((EntityInsentient) ((CraftEntity)e).getHandle());
        try {
            c.fromMobSpawner = true;
            c.dead = false;
            Field bField = PathfinderGoalSelector.class.getDeclaredField("b");
            bField.setAccessible(true);
            Field cField = PathfinderGoalSelector.class.getDeclaredField("c");
            cField.setAccessible(true);
            bField.set(c.goalSelector, Sets.newLinkedHashSet());
            bField.set(c.targetSelector, Sets.newLinkedHashSet());
            cField.set(c.goalSelector, Sets.newLinkedHashSet());
            cField.set(c.targetSelector, Sets.newLinkedHashSet());
        }
        catch (Exception exc) {exc.printStackTrace();}
    }
}