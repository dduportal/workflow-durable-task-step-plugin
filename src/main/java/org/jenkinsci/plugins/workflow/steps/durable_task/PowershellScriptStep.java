/*
 * The MIT License
 *
 * Copyright 2017 Gabriel Loewen
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package org.jenkinsci.plugins.workflow.steps.durable_task;

import hudson.Extension;
import org.jenkinsci.plugins.durabletask.DurableTask;
import org.jenkinsci.plugins.durabletask.PowershellScript;
import org.kohsuke.stapler.DataBoundConstructor;

/**
 * Asynchronous batch script execution.
 */
public class PowershellScriptStep extends DurableTaskStep {

    private final String script;

    @DataBoundConstructor public PowershellScriptStep(String script) {
        if (script == null) {
            throw new IllegalArgumentException();
        }
        this.script = script;
    }

    public String getScript() {
        return script;
    }

    @Override protected DurableTask task() {
        return new PowershellScript(script);
    }

    @Extension public static final class DescriptorImpl extends DurableTaskStepDescriptor {

        @Override public String getDisplayName() {
            return "Windows PowerShell Script";
        }

        @Override public String getFunctionName() {
            return "powershell";
        }

    }

}
