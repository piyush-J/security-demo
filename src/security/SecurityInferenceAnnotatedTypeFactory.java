package security;

import checkers.inference.InferenceAnnotatedTypeFactory;
import checkers.inference.InferenceChecker;
import checkers.inference.InferenceMain;
import checkers.inference.InferenceQualifierHierarchy;
import checkers.inference.InferrableChecker;
import checkers.inference.SlotManager;
import checkers.inference.model.ConstraintManager;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import javax.lang.model.element.AnnotationMirror;
import org.checkerframework.common.basetype.BaseAnnotatedTypeFactory;
import org.checkerframework.framework.type.QualifierHierarchy;
import org.checkerframework.framework.util.MultiGraphQualifierHierarchy.MultiGraphFactory;
import org.checkerframework.javacutil.AnnotationBuilder;
import org.checkerframework.javacutil.AnnotationUtils;
import security.qual.TopSecret;

public class SecurityInferenceAnnotatedTypeFactory extends InferenceAnnotatedTypeFactory {

    protected final AnnotationMirror TOPSECRET = AnnotationBuilder
            .fromClass(elements, TopSecret.class);

    public SecurityInferenceAnnotatedTypeFactory(
            InferenceChecker inferenceChecker,
            boolean withCombineConstraints,
            BaseAnnotatedTypeFactory realTypeFactory,
            InferrableChecker realChecker,
            SlotManager slotManager,
            ConstraintManager constraintManager) {
        super(
                inferenceChecker,
                withCombineConstraints,
                realTypeFactory,
                realChecker,
                slotManager,
                constraintManager);
        postInit();
    }

    @Override
    protected Set<? extends AnnotationMirror> getDefaultTypeDeclarationBounds() {
        Set<AnnotationMirror> top = new HashSet<>();
        top.add(TOPSECRET);
        return top;
    }

    @Override
    public QualifierHierarchy createQualifierHierarchy(MultiGraphFactory factory) {
        return new SecurityInferenceQualifierHierarchy(factory);
    }

    private static final class SecurityInferenceQualifierHierarchy extends
            InferenceQualifierHierarchy {

        SecurityInferenceQualifierHierarchy(MultiGraphFactory factory) {
            super(factory);
        }

        @Override
        public Set<? extends AnnotationMirror> leastUpperBounds(
                Collection<? extends AnnotationMirror> annos1,
                Collection<? extends AnnotationMirror> annos2) {
            if (InferenceMain.isHackMode(annos1.size() != annos2.size())) {
                Set<AnnotationMirror> result = AnnotationUtils.createAnnotationSet();
                for (AnnotationMirror a1 : annos1) {
                    for (AnnotationMirror a2 : annos2) {
                        AnnotationMirror lub = leastUpperBound(a1, a2);
                        if (lub != null) {
                            result.add(lub);
                        }
                    }
                }
                return result;
            }
            return super.leastUpperBounds(annos1, annos2);
        }
    }
}
