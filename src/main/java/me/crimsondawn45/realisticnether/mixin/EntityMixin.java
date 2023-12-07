package me.crimsondawn45.realisticnether.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import me.crimsondawn45.realisticnether.RealisticNether;
import net.fabricmc.fabric.api.tag.convention.v1.TagUtil;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;

@Mixin(LivingEntity.class)
public class EntityMixin {

	@Inject(at = @At("TAIL"), method = "tick()V")
	private void init(CallbackInfo info) {
		
		LivingEntity entity = (LivingEntity)(Object)this;

		if(!entity.equals(null)) {
			if(entity.getWorld().getDimension().ultrawarm() && !entity.isFireImmune() && !entity.isOnFire() & !TagUtil.isIn(RealisticNether.NETHER_NATIVES, entity.getType()) && !hasFireProt(entity)) {
				entity.setOnFireFor((int) ((Math.random() * (RealisticNether.MAX_BURN_TIME - RealisticNether.MIN_BURN_TIME)) + RealisticNether.MIN_BURN_TIME));
			}
		}
	}

	public boolean hasFireProt(LivingEntity entity) {
		// 5 = Head, 6 = Chest, 7 = Legs, 8 = Feet
		for(ItemStack item : entity.getArmorItems()) {
			if(!hasFireProtEnch(item)) {
				return false;
			}
		}
		return true;
	}

	public boolean hasFireProtEnch(ItemStack stack) {
        return EnchantmentHelper.getLevel(Enchantments.FIRE_PROTECTION, stack) > 0;
    }
}