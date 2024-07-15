package com.yourorg;

import org.openrewrite.NlsRewrite;
import org.openrewrite.Recipe;

public class MyFirstVisitorExercise extends Recipe {
    @Override
    public @NlsRewrite.DisplayName String getDisplayName() {
        return "How to use a visitor";
    }

    @Override
    public @NlsRewrite.Description String getDescription() {
        return "First try to see visitors myself.";
    }
}
