package org.renjin.gcc.translate.marshall;


import org.renjin.gcc.jimple.JimpleExpr;
import org.renjin.gcc.translate.FunctionContext;
import org.renjin.gcc.translate.expr.Expr;

import java.util.List;

/**
 * Translator that knows how to marhshall an intermediate 
 * expression to a return value or a call parameter.
 */
public interface Marshaller {
  
  JimpleExpr marshall(FunctionContext context, Expr expr);
  
}