/* Generated by JTB 1.4.4 */
package gool.parser.objc.jtb.visitor;

import gool.parser.objc.core.ObjCModifier;
import gool.parser.objc.jtb.core.*;

import java.util.*;


/*
This is the visitor who transform the objc tree to the simple objc tree
 */
public class DepthFirstRetArguVisitor<R, A> implements IRetArguVisitor<R, A> {

	public R visit(final NodeChoice n, final A argu) {
		final R nRes = (R) n.choice.accept(this, argu);
		return nRes;
	}

	public R visit(final NodeList n, final A argu) {
		R nRes = null;
		for (final Iterator<INode> e = n.elements(); e.hasNext();) {
			@SuppressWarnings("unused")
			final R sRes = (R) e.next().accept(this, argu);
		}
		return nRes;
	}

	public R visit(final NodeListOptional n, final A argu) {
		if (n.present()) {
			R nRes = null;
			for (final Iterator<INode> e = n.elements(); e.hasNext();) {
				@SuppressWarnings("unused")
				R sRes = (R) e.next().accept(this, argu);
			}
			return nRes;
		} else
			return null;
	}

	public R visit(final NodeOptional n, final A argu) {
		if (n.present()) {
			final R nRes = (R) n.node.accept(this, argu);
			return nRes;
		} else
			return null;
	}

	public R visit(final NodeSequence n, final A argu) {
		R nRes = null;
		for (final Iterator<INode> e = n.elements(); e.hasNext();) {
			@SuppressWarnings("unused")
			R subRet = (R) e.next().accept(this, argu);
		}
		return nRes;
	}

	public R visit(final NodeToken n, @SuppressWarnings("unused") final A argu) {
		R nRes = null;
		@SuppressWarnings("unused")
		final String tkIm = n.tokenImage;
		return nRes;
	}

	public R visit(final TranslationUnit n, final A argu) {
		R nRes = null;
		n.f0.accept(this, argu);
		return nRes;
	}

	public R visit(final ExternalDeclaration n, final A argu) {
		R nRes = null;
		n.f0.accept(this, argu);
		return nRes;
	}

	public R visit(final StrippedParens n, final A argu) {
		R nRes = null;
		n.f0.accept(this, argu);
		n.f1.accept(this, argu);
		n.f2.accept(this, argu);
		return nRes;
	}

	public R visit(final FunctionDefinition n, final A argu) {
		gool.parser.objc.core.ObjCFunctionDefinition fd = new gool.parser.objc.core.ObjCFunctionDefinition(null, null, null, null);
		gool.parser.objc.core.ObjCNoeud noeud = (gool.parser.objc.core.ObjCNoeud) (argu);
		noeud.addFils(fd);
		R nRes = null;
		n.f0.accept(this, (A) fd);
		n.f1.accept(this, (A) fd);
		n.f2.accept(this, (A) fd);
		n.f3.accept(this, (A) fd);
		return nRes;
	}

	public R visit(final Declaration n, final A argu) {
		gool.parser.objc.core.ObjCDeclaration de = new gool.parser.objc.core.ObjCDeclaration(null, null, null);
		gool.parser.objc.core.ObjCNoeud noeud = (gool.parser.objc.core.ObjCNoeud) (argu);
		noeud.addFils(de);
		R nRes = null;
		n.f0.accept(this, (A) de);
		n.f1.accept(this, (A) de);
		n.f2.accept(this, (A) de);
		n.f3.accept(this, (A) de);
		return nRes;
	}

	public R visit(final ClassInterface n, final A argu) {// TODO what is in n.f3, n.f4 and n.f5 ?
		gool.parser.objc.core.ObjCClassInterface ci = new gool.parser.objc.core.ObjCClassInterface(null, null, null, null);
		gool.parser.objc.core.ObjCNoeud noeud = (gool.parser.objc.core.ObjCNoeud) (argu);
		noeud.addFils(ci);
		R nRes = null;
		n.f0.accept(this, (A) ci);
		n.f1.accept(this, (A) ci);
		n.f2.accept(this, (A) ci);
		n.f3.accept(this, (A) ci);
		n.f4.accept(this, (A) ci);
		n.f5.accept(this, (A) ci);
		n.f6.accept(this, (A) ci);
		n.f7.accept(this, (A) ci);
		return nRes;
	}

	public R visit(final ClassImplementation n, final A argu) { // TODO what is in n.f2 and n.f3 ?
		gool.parser.objc.core.ObjCClassImplementation ci = new gool.parser.objc.core.ObjCClassImplementation(null, null, null);
		gool.parser.objc.core.ObjCNoeud noeud = (gool.parser.objc.core.ObjCNoeud) (argu);
		noeud.addFils(ci);
		R nRes = null;
		n.f0.accept(this, (A) ci);
		n.f1.accept(this, (A) ci);
		n.f2.accept(this, (A) ci);
		n.f3.accept(this, (A) ci);
		n.f4.accept(this, (A) ci);
		n.f5.accept(this, (A) ci);
		return nRes;
	}

	public R visit(final CategoryInterface n, final A argu) {
		R nRes = null;
		n.f0.accept(this, argu);
		n.f1.accept(this, argu);
		n.f2.accept(this, argu);
		n.f3.accept(this, argu);
		n.f4.accept(this, argu);
		n.f5.accept(this, argu);
		n.f6.accept(this, argu);
		n.f7.accept(this, argu);
		return nRes;
	}

	public R visit(final CategoryImplementation n, final A argu) {
		R nRes = null;
		n.f0.accept(this, argu);
		n.f1.accept(this, argu);
		n.f2.accept(this, argu);
		n.f3.accept(this, argu);
		n.f4.accept(this, argu);
		n.f5.accept(this, argu);
		n.f6.accept(this, argu);
		return nRes;
	}

	public R visit(final ProtocolDeclaration n, final A argu) {
		R nRes = null;
		n.f0.accept(this, argu);
		n.f1.accept(this, argu);
		n.f2.accept(this, argu);
		n.f3.accept(this, argu);
		n.f4.accept(this, argu);
		return nRes;
	}

