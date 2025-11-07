package io.github.techtastic.valkyrien_logistics.content.logistics.board

import com.simibubi.create.content.logistics.factoryBoard.FactoryPanelBlock
import com.simibubi.create.content.logistics.factoryBoard.FactoryPanelBlockEntity
import dev.engine_room.flywheel.lib.model.baked.PartialModel
import io.github.techtastic.valkyrien_logistics.registry.VLItems
import io.github.techtastic.valkyrien_logistics.registry.VLPartialModels
import net.liukrast.eg.api.registry.PanelType
import net.minecraft.world.item.Item
import org.joml.Vector3d
import org.joml.Vector3dc
import org.valkyrienskies.mod.common.getShipManagingPos

class AngularVelocityPanelBehaviour(type: PanelType<*>, be: FactoryPanelBlockEntity, slot: FactoryPanelBlock.PanelSlot):
    Vector3PanelBehaviour(type, be, slot) {

    init {
        this.onlyActiveWhen { world.getShipManagingPos(pos) != null }
    }

    override fun getVector(): Vector3dc = world.getShipManagingPos(pos)?.omega ?: Vector3d()

    override fun getItem(): Item = VLItems.ANGULAR_VELOCITY_GAUGE.get()

    override fun getModel(panelState: FactoryPanelBlock.PanelState, panelType: FactoryPanelBlock.PanelType): PartialModel =
        VLPartialModels.ANGULAR_VELOCITY_PANEL
}

