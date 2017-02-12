package kewaiigamer.rice.blocks;

import kewaiigamer.kewaiilib.custom.CustomBlock;
import kewaiigamer.rice.CreativeTab;
import kewaiigamer.rice.Rice;
import kewaiigamer.rice.tile.TileEntityRiceCrafting;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class BlockRiceCrafting extends CustomBlock implements ITileEntityProvider {
    public static final PropertyDirection FACING = PropertyDirection.create("facing");
    public static final int GUI_ID = 0;

    public BlockRiceCrafting() {
        super(Rice.MODID, "rice_crafting_table", CreativeTab.tabRice, Material.IRON, 50.0F, 2000.0F);
        setHarvestLevel("pickaxe", 1);
        GameRegistry.registerTileEntity(TileEntityRiceCrafting.class, Rice.MODID + ":   rice_crafting_table_te");
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

    /**
     Fix item dropping on block broken
     */
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

    @Override
    public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
        world.setBlockState(pos, state.withProperty(FACING, placer.getHorizontalFacing().getOpposite()), 2);
    }

    public static EnumFacing getFacingFromEntity(BlockPos clickedBlock, EntityLivingBase entity) {
        return EnumFacing.getFacingFromVector(
                (float) (entity.posX - clickedBlock.getX()),
                (float) (entity.posY - clickedBlock.getY()),
                (float) (entity.posZ - clickedBlock.getZ()));
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        return getDefaultState().withProperty(FACING, EnumFacing.getFront(meta & 7));
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return state.getValue(FACING).getIndex();
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, FACING);
    }

    @Override
    public boolean isFullCube(IBlockState state) {
        return false;
    }

    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }
}