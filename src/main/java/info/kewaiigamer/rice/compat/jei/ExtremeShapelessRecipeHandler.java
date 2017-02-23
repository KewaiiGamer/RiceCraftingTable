package info.kewaiigamer.rice.compat.jei;

import info.kewaiigamer.rice.crafting.ricecraftingtable.ExtremeShapelessRecipe;
import mezz.jei.api.IJeiHelpers;
import mezz.jei.api.recipe.IRecipeHandler;
import mezz.jei.api.recipe.IRecipeWrapper;

import java.util.List;

public class ExtremeShapelessRecipeHandler implements IRecipeHandler<ExtremeShapelessRecipe>{

    private IJeiHelpers jeiHelpers;

    public ExtremeShapelessRecipeHandler(IJeiHelpers jeiHelpers)
    {
        this.jeiHelpers = jeiHelpers;
    }

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
        return new ExtremeShapelessRecipeWrapper(jeiHelpers, recipe);
    }

    @Override
    public boolean isRecipeValid(ExtremeShapelessRecipe recipe) {
        if(recipe.getRecipeOutput() == null)
            return false;

        int inputCount = 0;
        for (Object input : recipe.recipeItems) {
            if(input != null) {
                if(input instanceof List && ((List) input).isEmpty())
                {
                    return false;
                }
                inputCount++;
            }
        }

        if(inputCount > 81)
            return false;

        return inputCount > 0;
    }
}
