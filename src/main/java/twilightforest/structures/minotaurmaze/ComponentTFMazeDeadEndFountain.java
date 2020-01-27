package twilightforest.structures.minotaurmaze;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import twilightforest.block.TFBlocks;

public class ComponentTFMazeDeadEndFountain extends ComponentTFMazeDeadEnd {

    public ComponentTFMazeDeadEndFountain() {
        super();
        // TODO Auto-generated constructor stub
    }

    public ComponentTFMazeDeadEndFountain(int i, int x, int y, int z, int rotation) {
        super(i, x, y, z, rotation);
    }

    @Override
    public boolean addComponentParts(World world, Random rand, StructureBoundingBox sbb) {
        // normal doorway
        super.addComponentParts(world, rand, sbb);

        // back wall brick
        this.fillWithMetadataBlocks(world, sbb, 1, 1, 4, 4, 4, 4, TFBlocks.mazestone, 1, Blocks.air, 0, false);

        // water
        this.placeBlockAtCurrentPosition(world, Blocks.flowing_water, 0, 2, 3, 4, sbb);
        this.placeBlockAtCurrentPosition(world, Blocks.flowing_water, 0, 3, 3, 4, sbb);

        // receptacle
        this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 2, 0, 3, sbb);
        this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 3, 0, 3, sbb);

        return true;
    }
}