	public R visit(final ClassDeclarationList n, final A argu) {
		R nRes = null;
		n.f0.accept(this, argu);
		n.f1.accept(this, argu);
		n.f2.accept(this, argu);
		return nRes;
	}

	public R visit(final ClassList n, final A argu) {
		R nRes = null;
		n.f0.accept(this, argu);
		n.f1.accept(this, argu);
		return nRes;
	}

	public R visit(final ProtocolReferenceList n, final A argu) {
		R nRes = null;
		n.f0.accept(this, argu);
		n.f1.accept(this, argu);
		n.f2.accept(this, argu);
		n.f3.accept(this, argu);
		return nRes;
	}

	public R visit(final ProtocolList n, final A argu) {
		R nRes = null;
		n.f0.accept(this, argu);
		n.f1.accept(this, argu);
		return nRes;
	}

	public R visit(final ObjCIDENT n, final A argu) {
		gool.parser.objc.core.ObjCIDENT ob = new gool.parser.objc.core.ObjCIDENT(n.f0.choice.toString());
		gool.parser.objc.core.ObjCNoeud noeud = (gool.parser.objc.core.ObjCNoeud) (argu);
		noeud.addFils(ob);
		R nRes = null;
		n.f0.accept(this, (A) ob);
		return nRes;
	}

	public R visit(final ClassName n, final A argu) {
		R nRes = null;
		n.f0.accept(this, argu);
		return nRes;
	}

	public R visit(final SuperClassName n, final A argu) {
		if (n.f0 != null) {
			gool.parser.objc.core.ObjCSuperClassName sc = new gool.parser.objc.core.ObjCSuperClassName(n.f0.f0.choice.toString());
			gool.parser.objc.core.ObjCNoeud noeud = (gool.parser.objc.core.ObjCNoeud) (argu);
			noeud.addFils(sc);
			R nRes = null;
			n.f0.accept(this, (A) sc);
			return nRes;
		}
		R nRes = null;
		n.f0.accept(this, argu);
		return nRes;
	}

	public R visit(final ColonSuperClassName n, final A argu) {
		R nRes = null;
		n.f0.accept(this, argu);
		n.f1.accept(this, argu);
		return nRes;
	}

	public R visit(final CategoryName n, final A argu) {
		R nRes = null;
		n.f0.accept(this, argu);
		return nRes;
	}

	public R visit(final ProtocolName n, final A argu) {
		R nRes = null;
		n.f0.accept(this, argu);
		return nRes;
	}

	public R visit(final InstanceVariables n, final A argu) {
		R nRes = null;
		n.f0.accept(this, argu);
		n.f1.accept(this, argu);
		n.f2.accept(this, argu);
		n.f3.accept(this, argu);
		return nRes;
	}

	public R visit(final InstanceVariableDeclaration n, final A argu) {
		R nRes = null;
		n.f0.accept(this, argu);
		return nRes;
	}

	public R visit(final InstanceVariableDeclarator n, final A argu) {
		R nRes = null;
		n.f0.accept(this, argu);
		return nRes;
	}

	public R visit(final VisibilitySpecification n, final A argu) {
		R nRes = null;
		n.f0.accept(this, argu);
		return nRes;
	}

	public R visit(final IBOutlet n, final A argu) {
		R nRes = null;
		n.f0.accept(this, argu);
		return nRes;
	}

	public R visit(final ProtocolInterfaceDeclaration n, final A argu) {
		R nRes = null;
		n.f0.accept(this, argu);
		n.f1.accept(this, argu);
		return nRes;
	}

	public R visit(final QualifiedProtocolInterfaceDeclaration n, final A argu) {
		R nRes = null;
		n.f0.accept(this, argu);
		return nRes;
	}

	public R visit(final InterfaceDeclaration n, final A argu) {
		R nRes = null;
		n.f0.accept(this, argu);
		return nRes;
	}

	public R visit(final PropertyDeclaration n, final A argu) {
		R nRes = null;
		n.f0.accept(this, argu);
		n.f1.accept(this, argu);
		n.f2.accept(this, argu);
		return nRes;
	}

	public R visit(final PropertyAttributesDeclaration n, final A argu) {
		R nRes = null;
		n.f0.accept(this, argu);
		n.f1.accept(this, argu);
		n.f2.accept(this, argu);
		return nRes;
	}

	public R visit(final PropertyAttributesList n, final A argu) {
		R nRes = null;
		n.f0.accept(this, argu);
		n.f1.accept(this, argu);
		return nRes;
	}

	public R visit(final PropertyAttribute n, final A argu) {
		R nRes = null;
		n.f0.accept(this, argu);
		return nRes;
	}

	public R visit(final MethodDeclaration n, final A argu) {
		R nRes = null;
		n.f0.accept(this, argu);
		return nRes;
	}

	public R visit(final ClassMethodDeclaration n, final A argu) {
		if (n.f0.toString().equals("+")) {
			gool.parser.objc.core.ObjCMethodDeclaration me = new gool.parser.objc.core.ObjCMethodDeclaration(ObjCModifier.PUBLIC, null, null, null);
			gool.parser.objc.core.ObjCNoeud noeud = (gool.parser.objc.core.ObjCNoeud) (argu);
			noeud.addFils(me);
			R nRes = null;
			n.f0.accept(this, (A) me);
			n.f1.accept(this, (A) me);
			n.f2.accept(this, (A) me);
			n.f3.accept(this, (A) me);
			return nRes;
		}
		R nRes = null;
		n.f0.accept(this, argu);
		n.f1.accept(this, argu);
		n.f2.accept(this, argu);
		n.f3.accept(this, argu);
		return nRes;
	}

