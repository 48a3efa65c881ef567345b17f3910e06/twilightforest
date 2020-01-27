package twilightforest.structures.minotaurmaze;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureBoundingBox;

public class ComponentTFMazeMushRoom extends ComponentTFMazeRoom {

    public ComponentTFMazeMushRoom() {
        super();
        // TODO Auto-generated constructor stub
    }

    public ComponentTFMazeMushRoom(int i, Random rand, int x, int y, int z) {
        super(i, rand, x, y, z);

        this.coordBaseMode = 0; // let's just make this easy on us?
    }

    @Override
    public boolean addComponentParts(World world, Random rand, StructureBoundingBox sbb) {
        super.addComponentParts(world, rand, sbb);

        for (int x = 1; x < 14; x++) {
            for (int z = 1; z < 14; z++) {
                // calculate distance from middle
                int dist = (int) Math.round(7 / Math.sqrt((7.5 - x) * (7.5 - x) + (7.5 - z) * (7.5 - z)));

                // make part of the floor mycelium
                if (rand.nextInt(dist + 1) > 0) {
                    this.placeBlockAtCurrentPosition(world, Blocks.mycelium, 0, x, 0, z, sbb);
                }
                // add small mushrooms all over
                if (rand.nextInt(dist) > 0) {
                    this.placeBlockAtCurrentPosition(world, rand.nextBoolean() ? Blocks.red_mushroom : Blocks.brown_mushroom, 0, x, 1, z, sbb);
                }
            }
        }

        // add our medium mushrooms
        makeMediumMushroom(world, sbb, 5, 2, 9, Blocks.red_mushroom_block);
        makeMediumMushroom(world, sbb, 5, 3, 9, Blocks.red_mushroom_block);
        makeMediumMushroom(world, sbb, 9, 2, 5, Blocks.red_mushroom_block);
        makeMediumMushroom(world, sbb, 6, 3, 4, Blocks.brown_mushroom_block);
        makeMediumMushroom(world, sbb, 10, 1, 9, Blocks.brown_mushroom_block);

        // bracket mushrooms on the wall
        this.placeBlockAtCurrentPosition(world, Blocks.red_mushroom_block, 15, 1, 2, 1, sbb);
        this.placeBlockAtCurrentPosition(world, Blocks.red_mushroom_block, 5, 1, 3, 1, sbb);
        this.placeBlockAtCurrentPosition(world, Blocks.red_mushroom_block, 9, 2, 3, 1, sbb);
        this.placeBlockAtCurrentPosition(world, Blocks.red_mushroom_block, 9, 1, 3, 2, sbb);

        this.placeBlockAtCurrentPosition(world, Blocks.brown_mushroom_block, 15, 14, 3, 1, sbb);
        this.placeBlockAtCurrentPosition(world, Blocks.brown_mushroom_block, 5, 14, 4, 1, sbb);
        this.placeBlockAtCurrentPosition(world, Blocks.brown_mushroom_block, 7, 13, 4, 1, sbb);
        this.placeBlockAtCurrentPosition(world, Blocks.brown_mushroom_block, 7, 14, 4, 2, sbb);

        this.placeBlockAtCurrentPosition(world, Blocks.brown_mushroom_block, 15, 1, 1, 14, sbb);
        this.placeBlockAtCurrentPosition(world, Blocks.brown_mushroom_block, 5, 1, 2, 14, sbb);
        this.placeBlockAtCurrentPosition(world, Blocks.brown_mushroom_block, 3, 2, 2, 14, sbb);
        this.placeBlockAtCurrentPosition(world, Blocks.brown_mushroom_block, 3, 1, 2, 13, sbb);

        this.placeBlockAtCurrentPosition(world, Blocks.brown_mushroom_block, 5, 14, 1, 14, sbb);
        this.placeBlockAtCurrentPosition(world, Blocks.brown_mushroom_block, 1, 13, 1, 14, sbb);
        this.placeBlockAtCurrentPosition(world, Blocks.brown_mushroom_block, 1, 14, 1, 13, sbb);

        // mushroom ceiling spots?

        return true;
    }

    /**
     * Make a 3x3 square mushroom centered on the specified coords.
     */
    private void makeMediumMushroom(World world, StructureBoundingBox sbb, int mx, int my, int mz, Block redMushroomBlock) {
        // cap
        this.placeBlockAtCurrentPosition(world, redMushroomBlock, 5, mx + 0, my, mz + 0, sbb);
        this.placeBlockAtCurrentPosition(world, redMushroomBlock, 6, mx + 1, my, mz + 0, sbb);
        this.placeBlockAtCurrentPosition(world, redMushroomBlock, 9, mx + 1, my, mz + 1, sbb);
        this.placeBlockAtCurrentPosition(world, redMushroomBlock, 8, mx + 0, my, mz + 1, sbb);
        this.placeBlockAtCurrentPosition(world, redMushroomBlock, 7, mx - 1, my, mz + 1, sbb);
        this.placeBlockAtCurrentPosition(world, redMushroomBlock, 4, mx - 1, my, mz + 0, sbb);
        this.placeBlockAtCurrentPosition(world, redMushroomBlock, 1, mx - 1, my, mz - 1, sbb);
        this.placeBlockAtCurrentPosition(world, redMushroomBlock, 2, mx + 0, my, mz - 1, sbb);
        this.placeBlockAtCurrentPosition(world, redMushroomBlock, 3, mx + 1, my, mz - 1, sbb);

        // stem
        for (int y = 1; y < my; y++) {
            this.placeBlockAtCurrentPosition(world, redMushroomBlock, 10, mx + 0, y, mz + 0, sbb);
        }
    }
}
