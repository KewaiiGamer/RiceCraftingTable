package kewaiigamer.rice.compat.jei;

import kewaiigamer.rice.crafting.ExtremeShapelessRecipe;
import mezz.jei.api.recipe.IRecipeHandler;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;

public class ExtremeShapelessRecipeHandler implements IRecipeHandler<ExtremeShapelessRecipe>{
    @Override
    public Class<ExtremeShapelessRecipe> getRecipeClass() {
        return ExtremeShapelessRecipe.class;
    }

    @Override
    public String getRecipeCategoryUid() {
        return ExtremeCraftingCategory.UID;
    }

    @Override
    public String getRecipeCategoryUid(ExtremeShapelessRecipe recipe) {
        return ExtremeCraftingCategory.UID;
    }


    @Override
    public IRecipeWrapper getRecipeWrapper(ExtremeShapelessRecipe recipe) {
        return new ExtremeShapelessRecipeWrapper(recipe);
    }

    @Override
    public boolean isRecipeValid(ExtremeShapelessRecipe recipe) {
        System.out.print(recipe + ": ");
        if(recipe.getRecipeOutput() == null)
            return false;

        int inputCount = 0;
        for (Object input : recipe.recipeItems) {
            if(input instanceof ItemStack) {
                if (input != null)
                    inputCount++;
            }
            else return false;
        }

        if(inputCount > 81)
            return false;
        System.out.println("Passed!");

        return inputCount > 0;
    }
}
