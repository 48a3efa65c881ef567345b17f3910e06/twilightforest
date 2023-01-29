package twilightforest.structures.darktower;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureBoundingBox;

import twilightforest.structures.lichtower.ComponentTFTowerWing;

public class ComponentTFDarkTowerRoofCactus extends ComponentTFDarkTowerRoof {

    public ComponentTFDarkTowerRoofCactus() {
        super();
        // TODO Auto-generated constructor stub
    }

    public ComponentTFDarkTowerRoofCactus(int i, ComponentTFTowerWing wing) {
        super(i, wing);
    }

    /**
     * cactussy thing
     */
    @Override
    public boolean addComponentParts(World world, Random rand, StructureBoundingBox sbb) {
        super.addComponentParts(world, rand, sbb);

        // antenna
        for (int y = 1; y < 10; y++) {
            placeBlockAtCurrentPosition(world, deco.blockID, deco.blockMeta, size / 2, y, size / 2, sbb);
        }
        placeBlockAtCurrentPosition(world, deco.accentID, deco.accentMeta, size / 2, 10, size / 2, sbb);

        placeBlockAtCurrentPosition(world, deco.accentID, deco.accentMeta, size / 2 - 1, 1, size / 2, sbb);
        placeBlockAtCurrentPosition(world, deco.accentID, deco.accentMeta, size / 2 + 1, 1, size / 2, sbb);
        placeBlockAtCurrentPosition(world, deco.accentID, deco.accentMeta, size / 2, 1, size / 2 - 1, sbb);
        placeBlockAtCurrentPosition(world, deco.accentID, deco.accentMeta, size / 2, 1, size / 2 + 1, sbb);

        // cactus things
        placeBlockAtCurrentPosition(world, deco.accentID, deco.accentMeta, size / 2 + 1, 7, size / 2, sbb);
        placeBlockAtCurrentPosition(world, deco.accentID, deco.accentMeta, size / 2 + 2, 7, size / 2, sbb);
        placeBlockAtCurrentPosition(world, deco.accentID, deco.accentMeta, size / 2 + 2, 8, size / 2, sbb);
        placeBlockAtCurrentPosition(world, deco.accentID, deco.accentMeta, size / 2 + 2, 9, size / 2, sbb);
        placeBlockAtCurrentPosition(world, deco.accentID, deco.accentMeta, size / 2 + 3, 9, size / 2, sbb);

        placeBlockAtCurrentPosition(world, deco.accentID, deco.accentMeta, size / 2, 6, size / 2 + 1, sbb);
        placeBlockAtCurrentPosition(world, deco.accentID, deco.accentMeta, size / 2, 6, size / 2 + 2, sbb);
        placeBlockAtCurrentPosition(world, deco.accentID, deco.accentMeta, size / 2, 7, size / 2 + 2, sbb);
        placeBlockAtCurrentPosition(world, deco.accentID, deco.accentMeta, size / 2, 8, size / 2 + 2, sbb);
        placeBlockAtCurrentPosition(world, deco.accentID, deco.accentMeta, size / 2, 8, size / 2 + 3, sbb);

        placeBlockAtCurrentPosition(world, deco.accentID, deco.accentMeta, size / 2 - 1, 5, size / 2, sbb);
        placeBlockAtCurrentPosition(world, deco.accentID, deco.accentMeta, size / 2 - 2, 5, size / 2, sbb);
        placeBlockAtCurrentPosition(world, deco.accentID, deco.accentMeta, size / 2 - 2, 6, size / 2, sbb);
        placeBlockAtCurrentPosition(world, deco.accentID, deco.accentMeta, size / 2 - 2, 7, size / 2, sbb);
        placeBlockAtCurrentPosition(world, deco.accentID, deco.accentMeta, size / 2 - 3, 7, size / 2, sbb);

        placeBlockAtCurrentPosition(world, deco.accentID, deco.accentMeta, size / 2, 4, size / 2 - 1, sbb);
        placeBlockAtCurrentPosition(world, deco.accentID, deco.accentMeta, size / 2, 4, size / 2 - 2, sbb);
        placeBlockAtCurrentPosition(world, deco.accentID, deco.accentMeta, size / 2, 5, size / 2 - 2, sbb);
        placeBlockAtCurrentPosition(world, deco.accentID, deco.accentMeta, size / 2, 6, size / 2 - 2, sbb);
        placeBlockAtCurrentPosition(world, deco.accentID, deco.accentMeta, size / 2, 6, size / 2 - 3, sbb);

        return true;
    }
}
