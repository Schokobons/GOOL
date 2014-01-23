/* Generated by JTB 1.4.4 */
package gool.parser.objc.jtb.visitor;

import gool.parser.objc.jtb.core.*;

public interface IVoidArguVisitor<A> {

  public void visit(final NodeList n, final A argu);

  public void visit(final NodeListOptional n, final A argu);

  public void visit(final NodeOptional n, final A argu);


  public void visit(final NodeSequence n, final A argu);

  public void visit(final NodeToken n, final A argu);

  public void visit(final TranslationUnit n, final A argu);

  public void visit(final ExternalDeclaration n, final A argu);

  public void visit(final StrippedParens n, final A argu);

  public void visit(final FunctionDefinition n, final A argu);

  public void visit(final Declaration n, final A argu);

  public void visit(final ClassInterface n, final A argu);

  public void visit(final ClassImplementation n, final A argu);

  public void visit(final CategoryInterface n, final A argu);

  public void visit(final CategoryImplementation n, final A argu);

  public void visit(final ProtocolDeclaration n, final A argu);

  public void visit(final ClassDeclarationList n, final A argu);

  public void visit(final ClassList n, final A argu);

  public void visit(final ProtocolReferenceList n, final A argu);

  public void visit(final ProtocolList n, final A argu);

  public void visit(final ObjCIDENT n, final A argu);

  public void visit(final ClassName n, final A argu);

  public void visit(final SuperClassName n, final A argu);

  public void visit(final ColonSuperClassName n, final A argu);

  public void visit(final CategoryName n, final A argu);

  public void visit(final ProtocolName n, final A argu);

  public void visit(final InstanceVariables n, final A argu);

  public void visit(final InstanceVariableDeclaration n, final A argu);

  public void visit(final InstanceVariableDeclarator n, final A argu);

  public void visit(final VisibilitySpecification n, final A argu);

  public void visit(final IBOutlet n, final A argu);

  public void visit(final ProtocolInterfaceDeclaration n, final A argu);

  public void visit(final QualifiedProtocolInterfaceDeclaration n, final A argu);

  public void visit(final InterfaceDeclaration n, final A argu);

  public void visit(final PropertyDeclaration n, final A argu);

  public void visit(final PropertyAttributesDeclaration n, final A argu);

  public void visit(final PropertyAttributesList n, final A argu);

  public void visit(final PropertyAttribute n, final A argu);

  public void visit(final MethodDeclaration n, final A argu);

  public void visit(final ClassMethodDeclaration n, final A argu);

  public void visit(final InstanceMethodDeclaration n, final A argu);

  public void visit(final ImplementationDefinition n, final A argu);

  public void visit(final PropertyImplementation n, final A argu);

  public void visit(final PropertySynthesizeList n, final A argu);

  public void visit(final PropertySynthesizeItem n, final A argu);

  public void visit(final MethodDefinition n, final A argu);

  public void visit(final ClassMethodDefinition n, final A argu);

  public void visit(final InstanceMethodDefinition n, final A argu);

  public void visit(final MethodSelectorNoList n, final A argu);

  public void visit(final MethodSelector n, final A argu);

  public void visit(final UnarySelector n, final A argu);

  public void visit(final KeywordSelector n, final A argu);

  public void visit(final KeywordDeclarator n, final A argu);

  public void visit(final Selector n, final A argu);

  public void visit(final MethodType n, final A argu);

  public void visit(final SelectorExpression n, final A argu);

  public void visit(final SelectorName n, final A argu);

  public void visit(final KeywordName n, final A argu);

  public void visit(final ProtocolExpression n, final A argu);

  public void visit(final EncodeExpression n, final A argu);

  public void visit(final DeclarationList n, final A argu);

  public void visit(final DeclarationSpecifiers n, final A argu);

  public void visit(final StorageClassSpecifier n, final A argu);

  public void visit(final TypeSpecifier n, final A argu);

  public void visit(final GreedyFixedNumType n, final A argu);

  public void visit(final PossibleCocoaType n, final A argu);

  public void visit(final PossibleCoreType n, final A argu);

