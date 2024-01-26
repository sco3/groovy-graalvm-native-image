#!/usr/bin/env -S groovy
import groovy.transform.CompileStatic

import java.util.concurrent.TimeUnit

import static java.lang.System.out

@CompileStatic
class TestSh {

    static Process runCommand(String s) {
        Process p = s.execute()
        p.waitFor(4, TimeUnit.SECONDS)
        for (String line : p.getInputStream().readLines()) {
            out.println("${line}")
        }
        return p
    }

    public static void main(String[] argv) {
        Process p = runCommand('ls -la . ')
        out.println("Execute: ${p}")
    }
}

TestSh test = new TestSh()
test.main(new String[]{})
