package twilightforest.structures.darktower;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import twilightforest.block.TFBlocks;
import twilightforest.structures.StructureTFComponent;
import twilightforest.structures.lichtower.ComponentTFTowerWing;

public class ComponentTFDarkTowerBeard extends StructureTFComponent {

    protected int size;
    protected int height;

    public ComponentTFDarkTowerBeard() {
        super();
    }

    public ComponentTFDarkTowerBeard(int i, ComponentTFTowerWing wing) {
        super(i);

        this.setCoordBaseMode(wing.getCoordBaseMode());
        this.size = wing.size;
        this.height = size / 2;

        // just hang out at the very bottom of the tower
        this.boundingBox = new StructureBoundingBox(wing.getBoundingBox().minX, wing.getBoundingBox().minY - this.height, wing.getBoundingBox().minZ, wing.getBoundingBox().maxX,
                wing.getBoundingBox().minY, wing.getBoundingBox().maxZ);

    }

    /**
     * Save to NBT
     */
    @Override
    protected void func_143012_a(NBTTagCompound par1NBTTagCompound) {
        super.func_143012_a(par1NBTTagCompound);

        par1NBTTagCompound.setInteger("beardSize", this.size);
        par1NBTTagCompound.setInteger("beardHeight", this.height);
    }

    /**
     * Load from NBT
     */
    @Override
    protected void func_143011_b(NBTTagCompound par1NBTTagCompound) {
        super.func_143011_b(par1NBTTagCompound);
        this.size = par1NBTTagCompound.getInteger("beardSize");
        this.height = par1NBTTagCompound.getInteger("beardHeight");
    }

    /**
     * Makes a dark tower type beard
     */
    @Override
    public boolean addComponentParts(World world, Random rand, StructureBoundingBox sbb) {
        makeDarkBeard(world, sbb, 0, 0, 0, size - 1, height - 1, size - 1);

        return true;
    }

    protected void makeDarkBeard(World world, StructureBoundingBox sbb, int minX, int minY, int minZ, int maxX, int maxY, int maxZ) {
        Block frameID = TFBlocks.towerWood;
        int frameMeta = 1;

        for (int x = minX; x <= maxX; x++) {
            for (int z = minZ; z <= maxZ; z++) {
                if (x == minX || x == maxX || z == minZ || z == maxZ) {
                    int length = Math.min(Math.abs(x - height) - 1, Math.abs(z - height) - 1);

                    if (length == height - 1) {
                        length++;
                    }

                    if (length == -1) {
                        length = 1;
                    }

                    for (int y = maxY; y >= height - length; y--) {
                        // wall
                        this.placeBlockAtCurrentPosition(world, frameID, frameMeta, x, y, z, sbb);
                    }
                }
            }
        }
    }
}
