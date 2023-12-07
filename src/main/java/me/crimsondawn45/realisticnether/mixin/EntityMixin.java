package me.crimsondawn45.realisticnether.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import me.crimsondawn45.realisticnether.RealisticNether;
import net.fabricmc.fabric.api.tag.convention.v1.TagUtil;
import net.minecraft.entity.LivingEntity;

@Mixin(LivingEntity.class)
public class EntityMixin {

	@Inject(at = @At("TAIL"), method = "tick()V")
	private void init(CallbackInfo info) {
		
		LivingEntity entity = (LivingEntity)(Object)this;

		if(!entity.equals(null)) {
			if(entity.getWorld().getDimension().ultrawarm() && !entity.isFireImmune() && !entity.isOnFire() & !TagUtil.isIn(RealisticNether.NETHER_NATIVES, entity.getType())) {
				entity.setOnFireFor((int) ((Math.random() * (RealisticNether.MAX_BURN_TIME - RealisticNether.MIN_BURN_TIME)) + RealisticNether.MIN_BURN_TIME));
			}
		}
	}
}