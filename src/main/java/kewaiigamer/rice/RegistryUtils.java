package kewaiigamer.rice;

public class RegistryUtils {
    /*private static Map<Block,String> itemRegistry = new HashMap<>();

      public static void registerItem(Object obj, String name) {
        if (obj instanceof Block) {
            Block block = (Block) obj;
            block.setUnlocalizedName(name.toLowerCase());
            block.setRegistryName(name);
        } else if (obj instanceof Item) {
            Item item = (Item) obj;
            item.setUnlocalizedName(name.toLowerCase());
            item.setRegistryName(name.toLowerCase());
        } else {
            throw new IllegalArgumentException("Item or Block required!");
        }
    }
     public static Block registerBlock(Block block, String name, CreativeTabs tab) {
        GameRegistry.register(block);
        itemRegistry.put(block, name);
        if (tab != null) {
            block.setCreativeTab(tab);
        }
        return block;
    }
    public static Block registerBlocks(){
        return registerBlock(new BlockRiceCrafting(), "rice_crafting", CreativeTabs.MISC);
    } */
}
