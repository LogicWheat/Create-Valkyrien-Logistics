package io.github.techtastic.valkyrien_logistics.content.logistics.board

import com.simibubi.create.foundation.blockEntity.behaviour.scrollValue.INamedIconOptions
import com.simibubi.create.foundation.gui.AllIcons
import io.github.techtastic.valkyrien_logistics.VLIcons
import net.createmod.catnip.lang.Lang

enum class VectorSelectionMode(private val newIcon: AllIcons): INamedIconOptions {
    X(VLIcons.X),
    Y(VLIcons.Y),
    Z(VLIcons.Z);

    private val translationKey: String = "vector_gauge.${Lang.asId(this.name)}"

    override fun getIcon() = this.newIcon

    override fun getTranslationKey() = this.translationKey

}