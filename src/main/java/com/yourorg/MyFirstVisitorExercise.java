package com.yourorg;

import org.openrewrite.ExecutionContext;
import org.openrewrite.NlsRewrite;
import org.openrewrite.Recipe;
import org.openrewrite.TreeVisitor;
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
                if(method.getSimpleName().equals("testMethod"))
                    return method.withName(method.getName().withSimpleName("theAnswerToLife"))
                            .withMethodType(method.getMethodType().withName("theAnswerToLife"));
                return super.visitMethodDeclaration(method, ctx);
            }
        };
    }
}
