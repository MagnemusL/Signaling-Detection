package net.smazeee.signaling;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class Test extends BlockItem {
    public static BlockPos blockPos;
    public static int blockPosX;
    public static int blockPosY;
    public static int blockPosZ;
    public static boolean hasSelected;
    public static boolean canBreak;

    public Test(Block pBlock, Properties pProperties) {
        super(pBlock, pProperties);
    }

    @Override
    public boolean onBlockStartBreak(ItemStack itemstack, BlockPos pos, Player player) {
        if (!hasSelected) {
            blockPos = pos;
            blockPosX = blockPos.getX();
            blockPosY = blockPos.getY();
            blockPosZ = blockPos.getZ();
            System.out.println(blockPos);
            setCanBreak(false);
        }
        else if(player.isShiftKeyDown()) {
            blockPos = pos;
            System.out.println(blockPos);
            setCanBreak(false);
        }
        else {
            setCanBreak(true);
        }
        return false;
    }

    public void setCanBreak(Boolean pCanBreak) {
        if(pCanBreak) {
            canBreak = true;
            System.out.println("Can Break: " + true);
            System.out.println("Has Selected: " + hasSelected);
        }
        else {
            canBreak = false;
            hasSelected = true;
            System.out.println("Can Break: " + false);
            System.out.println("Has Selected: " + hasSelected);
        }
    }

    @Override
    public boolean canAttackBlock(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer) {
        return canBreak;
    }

}
