package twilightforest.structures.minotaurmaze;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import twilightforest.block.TFBlocks;

public class ComponentTFMazeRoomFountain extends ComponentTFMazeRoom {

    public ComponentTFMazeRoomFountain() {
        super();
        // TODO Auto-generated constructor stub
    }

    public ComponentTFMazeRoomFountain(int i, Random rand, int x, int y, int z) {
        super(i, rand, x, y, z);
    }

    @Override
    public boolean addComponentParts(World world, Random rand, StructureBoundingBox sbb) {
        super.addComponentParts(world, rand, sbb);

        this.fillWithMetadataBlocks(world, sbb, 5, 1, 5, 10, 1, 10, TFBlocks.mazestone, 3, Blocks.air, 0, false);
        this.fillWithBlocks(world, sbb, 6, 1, 6, 9, 1, 9, Blocks.water, Blocks.air, false);

        return true;
    }
}
