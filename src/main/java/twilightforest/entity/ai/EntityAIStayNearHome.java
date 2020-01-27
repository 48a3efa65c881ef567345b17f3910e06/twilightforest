package twilightforest.entity.ai;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.RandomPositionGenerator;
import net.minecraft.util.Vec3;

public class EntityAIStayNearHome extends EntityAIBase {

    private EntityCreature entity;
    private float speed;

    public EntityAIStayNearHome(EntityCreature entityTFYetiAlpha, float sp) {
        this.entity = entityTFYetiAlpha;
        this.speed = sp;
        this.setMutexBits(1);

    }

    @Override
    public boolean shouldExecute() {
        boolean isOutOfRange = !this.entity.isWithinHomeDistanceCurrentPosition();

//		if (isOutOfRange) {
//			System.out.println("This creature is outside home range, moving home!");
//		} else {
//			System.out.println("This creature is inside home range");
//		}

        return isOutOfRange;
    }

    /**
     * Returns whether an in-progress EntityAIBase should continue executing
     */
    public boolean continueExecuting() {
        return !this.entity.getNavigator().noPath();
    }

//	/**
//	 * Execute a one shot task or start executing a continuous task
//	 */
//	public void startExecuting()
//	{
//		this.entity.getNavigator().tryMoveToXYZ(this.entity.getHomePosition().posX, this.entity.getHomePosition().posY, this.entity.getHomePosition().posZ, this.speed);
//	}

    /**
     * Execute a one shot task or start executing a continuous task
     */
    public void startExecuting() {
        // this.insidePosX = -1;

        if (this.entity.getDistanceSq(this.entity.getHomePosition().posX, this.entity.getHomePosition().posY, this.entity.getHomePosition().posZ) > 256.0D) {
            Vec3 vec3 = RandomPositionGenerator.findRandomTargetBlockTowards(this.entity, 14, 3,
                    Vec3.createVectorHelper(this.entity.getHomePosition().posX + 0.5D, this.entity.getHomePosition().posY, this.entity.getHomePosition().posZ + 0.5D));

            if (vec3 != null) {
                this.entity.getNavigator().tryMoveToXYZ(vec3.xCoord, vec3.yCoord, vec3.zCoord, speed);
            }
        } else {
            this.entity.getNavigator().tryMoveToXYZ(this.entity.getHomePosition().posX + 0.5D, this.entity.getHomePosition().posY, this.entity.getHomePosition().posZ + 0.5D, speed);
        }
    }

}
