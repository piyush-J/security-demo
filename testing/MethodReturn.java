import security.qual.TopSecret;
import security.qual.Confidential;
import security.qual.Public;

public class MethodReturn {

  String topSecreteMethod(@TopSecret String s) {
      return s;
  }

  String confidentialMethod(@Confidential String s) {
      return s;
  }

  String publicMethod(@Public String s) {
      return s;
  }
}