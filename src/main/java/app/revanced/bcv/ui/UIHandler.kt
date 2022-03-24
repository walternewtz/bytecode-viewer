package app.revanced.bcv.ui

import app.revanced.bcv.actions.GenerateSignatureAction
import the.bytecode.club.bytecodeviewer.decompilers.Decompiler
import the.bytecode.club.bytecodeviewer.gui.resourceviewer.BytecodeViewPanel
import javax.swing.JMenuItem
import javax.swing.JPopupMenu

object UIHandler {
    fun addMenuButtons(panel: BytecodeViewPanel, menu: JPopupMenu) {
        if (panel.decompiler != Decompiler.BYTECODE_DISASSEMBLER) return

        val generateSignatureItem = JMenuItem("Generate Signature")
        generateSignatureItem.addActionListener(GenerateSignatureAction(panel))
        menu.insert(generateSignatureItem, 0)
        menu.insert(JPopupMenu.Separator(), 1)
    }
}