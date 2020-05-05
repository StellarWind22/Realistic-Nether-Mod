package me.crimsondawn45.realisticnether.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.entity.LivingEntity;
import net.minecraft.world.dimension.DimensionType;

@Mixin(LivingEntity.class)
public class EntityMixin
{
	@Inject(at = @At(value = "TAIL"), method = "tick()V")
	private void tick(CallbackInfo cb)
	{
		LivingEntity entity = (LivingEntity)(Object)this;
		
		if(entity.world.getDimension().getType() == DimensionType.THE_NETHER && !entity.isFireImmune())
		{
			entity.setFireTicks(20);
		}
	}
}
