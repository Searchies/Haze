package net.searchies.haze.item;

import net.minecraft.core.Direction;
import net.minecraft.core.Position;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ProjectileItem;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.searchies.haze.entity.Bamboom;

import java.awt.*;

public class BamboomItem extends Item implements ProjectileItem {
    public BamboomItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult use(Level level, Player player, InteractionHand hand) {
        ItemStack itemStack = player.getItemInHand(hand);
        level.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.SNOWBALL_THROW, SoundSource.NEUTRAL, 0.5F, 0.4F / (level.getRandom().nextFloat() * 0.4F + 0.8F));

        if (level instanceof ServerLevel serverLevel) {
            if (serverLevel.getRandom().nextInt(2) == 0) {
                Projectile.spawnProjectileFromRotation(Bamboom::new,
                        serverLevel,
                        itemStack,
                        player,
                        /* yOffset: */ 0.0F,
                        /* pow: */ 1.5F,
                        /* uncertainty: */ 1.0F);
            } else {
                player.displayClientMessage(Component.literal("lol get exploded chump").copy().withColor(Color.RED.getRGB()), true);
                serverLevel.explode(
                        player,
                        Explosion.getDefaultDamageSource(serverLevel, player),
                        null,
                        player.getX(),
                        player.getY(),
                        player.getZ(),
                        2F,
                        false,
                        Level.ExplosionInteraction.NONE
                );
            }
        }

        player.awardStat(Stats.ITEM_USED.get(this));
        itemStack.consume(1, player);
        return InteractionResult.SUCCESS;
    }

    @Override
    public Projectile asProjectile(Level level, Position position, ItemStack itemStack, Direction direction) {
        return new Bamboom(level, position.x(), position.y(), position.z(), itemStack);
    }
}
