package com.elmakers.mine.bukkit.utilities;

public enum ParticleType {
	
	SMOKE("smoke"),
	LARGE_SMOKE("largesmoke"),
	BLOCK_BREAKING("iconcrack_{subtype}"),
	SNOWBALL_POOF("snowballpoof"),
	SNOW_SHOVEL("snowshovel"),
	TOOL_BREAKING("tilecrack_{subtype}"),
	PORTAL("portal"),
	SPLASH("splash"),
	BUBBLE("bubble"),
	SUSPENDED("suspended"),
	DEPTH_SUSPENDED("depthsuspend"),
	TOWN_AURA("townaura"),
	HUGE_EXPLOSION("hugeexplosion"),
	LARGE_EXPLOSION("largeexplode"),
	FLAME("flame"),
	HEART("heart"),
	CLOUD("cloud"),
	CRITICAL("crit"),
	MAGIC_CRITICAL("magicCrit"),
	NOTE("note"),
	MAGIC_RUNES("enchantmenttable"),
	LAVA("lava"),
	FOOTSTEP("footstep"),
	RED_DUST("reddust"),
	WATER_DRIPPING("dripWater"),
	LAVA_DRIPPING("dripLava"),
	HAPPY_VILLAGER("happyVillager"),
	SLIME("slime"),
	SPELL("spell"),
	MOB_SPELL("mobSpell"),
	INSTANT_SPELL("instantSpell"),
	UNKNOWN("nil");

	private String particleName;
	
	private ParticleType(String particleName) {
		this.particleName = particleName;
	}
	
	public String getParticleName() {
		return particleName;
	}
	
	public String getParticleName(String subtype) {
		return particleName.replace("{subtype}", subtype);
	}
	
}
