package security;

import org.checkerframework.common.basetype.BaseAnnotatedTypeFactory;
import org.checkerframework.common.basetype.BaseTypeChecker;

public class SecurityAnnotatedTypeFactory extends BaseAnnotatedTypeFactory {
    public SecurityAnnotatedTypeFactory(BaseTypeChecker checker) {
        super(checker);
        postInit();
    }
}
