package io.github.techtastic.valkyrien_logistics.content.logistics.board

import com.simibubi.create.content.logistics.factoryBoard.FactoryPanelBlock
import com.simibubi.create.content.logistics.factoryBoard.FactoryPanelBlock.PanelSlot
import com.simibubi.create.content.logistics.factoryBoard.FactoryPanelBlockEntity
import dev.engine_room.flywheel.lib.model.baked.PartialModel
import io.github.techtastic.valkyrien_logistics.registry.VLItems
import io.github.techtastic.valkyrien_logistics.registry.VLPartialModels
import io.github.techtastic.valkyrien_logistics.util.ReflectionStuffs
import net.liukrast.eg.api.logistics.board.AbstractPanelBehaviour
import net.liukrast.eg.api.registry.PanelType
import net.minecraft.network.chat.Component
import net.minecraft.network.chat.MutableComponent
import net.minecraft.world.item.Item
import org.valkyrienskies.mod.common.getShipManagingPos

class SlugPanelBehaviour(panelType: PanelType<*>, fpbe: FactoryPanelBlockEntity, panelSlot: PanelSlot): AbstractPanelBehaviour(panelType, fpbe, panelSlot) {
    init {
        this.onlyActiveWhen { world.getShipManagingPos(pos) != null }
    }

    override fun addConnections(builder: PanelConnectionBuilder) {
        ReflectionStuffs.getConnection<String>("STRING")?.let {
            builder.put(it) { world.getShipManagingPos(pos)?.slug ?: "" }
        }
    }

    override fun getItem(): Item = VLItems.SLUG_GAUGE.get()

    override fun getModel(panelState: FactoryPanelBlock.PanelState, panelType: FactoryPanelBlock.PanelType): PartialModel =
        VLPartialModels.SLUG_PANEL

    override fun getDisplayLinkComponent(shortenNumbers: Boolean): MutableComponent {
        return Component.literal(world.getShipManagingPos(pos)?.slug ?: "")
    }
}