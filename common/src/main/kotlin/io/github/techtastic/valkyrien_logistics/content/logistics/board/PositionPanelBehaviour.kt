package io.github.techtastic.valkyrien_logistics.content.logistics.board

import com.simibubi.create.content.logistics.factoryBoard.FactoryPanelBlock
import com.simibubi.create.content.logistics.factoryBoard.FactoryPanelBlockEntity
import dev.engine_room.flywheel.lib.model.baked.PartialModel
import io.github.techtastic.valkyrien_logistics.registry.VLItems
import io.github.techtastic.valkyrien_logistics.registry.VLPartialModels
import net.liukrast.eg.api.logistics.board.PanelConnection
import net.liukrast.eg.api.registry.PanelType
import net.liukrast.eg.content.logistics.board.ScrollOptionPanelBehaviour
import net.liukrast.eg.registry.EGPanelConnections
import net.minecraft.network.chat.Component
import net.minecraft.world.item.Item
import org.valkyrienskies.core.util.x
import org.valkyrienskies.core.util.y
import org.valkyrienskies.core.util.z
import org.valkyrienskies.mod.common.getShipObjectManagingPos


class PositionPanelBehaviour(type: PanelType<*>, be: FactoryPanelBlockEntity, slot: FactoryPanelBlock.PanelSlot): ScrollOptionPanelBehaviour<VectorSelectionMode>(
    Component.translatable("create.logistics.position_panel"), type, be, slot, VectorSelectionMode::class.java
) {
    private fun <T> getConnection(field: String): PanelConnection<T>? {
        try {
            val instance = EGPanelConnections::class.java.getField(field)
            val get = Class.forName("net.minecraftforge.registries.RegistryObject").getMethod("get")
            return get.invoke(instance.get(null)) as PanelConnection<T>
        } catch (_: Exception) {}
        return null
    }

    override fun addConnections(builder: PanelConnectionBuilder) {
        getConnection<Int>("INTEGER")?.let {
            builder.put(it) {
                val ship = world.getShipObjectManagingPos(pos)
                when(get()) {
                    VectorSelectionMode.X -> ship?.transform?.positionInWorld?.x?.toInt() ?: pos.x
                    VectorSelectionMode.Y -> ship?.transform?.positionInWorld?.y?.toInt() ?: pos.y
                    VectorSelectionMode.Z -> ship?.transform?.positionInWorld?.z?.toInt() ?: pos.z
                    else -> 0
                }
            }
        }
    }

    override fun getItem(): Item = VLItems.POSITION_GAUGE.get()

    override fun getModel(panelState: FactoryPanelBlock.PanelState, panelType: FactoryPanelBlock.PanelType): PartialModel =
        when(get()) {
            VectorSelectionMode.Y -> VLPartialModels.VECTOR_Y_PANEL
            VectorSelectionMode.Z -> VLPartialModels.VECTOR_Z_PANEL
            else -> VLPartialModels.VECTOR_X_PANEL
        }

    override fun shouldRenderBulb(original: Boolean): Boolean {
        return world.getShipObjectManagingPos(pos) != null
    }
}