	public R visit(final InstanceMethodDeclaration n, final A argu) {
		if (n.f0.toString().equals("-")) {
			gool.parser.objc.core.ObjCMethodDeclaration me = new gool.parser.objc.core.ObjCMethodDeclaration(ObjCModifier.PRIVE, null, null, null);
			gool.parser.objc.core.ObjCNoeud noeud = (gool.parser.objc.core.ObjCNoeud) (argu);
			noeud.addFils(me);
			R nRes = null;
			n.f0.accept(this, (A) me);
			n.f1.accept(this, (A) me);
			n.f2.accept(this, (A) me);
			n.f3.accept(this, (A) me);
			return nRes;
		}
		R nRes = null;
		n.f0.accept(this, argu);
		n.f1.accept(this, argu);
		n.f2.accept(this, argu);
		n.f3.accept(this, argu);
		return nRes;
	}

	public R visit(final ImplementationDefinition n, final A argu) {
		R nRes = null;
		n.f0.accept(this, argu);
		return nRes;
	}

	public R visit(final PropertyImplementation n, final A argu) {
		R nRes = null;
		n.f0.accept(this, argu);
		return nRes;
	}

	public R visit(final PropertySynthesizeList n, final A argu) {
		R nRes = null;
		n.f0.accept(this, argu);
		n.f1.accept(this, argu);
		return nRes;
	}

	public R visit(final PropertySynthesizeItem n, final A argu) {
		R nRes = null;
		n.f0.accept(this, argu);
		return nRes;
	}

	public R visit(final MethodDefinition n, final A argu) {
		R nRes = null;
		n.f0.accept(this, argu);
		return nRes;
	}

	public R visit(final ClassMethodDefinition n, final A argu) {
		if (n.f0.toString().equals("+")) {
			gool.parser.objc.core.ObjCMethode me = new gool.parser.objc.core.ObjCMethode(ObjCModifier.PUBLIC, null, null, null, null);
			gool.parser.objc.core.ObjCNoeud noeud = (gool.parser.objc.core.ObjCNoeud) (argu);
			noeud.addFils(me);
			R nRes = null;
			n.f0.accept(this, (A) me);
			n.f1.accept(this, (A) me);
			n.f2.accept(this, (A) me);
			n.f3.accept(this, (A) me);
			n.f4.accept(this, (A) me);
			n.f5.accept(this, (A) me);
			return nRes;
		}
		R nRes = null;
		n.f0.accept(this, argu);
		n.f1.accept(this, argu);
		n.f2.accept(this, argu);
		n.f3.accept(this, argu);
		n.f4.accept(this, argu);
		n.f5.accept(this, argu);
		return nRes;
	}

	public R visit(final InstanceMethodDefinition n, final A argu) {
		if (n.f0.toString().equals("-")) {
			gool.parser.objc.core.ObjCMethode me = new gool.parser.objc.core.ObjCMethode(ObjCModifier.PRIVE, null, null, null, null);
			gool.parser.objc.core.ObjCNoeud noeud = (gool.parser.objc.core.ObjCNoeud) (argu);
			noeud.addFils(me);
			R nRes = null;
			n.f0.accept(this, (A) me);
			n.f1.accept(this, (A) me);
			n.f2.accept(this, (A) me);
			n.f3.accept(this, (A) me);
			n.f4.accept(this, (A) me);
			n.f5.accept(this, (A) me);
			return nRes;
		}
		R nRes = null;
		n.f0.accept(this, argu);
		n.f1.accept(this, argu);
		n.f2.accept(this, argu);
		n.f3.accept(this, argu);
		n.f4.accept(this, argu);
		n.f5.accept(this, argu);
		return nRes;
	}

	public R visit(final MethodSelectorNoList n, final A argu) {
		R nRes = null;
		n.f0.accept(this, argu);
		return nRes;
	}

	public R visit(final MethodSelector n, final A argu) {
		R nRes = null;
		n.f0.accept(this, argu);
		return nRes;
	}

	public R visit(final UnarySelector n, final A argu) {
		R nRes = null;
		n.f0.accept(this, argu);
		return nRes;
	}

	public R visit(final KeywordSelector n, final A argu) {
		R nRes = null;
		n.f0.accept(this, argu);
		return nRes;
	}

	public R visit(final KeywordDeclarator n, final A argu) {
		gool.parser.objc.core.ObjCParameterDeclaration pd = new gool.parser.objc.core.ObjCParameterDeclaration(null, null);
		gool.parser.objc.core.ObjCNoeud noeud = (gool.parser.objc.core.ObjCNoeud) (argu);
		noeud.addFils(pd);
		R nRes = null;
		n.f0.accept(this, argu);
		n.f1.accept(this, (A) pd);
		n.f2.accept(this, (A) pd);
		n.f3.accept(this, (A) pd);
		pd.addFils(new gool.parser.objc.core.ObjCIDENT(n.f3.tokenImage));
		return nRes;
	}

	public R visit(final Selector n, final A argu) {
		gool.parser.objc.core.ObjCSelector se = new gool.parser.objc.core.ObjCSelector(n.f0.tokenImage);
		gool.parser.objc.core.ObjCNoeud noeud = (gool.parser.objc.core.ObjCNoeud) (argu);
		noeud.addFils(se);
		R nRes = null;
		n.f0.accept(this, (A) se);
		return nRes;
	}

	public R visit(final MethodType n, final A argu) {
		R nRes = null;
		n.f0.accept(this, argu);
		n.f1.accept(this, argu);
		n.f2.accept(this, argu);
		return nRes;
	}

	public R visit(final SelectorExpression n, final A argu) {
		R nRes = null;
		n.f0.accept(this, argu);
		n.f1.accept(this, argu);
		n.f2.accept(this, argu);
		n.f3.accept(this, argu);
		return nRes;
	}

	public R visit(final SelectorName n, final A argu) {
		R nRes = null;
		n.f0.accept(this, argu);
		return nRes;
	}

	public R visit(final KeywordName n, final A argu) {
		R nRes = null;
		n.f0.accept(this, argu);
		n.f1.accept(this, argu);
		return nRes;
	}

	public R visit(final ProtocolExpression n, final A argu) {
		R nRes = null;
		n.f0.accept(this, argu);
		n.f1.accept(this, argu);
		n.f2.accept(this, argu);
		n.f3.accept(this, argu);
		return nRes;
	}

