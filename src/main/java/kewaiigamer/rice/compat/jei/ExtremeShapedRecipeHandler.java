package kewaiigamer.rice.compat.jei;


import kewaiigamer.rice.crafting.ExtremeShapedRecipe;
import mezz.jei.api.recipe.IRecipeHandler;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.item.ItemStack;

public class ExtremeShapedRecipeHandler implements IRecipeHandler<ExtremeShapedRecipe>{
    @Override
    public Class<ExtremeShapedRecipe> getRecipeClass() {
        return ExtremeShapedRecipe.class;
    }

    @Override
    public String getRecipeCategoryUid() {
        return ExtremeCraftingCategory.UID;
    }

    @Override
    public String getRecipeCategoryUid(ExtremeShapedRecipe recipe) {
        return ExtremeCraftingCategory.TITLE;
    }

    @Override
    public IRecipeWrapper getRecipeWrapper(ExtremeShapedRecipe recipe) {
        return new ExtremeShapedRecipeWrapper(recipe);
    }

    @Override
    public boolean isRecipeValid(ExtremeShapedRecipe recipe) {
        if(recipe.getRecipeOutput() == null)
            return false;

        int inputCount = 0;
        for (ItemStack input :
                recipe.recipeItems) {
            if (input != null)
                inputCount++;
        }

        if(inputCount > 81)
            return false;

        return inputCount > 0;
    }
}
