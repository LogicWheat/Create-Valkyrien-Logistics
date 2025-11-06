package io.github.techtastic.valkyrien_logistics.content.logistics.board

import com.simibubi.create.content.logistics.factoryBoard.FactoryPanelBlock
import com.simibubi.create.content.logistics.factoryBoard.FactoryPanelBlockEntity
import dev.engine_room.flywheel.lib.model.baked.PartialModel
import io.github.techtastic.valkyrien_logistics.registry.VLItems
import io.github.techtastic.valkyrien_logistics.registry.VLPartialModels
import net.liukrast.eg.api.registry.PanelType
import net.minecraft.network.chat.Component
import net.minecraft.world.item.Item
import org.valkyrienskies.mod.common.getShipObjectManagingPos

class LinearVelocityPanelBehaviour(type: PanelType<*>, be: FactoryPanelBlockEntity, slot: FactoryPanelBlock.PanelSlot):
    VectorPanelBehaviour(Component.translatable("create.logistics.velocity_panel"), type, be, slot) {

    init {
        this.onlyActiveWhen { world.getShipObjectManagingPos(pos) != null }
    }

    override fun getOutput(): Int {
        val ship = world.getShipObjectManagingPos(pos)
        return when(get()) {
            VectorSelectionMode.X -> ship?.velocity?.x()?.toInt() ?: 0
            VectorSelectionMode.Y -> ship?.velocity?.y()?.toInt() ?: 0
            VectorSelectionMode.Z -> ship?.velocity?.z()?.toInt() ?: 0
            else -> 0
        }
    }

    override fun getItem(): Item = VLItems.LINEAR_VELOCITY_GAUGE.get()

    override fun getModel(panelState: FactoryPanelBlock.PanelState, panelType: FactoryPanelBlock.PanelType): PartialModel =
        VLPartialModels.LINEAR_VELOCITY_PANEL
}

