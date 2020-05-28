import security.qual.TopSecret;
import security.qual.Confidential;
import security.qual.Public;

public class MethodInvoke {

  String topSecreteMethod(String s) {
      return s;
  }

  String confidentialMethod(String s) {
      return s;
  }

  String publicMethod(String s) {
      return s;
  }

  void topSecreteMethodTest() {
    @TopSecret String s = topSecreteMethod("");
  }

  void confidentialMethodTest() {
    @Confidential String s = confidentialMethod("");
  }

  void publicMethodTest() {
    @Public String s = publicMethod("");
  }
}