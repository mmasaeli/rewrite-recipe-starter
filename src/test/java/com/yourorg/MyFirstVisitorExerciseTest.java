package com.yourorg;

import org.junit.jupiter.api.Test;
import org.openrewrite.test.RecipeSpec;
import org.openrewrite.test.RewriteTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.openrewrite.java.Assertions.java;

class MyFirstVisitorExerciseTest implements RewriteTest {

    @Override
    public void defaults(RecipeSpec spec) {
        spec.recipe(new MyFirstVisitorExercise());
    }

    @Test
    void theAnswerToUniverseTest() {
        rewriteRun(
          java("""
            class Test{
               void testMethod() {
               }
            }
            """)
        );
    }

}