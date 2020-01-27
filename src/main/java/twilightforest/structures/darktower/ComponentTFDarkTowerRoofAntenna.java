package twilightforest.structures.darktower;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import twilightforest.structures.lichtower.ComponentTFTowerWing;

public class ComponentTFDarkTowerRoofAntenna extends ComponentTFDarkTowerRoof {

    public ComponentTFDarkTowerRoofAntenna() {
        super();
        // TODO Auto-generated constructor stub
    }

    public ComponentTFDarkTowerRoofAntenna(int i, ComponentTFTowerWing wing) {
        super(i, wing);
    }

    /**
     * Stick with a ball on top antenna
     */
    @Override
    public boolean addComponentParts(World world, Random rand, StructureBoundingBox sbb) {
        super.addComponentParts(world, rand, sbb);

        // antenna
        for (int y = 1; y < 10; y++) {
            placeBlockAtCurrentPosition(world, deco.accentID, deco.accentMeta, size / 2, y, size / 2, sbb);
        }

        placeBlockAtCurrentPosition(world, deco.accentID, deco.accentMeta, size / 2 - 1, 1, size / 2, sbb);
        placeBlockAtCurrentPosition(world, deco.accentID, deco.accentMeta, size / 2 + 1, 1, size / 2, sbb);
        placeBlockAtCurrentPosition(world, deco.accentID, deco.accentMeta, size / 2, 1, size / 2 - 1, sbb);
        placeBlockAtCurrentPosition(world, deco.accentID, deco.accentMeta, size / 2, 1, size / 2 + 1, sbb);

        for (int y = 7; y < 10; y++) {
            placeBlockAtCurrentPosition(world, deco.accentID, deco.accentMeta, size / 2 - 1, y, size / 2, sbb);
            placeBlockAtCurrentPosition(world, deco.accentID, deco.accentMeta, size / 2 + 1, y, size / 2, sbb);
            placeBlockAtCurrentPosition(world, deco.accentID, deco.accentMeta, size / 2, y, size / 2 - 1, sbb);
            placeBlockAtCurrentPosition(world, deco.accentID, deco.accentMeta, size / 2, y, size / 2 + 1, sbb);
        }

        placeBlockAtCurrentPosition(world, deco.accentID, deco.accentMeta, size / 2 - 1, 8, size / 2 - 1, sbb);
        placeBlockAtCurrentPosition(world, deco.accentID, deco.accentMeta, size / 2 - 1, 8, size / 2 + 1, sbb);
        placeBlockAtCurrentPosition(world, deco.accentID, deco.accentMeta, size / 2 + 1, 8, size / 2 - 1, sbb);
        placeBlockAtCurrentPosition(world, deco.accentID, deco.accentMeta, size / 2 + 1, 8, size / 2 + 1, sbb);

        return true;
    }

}