	public R visit(final EncodeExpression n, final A argu) {
		R nRes = null;
		n.f0.accept(this, argu);
		n.f1.accept(this, argu);
		n.f2.accept(this, argu);
		n.f3.accept(this, argu);
		return nRes;
	}

	public R visit(final DeclarationList n, final A argu) {
		R nRes = null;
		n.f0.accept(this, argu);
		return nRes;
	}

	public R visit(final DeclarationSpecifiers n, final A argu) {
		R nRes = null;
		n.f0.accept(this, argu);
		return nRes;
	}

	public R visit(final StorageClassSpecifier n, final A argu) {
		R nRes = null;
		n.f0.accept(this, argu);
		return nRes;
	}

	public R visit(final TypeSpecifier n, final A argu) {
		if (!PossibleCocoaType.class.isInstance(n.f0.choice)) {
			gool.parser.objc.core.ObjCTypeSpecifier ts = null;
			if (n.f0.choice.toString().equals("void"))
				ts = gool.parser.objc.core.ObjCTypeSpecifier.INSTANCEvide;
			else if (n.f0.choice.toString().equals("BOOL"))
				ts = gool.parser.objc.core.ObjCTypeSpecifier.INSTANCEbooleen;
			else if (n.f0.choice.toString().equals("float"))
				ts = gool.parser.objc.core.ObjCTypeSpecifier.INSTANCEreel;
			else if (n.f0.choice.toString().equals("char"))
				ts = gool.parser.objc.core.ObjCTypeSpecifier.INSTANCEcaractere;
			else if (n.f0.choice.toString().contains("GreedyFixedNumType"))
				ts = gool.parser.objc.core.ObjCTypeSpecifier.INSTANCEentier;
			else if (n.f0.choice.toString().contains("PossibleUnknownType"))
				ts = new gool.parser.objc.core.ObjCTypeSpecifier(
						((PossibleUnknownType) n.f0.choice).f0.tokenImage);
			else if (n.f0.choice.toString().contains("id"))
				ts = gool.parser.objc.core.ObjCTypeSpecifier.INSTANCEobjet;
			gool.parser.objc.core.ObjCNoeud noeud = (gool.parser.objc.core.ObjCNoeud) (argu);
			noeud.addFils(ts);
			R nRes = null;
			n.f0.accept(this, (A) ts);
			return nRes;
		}
		R nRes = null;
		n.f0.accept(this, argu);
		return nRes;
	}

	public R visit(final GreedyFixedNumType n, final A argu) {
		R nRes = null;
		n.f0.accept(this, argu);
		return nRes;
	}

	public R visit(final PossibleCocoaType n, final A argu) {
		if (n.f0.tokenImage.equals("NSString")) {
			gool.parser.objc.core.ObjCTypeSpecifier ts = gool.parser.objc.core.ObjCTypeSpecifier.INSTANCEchaine;
			gool.parser.objc.core.ObjCNoeud noeud = (gool.parser.objc.core.ObjCNoeud) (argu);
			noeud.addFils(ts);
			R nRes = null;
			n.f0.accept(this, argu);
			return nRes;
		}
		R nRes = null;
		n.f0.accept(this, argu);
		return nRes;
	}

	public R visit(final PossibleCoreType n, final A argu) {
		R nRes = null;
		n.f0.accept(this, argu);
		return nRes;
	}

	public R visit(final PossibleUnknownType n, final A argu) {
		R nRes = null;
		n.f0.accept(this, argu);
		return nRes;
	}

	public R visit(final TypeSpecifierWithUnknownType n, final A argu) {
		if (NodeSequence.class.isInstance(n.f0.choice)) {
			NodeSequence ns = (NodeSequence) n.f0.choice;
			if (ns.nodes.size() > 1 && ((NodeChoice) ns.nodes.get(0)).choice.toString().equals("id")) {
				gool.parser.objc.core.ObjCTypeSpecifier ts = new gool.parser.objc.core.ObjCTypeSpecifier("");
				gool.parser.objc.core.ObjCNoeud noeud = (gool.parser.objc.core.ObjCNoeud) (argu);
				noeud.addFils(ts);
				R nRes = null;
				n.f0.accept(this, (A) ts);
				return nRes;
			}
		}
		R nRes = null;
		n.f0.accept(this, argu);
		return nRes;
	}

	public R visit(final TypeQualifier n, final A argu) {
		R nRes = null;
		n.f0.accept(this, argu);
		return nRes;
	}

	public R visit(final StructOrUnionSpecifier n, final A argu) {
		R nRes = null;
		n.f0.accept(this, argu);
		n.f1.accept(this, argu);
		return nRes;
	}

	public R visit(final StructOrUnion n, final A argu) {
		R nRes = null;
		n.f0.accept(this, argu);
		return nRes;
	}

	public R visit(final StructDeclarationList n, final A argu) {
		R nRes = null;
		n.f0.accept(this, argu);
		return nRes;
	}

	public R visit(final InitDeclaratorList n, final A argu) {
		R nRes = null;
		n.f0.accept(this, argu);
		n.f1.accept(this, argu);
		return nRes;
	}

	public R visit(final InitDeclarator n, final A argu) {
		R nRes = null;
		n.f0.accept(this, argu);
		n.f1.accept(this, argu);
		return nRes;
	}

	public R visit(final ProtocolQualifier n, final A argu) {
		R nRes = null;
		n.f0.accept(this, argu);
		return nRes;
	}

	public R visit(final In n, final A argu) {
		R nRes = null;
		n.f0.accept(this, argu);
		return nRes;
	}

	public R visit(final StructDeclaration n, final A argu) {
		R nRes = null;
		n.f0.accept(this, argu);
		n.f1.accept(this, argu);
		n.f2.accept(this, argu);
		return nRes;
	}

	public R visit(final SpecifierQualifierWithUnknownType n, final A argu) {
		R nRes = null;
		n.f0.accept(this, argu);
		return nRes;
	}

	public R visit(final SpecifierQualifierList n, final A argu) {
		R nRes = null;
		n.f0.accept(this, argu);
		return nRes;
	}

