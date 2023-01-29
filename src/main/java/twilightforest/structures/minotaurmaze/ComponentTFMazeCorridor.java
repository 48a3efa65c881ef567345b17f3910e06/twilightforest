package twilightforest.structures.minotaurmaze;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureBoundingBox;

import twilightforest.structures.StructureTFComponent;

public class ComponentTFMazeCorridor extends StructureTFComponent {

    public ComponentTFMazeCorridor() {
        super();
        // TODO Auto-generated constructor stub
    }

    public ComponentTFMazeCorridor(int i, int x, int y, int z, int rotation) {
        super(i);
        this.coordBaseMode = rotation;
        this.boundingBox = new StructureBoundingBox(x, y, z, x + 5, y + 5, z + 5);
    }

    @Override
    public boolean addComponentParts(World world, Random rand, StructureBoundingBox sbb) {

        // arch
        this.fillWithMetadataBlocks(world, sbb, 1, 1, 2, 4, 4, 3, Blocks.fence, 0, Blocks.air, 0, false);
        this.fillWithAir(world, sbb, 2, 1, 2, 3, 3, 3);

        return true;
    }

}
