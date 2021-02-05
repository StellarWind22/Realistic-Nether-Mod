package me.crimsondawn45.realisticnether;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.tag.TagRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.tag.Tag;
import net.minecraft.util.Identifier;

public class RealisticNether implements ModInitializer
{
	public static final int MIN_BURN_TIME = 1;
	public static final int MAX_BURN_TIME = 4;
	
	public static Tag<EntityType<?>> nether_natives = TagRegistry.entityType(new Identifier("realisticnether", "nether_natives"));
	
	@Override
	public void onInitialize()
	{
		
	}
}