	public R visit(final StructDeclaratorList n, final A argu) {
		R nRes = null;
		n.f0.accept(this, argu);
		n.f1.accept(this, argu);
		return nRes;
	}

	public R visit(final StructDeclarator n, final A argu) {
		R nRes = null;
		n.f0.accept(this, argu);
		return nRes;
	}

	public R visit(final EnumSpecifier n, final A argu) {
		R nRes = null;
		n.f0.accept(this, argu);
		n.f1.accept(this, argu);
		return nRes;
	}

	public R visit(final EnumeratorList n, final A argu) {
		R nRes = null;
		n.f0.accept(this, argu);
		n.f1.accept(this, argu);
		return nRes;
	}

	public R visit(final Enumerator n, final A argu) {
		R nRes = null;
		n.f0.accept(this, argu);
		n.f1.accept(this, argu);
		return nRes;
	}

	public R visit(final Declarator n, final A argu) {
		R nRes = null;
		n.f0.accept(this, argu);
		return nRes;
	}

	public R visit(final Block n, final A argu) {
		R nRes = null;
		n.f0.accept(this, argu);
		n.f1.accept(this, argu);
		n.f2.accept(this, argu);
		n.f3.accept(this, argu);
		n.f4.accept(this, argu);
		n.f5.accept(this, argu);
		n.f6.accept(this, argu);
		return nRes;
	}

	public R visit(final DirectDeclarator n, final A argu) {
		R nRes = null;
		n.f0.accept(this, argu);
		n.f1.accept(this, argu);
		return nRes;
	}

	public R visit(final Pointer n, final A argu) {
		R nRes = null;
		n.f0.accept(this, argu);
		n.f1.accept(this, argu);
		n.f2.accept(this, argu);
		return nRes;
	}

	public R visit(final TypeQualifierList n, final A argu) {
		R nRes = null;
		n.f0.accept(this, argu);
		return nRes;
	}

	public R visit(final ParameterTypeList n, final A argu) {
		R nRes = null;
		n.f0.accept(this, argu);
		n.f1.accept(this, argu);
		return nRes;
	}

	public R visit(final ParameterList n, final A argu) {
		R nRes = null;
		n.f0.accept(this, argu);
		n.f1.accept(this, argu);
		return nRes;
	}

	public R visit(final ParameterDeclaration n, final A argu) {
		gool.parser.objc.core.ObjCParameterDeclaration pd = new gool.parser.objc.core.ObjCParameterDeclaration(null, null);
		gool.parser.objc.core.ObjCNoeud noeud = (gool.parser.objc.core.ObjCNoeud) (argu);
		noeud.addFils(pd);
		R nRes = null;
		n.f0.accept(this, (A) pd);
		n.f1.accept(this, (A) pd);
		return nRes;
	}

	public R visit(final IdentifierList n, final A argu) {
		R nRes = null;
		n.f0.accept(this, argu);
		n.f1.accept(this, argu);
		return nRes;
	}

	public R visit(final Initializer n, final A argu) {
		R nRes = null;
		n.f0.accept(this, argu);
		return nRes;
	}

	public R visit(final InitializerList n, final A argu) {
		R nRes = null;
		n.f0.accept(this, argu);
		n.f1.accept(this, argu);
		return nRes;
	}

	public R visit(final TypeName n, final A argu) {
		R nRes = null;
		n.f0.accept(this, argu);
		n.f1.accept(this, argu);
		return nRes;
	}

	public R visit(final TypeNameWithUnknownType n, final A argu) {
		R nRes = null;
		n.f0.accept(this, argu);
		n.f1.accept(this, argu);
		return nRes;
	}

	public R visit(final AbstractDeclarator n, final A argu) {
		R nRes = null;
		n.f0.accept(this, argu);
		return nRes;
	}

	public R visit(final DirectAbstractDeclarator n, final A argu) {
		R nRes = null;
		n.f0.accept(this, argu);
		n.f1.accept(this, argu);
		return nRes;
	}

	public R visit(final TypedefName n, final A argu) {
		R nRes = null;
		n.f0.accept(this, argu);
		return nRes;
	}

	public R visit(final Statement n, final A argu) {
		R nRes = null;
		n.f0.accept(this, argu);
		return nRes;
	}

	public R visit(final LabeledStatement n, final A argu) {
		R nRes = null;
		n.f0.accept(this, argu);
		return nRes;
	}

	public R visit(final InitStatement n, final A argu) {
		R nRes = null;
		n.f0.accept(this, argu);
		n.f1.accept(this, argu);
		n.f2.accept(this, argu);
		n.f3.accept(this, argu);
		n.f4.accept(this, argu);
		return nRes;
	}

	public R visit(final ExpressionStatement n, final A argu) {
		R nRes = null;
		n.f0.accept(this, argu);
		n.f1.accept(this, argu);
		return nRes;
	}

	public R visit(final CompoundStatement n, final A argu) {
		gool.parser.objc.core.ObjCCompoundStatement cs = new gool.parser.objc.core.ObjCCompoundStatement(null, null);
		gool.parser.objc.core.ObjCNoeud noeud = (gool.parser.objc.core.ObjCNoeud) (argu);
		noeud.addFils(cs);
		R nRes = null;
		n.f0.accept(this, (A) cs);
		n.f1.accept(this, (A) cs);
		n.f2.accept(this, (A) cs);
		return nRes;
	}

	public R visit(final StatementList n, final A argu) {
		R nRes = null;
		n.f0.accept(this, argu);
		return nRes;
	}

	public R visit(final SelectionStatement n, final A argu) {
		NodeSequence ns = (NodeSequence) n.f0.choice;
		if (ns.nodes.get(0).toString().equals("if")) {
			gool.parser.objc.core.ObjCIf ss = new gool.parser.objc.core.ObjCIf(null, null, null);
			gool.parser.objc.core.ObjCNoeud noeud = (gool.parser.objc.core.ObjCNoeud) (argu);
			noeud.addFils(ss);
			R nRes = null;
			n.f0.accept(this, (A) ss);
			return nRes;
		} else {
			R nRes = null;
			n.f0.accept(this, argu);
			return nRes;
		}
	}

