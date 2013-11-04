package org.renjin.compiler.ir.tac.expressions;

import java.util.Collections;
import java.util.List;

import com.sun.org.apache.bcel.internal.generic.INVOKEVIRTUAL;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.renjin.compiler.emit.EmitContext;


/**
 * The length of an expression.
 * 
 * <p>This is a bit annoying to add this to the set of expressions,
 * but we need it to translate for expressions, because the length
 * primitive is generic, but the for loop always uses the actual length of the
 * vector. (is this another sign we need to push 'fors' down into the IR level?)
 */
public class Length extends SpecializedCallExpression implements SimpleExpression {

  public Length(Expression vector) {
    super(vector);
  }

  public Expression getVector() {
    return arguments[0];
  }

  @Override
  public boolean isFunctionDefinitelyPure() {
    return true;
  }

  @Override
  public void emitPush(EmitContext emitContext, MethodVisitor mv) {
    getVector().emitPush(emitContext, mv);
    mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "org/renjin/sexp/SEXP", "length", "()I");
  }

  @Override
  public Class getType() {
    return int.class;
  }

  @Override
  public String toString() {
    return "length(" + getVector() + ")";
  }

  @Override
  public void resolveType() {
  }

  @Override
  public boolean isTypeResolved() {
    return true;
  }
}
