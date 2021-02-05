package me.crimsondawn45.realisticnether.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import me.crimsondawn45.realisticnether.RealisticNether;
import net.minecraft.entity.LivingEntity;

@Mixin(LivingEntity.class)
public class EntityMixin
{
	@Inject(at = @At(value = "TAIL"), method = "tick()V")
	private void tick(CallbackInfo cb)
	{
		LivingEntity entity = (LivingEntity)(Object)this;
		
		if(entity.getEntityWorld().getDimension().isUltrawarm() && !entity.isFireImmune() && !RealisticNether.nether_natives.contains(entity.getType()) && !entity.isOnFire())
		{
			entity.setOnFireFor((int) ((Math.random() * (RealisticNether.MAX_BURN_TIME - RealisticNether.MIN_BURN_TIME)) + RealisticNether.MIN_BURN_TIME));
		}
	}
}
