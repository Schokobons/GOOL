/*
 * Copyright 2010 Pablo Arrighi, Alex Concha, Miguel Lezama for version 1.
 * Copyright 2013 Pablo Arrighi, Miguel Lezama, Kevin Mazet for version 2.    
 *
 * This file is part of GOOL.
 *
 * GOOL is free software: you can redistribute it and/or modify it under the terms of the GNU
 * General Public License as published by the Free Software Foundation, version 3.
 *
 * GOOL is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU General Public License version 3 for more details.
 *
 * You should have received a copy of the GNU General Public License along with GOOL,
 * in the file COPYING.txt.  If not, see <http://www.gnu.org/licenses/>.
 */

package gool.ast.core;

import com.sun.tools.javac.util.Name;

import gool.generator.GoolGeneratorController;

/**
 * This captures the if statements of the intermediate language. Hence it is an
 * OOTStatement. Notice the type checking achieved through generics.
 */
public class Break extends Statement {

	/**
	 * The condition expression.
	 */
	private Name name;
	
	/**
	 * @param condition
	 * @param statements
	 */
	public Break(Name name) {
		this.name = name;

	}

	public Name getLabel() {
		return name;
	}

	@Override
	public String callGetCode() {
		return GoolGeneratorController.generator().getCode(this);
	}

}
