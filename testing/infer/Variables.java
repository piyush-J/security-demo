import security.qual.TopSecret;
import security.qual.Confidential;
import security.qual.Public;

public class Variables {

    // box Field
    @TopSecret String secretStringField = "TopSecret";
    @Confidential String confidentialStringField = "Confidential";
    @Public String publicStringField = "Public";

    // primitive Field
    @TopSecret int secretIntField = 0;
    @Confidential byte confidentialIntField = 1;
    @Public char publicIntField = 2;

    void boxVars() {
        @TopSecret String secretString = "TopSecret";
        @Confidential String confidentialString = "Confidential";
        @Public String publicString = "Public";

        secretString = secretStringField;
        confidentialString = confidentialStringField;
        publicString = publicStringField;
    }

    void primitiveVars() {
        @TopSecret int secretVar = 0;
        @Confidential byte confidentialVar = 1;
        @Public char publicVar = 2;

        secretVar = 0;
        confidentialVar = 1;
        publicVar = 2;
    }
}
