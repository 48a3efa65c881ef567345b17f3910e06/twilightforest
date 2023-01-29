package twilightforest.structures.minotaurmaze;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureBoundingBox;

public class ComponentTFMazeDeadEndShrooms extends ComponentTFMazeDeadEndRoots {

    public ComponentTFMazeDeadEndShrooms() {
        super();
        // TODO Auto-generated constructor stub
    }

    public ComponentTFMazeDeadEndShrooms(int i, int x, int y, int z, int rotation) {
        super(i, x, y, z, rotation);
    }

    @Override
    public boolean addComponentParts(World world, Random rand, StructureBoundingBox sbb) {
        // no door

        // mycelium & mushrooms going back
        for (int x = 1; x < 5; x++) {
            for (int z = 0; z < 5; z++) {
                if (rand.nextInt(z + 2) > 0) {
                    this.placeBlockAtCurrentPosition(world, Blocks.mycelium, 0, x, 0, z, sbb);
                }
                if (rand.nextInt(z + 2) > 0) {
                    this.placeBlockAtCurrentPosition(
                            world,
                            rand.nextBoolean() ? Blocks.red_mushroom : Blocks.brown_mushroom,
                            0,
                            x,
                            1,
                            z,
                            sbb);
                }
            }
        }

        // brackets?
        Block mushType = rand.nextBoolean() ? Blocks.red_mushroom_block : Blocks.brown_mushroom_block;
        int mushY = rand.nextInt(4) + 1;
        int mushZ = rand.nextInt(3) + 1;
        this.placeBlockAtCurrentPosition(world, mushType, 15, 1, mushY - 1, mushZ, sbb);
        this.fillWithMetadataBlocks(world, sbb, 1, 1, mushZ, 1, mushY, mushZ, mushType, 10, Blocks.air, 0, false);
        this.fillWithMetadataBlocks(
                world,
                sbb,
                1,
                mushY,
                mushZ - 1,
                2,
                mushY,
                mushZ + 1,
                mushType,
                14,
                Blocks.air,
                0,
                false);

        mushType = mushType == Blocks.brown_mushroom_block ? Blocks.red_mushroom_block : Blocks.brown_mushroom_block;
        mushY = rand.nextInt(4) + 1;
        mushZ = rand.nextInt(3) + 1;
        this.fillWithMetadataBlocks(world, sbb, 4, 1, mushZ, 4, mushY, mushZ, mushType, 10, Blocks.air, 0, false);
        this.fillWithMetadataBlocks(
                world,
                sbb,
                3,
                mushY,
                mushZ - 1,
                4,
                mushY,
                mushZ + 1,
                mushType,
                14,
                Blocks.air,
                0,
                false);

        mushType = rand.nextBoolean() ? Blocks.red_mushroom_block : Blocks.brown_mushroom_block;
        mushY = rand.nextInt(4) + 1;
        int mushX = rand.nextInt(3) + 2;
        this.fillWithMetadataBlocks(world, sbb, mushX, 1, 4, mushX, mushY, 4, mushType, 10, Blocks.air, 0, false);
        this.fillWithMetadataBlocks(
                world,
                sbb,
                mushX - 1,
                mushY,
                3,
                mushX + 1,
                mushY,
                4,
                mushType,
                14,
                Blocks.air,
                0,
                false);

        return true;
    }
}
