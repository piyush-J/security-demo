import security.qual.TopSecret;
import security.qual.Confidential;
import security.qual.Public;

public class TypeCheck {

  void topSecretFunc(@TopSecret String p) {}
  void confidentialFunc(@Confidential String p) {}
  void publicFunc(@Public String p) {}

  void parameter(@TopSecret String s1, @Confidential String s2, @Public String s3) {
    topSecretFunc(s1);		// OK
    // :: error: (argument.type.incompatible)
    confidentialFunc(s1);
    // :: error: (argument.type.incompatible)
    publicFunc(s1);

    topSecretFunc(s2);		// OK
    confidentialFunc(s2);	// OK
    // :: error: (argument.type.incompatible)
    publicFunc(s2);

    topSecretFunc(s3);		// OK
    confidentialFunc(s3);	// OK
    publicFunc(s3);		// OK
  }
}
