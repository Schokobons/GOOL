/* Generated by JTB 1.4.4 */
package gool.parser.objc.jtb.core;

import gool.parser.objc.jtb.visitor.*;

public class CategoryImplementation implements INode {

  public NodeToken f0;

  public ClassName f1;

  public NodeToken f2;

  public CategoryName f3;

  public NodeToken f4;

  public NodeListOptional f5;

  public NodeToken f6;

  private static final long serialVersionUID = 144L;

  public CategoryImplementation(final NodeToken n0, final ClassName n1, final NodeToken n2, final CategoryName n3, final NodeToken n4, final NodeListOptional n5, final NodeToken n6) {
    f0 = n0;
    f1 = n1;
    f2 = n2;
    f3 = n3;
    f4 = n4;
    f5 = n5;
    f6 = n6;
  }

  public CategoryImplementation(final ClassName n0, final CategoryName n1, final NodeListOptional n2) {
    f0 = new NodeToken("@implementation");
    f1 = n0;
    f2 = new NodeToken("(");
    f3 = n1;
    f4 = new NodeToken(")");
    f5 = n2;
    f6 = new NodeToken("@end");
  }

  public <R, A> R accept(final IRetArguVisitor<R, A> vis, final A argu) {
    return vis.visit(this, argu);
  }

  public <R> R accept(final IRetVisitor<R> vis) {
    return vis.visit(this);
  }

  public <A> void accept(final IVoidArguVisitor<A> vis, final A argu) {
    vis.visit(this, argu);
  }

  public void accept(final IVoidVisitor vis) {
    vis.visit(this);
  }

}