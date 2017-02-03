package kewaiigamer.rice.compat.jei;


import kewaiigamer.rice.crafting.ExtremeShapedOreRecipe;
import kewaiigamer.rice.crafting.ExtremeShapedRecipe;
import mezz.jei.api.recipe.IRecipeHandler;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ExtremeShapedRecipeHandler implements IRecipeHandler<ExtremeShapedOreRecipe>{
    @Override
    public Class<ExtremeShapedOreRecipe> getRecipeClass() {
        return ExtremeShapedOreRecipe.class;
    }

    @Override
    public String getRecipeCategoryUid() {
        return ExtremeCraftingCategory.UID;
    }

    @Override
    public String getRecipeCategoryUid(ExtremeShapedOreRecipe recipe) {
        return ExtremeCraftingCategory.UID;
    }

    @Override
    public IRecipeWrapper getRecipeWrapper(ExtremeShapedOreRecipe recipe) {
        return new ExtremeShapedRecipeWrapper(recipe);
    }

    @Override
    public boolean isRecipeValid(ExtremeShapedOreRecipe recipe) {
        System.out.println(recipe + ": ");
        if(recipe.getRecipeOutput() == null)
            return false;
        int inputCount = 0;
        for (Object input : recipe.getInput()) {
            if(input != null) {
                if (input instanceof ItemStack) {
                    if (input != null)
                        inputCount++;
                } else return false;
            }
        }
        if(inputCount > 81)
            return false;
        System.out.println("Passed");

        return inputCount > 0;
    }
}
