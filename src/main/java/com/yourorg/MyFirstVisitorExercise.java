package com.yourorg;

import org.openrewrite.*;
import org.openrewrite.java.JavaIsoVisitor;
import org.openrewrite.java.tree.J;

public class MyFirstVisitorExercise extends Recipe {
    @Override
    public @NlsRewrite.DisplayName String getDisplayName() {
        return "How to use a visitor";
    }

    @Override
    public @NlsRewrite.Description String getDescription() {
        return "First try to see visitors myself.";
    }

    @Override
    public TreeVisitor<?, ExecutionContext> getVisitor() {
        return new JavaIsoVisitor<ExecutionContext>() {
            @Override
            public J.MethodDeclaration visitMethodDeclaration(J.MethodDeclaration method, ExecutionContext ctx) {
                J.MethodDeclaration visited = super.visitMethodDeclaration(method, ctx);
                if (getCursor().getMessage("sum", 0) == 42) {
                    return method.withName(method.getName().withSimpleName("theAnswerToLife"))
                            .withMethodType(method.getMethodType().withName("theAnswerToLife"));
                }
                return visited;
            }

            @Override
            public J.Literal visitLiteral(J.Literal literal, ExecutionContext executionContext) {
                Object value = literal.getValue();
                if (value instanceof Integer) {
                    Cursor method = getCursor().dropParentUntil(J.MethodDeclaration.class::isInstance);
                    Integer sum = method.getMessage("sum", 0);
                    method.putMessage("sum", sum + (Integer) value);
                }
                return super.visitLiteral(literal, executionContext);
            }
        };
    }
}
