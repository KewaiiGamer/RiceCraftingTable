package kewaiigamer.rice.compat.jei;


import kewaiigamer.rice.crafting.ExtremeShapedOreRecipe;
import kewaiigamer.rice.crafting.ExtremeShapedRecipe;
import mezz.jei.api.IJeiHelpers;
import mezz.jei.api.recipe.IRecipeHandler;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.List;

public class ExtremeShapedRecipeHandler implements IRecipeHandler<ExtremeShapedOreRecipe>{

    private IJeiHelpers jeiHelpers;

    public ExtremeShapedRecipeHandler(IJeiHelpers jeiHelpers)
    {
        this.jeiHelpers = jeiHelpers;
    }

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
        return new ExtremeShapedRecipeWrapper(jeiHelpers, recipe);
    }

    @Override
    public boolean isRecipeValid(ExtremeShapedOreRecipe recipe) {
        if(recipe.getRecipeOutput() == null)
            return false;
        int inputCount = 0;
        for (Object input : recipe.getInput()) {
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
