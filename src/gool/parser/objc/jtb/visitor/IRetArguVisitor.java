/* Generated by JTB 1.4.4 */
package gool.parser.objc.jtb.visitor;

import gool.parser.objc.jtb.core.*;

public interface IRetArguVisitor<R, A> {

	public R visit(final NodeList n, final A argu);

	public R visit(final NodeListOptional n, final A argu);

	public R visit(final NodeOptional n, final A argu);

	public R visit(final NodeSequence n, final A argu);

	public R visit(final NodeToken n, final A argu);

	public R visit(final TranslationUnit n, final A argu);

	public R visit(final ExternalDeclaration n, final A argu);

	public R visit(final StrippedParens n, final A argu);

	public R visit(final FunctionDefinition n, final A argu);

	public R visit(final Declaration n, final A argu);

	public R visit(final ClassInterface n, final A argu);

	public R visit(final ClassImplementation n, final A argu);

	public R visit(final CategoryInterface n, final A argu);

	public R visit(final CategoryImplementation n, final A argu);

	public R visit(final ProtocolDeclaration n, final A argu);

	public R visit(final ClassDeclarationList n, final A argu);

	public R visit(final ClassList n, final A argu);

	public R visit(final ProtocolReferenceList n, final A argu);

	public R visit(final ProtocolList n, final A argu);

	public R visit(final ObjCIDENT n, final A argu);

	public R visit(final ClassName n, final A argu);

	public R visit(final SuperClassName n, final A argu);

	public R visit(final ColonSuperClassName n, final A argu);

	public R visit(final CategoryName n, final A argu);

	public R visit(final ProtocolName n, final A argu);

	public R visit(final InstanceVariables n, final A argu);

	public R visit(final InstanceVariableDeclaration n, final A argu);

	public R visit(final InstanceVariableDeclarator n, final A argu);

	public R visit(final VisibilitySpecification n, final A argu);

	public R visit(final IBOutlet n, final A argu);

	public R visit(final ProtocolInterfaceDeclaration n, final A argu);

	public R visit(final QualifiedProtocolInterfaceDeclaration n, final A argu);

	public R visit(final InterfaceDeclaration n, final A argu);

	public R visit(final PropertyDeclaration n, final A argu);

	public R visit(final PropertyAttributesDeclaration n, final A argu);

	public R visit(final PropertyAttributesList n, final A argu);

	public R visit(final PropertyAttribute n, final A argu);

	public R visit(final MethodDeclaration n, final A argu);

	public R visit(final ClassMethodDeclaration n, final A argu);

	public R visit(final InstanceMethodDeclaration n, final A argu);

	public R visit(final ImplementationDefinition n, final A argu);

	public R visit(final PropertyImplementation n, final A argu);

	public R visit(final PropertySynthesizeList n, final A argu);

	public R visit(final PropertySynthesizeItem n, final A argu);

	public R visit(final MethodDefinition n, final A argu);

	public R visit(final ClassMethodDefinition n, final A argu);

	public R visit(final InstanceMethodDefinition n, final A argu);

	public R visit(final MethodSelectorNoList n, final A argu);

	public R visit(final MethodSelector n, final A argu);

	public R visit(final UnarySelector n, final A argu);

	public R visit(final KeywordSelector n, final A argu);

	public R visit(final KeywordDeclarator n, final A argu);

	public R visit(final Selector n, final A argu);

	public R visit(final MethodType n, final A argu);

	public R visit(final SelectorExpression n, final A argu);

	public R visit(final SelectorName n, final A argu);

	public R visit(final KeywordName n, final A argu);

	public R visit(final ProtocolExpression n, final A argu);

	public R visit(final EncodeExpression n, final A argu);

	public R visit(final DeclarationList n, final A argu);

	public R visit(final DeclarationSpecifiers n, final A argu);

	public R visit(final StorageClassSpecifier n, final A argu);

	public R visit(final TypeSpecifier n, final A argu);

	public R visit(final GreedyFixedNumType n, final A argu);

	public R visit(final PossibleCocoaType n, final A argu);

	public R visit(final PossibleCoreType n, final A argu);

