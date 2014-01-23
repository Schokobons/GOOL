/* Generated by JTB 1.4.4 */
package gool.parser.objc.jtb.core;

import gool.parser.objc.jtb.visitor.IRetArguVisitor;
import gool.parser.objc.jtb.visitor.IRetVisitor;
import gool.parser.objc.jtb.visitor.IVoidArguVisitor;
import gool.parser.objc.jtb.visitor.IVoidVisitor;

public class NodeChoice implements INode {

  public INode choice;

  public int which;

  public int total;

  private static final long serialVersionUID = 144L;

  public NodeChoice(final INode node) {
   this(node, -1, -1);
  }

  public NodeChoice(final INode node, final int whichChoice, final int totalChoices) {
    choice = node;
    which = whichChoice;
    total = totalChoices;
  }

  public <R, A> R accept(final IRetArguVisitor<R, A> vis, final A argu) {
    return choice.accept(vis, argu);
  }

  public <R> R accept(final IRetVisitor<R> vis) {
    return choice.accept(vis);
  }

  public <A> void accept(final IVoidArguVisitor<A> vis, final A argu) {
    choice.accept(vis, argu);
  }

  public void accept(final IVoidVisitor vis) {
    choice.accept(vis);
  }

}