	public R visit(final NestedLogicalExpression n, final A argu) {
		R nRes = null;
		n.f0.accept(this, argu);
		n.f1.accept(this, argu);
		n.f2.accept(this, argu);
		n.f3.accept(this, argu);
		n.f4.accept(this, argu);
		return nRes;
	}

	public R visit(final LogicalOperator n, final A argu) {
		R nRes = null;
		n.f0.accept(this, argu);
		return nRes;
	}

	public R visit(final IterationStatement n, final A argu) {
		R nRes = null;
		n.f0.accept(this, argu);
		return nRes;
	}

	public R visit(final NumberTypeInit n, final A argu) {
		R nRes = null;
		n.f0.accept(this, argu);
		return nRes;
	}

	public R visit(final JumpStatement n, final A argu) {
		NodeSequence ns = (NodeSequence) n.f0.choice;
		if (ns.nodes.get(0).toString().equals("return")) {
			gool.parser.objc.core.ObjCReturn rs = new gool.parser.objc.core.ObjCReturn(null);
			gool.parser.objc.core.ObjCNoeud noeud = (gool.parser.objc.core.ObjCNoeud) (argu);
			noeud.addFils(rs);
			R nRes = null;
			n.f0.accept(this, (A) rs);
			return nRes;
		} else {
			R nRes = null;
			n.f0.accept(this, argu);
			return nRes;
		}
	}

	public R visit(final Expression n, final A argu) {
		R nRes = null;
		n.f0.accept(this, argu);
		n.f1.accept(this, argu);
		return nRes;
	}

	public R visit(final AssignmentExpression n, final A argu) {
		if (NodeSequence.class.isInstance(n.f0.choice)) {
			gool.parser.objc.core.ObjCAssignement as = new gool.parser.objc.core.ObjCAssignement(null, null);
			gool.parser.objc.core.ObjCNoeud noeud = (gool.parser.objc.core.ObjCNoeud) (argu);
			noeud.addFils(as);
			R nRes = null;
			n.f0.accept(this, (A) as);
			return nRes;
		} else {
			R nRes = null;
			n.f0.accept(this, argu);
			return nRes;
		}
	}

	public R visit(final AssignmentOperator n, final A argu) {
		R nRes = null;
		n.f0.accept(this, argu);
		return nRes;
	}

	public R visit(final ConditionalExpression n, final A argu) {
		R nRes = null;
		n.f0.accept(this, argu);
		n.f1.accept(this, argu);
		return nRes;
	}

	public R visit(final ConstantExpression n, final A argu) {
		R nRes = null;
		n.f0.accept(this, argu);
		return nRes;
	}

	public R visit(final LogicalORExpression n, final A argu) {
		if (NodeSequence.class.isInstance(n.f1.node)) {
			gool.parser.objc.core.ObjCExpBinaire eb = new gool.parser.objc.core.ObjCExpBinaire(gool.parser.objc.core.ObjCOperation.ou, null, null);
			gool.parser.objc.core.ObjCNoeud noeud = (gool.parser.objc.core.ObjCNoeud) (argu);
			noeud.addFils(eb);
			R nRes = null;
			n.f0.accept(this, (A) eb);
			n.f1.accept(this, (A) eb);
			return nRes;
		}
		R nRes = null;
		n.f0.accept(this, argu);
		n.f1.accept(this, argu);
		return nRes;
	}

	public R visit(final LogicalANDExpression n, final A argu) {
		if (NodeSequence.class.isInstance(n.f1.node)) {
			gool.parser.objc.core.ObjCExpBinaire eb = new gool.parser.objc.core.ObjCExpBinaire(gool.parser.objc.core.ObjCOperation.et, null, null);
			gool.parser.objc.core.ObjCNoeud noeud = (gool.parser.objc.core.ObjCNoeud) (argu);
			noeud.addFils(eb);
			R nRes = null;
			n.f0.accept(this, (A) eb);
			n.f1.accept(this, (A) eb);
			return nRes;
		}
		R nRes = null;
		n.f0.accept(this, argu);
		n.f1.accept(this, argu);
		return nRes;
	}

	public R visit(final InclusiveORExpression n, final A argu) {
		R nRes = null;
		n.f0.accept(this, argu);
		n.f1.accept(this, argu);
		return nRes;
	}

	public R visit(final ExclusiveORExpression n, final A argu) {
		R nRes = null;
		n.f0.accept(this, argu);
		n.f1.accept(this, argu);
		return nRes;
	}

	public R visit(final ANDExpression n, final A argu) {
		R nRes = null;
		n.f0.accept(this, argu);
		n.f1.accept(this, argu);
		return nRes;
	}

	public R visit(final EqualityExpression n, final A argu) {
		if (NodeSequence.class.isInstance(n.f1.node)) {
			if (((NodeChoice) ((NodeSequence) n.f1.node).nodes.get(0)).choice.toString() == "==") {
				gool.parser.objc.core.ObjCExpBinaire eb = new gool.parser.objc.core.ObjCExpBinaire(gool.parser.objc.core.ObjCOperation.egal, null, null);
				gool.parser.objc.core.ObjCNoeud noeud = (gool.parser.objc.core.ObjCNoeud) (argu);
				noeud.addFils(eb);
				R nRes = null;
				n.f0.accept(this, (A) eb);
				n.f1.accept(this, (A) eb);
				return nRes;
			} else {
				gool.parser.objc.core.ObjCExpBinaire eb = new gool.parser.objc.core.ObjCExpBinaire(gool.parser.objc.core.ObjCOperation.different, null,null);
				gool.parser.objc.core.ObjCNoeud noeud = (gool.parser.objc.core.ObjCNoeud) (argu);
				noeud.addFils(eb);
				R nRes = null;
				n.f0.accept(this, (A) eb);
				n.f1.accept(this, (A) eb);
				return nRes;
			}
		}
		R nRes = null;
		n.f0.accept(this, argu);
		n.f1.accept(this, argu);
		return nRes;
	}

