package me.crimsondawn45.realisticnether;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.fabricmc.api.ModInitializer;
import net.minecraft.entity.EntityType;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class RealisticNether implements ModInitializer {
	
    public static final Logger LOGGER = LoggerFactory.getLogger("realisticnether");

	public static final TagKey<EntityType<?>> NETHER_NATIVES = TagKey.of(RegistryKeys.ENTITY_TYPE, new Identifier("realisticnether","nether_natives"));

	public static final int MIN_BURN_TIME = 1;
	public static final int MAX_BURN_TIME = 4;

	@Override
	public void onInitialize() {
		LOGGER.info("\"Realistic\" Nether Initialized!");
	}
}