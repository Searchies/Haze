package net.searchies.haze.entity;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.throwableitemprojectile.Snowball;
import net.minecraft.world.entity.projectile.throwableitemprojectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.searchies.haze.init.ModEntityTypes;
import net.searchies.haze.init.ModItems;

public class Bamboom extends ThrowableItemProjectile {
    public Bamboom(EntityType<? extends Bamboom> entityType, Level level) {
        super(entityType, level);
    }

    public Bamboom(Level level, LivingEntity livingEntity, ItemStack itemStack) {
        super(ModEntityTypes.BAMBOOM, livingEntity, level, itemStack);
    }

    public Bamboom(Level level, double d, double e, double f, ItemStack itemStack) {
        super(ModEntityTypes.BAMBOOM, d, e, f, level, itemStack);
    }

    @Override
    public Item getDefaultItem() {
        return ModItems.BAMBOOM;
    }

    @Override
    protected void onHitEntity(EntityHitResult hitResult) {
        super.onHitEntity(hitResult);

        if (!level().isClientSide()) {
            level().explode(
                    this,
                    Explosion.getDefaultDamageSource(this.level(), this),
                    null,
                    this.getX(),
                    this.getY(),
                    this.getZ(),
                    2F,
                    false,
                    Level.ExplosionInteraction.NONE
            );

        }
    }

    @Override
    protected void onHit(HitResult hitResult) {
        super.onHit(hitResult);

        if (!level().isClientSide()) {
            this.discard();
        }
    }
}
