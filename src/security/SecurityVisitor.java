package security;

import checkers.inference.InferenceChecker;
import checkers.inference.InferenceVisitor;
import org.checkerframework.common.basetype.BaseAnnotatedTypeFactory;

public class SecurityVisitor extends InferenceVisitor<SecurityChecker, BaseAnnotatedTypeFactory> {
    public SecurityVisitor(
            SecurityChecker checker,
            InferenceChecker ichecker,
            BaseAnnotatedTypeFactory factory,
            boolean infer) {
        super(checker, ichecker, factory, infer);
    }
}
