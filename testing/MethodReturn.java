import security.qual.TopSecret;
import security.qual.Confidential;
import security.qual.Public;

public class MethodReturn {

  String topSecreteMethod(@TopSecret String s) {
      // :: fixable-error: (return.type.incompatible)
      return s;
  }

  String confidentialMethod(@Confidential String s) {
      // :: fixable-error: (return.type.incompatible)
      return s;
  }

  String publicMethod(@Public String s) {
      return s;
  }
}
