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
import net.minecraft.nbt.CompoundTag
import net.minecraft.network.chat.Component
import net.minecraft.network.chat.MutableComponent
import net.minecraft.server.level.ServerLevel
import net.minecraft.world.item.Item
import org.valkyrienskies.mod.common.getShipManagingPos

class MassPanelBehaviour(panelType: PanelType<*>, fpbe: FactoryPanelBlockEntity, panelSlot: PanelSlot): AbstractPanelBehaviour(panelType, fpbe, panelSlot) {
    var mass = 0.0

    init {
        this.onlyActiveWhen { world.getShipManagingPos(pos) != null }
    }

    override fun addConnections(builder: PanelConnectionBuilder) {
        ReflectionStuffs.getConnection<Int>("INTEGER")?.let {
            builder.put(it) { mass.toInt() }
        }
        ReflectionStuffs.getConnection<String>("STRING")?.let {
            builder.put(it) { mass.toString() }
        }
    }

    override fun getItem(): Item = VLItems.MASS_GAUGE.get()

    override fun getModel(panelState: FactoryPanelBlock.PanelState, panelType: FactoryPanelBlock.PanelType): PartialModel =
        VLPartialModels.MASS_PANEL

    override fun tick() {
        super.tick()
        (world as? ServerLevel)?.let { level ->
            val newMass = level.getShipManagingPos(pos)?.inertiaData?.mass ?: 0.0
            if (newMass == mass)
                return
            mass = newMass
            blockEntity.notifyUpdate()
        }
    }

    override fun easyRead(nbt: CompoundTag, clientPacket: Boolean) {
        super.easyRead(nbt, clientPacket)
        mass = nbt.getDouble("Mass")
    }

    override fun easyWrite(nbt: CompoundTag, clientPacket: Boolean) {
        super.easyWrite(nbt, clientPacket)
        nbt.putDouble("Mass", mass)
    }

    override fun getDisplayLinkComponent(shortenNumbers: Boolean): MutableComponent {
        return Component.literal(mass.toString())
    }
}