	public R visit(final PossibleUnknownType n, final A argu);

	public R visit(final TypeSpecifierWithUnknownType n, final A argu);

	public R visit(final TypeQualifier n, final A argu);

	public R visit(final StructOrUnionSpecifier n, final A argu);

	public R visit(final StructOrUnion n, final A argu);

	public R visit(final StructDeclarationList n, final A argu);

	public R visit(final InitDeclaratorList n, final A argu);

	public R visit(final InitDeclarator n, final A argu);

	public R visit(final ProtocolQualifier n, final A argu);

	public R visit(final In n, final A argu);

	public R visit(final StructDeclaration n, final A argu);

	public R visit(final SpecifierQualifierWithUnknownType n, final A argu);

	public R visit(final SpecifierQualifierList n, final A argu);

	public R visit(final StructDeclaratorList n, final A argu);

	public R visit(final StructDeclarator n, final A argu);

	public R visit(final EnumSpecifier n, final A argu);

	public R visit(final EnumeratorList n, final A argu);

	public R visit(final Enumerator n, final A argu);

	public R visit(final Declarator n, final A argu);

	public R visit(final Block n, final A argu);

	public R visit(final DirectDeclarator n, final A argu);

	public R visit(final Pointer n, final A argu);

	public R visit(final TypeQualifierList n, final A argu);

	public R visit(final ParameterTypeList n, final A argu);

	public R visit(final ParameterList n, final A argu);

	public R visit(final ParameterDeclaration n, final A argu);

	public R visit(final IdentifierList n, final A argu);

	public R visit(final Initializer n, final A argu);

	public R visit(final InitializerList n, final A argu);

	public R visit(final TypeName n, final A argu);

	public R visit(final TypeNameWithUnknownType n, final A argu);

	public R visit(final AbstractDeclarator n, final A argu);

	public R visit(final DirectAbstractDeclarator n, final A argu);

	public R visit(final TypedefName n, final A argu);

	public R visit(final Statement n, final A argu);

	public R visit(final LabeledStatement n, final A argu);

	public R visit(final InitStatement n, final A argu);

	public R visit(final ExpressionStatement n, final A argu);

	public R visit(final CompoundStatement n, final A argu);

	public R visit(final StatementList n, final A argu);

	public R visit(final SelectionStatement n, final A argu);

	public R visit(final NestedLogicalExpression n, final A argu);

	public R visit(final LogicalOperator n, final A argu);

	public R visit(final IterationStatement n, final A argu);

	public R visit(final NumberTypeInit n, final A argu);

	public R visit(final JumpStatement n, final A argu);

	public R visit(final Expression n, final A argu);

	public R visit(final AssignmentExpression n, final A argu);

	public R visit(final AssignmentOperator n, final A argu);

	public R visit(final ConditionalExpression n, final A argu);

	public R visit(final ConstantExpression n, final A argu);

	public R visit(final LogicalORExpression n, final A argu);

	public R visit(final LogicalANDExpression n, final A argu);

	public R visit(final InclusiveORExpression n, final A argu);

	public R visit(final ExclusiveORExpression n, final A argu);

	public R visit(final ANDExpression n, final A argu);

	public R visit(final EqualityExpression n, final A argu);

	public R visit(final RelationalExpression n, final A argu);

	public R visit(final ShiftExpression n, final A argu);

	public R visit(final AdditiveExpression n, final A argu);

	public R visit(final MultiplicativeExpression n, final A argu);

	public R visit(final CastExpression n, final A argu);

	public R visit(final UnaryExpression n, final A argu);

	public R visit(final UnaryOperator n, final A argu);

	public R visit(final PostfixExpression n, final A argu);

	public R visit(final PrimaryExpression n, final A argu);

	public R visit(final MessageExpression n, final A argu);

	public R visit(final Receiver n, final A argu);

	public R visit(final TypeDefedIDENT n, final A argu);

	public R visit(final MessageSelector n, final A argu);

	public R visit(final KeywordArgument n, final A argu);

	public R visit(final ArgumentExpressionList n, final A argu);

	public R visit(final Constant n, final A argu);

}
