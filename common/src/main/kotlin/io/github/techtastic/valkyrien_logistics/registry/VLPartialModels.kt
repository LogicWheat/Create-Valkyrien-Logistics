package io.github.techtastic.valkyrien_logistics.registry

import dev.engine_room.flywheel.lib.model.baked.PartialModel
import io.github.techtastic.valkyrien_logistics.ValkyrienLogistics
import net.minecraft.resources.ResourceLocation

object VLPartialModels {
    val POSITION_PANEL = PartialModel.of(ResourceLocation(ValkyrienLogistics.MOD_ID, "block/position_gauge"))
    val LINEAR_VELOCITY_PANEL = PartialModel.of(ResourceLocation(ValkyrienLogistics.MOD_ID, "block/linear_velocity_gauge"))
    val ANGULAR_VELOCITY_PANEL = PartialModel.of(ResourceLocation(ValkyrienLogistics.MOD_ID, "block/angular_velocity_gauge"))
    val ROTATION_PANEL = PartialModel.of(ResourceLocation(ValkyrienLogistics.MOD_ID, "block/rotation_gauge"))
    val MASS_PANEL = PartialModel.of(ResourceLocation(ValkyrienLogistics.MOD_ID, "block/mass_gauge"))
    val SLUG_PANEL = PartialModel.of(ResourceLocation(ValkyrienLogistics.MOD_ID, "block/slug_gauge"))
    val EULER_PANEL = PartialModel.of(ResourceLocation(ValkyrienLogistics.MOD_ID, "block/euler_gauge"))

    fun init() {}
}