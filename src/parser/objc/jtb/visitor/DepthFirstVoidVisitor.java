/* Generated by JTB 1.4.4 */
package gool.parser.objc.jtb.visitor;

import gool.parser.objc.jtb.core.*;

import java.util.*;

public class DepthFirstVoidVisitor implements IVoidVisitor {


  public void visit(final NodeChoice n) {
    n.choice.accept(this);
    return;
  }

  public void visit(final NodeList n) {
    for (final Iterator<INode> e = n.elements(); e.hasNext();) {
      e.next().accept(this);
    }
    return;
  }

  public void visit(final NodeListOptional n) {
    if (n.present()) {
      for (final Iterator<INode> e = n.elements(); e.hasNext();) {
        e.next().accept(this);
        }
      return;
    } else
      return;
  }

  public void visit(final NodeOptional n) {
    if (n.present()) {
      n.node.accept(this);
      return;
    } else
    return;
  }

  public void visit(final NodeSequence n) {
    for (final Iterator<INode> e = n.elements(); e.hasNext();) {
      e.next().accept(this);
    }
    return;
  }

  public void visit(final NodeToken n) {
    @SuppressWarnings("unused")
    final String tkIm = n.tokenImage;
    return;
  }

  public void visit(final TranslationUnit n) {
    n.f0.accept(this);
  }

  public void visit(final ExternalDeclaration n) {
    n.f0.accept(this);
  }

  public void visit(final StrippedParens n) {
    n.f0.accept(this);
    n.f1.accept(this);
    n.f2.accept(this);
  }

  public void visit(final FunctionDefinition n) {
    n.f0.accept(this);
    n.f1.accept(this);
    n.f2.accept(this);
    n.f3.accept(this);
  }

  public void visit(final Declaration n) {
    n.f0.accept(this);
    n.f1.accept(this);
    n.f2.accept(this);
    n.f3.accept(this);
  }

  public void visit(final ClassInterface n) {
    n.f0.accept(this);
    n.f1.accept(this);
    n.f2.accept(this);
    n.f3.accept(this);
    n.f4.accept(this);
    n.f5.accept(this);
    n.f6.accept(this);
    n.f7.accept(this);
  }

  public void visit(final ClassImplementation n) {
    n.f0.accept(this);
    n.f1.accept(this);
    n.f2.accept(this);
    n.f3.accept(this);
    n.f4.accept(this);
    n.f5.accept(this);
  }

  public void visit(final CategoryInterface n) {
    n.f0.accept(this);
    n.f1.accept(this);
    n.f2.accept(this);
    n.f3.accept(this);
    n.f4.accept(this);
    n.f5.accept(this);
    n.f6.accept(this);
    n.f7.accept(this);
  }

  public void visit(final CategoryImplementation n) {
    n.f0.accept(this);
    n.f1.accept(this);
    n.f2.accept(this);
    n.f3.accept(this);
    n.f4.accept(this);
    n.f5.accept(this);
    n.f6.accept(this);
  }

  public void visit(final ProtocolDeclaration n) {
    n.f0.accept(this);
    n.f1.accept(this);
    n.f2.accept(this);
    n.f3.accept(this);
    n.f4.accept(this);
  }

  public void visit(final ClassDeclarationList n) {
    n.f0.accept(this);
    n.f1.accept(this);
    n.f2.accept(this);
  }

  public void visit(final ClassList n) {
    n.f0.accept(this);
    n.f1.accept(this);
  }

  public void visit(final ProtocolReferenceList n) {
    n.f0.accept(this);
    n.f1.accept(this);
    n.f2.accept(this);
    n.f3.accept(this);
  }

  public void visit(final ProtocolList n) {
    n.f0.accept(this);
    n.f1.accept(this);
  }

  public void visit(final ObjCIDENT n) {
    n.f0.accept(this);
  }

  public void visit(final ClassName n) {
    n.f0.accept(this);
  }

  public void visit(final SuperClassName n) {
    n.f0.accept(this);
  }

  public void visit(final ColonSuperClassName n) {
    n.f0.accept(this);
    n.f1.accept(this);
  }

  public void visit(final CategoryName n) {
    n.f0.accept(this);
  }