  public void visit(final PossibleUnknownType n, final A argu);

  public void visit(final TypeSpecifierWithUnknownType n, final A argu);

  public void visit(final TypeQualifier n, final A argu);

  public void visit(final StructOrUnionSpecifier n, final A argu);

  public void visit(final StructOrUnion n, final A argu);

  public void visit(final StructDeclarationList n, final A argu);

  public void visit(final InitDeclaratorList n, final A argu);

  public void visit(final InitDeclarator n, final A argu);

  public void visit(final ProtocolQualifier n, final A argu);

  public void visit(final In n, final A argu);

  public void visit(final StructDeclaration n, final A argu);

  public void visit(final SpecifierQualifierWithUnknownType n, final A argu);

  public void visit(final SpecifierQualifierList n, final A argu);

  public void visit(final StructDeclaratorList n, final A argu);

  public void visit(final StructDeclarator n, final A argu);

  public void visit(final EnumSpecifier n, final A argu);

  public void visit(final EnumeratorList n, final A argu);

  public void visit(final Enumerator n, final A argu);

  public void visit(final Declarator n, final A argu);

  public void visit(final Block n, final A argu);

  public void visit(final DirectDeclarator n, final A argu);

  public void visit(final Pointer n, final A argu);

  public void visit(final TypeQualifierList n, final A argu);

  public void visit(final ParameterTypeList n, final A argu);

  public void visit(final ParameterList n, final A argu);

  public void visit(final ParameterDeclaration n, final A argu);

  public void visit(final IdentifierList n, final A argu);

  public void visit(final Initializer n, final A argu);

  public void visit(final InitializerList n, final A argu);

  public void visit(final TypeName n, final A argu);

  public void visit(final TypeNameWithUnknownType n, final A argu);

  public void visit(final AbstractDeclarator n, final A argu);

  public void visit(final DirectAbstractDeclarator n, final A argu);

  public void visit(final TypedefName n, final A argu);

  public void visit(final Statement n, final A argu);

  public void visit(final LabeledStatement n, final A argu);

  public void visit(final InitStatement n, final A argu);

  public void visit(final ExpressionStatement n, final A argu);

  public void visit(final CompoundStatement n, final A argu);

  public void visit(final StatementList n, final A argu);

  public void visit(final SelectionStatement n, final A argu);

  public void visit(final NestedLogicalExpression n, final A argu);

  public void visit(final LogicalOperator n, final A argu);

  public void visit(final IterationStatement n, final A argu);

  public void visit(final NumberTypeInit n, final A argu);

  public void visit(final JumpStatement n, final A argu);

  public void visit(final Expression n, final A argu);

  public void visit(final AssignmentExpression n, final A argu);

  public void visit(final AssignmentOperator n, final A argu);

  public void visit(final ConditionalExpression n, final A argu);

  public void visit(final ConstantExpression n, final A argu);

  public void visit(final LogicalORExpression n, final A argu);

  public void visit(final LogicalANDExpression n, final A argu);

  public void visit(final InclusiveORExpression n, final A argu);

  public void visit(final ExclusiveORExpression n, final A argu);

  public void visit(final ANDExpression n, final A argu);

  public void visit(final EqualityExpression n, final A argu);

  public void visit(final RelationalExpression n, final A argu);

  public void visit(final ShiftExpression n, final A argu);

  public void visit(final AdditiveExpression n, final A argu);

  public void visit(final MultiplicativeExpression n, final A argu);

  public void visit(final CastExpression n, final A argu);

  public void visit(final UnaryExpression n, final A argu);

  public void visit(final UnaryOperator n, final A argu);

  public void visit(final PostfixExpression n, final A argu);

  public void visit(final PrimaryExpression n, final A argu);

  public void visit(final MessageExpression n, final A argu);

  public void visit(final Receiver n, final A argu);

  public void visit(final TypeDefedIDENT n, final A argu);

  public void visit(final MessageSelector n, final A argu);

  public void visit(final KeywordArgument n, final A argu);

  public void visit(final ArgumentExpressionList n, final A argu);

  public void visit(final Constant n, final A argu);

}