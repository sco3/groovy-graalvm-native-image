#!/usr/bin/env -S groovy

import static java.lang.System.out

class TestSh {

    static Process runCommand(String s) {
        Process p = s.execute()
        p.waitFor()
        for (String line : p.getInputStream().readLines()) {
            out.println("Execute: ${line}")
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
