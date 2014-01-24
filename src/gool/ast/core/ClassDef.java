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

import gool.ast.type.IType;
import gool.ast.type.TypeClass;
import gool.generator.GoolGeneratorController;
import gool.generator.common.CodeGeneratorNoVelocity;
import gool.generator.common.CodePrinter;
import gool.generator.common.Platform;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

/**
 * This captures classes in the intermediate language. For each object member of
 * ClassDef the compiler will have to generate a separate file containing the
 * code of the class in the target language.
 */
public class ClassDef extends Dependency {

	/**
	 * Class' dependencies (imports).
	 */
	private List<Dependency> dependencies = new ArrayList<Dependency>();

	/**
	 * Class' modifiers.
	 */
	private Collection<Modifier> modifiers = new HashSet<Modifier>();
	/**
	 * Class' name.
	 */
	private String name;

	/**
	 * List of fields.
	 */
	private List<Field> fields = new ArrayList<Field>();
	/**
	 * List of methods.
	 */
	private List<Meth> methods = new ArrayList<Meth>();
	/**
	 * List of implemented interfaces.
	 */
	private List<IType> interfaces = new ArrayList<IType>();
	/**
	 * Parent class.
	 */
	private IType parentClass;

	/**
	 * The class' type.
	 */
	private IType classType;

	private Platform platform;

	private boolean isInterface;

	private boolean isMainClass;
	
	private boolean isGoolLibraryClass;

	private Package ppackage;

	public ClassDef(Modifier modifier, String name, Platform platform) {
		this(name, platform);
		addModifier(modifier);
	}

	public ClassDef(String name) {
		this.name = name;
		setType(new TypeClass(name));
	}

	public ClassDef(String name, Platform platform) {
		this(name);
		this.platform = platform;
	}

	/**
	 * Adds a new class modifier.
	 * 
	 * @param modifier
	 *            the modifier to be added.
	 */
	public final void addModifier(Modifier modifier) {
		this.modifiers.add(modifier);
	}

	/**
	 * Appends the specified method to the list of methods.
	 * 
	 * @param method
	 *            method to be appended.
	 */
	public void addMethod(Meth method) {
		if (method instanceof Constructor) {
			method.setName(getName());
		} else if (method instanceof MainMeth) {
			setMainClass(true);
		}
		method.setClassDef(this);
		methods.add(method);
	}

	/**
	 * Appends the specified field to the list of fields.
	 * 
	 * @param field
	 *            field to be appended.
	 */
	public void addField(Field field) {
		fields.add(field);
	}

	/**
	 * Initializes the default constructor by using a list of undeclared
	 * variables.
	 * 
	 * @param freeVars
	 *            list of undeclared variables that are used inside the class.
	 * @return the default constructor.
	 */
	public Constructor createDefaultConstructor() {
		Constructor constructor = new Constructor();
		for (Field field : getFields()) {
			constructor.addParameter(new VarDeclaration(field));
			Assign assign = new Assign(new FieldAccess(field.getType(),
					new This(getType()), field.getName()), new VarAccess(field));
			constructor.addStatement(assign);
		}
		addMethod(constructor);

		return constructor;
	}

	/**
	 * Initializes the class' fields and adds a default constructor initializing
	 * those fields.
	 * 
	 * @param parameters
	 *            the list of undeclared variables that are used in the class.
	 * @return the default constructor.
	 */
	public void addFields(Collection<Dec> parameters) {
		for (Dec freeVar : parameters) {
			addField(new Field(Modifier.PRIVATE, freeVar.getName(),
					freeVar.getType()));
		}
	}

	public void setPpackage(Package ppackage) {
		this.ppackage = ppackage;
	}

	public Package getPpackage() {
		return ppackage;
	}

	public String getPackageName() {
		return ppackage == null ? "" : ppackage.getName();
	}

	/**
	 * Gets the list of modifiers.
	 * 
	 * @return a list of modifiers.
	 */
	public Collection<Modifier> getModifiers() {
		return modifiers;
	}

	/**
	 * Gets the class' name.
	 * 
	 * @return the class' name.
	 */
	public final String getName() {
		return name;
	}

	public final void setName(String name) {
		this.name = name;
	}

	public List<Constructor> getConstructors() {
		List<Constructor> constructors = new ArrayList<Constructor>();
		for (Meth m : methods) {
			if (m instanceof Constructor) {
				constructors.add((Constructor) m);
			}
		}
		return constructors;
	}

	public final boolean isInterface() {
		return isInterface;
	}

	public final void setIsInterface(boolean isInterface) {
		this.isInterface = isInterface;
	}

	/**
	 * Gets the platform.
	 * 
	 * @return
	 */
	public final Platform getPlatform() {
		return platform;
	}

