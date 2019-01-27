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
    // :: fixable-error: (assignment.type.incompatible)
    @TopSecret String s = topSecreteMethod("");
  }

  void confidentialMethodTest() {
    // :: fixable-error: (assignment.type.incompatible)
    @Confidential String s = confidentialMethod("");
  }

  void publicMethodTest() {
    // :: fixable-error: (assignment.type.incompatible)
    @Public String s = publicMethod("");
  }
}