  public void visit(final ProtocolName n) {
    n.f0.accept(this);
  }

  public void visit(final InstanceVariables n) {
    n.f0.accept(this);
    n.f1.accept(this);
    n.f2.accept(this);
    n.f3.accept(this);
  }

  public void visit(final InstanceVariableDeclaration n) {
    n.f0.accept(this);
  }

  public void visit(final InstanceVariableDeclarator n) {
    n.f0.accept(this);
  }

  public void visit(final VisibilitySpecification n) {
    n.f0.accept(this);
  }

  public void visit(final IBOutlet n) {
    n.f0.accept(this);
  }

  public void visit(final ProtocolInterfaceDeclaration n) {
    n.f0.accept(this);
    n.f1.accept(this);
  }

  public void visit(final QualifiedProtocolInterfaceDeclaration n) {
    n.f0.accept(this);
  }

  public void visit(final InterfaceDeclaration n) {
    n.f0.accept(this);
  }

  public void visit(final PropertyDeclaration n) {
    n.f0.accept(this);
    n.f1.accept(this);
    n.f2.accept(this);
  }

  public void visit(final PropertyAttributesDeclaration n) {
    n.f0.accept(this);
    n.f1.accept(this);
    n.f2.accept(this);
  }

  public void visit(final PropertyAttributesList n) {
    n.f0.accept(this);
    n.f1.accept(this);
  }

  public void visit(final PropertyAttribute n) {
    n.f0.accept(this);
  }

  public void visit(final MethodDeclaration n) {
    n.f0.accept(this);
  }

  public void visit(final ClassMethodDeclaration n) {
    n.f0.accept(this);
    n.f1.accept(this);
    n.f2.accept(this);
    n.f3.accept(this);
  }

  public void visit(final InstanceMethodDeclaration n) {
    n.f0.accept(this);
    n.f1.accept(this);
    n.f2.accept(this);
    n.f3.accept(this);
  }

  public void visit(final ImplementationDefinition n) {
    n.f0.accept(this);
  }

  public void visit(final PropertyImplementation n) {
    n.f0.accept(this);
  }

  public void visit(final PropertySynthesizeList n) {
    n.f0.accept(this);
    n.f1.accept(this);
  }

  public void visit(final PropertySynthesizeItem n) {
    n.f0.accept(this);
  }

  public void visit(final MethodDefinition n) {
    n.f0.accept(this);
  }

  public void visit(final ClassMethodDefinition n) {
    n.f0.accept(this);
    n.f1.accept(this);
    n.f2.accept(this);
    n.f3.accept(this);
    n.f4.accept(this);
    n.f5.accept(this);
  }

  public void visit(final InstanceMethodDefinition n) {
    n.f0.accept(this);
    n.f1.accept(this);
    n.f2.accept(this);
    n.f3.accept(this);
    n.f4.accept(this);
    n.f5.accept(this);
  }

  public void visit(final MethodSelectorNoList n) {
    n.f0.accept(this);
  }

  public void visit(final MethodSelector n) {
    n.f0.accept(this);
  }

  public void visit(final UnarySelector n) {
    n.f0.accept(this);
  }

  public void visit(final KeywordSelector n) {
    n.f0.accept(this);
  }

  public void visit(final KeywordDeclarator n) {
    n.f0.accept(this);
    n.f1.accept(this);
    n.f2.accept(this);
    n.f3.accept(this);
  }

  public void visit(final Selector n) {
    n.f0.accept(this);
  }

  public void visit(final MethodType n) {
    n.f0.accept(this);
    n.f1.accept(this);
    n.f2.accept(this);
  }

  public void visit(final SelectorExpression n) {
    n.f0.accept(this);
    n.f1.accept(this);
    n.f2.accept(this);
    n.f3.accept(this);
  }

  public void visit(final SelectorName n) {
    n.f0.accept(this);
  }

  public void visit(final KeywordName n) {
    n.f0.accept(this);
    n.f1.accept(this);
  }

  public void visit(final ProtocolExpression n) {
    n.f0.accept(this);
    n.f1.accept(this);
    n.f2.accept(this);
    n.f3.accept(this);
  }

  public void visit(final EncodeExpression n) {
    n.f0.accept(this);
    n.f1.accept(this);
    n.f2.accept(this);
    n.f3.accept(this);
  }

