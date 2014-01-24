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

/**
 * The type of the nodes which allow us to represent the Abstract Syntax Tree of
 * the intermediate language.
 */

public abstract class Node {
	/**
	 * The string representation of this node. It is used to generate the code
	 * for the target language.
	 * 
	 * @return the code generated by this node for the selected language.
	 */

	/**
	 * This forces to override the toString; by forcing to override
	 * callGetCode(). See wiki, Nitty Gritty details for more explanations.
	 */
	@Override
	final public String toString() {
		return callGetCode();
	}

	/**
	 * This forces that each leaf of the abstract GOOL tree makes a
	 * getCode(this). So that the visitor generates code specifically for it.
	 * See wiki, Nitty Gritty details for more explanations.
	 * 
	 * @return
	 */
	public abstract String callGetCode();
}
