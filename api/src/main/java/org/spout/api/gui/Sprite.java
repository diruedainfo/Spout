/*
 * This file is part of Spout.
 *
 * Copyright (c) 2011 Spout LLC <http://www.spout.org/>
 * Spout is licensed under the Spout License Version 1.
 *
 * Spout is free software: you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or (at your option)
 * any later version.
 *
 * In addition, 180 days after any changes are published, you can use the
 * software, incorporating those changes, under the terms of the MIT license,
 * as described in the Spout License Version 1.
 *
 * Spout is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE.  See the GNU Lesser General Public License for
 * more details.
 *
 * You should have received a copy of the GNU Lesser General Public License,
 * the MIT license and the Spout License Version 1 along with this program.
 * If not, see <http://www.gnu.org/licenses/> for the GNU Lesser General Public
 * License and see <http://spout.in/licensev1> for the full license, including
 * the MIT license.
 */
package org.spout.api.gui;

import java.awt.Color;
import java.util.List;

import org.spout.api.math.Rectangle;
import org.spout.api.model.mesh.Vertex;
import org.spout.api.render.RenderMaterial;
import org.spout.api.render.SpoutRenderMaterials;

/**
 * Contains render data for {@link Widget}s to be used by the
 * {@link GuiRenderer}. Multiple of these are returned to be rendered
 * for each Widget.
 *
 * @see org.spout.api.gui.Widget#getSprites()
 */
public class Sprite implements Comparable<Sprite> {
	private RenderMaterial material = SpoutRenderMaterials.GUI_COLOR;
	private Rectangle source = Rectangle.ZERO;
	private Rectangle sprite = Rectangle.ZERO;
	private int zIndex = 0;
	private Color color = Color.WHITE;

	/**
	 * Returns the {@link RenderMaterial} of the Sprite.
	 * This is used by the source {@link Rectangle} to obtain sub-images
	 * common for sprite-sheets.
	 *
	 * @see org.spout.api.gui.Sprite#getSource()
	 * @return material to render
	 */
	public RenderMaterial getMaterial() {
		return material;
	}

	/**
	 * Sets the {@link RenderMaterial} of the Sprite.
	 * This is used by the source {@link Rectangle} to obtain sub-images
	 * common for sprite-sheets.
	 *
	 * @see org.spout.api.gui.Sprite#getSource()
	 * @param material to render
	 */
	public void setMaterial(RenderMaterial material) {
		this.material = material;
	}

	/**
	 * Sets the bounds of the source of the render part. This is commonly used
	 * for sprite sheets and should be left at zero for simple colored
	 * rectangles.
	 *
	 * @param source of part
	 */
	public void setSource(Rectangle source) {
		this.source = source;
	}

	/**
	 * Returns the bounds of the source of the render part. This is commonly
	 * used for sprite sheets and should be left at zero for simple colored
	 * rectangles.
	 *
	 * @return source of part
	 */
	public Rectangle getSource() {
		return source;
	}

	/**
	 * Sets the bounds of the actual sprite of the render material. This is
	 * used for specifying the actual visible size of the render part.
	 *
	 * @param sprite of render part
	 */
	public void setSprite(Rectangle sprite) {
		this.sprite = sprite;
	}

	/**
	 * Returns the bounds of the actual sprite of the render material. This is
	 * used for specifying the actual visible size of the render part.
	 *
	 * @return sprite of render part
	 */
	public Rectangle getSprite() {
		return sprite;
	}

	/**
	 * Returns the layer that this should be rendered on. Something with a
	 * higher z-index will be rendered on top of something with a lower z-index
	 * and something with a lower z-index will be rendered under the higher
	 * z-index part.
	 *
	 * @param zIndex of part
	 */
	public void setZIndex(int zIndex) {
		this.zIndex = zIndex;
	}

	/**
	 * Returns the layer that this should be rendered on. Something with a
	 * higher z-index will be rendered on top of something with a lower z-index
	 * and something with a lower z-index will be rendered under the higher
	 * z-index part.
	 *
	 * @return z-index of part
	 */
	public int getZIndex() {
		return zIndex;
	}

	/**
	 * Returns the color of this part.
	 *
	 * @return color of part
	 */
	public Color getColor() {
		return color;
	}

	/**
	 * Sets the color of this part.
	 *
	 * @param color of part
	 */
	public void setColor(Color color) {
		this.color = color;
	}

	/**
	 * Returns the vertices used for rendering the part.
	 *
	 * @return vertices of part
	 */
	public List<Vertex> getVertices() {
		return null;
	}

	@Override
	public int compareTo(Sprite arg0) {
		return arg0.getZIndex() - getZIndex();
	}
}