	public R visit(final RelationalExpression n, final A argu) {
		if (NodeSequence.class.isInstance(n.f1.node)) {
			gool.parser.objc.core.ObjCExpBinaire eb;
			if (((NodeChoice) ((NodeSequence) n.f1.node).nodes.get(0)).choice.toString() == "<") {
				eb = new gool.parser.objc.core.ObjCExpBinaire(gool.parser.objc.core.ObjCOperation.inferieur, null, null);
			} else if (((NodeChoice) ((NodeSequence) n.f1.node).nodes.get(0)).choice.toString() == "<=") {
				eb = new gool.parser.objc.core.ObjCExpBinaire(gool.parser.objc.core.ObjCOperation.inferieurouegal,null, null);
			} else if (((NodeChoice) ((NodeSequence) n.f1.node).nodes.get(0)).choice.toString() == ">") {
				eb = new gool.parser.objc.core.ObjCExpBinaire(gool.parser.objc.core.ObjCOperation.superieur, null, null);
			} else {
				eb = new gool.parser.objc.core.ObjCExpBinaire(gool.parser.objc.core.ObjCOperation.superieurouegal, null, null);
			}
			gool.parser.objc.core.ObjCNoeud noeud = (gool.parser.objc.core.ObjCNoeud) (argu);
			noeud.addFils(eb);
			R nRes = null;
			n.f0.accept(this, (A) eb);
			n.f1.accept(this, (A) eb);
			return nRes;
		}
		R nRes = null;
		n.f0.accept(this, argu);
		n.f1.accept(this, argu);
		return nRes;
	}

	public R visit(final ShiftExpression n, final A argu) {
		R nRes = null;
		n.f0.accept(this, argu);
		n.f1.accept(this, argu);
		return nRes;
	}

	public R visit(final AdditiveExpression n, final A argu) {
		if (NodeSequence.class.isInstance(n.f1.node)) {
			if (((NodeChoice) ((NodeSequence) n.f1.node).nodes.get(0)).choice.toString() == "+") {
				gool.parser.objc.core.ObjCExpBinaire eb = new gool.parser.objc.core.ObjCExpBinaire(gool.parser.objc.core.ObjCOperation.plus, null, null);
				gool.parser.objc.core.ObjCNoeud noeud = (gool.parser.objc.core.ObjCNoeud) (argu);
				noeud.addFils(eb);
				R nRes = null;
				n.f0.accept(this, (A) eb);
				n.f1.accept(this, (A) eb);
				return nRes;
			} else {
				gool.parser.objc.core.ObjCExpBinaire eb = new gool.parser.objc.core.ObjCExpBinaire(gool.parser.objc.core.ObjCOperation.moins, null, null);
				gool.parser.objc.core.ObjCNoeud noeud = (gool.parser.objc.core.ObjCNoeud) (argu);
				noeud.addFils(eb);
				R nRes = null;
				n.f0.accept(this, (A) eb);
				n.f1.accept(this, (A) eb);
				return nRes;
			}
		}
		R nRes = null;
		n.f0.accept(this, argu);
		n.f1.accept(this, argu);
		return nRes;
	}

	public R visit(final MultiplicativeExpression n, final A argu) {
		if (NodeSequence.class.isInstance(n.f1.node)) {
			if (((NodeChoice) ((NodeSequence) n.f1.node).nodes.get(0)).choice.toString() == "*") {
				gool.parser.objc.core.ObjCExpBinaire eb = new gool.parser.objc.core.ObjCExpBinaire(gool.parser.objc.core.ObjCOperation.multiplier, null, null);
				gool.parser.objc.core.ObjCNoeud noeud = (gool.parser.objc.core.ObjCNoeud) (argu);
				noeud.addFils(eb);
				R nRes = null;
				n.f0.accept(this, (A) eb);
				n.f1.accept(this, (A) eb);
				return nRes;
			} else {
				gool.parser.objc.core.ObjCExpBinaire eb = new gool.parser.objc.core.ObjCExpBinaire(gool.parser.objc.core.ObjCOperation.diviser, null, null);
				gool.parser.objc.core.ObjCNoeud noeud = (gool.parser.objc.core.ObjCNoeud) (argu);
				noeud.addFils(eb);
				R nRes = null;
				n.f0.accept(this, (A) eb);
				n.f1.accept(this, (A) eb);
				return nRes;
			}
		}
		R nRes = null;
		n.f0.accept(this, argu);
		n.f1.accept(this, argu);
		return nRes;
	}

	public R visit(final CastExpression n, final A argu) {
		R nRes = null;
		n.f0.accept(this, argu);
		return nRes;
	}

	public R visit(final UnaryExpression n, final A argu) {
		if (NodeSequence.class.isInstance(n.f0.choice) && UnaryOperator.class.isInstance(((NodeSequence) n.f0.choice).nodes.get(0))) {
			gool.parser.objc.core.ObjCExpUnaire eu = new gool.parser.objc.core.ObjCExpUnaire(gool.parser.objc.core.ObjCOperation.non, null);
			gool.parser.objc.core.ObjCNoeud noeud = (gool.parser.objc.core.ObjCNoeud) (argu);
			noeud.addFils(eu);
			R nRes = null;
			n.f0.accept(this, (A) eu);
			return nRes;
		}
		R nRes = null;
		n.f0.accept(this, argu);
		return nRes;
	}

	public R visit(final UnaryOperator n, final A argu) {
		R nRes = null;
		n.f0.accept(this, argu);
		return nRes;
	}

