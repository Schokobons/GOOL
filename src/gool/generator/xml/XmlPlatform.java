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

package gool.generator.xml;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;

import gool.Settings;
import gool.executor.common.SpecificCompiler;
import gool.generator.common.CodePrinter;
import gool.generator.common.Platform;
import gool.generator.python.PythonPlatform;

public class XmlPlatform extends Platform {

	private final String outputDir = Settings.get("xml_out_dir");

	protected XmlPlatform(Collection<File> myFile) {
		super("XML", myFile);
	}

	@Override
	protected CodePrinter initializeCodeWriter() {
		return new XmlCodePrinter(new File(outputDir), myFileToCopy);
	}

	@Override
	protected SpecificCompiler initializeCompiler() {
		return null;
	}

	private static XmlPlatform instance = new XmlPlatform(myFileToCopy);

	public static XmlPlatform getInstance(Collection<File> myF) {
		myFileToCopy = myF;
		return instance;
	}

	public static XmlPlatform getInstance() {
		if (myFileToCopy == null) {
			myFileToCopy = new ArrayList<File>();
		}
		return instance;
	}

	public static void newInstance() {
		instance = new XmlPlatform(myFileToCopy);
	}

}
