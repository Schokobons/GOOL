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

import java.util.List;

import gool.generator.GoolGeneratorController;

/**
 * This captures the if statements of the intermediate language. Hence it is an
 * OOTStatement. Notice the type checking achieved through generics.
 */
public class Switch extends Statement {

	/**
	 * The expression to compare with case expression.
	 */
	private Expression expression;
	/**
	 * The list of casetrees.
	 */
	private List<Case> cases;

	/**
	 * @param expression
	 * @param cases
	 */
	public Switch(Expression expression, List<Case> cases) {
		this.expression = expression;
		this.cases = cases;
	}

	public Expression getExpression() {
		return expression;
	}

	public List<Case> getCases() {
		return cases;
	}

	@Override
	public String callGetCode() {
		return GoolGeneratorController.generator().getCode(this);
	}

}
