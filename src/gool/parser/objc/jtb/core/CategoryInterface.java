/* Generated by JTB 1.4.4 */
package gool.parser.objc.jtb.core;

import gool.parser.objc.jtb.visitor.*;

public class CategoryInterface implements INode {

  public NodeToken f0;

  public ClassName f1;

  public NodeToken f2;

  public NodeOptional f3;

  public NodeToken f4;

  public NodeOptional f5;

  public NodeListOptional f6;

  public NodeToken f7;

  private static final long serialVersionUID = 144L;

  public CategoryInterface(final NodeToken n0, final ClassName n1, final NodeToken n2, final NodeOptional n3, final NodeToken n4, final NodeOptional n5, final NodeListOptional n6, final NodeToken n7) {
    f0 = n0;
    f1 = n1;
    f2 = n2;
    f3 = n3;
    f4 = n4;
    f5 = n5;
    f6 = n6;
    f7 = n7;
  }

  public CategoryInterface(final ClassName n0, final NodeOptional n1, final NodeOptional n2, final NodeListOptional n3) {
    f0 = new NodeToken("@interface");
    f1 = n0;
    f2 = new NodeToken("(");
    f3 = n1;
    f4 = new NodeToken(")");
    f5 = n2;
    f6 = n3;
    f7 = new NodeToken("@end");
  }

  public <R, A> R accept(final IRetArguVisitor<R, A> vis, final A argu) {
    return vis.visit(this, argu);
  }
}
