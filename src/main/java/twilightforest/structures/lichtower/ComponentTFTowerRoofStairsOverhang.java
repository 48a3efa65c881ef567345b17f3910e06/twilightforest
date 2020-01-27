package twilightforest.structures.lichtower;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureBoundingBox;

public class ComponentTFTowerRoofStairsOverhang extends ComponentTFTowerRoof {

    public ComponentTFTowerRoofStairsOverhang() {
        super();
        // TODO Auto-generated constructor stub
    }

    public ComponentTFTowerRoofStairsOverhang(int i, ComponentTFTowerWing wing) {
        super(i, wing);

        // always facing = 0. This roof cannot rotate, due to stair facing issues.
        this.setCoordBaseMode(0);

        this.size = wing.size + 2; // assuming only square towers and roofs right now.
        this.height = size / 2;

        // just hang out at the very top of the tower
        this.boundingBox = new StructureBoundingBox(wing.getBoundingBox().minX - 1, wing.getBoundingBox().maxY, wing.getBoundingBox().minZ - 1, wing.getBoundingBox().maxX + 1,
                wing.getBoundingBox().maxY + this.height - 1, wing.getBoundingBox().maxZ + 1);

    }

    /**
     * Makes a pyramid-shaped roof out of stairs
     */
    @Override
    public boolean addComponentParts(World world, Random rand, StructureBoundingBox sbb) {
        for (int y = 0; y <= height; y++) {
            int min = y;
            int max = size - y - 1;
            for (int x = min; x <= max; x++) {
                for (int z = min; z <= max; z++) {
                    if (x == min) {
                        if (z == min || z == max) {
                            placeBlockAtCurrentPosition(world, Blocks.wooden_slab, 2, x, y, z, sbb);
                        } else {
                            placeBlockAtCurrentPosition(world, Blocks.birch_stairs, 0, x, y, z, sbb);
                        }
                    } else if (x == max) {
                        if (z == min || z == max) {
                            placeBlockAtCurrentPosition(world, Blocks.wooden_slab, 2, x, y, z, sbb);
                        } else {
                            placeBlockAtCurrentPosition(world, Blocks.birch_stairs, 1, x, y, z, sbb);
                        }
                    } else if (z == max) {
                        placeBlockAtCurrentPosition(world, Blocks.birch_stairs, 3, x, y, z, sbb);
                    } else if (z == min) {
                        placeBlockAtCurrentPosition(world, Blocks.birch_stairs, 2, x, y, z, sbb);
                    } else {
                        placeBlockAtCurrentPosition(world, Blocks.planks, 2, x, y, z, sbb);
                    }
                }
            }
        }
        return true;
    }

}
