package twilightforest.entity.ai;

import net.minecraft.entity.ai.EntityAIBase;
import twilightforest.entity.EntityTFGoblinKnightLower;
import twilightforest.entity.EntityTFGoblinKnightUpper;

public class EntityAITFRiderSpearAttack extends EntityAIBase {

    private EntityTFGoblinKnightLower entity;

    public EntityAITFRiderSpearAttack(EntityTFGoblinKnightLower par1EntityCreature) {
        this.entity = par1EntityCreature;
        this.setMutexBits(7);
    }

    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    @Override
    public boolean shouldExecute() {
        return isRiderDoingSpearAttack();
    }

    public boolean isRiderDoingSpearAttack() {
        if (this.entity.riddenByEntity != null && this.entity.riddenByEntity instanceof EntityTFGoblinKnightUpper) {
            int timer = ((EntityTFGoblinKnightUpper) this.entity.riddenByEntity).heavySpearTimer;
            return timer > 0 && timer < 50;
        } else {
            return false;
        }
    }

    /**
     * Returns whether an in-progress EntityAIBase should continue executing
     */
    @Override
    public boolean continueExecuting() {
        return isRiderDoingSpearAttack();
    }

}