	/**
	 * Assigns the platform of the current class.
	 * 
	 * @param platform
	 *            the platform to be assigned.
	 */
	public final void setPlatform(Platform platform) {
		this.platform = platform;
	}

	public final boolean isMainClass() {
		return isMainClass;
	}

	public final void setMainClass(boolean isMainClass) {
		this.isMainClass = isMainClass;
	}

	/**
	 * Gets the list of fields.
	 * 
	 * @return the list of fields.
	 */
	public final List<Field> getFields() {
		return fields;
	}

	/**
	 * Gets the list of methods defined in the class.
	 * 
	 * @return the list of methods.
	 */
	public final List<Meth> getMethods() {
		return methods;
	}

	/**
	 * Adds a new interface that should be implemented by the current class.
	 * 
	 * @param type
	 *            the type of the interface.
	 */
	public final void addInterface(IType type) {
		interfaces.add(type);
	}

	/**
	 * Sets the class to inherit from.
	 * 
	 * @param parentClass
	 *            the parent class.
	 */
	public final void setParentClass(IType parentClass) {
		this.parentClass = parentClass;
	}

	/**
	 * Gets the parent class.
	 * 
	 * @return the parent class.
	 */
	public final IType getParentClass() {
		return parentClass;
	}

	/**
	 * Gets the list of interfaces implemented by the class.
	 * 
	 * @return a list of interfaces implemented by the class.
	 */
	public final List<IType> getInterfaces() {
		return interfaces;
	}

	/**
	 * Generates the target code using the specific CodePrinter related to the
	 * class' platform.
	 * 
	 * Instead of concatenating strings, the code generation is implemented
	 * using velocity templates, unless the generator implements the interface
	 * CodeGeneratorNoVelocity.
	 * 
	 * @return the generated target code.
	 * @throws Exception
	 *             when velocity fails to render or find the relevant template.
	 */
	public String getCode() {
		CodePrinter printer = getPlatform().getCodePrinter();
		if (printer.getCodeGenerator() instanceof CodeGeneratorNoVelocity)
			return ((CodeGeneratorNoVelocity) printer.getCodeGenerator())
					.printClass(this);
		else
			return printer.processTemplate("class.vm", this);
	}

	public final void addField(String fieldName, IType type) {
		fields.add(new Field(Modifier.PRIVATE, fieldName, type));
	}

	public final IType getType() {
		return classType;
	}

	public final void addDependency(Dependency dependency) {
		if ((dependency instanceof TypeDependency)
				&& (((TypeDependency) dependency).getType() instanceof TypeClass)
				&& ((TypeClass) ((TypeDependency) dependency).getType())
						.getClassDef() != null
				&& ((TypeClass) ((TypeDependency) dependency).getType())
						.getClassDef().getPlatform() != null
				&& (!((TypeClass) ((TypeDependency) dependency).getType())
						.getClassDef().getPlatform().equals(getPlatform()))) {
			throw new IllegalArgumentException(
					"There should not be dependencies between classes of different platforms.");
		}

		if (dependency != null && !dependencies.contains(dependency)) {
			dependencies.add(0, dependency);
		}
	}

	public final List<Dependency> getDependencies() {
		return dependencies;
	}

	@Override
	public String callGetCode() {
		return GoolGeneratorController.generator().getCode(this);
	}

	public final Meth getMethod(String methName) {
		for (Meth method : methods) {
			if (method.getName().equals(methName)) {
				return method;
			}
		}
		;
		return null;
	}

	public final void setModifiers(Collection<Modifier> modifiers) {
		this.modifiers = modifiers;
	}

	public final void addDependencies(List<Dependency> dependencies) {
		for (Dependency dependency : dependencies) {
			addDependency(dependency);
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof ClassDef)) {
			return false;
		}
		return ((ClassDef) obj).getType().equals(getType());
	}

	@Override
	public int hashCode() {
		return getType().getName().hashCode();
	}

	public final void setType(IType type) {
		classType = type;
		if (type instanceof TypeClass) {
			((TypeClass) classType).setClassDef(this);
		}
	}

	public void setIsEnum(boolean isEnum) {
		if (classType instanceof TypeClass) {
			((TypeClass) classType).setIsEnum(isEnum);
		}
	}

	public boolean isEnum() {
		return (classType instanceof TypeClass)
				&& ((TypeClass) classType).isEnum();
	}
	
	public void setIsGoolLibraryClass(boolean isGoolLibraryClass) {
		this.isGoolLibraryClass = isGoolLibraryClass;
	}

	public boolean isGoolLibraryClass() {
		return this.isGoolLibraryClass;
	}
}
