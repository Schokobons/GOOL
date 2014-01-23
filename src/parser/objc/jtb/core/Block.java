/* Generated by JTB 1.4.4 */
package gool.parser.objc.jtb.core;

import gool.parser.objc.jtb.visitor.*;

public class Block implements INode {

  public NodeOptional f0;

  public NodeToken f1;

  public NodeOptional f2;

  public NodeToken f3;

  public NodeToken f4;

  public ParameterList f5;

  public NodeToken f6;

  private static final long serialVersionUID = 144L;

  public Block(final NodeOptional n0, final NodeToken n1, final NodeOptional n2, final NodeToken n3, final NodeToken n4, final ParameterList n5, final NodeToken n6) {
    f0 = n0;
    f1 = n1;
    f2 = n2;
    f3 = n3;
    f4 = n4;
    f5 = n5;
    f6 = n6;
  }

  public Block(final NodeOptional n0, final NodeOptional n1, final ParameterList n2) {
    f0 = n0;
    f1 = new NodeToken("(^");
    f2 = n1;
    f3 = new NodeToken(")");
    f4 = new NodeToken("(");
    f5 = n2;
    f6 = new NodeToken(")");
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
