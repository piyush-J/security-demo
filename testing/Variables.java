import security.qual.TopSecret;
import security.qual.Confidential;
import security.qual.Public;

public class Variables {

	// box Field
    @TopSecret String secretStringField = "TopSecret";
    // :: fixable-error: (assignment.type.incompatible)
    @Confidential String confidentialStringField = "Confidential";
    // :: fixable-error: (assignment.type.incompatible)
    @Public String publicStringField = "Public";

    // primitive Field
    @TopSecret int secretIntField = 0;
    // :: fixable-error: (assignment.type.incompatible)
    @Confidential byte confidentialIntField = 1;
    // :: fixable-error: (assignment.type.incompatible)
    @Public char publicIntField = 2;

  	void boxVars() {
	    @TopSecret String secretString = "TopSecret";
        // :: fixable-error: (assignment.type.incompatible)
	    @Confidential String confidentialString = "Confidential";
        // :: fixable-error: (assignment.type.incompatible)
	    @Public String publicString = "Public";
    }

    void primitiveVars() {
	    @TopSecret int secretVar = 0;
        // :: fixable-error: (assignment.type.incompatible)
    	@Confidential byte confidentialVar = 1;
        // :: fixable-error: (assignment.type.incompatible)
    	@Public char publicVar = 2;
    }
}
