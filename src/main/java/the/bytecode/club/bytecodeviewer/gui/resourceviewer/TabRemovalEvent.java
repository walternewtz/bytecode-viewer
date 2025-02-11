package the.bytecode.club.bytecodeviewer.gui.resourceviewer;

import the.bytecode.club.bytecodeviewer.BytecodeViewer;
import the.bytecode.club.bytecodeviewer.gui.resourceviewer.viewer.ResourceViewer;

import java.awt.*;
import java.awt.event.ContainerEvent;
import java.awt.event.ContainerListener;

/***************************************************************************
 * Bytecode Viewer (BCV) - Java & Android Reverse Engineering Suite        *
 * Copyright (C) 2014 Kalen 'Konloch' Kinloch - http://bytecodeviewer.com  *
 *                                                                         *
 * This program is free software: you can redistribute it and/or modify    *
 *   it under the terms of the GNU General Public License as published by  *
 *   the Free Software Foundation, either version 3 of the License, or     *
 *   (at your option) any later version.                                   *
 *                                                                         *
 *   This program is distributed in the hope that it will be useful,       *
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of        *
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the         *
 *   GNU General Public License for more details.                          *
 *                                                                         *
 *   You should have received a copy of the GNU General Public License     *
 *   along with this program.  If not, see <http://www.gnu.org/licenses/>. *
 ***************************************************************************/

/**
 * @author Konloch
 * @since 6/24/2021
 */
public class TabRemovalEvent implements ContainerListener
{
	@Override
	public void componentAdded(ContainerEvent e) { }
	
	@Override
	public void componentRemoved(ContainerEvent e)
	{
		final Component c = e.getChild();
		
		if(!(c instanceof ResourceViewer))
			return;
		
		String workingName = ((ResourceViewer) c).resource.workingName;
		BytecodeViewer.viewer.workPane.openedTabs.remove(workingName);
	}
}
