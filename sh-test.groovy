#!/usr/bin/env -S groovy

import static System.out
import groovy.transform.CompileStatic

String test(String s) {
   return s + s
}

@CompileStatic
class TestSh {

   static String test(String s) {
      return s + s
   }

   static void main(String[] argv) {
      String s = '1'
      int i = 0

      out.println("H ${test(s)} ${i}")
   }

}

TestSh test = new TestSh()
test.main(new String[]{})
