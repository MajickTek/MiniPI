package com.mt.minipi;

public class Item {
	final int id;
	
	Item(int id) {
		this.id = id;
	}
	
	static Item id(int id) {
		return new Item(id);
	}
	
	static Item decode(Object encoded) {
		 if(encoded == null || !(encoded instanceof Item)) {
	        	return id(0);
	        } else {
	        	Item decoded = ((Item) encoded);
	        	return decoded;
	        }
	}
	
	@Override
	public int hashCode() {
		return id;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null || !(obj instanceof Item)) {
			return false;
		}
		return id == ((Item) obj).id;
	}
	
	@Override
	public String toString() {
		return Integer.toString(id);
	}
	
	public enum Items {
		POWER_GLOVE,
		COW_SPAWNER,
		PIG_SPAWNER,
		SHEEP_SPAWNER,
		SLIME_SPAWNER,
		ZOMBIE_SPAWNER,
		CREEPER_SPAWNER,
		SKELETON_SPAWNER,
		SNAKE_SPAWNER,
		KNIGHT_SPAWNER,
		AIR_WIZARD_SPAWNER,
		CHEST,
		DUNGEON_CHEST,
		WORKBENCH,
		OVEN,
		FURNACE,
		ANVIL,
		ENCHANTER,
		LOOM,
		LANTERN,
		IRON_LANTERN,
		GOLD_LANTERN,
		TNT,
		BED,
		TORCH,
		BUCKET,
		BOOK,
		ANTIDIOUS_BOOK,
		FLOWER,
		ACORN,
		DIRT,
		NATURAL_ROCK,
		PLANK,
		PLANK_WALL,
		WOOD_DOOR,
		STONE,
		STONE_BRICK,
		ORNATE_STONE,
		STONE_WALL,
		STONE_DOOR,
		RAW_OBSIDIAN,
		OBSIDIAN_BRICK,
		ORNATE_OBSIDIAN,
		OBSIDIAN_WALL,
		OBSIDIAN_DOOR,
		WOOL,
		RED_WOOL,
		BLUE_WOOL,
		GREEN_WOOL,
		YELLOW_WOOL,
		BLACK_WOOL,
		SAND,
		CACTUS,
		BONE,
		CLOUD,
		WHEAT_SEEDS,
		POTATO,
		GRASS_SEEDS,
		FARMLAND,
		EXPLODED,
		HOLE,
		LAVA,
		PATH,
		WATER,
		SHOVEL,
		HOE,
		SWORD,
		PICKAXE,
		AXE,
		BOW,
		CLAYMORE,
		SHEARS,
		BAKED_POTATO,
		APPLE,
		RAW_PORK,
		RAW_FISH,
		RAW_BEEF,
		BREAD,
		COOKED_FISH,
		COOKED_PORK,
		STEAK,
		GOLD_APPLE,
		WOOD,
		LEATHER,
		WHEAT,
		KEY,
		ARROW,
		STRING,
		COAL,
		IRON_ORE,
		LAPIS,
		GOLD_ORE,
		IRON,
		GOLD,
		ROSE,
		GUNPOWDER,
		SLIME,
		GLASS,
		CLOTH,
		GEM,
		SCALE,
		SHARD,
		CLOUD_ORE,
		RED_CLOTHES,
		BLUE_CLOTHES,
		GREEN_CLOTHES,
		YELLOW_CLOTHES,
		BLACK_CLOTHES,
		ORANGE_CLOTHES,
		PURPLE_CLOTHES,
		CYAN_CLOTHES,
		REG_CLOTHES,
		LEATHER_ARMOR,
		SNAKE_ARMOR,
		IRON_ARMOR,
		GOLD_ARMOR,
		GEM_ARMOR,
		NONE_POTION,
		SPEED_POTION,
		LIGHT_POTION,
		SWIM_POTION,
		ENERGY_POTION,
		REGEN_POTION,
		HEALTH_POTION,
		TIME_POTION,
		LAVA_POTION,
		SHIELD_POTION,
		HASTE_POTION,
		ESCAPE_POTION,
		FISHING_ROD,
		TOTEM_OF_AIR
		;

		Item getItem() {
			return id(ordinal());
		}
	}
}
