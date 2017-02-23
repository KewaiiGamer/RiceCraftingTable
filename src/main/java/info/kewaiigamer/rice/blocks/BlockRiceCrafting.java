package info.kewaiigamer.rice.blocks;

import info.kewaiigamer.rice.Rice;
import info.kewaiigamer.rice.tile.TileEntityRiceCrafting;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

import static info.kewaiigamer.rice.Ref.MODID;

public class BlockRiceCrafting extends CustomCraftingTable implements ITileEntityProvider {
    public static final int GUI_ID = 0;

    public BlockRiceCrafting() {
        super("rice_crafting_table");
        GameRegistry.registerTileEntity(TileEntityRiceCrafting.class, MODID + ":   rice_crafting_table_te");
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ) {
        if (world.isRemote) {
            return true;
        }
        TileEntity te = world.getTileEntity(pos);
        if (!(te instanceof TileEntityRiceCrafting)) {
            return false;
        }
        player.openGui(Rice.Instance, GUI_ID, world, pos.getX(), pos.getY(), pos.getZ());
        return true;
    }

    @Override
    public TileEntity createNewTileEntity(World worldln, int meta) {
        return new TileEntityRiceCrafting();
    }

    public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
        TileEntityRiceCrafting craft = (TileEntityRiceCrafting) worldIn.getTileEntity(pos);
        if (craft instanceof TileEntityRiceCrafting) {
            //InventoryHelper.dropInventoryItems(worldIn, pos, (TileEntityRiceCrafting) craft);
            for(int i = 0; i < 81; i++){
                ItemStack stack = craft.matrix.getStackInSlot(i);
                if(stack != null)
                    worldIn.spawnEntityInWorld(new EntityItem(worldIn, pos.getX(), pos.getY(), pos.getZ(), stack));
            }
        }

        super.breakBlock(worldIn, pos, state);
    }
}