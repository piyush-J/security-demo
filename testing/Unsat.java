import security.qual.TopSecret;
import security.qual.Public;

public class Unsat {

  	void inferTop(@TopSecret String p) {
        String s = p;
        // :: fixable-error: (assignment.type.incompatible)
        @Public String x = s;
    }
}
