package com.cleanroommc.contemplate.world;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Biomes;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;

public class BlockSpace {

    static final BlockSpace EMPTY = new BlockSpace() {

        @Override
        void setBiome(Biome biome) {
            throw new UnsupportedOperationException("Can't apply to EMPTY BlockSpace");
        }

        @Override
        void setTile(TileEntity tile) {
            throw new UnsupportedOperationException("Can't apply to EMPTY BlockSpace");
        }

        @Override
        void setState(IBlockState state) {
            throw new UnsupportedOperationException("Can't apply to EMPTY BlockSpace");
        }

        @Override
        void setPos(BlockPos pos) {
            throw new UnsupportedOperationException("Can't apply to EMPTY BlockSpace");
        }

    };

    BlockPos pos = BlockPos.ORIGIN;
    IBlockState state = Blocks.AIR.getDefaultState();
    TileEntity tile = null;
    Biome biome = Biomes.PLAINS;

    void setPos(BlockPos pos) {
        this.pos = pos;
    }

    void setState(IBlockState state) {
        this.state = state;
    }

    void setTile(TileEntity tile) {
        this.tile = tile;
    }

    void setBiome(Biome biome) {
        this.biome = biome;
    }

}