  public void visit(final DeclarationList n) {
    n.f0.accept(this);
  }

  public void visit(final DeclarationSpecifiers n) {
    n.f0.accept(this);
  }

  public void visit(final StorageClassSpecifier n) {
    n.f0.accept(this);
  }

  public void visit(final TypeSpecifier n) {
    n.f0.accept(this);
  }

  public void visit(final GreedyFixedNumType n) {
    n.f0.accept(this);
  }

  public void visit(final PossibleCocoaType n) {
    n.f0.accept(this);
  }

  public void visit(final PossibleCoreType n) {
    n.f0.accept(this);
  }

  public void visit(final PossibleUnknownType n) {
    n.f0.accept(this);
  }

  public void visit(final TypeSpecifierWithUnknownType n) {
    n.f0.accept(this);
  }

  public void visit(final TypeQualifier n) {
    n.f0.accept(this);
  }

  public void visit(final StructOrUnionSpecifier n) {
    n.f0.accept(this);
    n.f1.accept(this);
  }

  public void visit(final StructOrUnion n) {
    n.f0.accept(this);
  }

  public void visit(final StructDeclarationList n) {
    n.f0.accept(this);
  }

  public void visit(final InitDeclaratorList n) {
    n.f0.accept(this);
    n.f1.accept(this);
  }

  public void visit(final InitDeclarator n) {
    n.f0.accept(this);
    n.f1.accept(this);
  }

  public void visit(final ProtocolQualifier n) {
    n.f0.accept(this);
  }

  public void visit(final In n) {
    n.f0.accept(this);
  }

  public void visit(final StructDeclaration n) {
    n.f0.accept(this);
    n.f1.accept(this);
    n.f2.accept(this);
  }

  public void visit(final SpecifierQualifierWithUnknownType n) {
    n.f0.accept(this);
  }

  public void visit(final SpecifierQualifierList n) {
    n.f0.accept(this);
  }

  public void visit(final StructDeclaratorList n) {
    n.f0.accept(this);
    n.f1.accept(this);
  }

  public void visit(final StructDeclarator n) {
    n.f0.accept(this);
  }

  public void visit(final EnumSpecifier n) {
    n.f0.accept(this);
    n.f1.accept(this);
  }

  public void visit(final EnumeratorList n) {
    n.f0.accept(this);
    n.f1.accept(this);
  }

  public void visit(final Enumerator n) {
    n.f0.accept(this);
    n.f1.accept(this);
  }

  public void visit(final Declarator n) {
    n.f0.accept(this);
  }

  public void visit(final Block n) {
    n.f0.accept(this);
    n.f1.accept(this);
    n.f2.accept(this);
    n.f3.accept(this);
    n.f4.accept(this);
    n.f5.accept(this);
    n.f6.accept(this);
  }

  public void visit(final DirectDeclarator n) {
    n.f0.accept(this);
    n.f1.accept(this);
  }

  public void visit(final Pointer n) {
    n.f0.accept(this);
    n.f1.accept(this);
    n.f2.accept(this);
  }

  public void visit(final TypeQualifierList n) {
    n.f0.accept(this);
  }

  public void visit(final ParameterTypeList n) {
    n.f0.accept(this);
    n.f1.accept(this);
  }

  public void visit(final ParameterList n) {
    n.f0.accept(this);
    n.f1.accept(this);
  }

  public void visit(final ParameterDeclaration n) {
    n.f0.accept(this);
    n.f1.accept(this);
  }

  public void visit(final IdentifierList n) {
    n.f0.accept(this);
    n.f1.accept(this);
  }

  public void visit(final Initializer n) {
    n.f0.accept(this);
  }

  public void visit(final InitializerList n) {
    n.f0.accept(this);
    n.f1.accept(this);
  }

  public void visit(final TypeName n) {
    n.f0.accept(this);
    n.f1.accept(this);
  }

  public void visit(final TypeNameWithUnknownType n) {
    n.f0.accept(this);
    n.f1.accept(this);
  }

  public void visit(final AbstractDeclarator n) {
    n.f0.accept(this);
  }

