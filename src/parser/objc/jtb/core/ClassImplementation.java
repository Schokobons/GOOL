/* Generated by JTB 1.4.4 */
package gool.parser.objc.jtb.core;

import gool.parser.objc.jtb.visitor.*;

public class ClassImplementation implements INode {

  public NodeToken f0;

  public ClassName f1;

  public NodeOptional f2;

  public NodeOptional f3;

  public NodeListOptional f4;

  public NodeToken f5;

  private static final long serialVersionUID = 144L;

  public ClassImplementation(final NodeToken n0, final ClassName n1, final NodeOptional n2, final NodeOptional n3, final NodeListOptional n4, final NodeToken n5) {
    f0 = n0;
    f1 = n1;
    f2 = n2;
    f3 = n3;
    f4 = n4;
    f5 = n5;
  }

  public ClassImplementation(final ClassName n0, final NodeOptional n1, final NodeOptional n2, final NodeListOptional n3) {
    f0 = new NodeToken("@implementation");
    f1 = n0;
    f2 = n1;
    f3 = n2;
    f4 = n3;
    f5 = new NodeToken("@end");
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