	public R visit(final PostfixExpression n, final A argu) {
		if (NodeSequence.class.isInstance(n.f0.choice)) {
			NodeSequence nS = (NodeSequence) n.f0.choice;
			if (nS.nodes.size() > 1 && NodeListOptional.class.isInstance(nS.nodes.get(1))) {
				PrimaryExpression pE = (PrimaryExpression) nS.nodes.get(0);
				if (ObjCIDENT.class.isInstance(pE.f0.choice)) {
					if (((ObjCIDENT) pE.f0.choice).f0.choice.toString().equals("NSLog")) {
						gool.parser.objc.core.ObjCPostfixExpression pe = new gool.parser.objc.core.ObjCPostfixExpression("NSLog", null);
						gool.parser.objc.core.ObjCNoeud noeud = (gool.parser.objc.core.ObjCNoeud) (argu);
						noeud.addFils(pe);
						R nRes = null;
						n.f0.accept(this, (A) pe);
						return nRes;
					}
				}
				NodeListOptional nLO = (NodeListOptional) nS.nodes.get(1);
				if (nLO.nodes.size() > 0 && NodeChoice.class.isInstance(nLO.nodes.get(0))) {
					NodeChoice nC = (NodeChoice) nLO.nodes.get(0);
					if (NodeToken.class.isInstance(nC.choice)) {
						gool.parser.objc.core.ObjCPostfixExpression pe = new gool.parser.objc.core.ObjCPostfixExpression(nC.choice.toString(), null);
						gool.parser.objc.core.ObjCNoeud noeud = (gool.parser.objc.core.ObjCNoeud) (argu);
						noeud.addFils(pe);
						R nRes = null;
						n.f0.accept(this, (A) pe);
						return nRes;
					}
				}
			}
		}
		if (n.f0.choice.toString() == "nil") {
			gool.parser.objc.core.ObjCConstante co = new gool.parser.objc.core.ObjCConstante("nil");
			gool.parser.objc.core.ObjCNoeud noeud = (gool.parser.objc.core.ObjCNoeud) (argu);
			noeud.addFils(co);
			R nRes = null;
			n.f0.accept(this, (A) co);
			return nRes;
		}
		R nRes = null;
		n.f0.accept(this, argu);
		return nRes;
	}

	public R visit(final PrimaryExpression n, final A argu) {
		if (NodeSequence.class.isInstance(n.f0.choice)) {
			gool.parser.objc.core.ObjCPrimaryExpression pe = new gool.parser.objc.core.ObjCPrimaryExpression(null);
			gool.parser.objc.core.ObjCNoeud noeud = (gool.parser.objc.core.ObjCNoeud) (argu);
			noeud.addFils(pe);
			R nRes = null;
			n.f0.accept(this, (A) pe);
			return nRes;
		}
		R nRes = null;
		n.f0.accept(this, argu);
		return nRes;
	}

	public R visit(final MessageExpression n, final A argu) {
		gool.parser.objc.core.ObjCMessageExpression me = new gool.parser.objc.core.ObjCMessageExpression(null, null);
		gool.parser.objc.core.ObjCNoeud noeud = (gool.parser.objc.core.ObjCNoeud) (argu);
		noeud.addFils(me);
		R nRes = null;
		n.f0.accept(this, (A) me);
		n.f1.accept(this, (A) me);
		n.f2.accept(this, (A) me);
		n.f3.accept(this, (A) me);
		return nRes;
	}

	public R visit(final Receiver n, final A argu) {
		R nRes = null;
		n.f0.accept(this, argu);
		return nRes;
	}

	public R visit(final TypeDefedIDENT n, final A argu) {
		R nRes = null;
		n.f0.accept(this, argu);
		return nRes;
	}

	public R visit(final MessageSelector n, final A argu) {
		if (!NodeList.class.isInstance(n.f0.choice)) {
			gool.parser.objc.core.ObjCMessageSelector ms = new gool.parser.objc.core.ObjCMessageSelector(new gool.parser.objc.core.ObjCIDENT(n.f0.choice.toString()), null);
			gool.parser.objc.core.ObjCNoeud noeud = (gool.parser.objc.core.ObjCNoeud) (argu);
			noeud.addFils(ms);
			R nRes = null;
			n.f0.accept(this, (A) ms);
			return nRes;
		} else {
			gool.parser.objc.core.ObjCMessageSelector ms = new gool.parser.objc.core.ObjCMessageSelector(new gool.parser.objc.core.ObjCIDENT(""), null);
			gool.parser.objc.core.ObjCNoeud noeud = (gool.parser.objc.core.ObjCNoeud) (argu);
			noeud.addFils(ms);
			for (int i = 0; i < ((NodeList) n.f0.choice).nodes.size(); i++)
				ms.growName(((NodeSequence) (((KeywordArgument) ((NodeList) n.f0.choice).nodes.get(i)).f0.choice)).nodes.get(0).toString());
			R nRes = null;
			n.f0.accept(this, (A) ms);
			return nRes;
		}
	}

	public R visit(final KeywordArgument n, final A argu) {
		R nRes = null;
		n.f0.accept(this, argu);
		return nRes;
	}

	public R visit(final ArgumentExpressionList n, final A argu) {
		R nRes = null;
		n.f0.accept(this, argu);
		n.f1.accept(this, argu);
		return nRes;
	}

	public R visit(final Constant n, final A argu) {
		gool.parser.objc.core.ObjCType type = null;
		gool.parser.objc.core.ObjCNoeud cs = new gool.parser.objc.core.ObjCConstante(n.f0.choice.toString());
		switch (((NodeToken) n.f0.choice).kind) {
		case 122:
			((gool.parser.objc.core.ObjCConstante) cs).setTypeSpecifier(gool.parser.objc.core.ObjCTypeSpecifier.INSTANCEchaine);break;
		case 121:
			((gool.parser.objc.core.ObjCConstante) cs).setTypeSpecifier(gool.parser.objc.core.ObjCTypeSpecifier.INSTANCEcaractere);break;
		default:
			((gool.parser.objc.core.ObjCConstante) cs).setTypeSpecifier(gool.parser.objc.core.ObjCTypeSpecifier.INSTANCEnull);break;
		}
		gool.parser.objc.core.ObjCNoeud noeud = (gool.parser.objc.core.ObjCNoeud) (argu);
		noeud.addFils(cs);
		R nRes = null;
		n.f0.accept(this, (A) cs);
		return nRes;
	}

}
