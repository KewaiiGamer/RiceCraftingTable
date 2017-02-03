package kewaiigamer.rice.compat.crafttweaker.handlers;

import kewaiigamer.rice.crafting.ExtremeCraftingManager;
import kewaiigamer.rice.crafting.ExtremeShapedOreRecipe;
import minetweaker.IUndoableAction;
import minetweaker.MineTweakerAPI;
import minetweaker.api.item.IIngredient;
import minetweaker.api.item.IItemStack;
import minetweaker.api.oredict.IOreDictEntry;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.oredict.OreDictionary;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

import java.util.ArrayList;

import static org.apache.logging.log4j.core.appender.rewrite.MapRewritePolicy.Mode.Add;

@ZenClass("mods.rice.ExtremeShapedOreTweaker")
public class ExtremeShapedOreTweaker {


    protected static final String name = "Rice Crafting Table";



    @ZenMethod
    public static void addShaped(IItemStack output, IIngredient[][] ingredients) {

        int height = ingredients.length;
        int width = 0;
        for (IIngredient[] row : ingredients) {
            if (width < row.length)
                width = row.length;
        }
        Object[] input = new Object[width * height];
        int x = 0;
        for (IIngredient[] row : ingredients) {
            for (IIngredient ingredient : row) {
                input[x++] = toObject(ingredient);
            }
        }
        MineTweakerAPI.apply(new Add(new ExtremeShapedOreRecipe(toStack(output), toShapedObjects(ingredients))));
    }

    /*private static class Add extends BaseListAddition<ExtremeShapedOreRecipe>{

        public Add(ExtremeShapedOreRecipe recipe) {
            super(ExtremeShapedOreTweaker.name, ExtremeCraftingManager.getInstance().getRecipeList());

            recipes.add(recipe);
        }
        @Override
        protected String getRecipeInfo(ExtremeShapedOreRecipe recipe) {
            return "Adding Rice Crafting Recipe for " + recipe.getRecipeOutput().getDisplayName();
        }
    }
    */
    private static class Add implements IUndoableAction {
        IRecipe recipe;

        public Add(IRecipe add) {
            recipe = add;
        }

        @Override
        public void apply() {

            ExtremeCraftingManager.getInstance().getRecipeList().add(recipe);
        }

        @Override
        public boolean canUndo() {
            return true;
        }

        @Override
        public void undo() {
            ExtremeCraftingManager.getInstance().getRecipeList().remove(recipe);
        }

        @Override
        public String describe() {
            return "Adding Xtreme Crafting Recipe for " + recipe.getRecipeOutput().getDisplayName();
        }

        @Override
        public String describeUndo() {
            return "Un-adding Xtreme Crafting Recipe for " + recipe.getRecipeOutput().getDisplayName();
        }

        @Override
        public Object getOverrideKey() {
            return null;
        }

    }
    public static Object[] toShapedObjects(IIngredient[][] ingredients) {
        if(ingredients == null) {
            return null;
        } else {
            ArrayList prep = new ArrayList();
            prep.add("abc");
            prep.add("def");
            prep.add("ghi");
            char[][] map = new char[][]{{'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}};

            for(int x = 0; x < ingredients.length; ++x) {
                if(ingredients[x] != null) {
                    for(int y = 0; y < ingredients[x].length; ++y) {
                        if(ingredients[x][y] != null && x < map.length && y < map[x].length) {
                            prep.add(Character.valueOf(map[x][y]));
                            prep.add(toObject(ingredients[x][y]));
                        }
                    }
                }
            }

            return prep.toArray();
        }
    }

    public static Object[] toObjects(IIngredient[] ingredient) {
        if(ingredient == null) {
            return null;
        } else {
            Object[] output = new Object[ingredient.length];

            for(int i = 0; i < ingredient.length; ++i) {
                if(ingredient[i] != null) {
                    output[i] = toObject(ingredient[i]);
                } else {
                    output[i] = "";
                }
            }

            return output;
        }
    }

    public static Object toObject(IIngredient iStack) {
        return iStack == null?null:(iStack instanceof IOreDictEntry ?toString((IOreDictEntry)iStack):(iStack instanceof IItemStack?toStack((IItemStack)iStack):null));
    }

    public static String toString(IOreDictEntry entry) {
        return entry.getName();
    }

    public static ItemStack toStack(IItemStack iStack) {
        if(iStack == null) {
            return null;
        } else {
            Object internal = iStack.getInternal();
            /*if(!(internal instanceof ItemStack)) {
                LogHelper.logError("Not a valid item stack: " + iStack);
            }
            */

            return (ItemStack)internal;
        }
    }

}
