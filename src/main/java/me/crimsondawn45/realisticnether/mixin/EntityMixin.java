package me.crimsondawn45.realisticnether.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.entity.LivingEntity;

@Mixin(LivingEntity.class)
public class EntityMixin
{
	@Inject(at = @At(value = "TAIL"), method = "tick()V")
	private void tick(CallbackInfo cb)
	{
		LivingEntity entity = (LivingEntity)(Object)this;
		
		if(entity.getEntityWorld().getDimension().isUltrawarm() && !entity.isFireImmune())
		{
			entity.setFireTicks(20);
		}
	}
}