  public void visit(final DirectAbstractDeclarator n) {
    n.f0.accept(this);
    n.f1.accept(this);
  }

  public void visit(final TypedefName n) {
    n.f0.accept(this);
  }

  public void visit(final Statement n) {
    n.f0.accept(this);
  }

  public void visit(final LabeledStatement n) {
    n.f0.accept(this);
  }

  public void visit(final InitStatement n) {
    n.f0.accept(this);
    n.f1.accept(this);
    n.f2.accept(this);
    n.f3.accept(this);
    n.f4.accept(this);
  }

  public void visit(final ExpressionStatement n) {
    n.f0.accept(this);
    n.f1.accept(this);
  }

  public void visit(final CompoundStatement n) {
    n.f0.accept(this);
    n.f1.accept(this);
    n.f2.accept(this);
  }

  public void visit(final StatementList n) {
    n.f0.accept(this);
  }

  public void visit(final SelectionStatement n) {
    n.f0.accept(this);
  }

  public void visit(final NestedLogicalExpression n) {
    n.f0.accept(this);
    n.f1.accept(this);
    n.f2.accept(this);
    n.f3.accept(this);
    n.f4.accept(this);
  }

  public void visit(final LogicalOperator n) {
    n.f0.accept(this);
  }

  public void visit(final IterationStatement n) {
    n.f0.accept(this);
  }

  public void visit(final NumberTypeInit n) {
    n.f0.accept(this);
  }

  public void visit(final JumpStatement n) {
    n.f0.accept(this);
  }

  public void visit(final Expression n) {
    n.f0.accept(this);
    n.f1.accept(this);
  }

  public void visit(final AssignmentExpression n) {
    n.f0.accept(this);
  }

  public void visit(final AssignmentOperator n) {
    n.f0.accept(this);
  }

  public void visit(final ConditionalExpression n) {
    n.f0.accept(this);
    n.f1.accept(this);
  }

  public void visit(final ConstantExpression n) {
    n.f0.accept(this);
  }

  public void visit(final LogicalORExpression n) {
    n.f0.accept(this);
    n.f1.accept(this);
  }

  public void visit(final LogicalANDExpression n) {
    n.f0.accept(this);
    n.f1.accept(this);
  }

  public void visit(final InclusiveORExpression n) {
    n.f0.accept(this);
    n.f1.accept(this);
  }

  public void visit(final ExclusiveORExpression n) {
    n.f0.accept(this);
    n.f1.accept(this);
  }

  public void visit(final ANDExpression n) {
    n.f0.accept(this);
    n.f1.accept(this);
  }

  public void visit(final EqualityExpression n) {
    n.f0.accept(this);
    n.f1.accept(this);
  }

  public void visit(final RelationalExpression n) {
    n.f0.accept(this);
    n.f1.accept(this);
  }

  public void visit(final ShiftExpression n) {
    n.f0.accept(this);
    n.f1.accept(this);
  }

  public void visit(final AdditiveExpression n) {
    n.f0.accept(this);
    n.f1.accept(this);
  }

  public void visit(final MultiplicativeExpression n) {
    n.f0.accept(this);
    n.f1.accept(this);
  }

  public void visit(final CastExpression n) {
    n.f0.accept(this);
  }

  public void visit(final UnaryExpression n) {
    n.f0.accept(this);
  }

  public void visit(final UnaryOperator n) {
    n.f0.accept(this);
  }

  public void visit(final PostfixExpression n) {
    n.f0.accept(this);
  }

  public void visit(final PrimaryExpression n) {
    n.f0.accept(this);
  }

  public void visit(final MessageExpression n) {
    n.f0.accept(this);
    n.f1.accept(this);
    n.f2.accept(this);
    n.f3.accept(this);
  }

  public void visit(final Receiver n) {
    n.f0.accept(this);
  }

  public void visit(final TypeDefedIDENT n) {
    n.f0.accept(this);
  }

  public void visit(final MessageSelector n) {
    n.f0.accept(this);
  }

  public void visit(final KeywordArgument n) {
    n.f0.accept(this);
  }

  public void visit(final ArgumentExpressionList n) {
    n.f0.accept(this);
    n.f1.accept(this);
  }

  public void visit(final Constant n) {
    n.f0.accept(this);
  }

}
