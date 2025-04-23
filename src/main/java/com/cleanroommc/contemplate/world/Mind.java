package com.cleanroommc.contemplate.world;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.Biome;

import javax.annotation.Nullable;
import java.util.Arrays;

public class Mind implements IBlockAccess {

    public static Mind create(int dimensionSize) {
        return new Mind(dimensionSize);
    }

    public static Mind create(int dimensionSize, IBlockState base) {
        Mind world = new Mind(dimensionSize);
        for (int x = 0; x < dimensionSize; x++) {
            for (int z = 0; z < dimensionSize; z++) {
                BlockPos pos = new BlockPos(x, 0, z);
                BlockSpace baseBlockSpace = new BlockSpace();
                baseBlockSpace.pos = pos;
                baseBlockSpace.state = Blocks.GRASS.getDefaultState();
                world.blocks[world.index(new BlockPos(x, 0, z))] = baseBlockSpace;
            }
        }
        return world;
    }

    private final int gridSize;
    private final BlockSpace[] blocks;
    private final WorldMimicProperties mimicProperties = WorldMimicProperties.overworld(); // TODO

    private Mind(int gridSize) {
        this.gridSize = gridSize;
        this.blocks = new BlockSpace[gridSize * gridSize * gridSize];
        Arrays.fill(blocks, BlockSpace.EMPTY);
    }

    @Nullable
    @Override
    public TileEntity getTileEntity(BlockPos pos) {
        return block(pos).tile;
    }

    // TODO
    @Override
    public int getCombinedLight(BlockPos pos, int lightValue) {
        return 15;
//      These end up calling chunk#getLightFor
//      int i = this.getLightFromNeighborsFor(EnumSkyBlock.SKY, pos);
//      int j = this.getLightFromNeighborsFor(EnumSkyBlock.BLOCK, pos);
//
//      if (j < lightValue)
//      {
//          j = lightValue;
//      }
//
//      return i << 20 | j << 4;
    }

    @Override
    public IBlockState getBlockState(BlockPos pos) {
        return block(pos).state;
    }

    @Override
    public boolean isAirBlock(BlockPos pos) {
        IBlockState state = block(pos).state;
        return state.getBlock().isAir(state, this, pos);
    }

    @Override
    public Biome getBiome(BlockPos pos) {
        return block(pos).biome;
    }

    @Override
    public int getStrongPower(BlockPos pos, EnumFacing side) {
        IBlockState state = block(pos).state;
        return state.getBlock().getStrongPower(state, this, pos, side);
    }

    @Override
    public WorldType getWorldType() {
        return WorldType.DEFAULT;
    }

    @Override
    public boolean isSideSolid(BlockPos pos, EnumFacing side, boolean _default) {
        IBlockState state = block(pos).state;
        return state.getBlock().isSideSolid(state, this, pos, side);
    }

    private BlockSpace block(BlockPos pos) {
        return this.blocks[index(pos)];
    }

    private int index(BlockPos pos) {
        return (pos.getY() * this.gridSize + pos.getZ()) * this.gridSize + pos.getX();
    }

}
