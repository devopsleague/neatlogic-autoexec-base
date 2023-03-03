/*
Copyright(c) $today.year NeatLogic Co., Ltd. All Rights Reserved.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 */

package neatlogic.framework.autoexec.exception;

import neatlogic.framework.exception.core.ApiRuntimeException;

public class AutoexecJobPhaseNodeNotFoundException extends ApiRuntimeException {

    private static final long serialVersionUID = 4522850144891547590L;

    public AutoexecJobPhaseNodeNotFoundException(String phase, String node) {
        super("exception.autoexec.autoexecjobphasenodenotfoundexception", phase, node);
    }

    public AutoexecJobPhaseNodeNotFoundException(String phase, Long nodeId) {
        super("exception.autoexec.autoexecjobphasenodenotfoundexception.1", phase, nodeId);
    }

    public AutoexecJobPhaseNodeNotFoundException(String phase, boolean isPhaseConfig) {
        super("exception.autoexec.autoexecjobphasenodenotfoundexception.2", phase, isPhaseConfig);
    }
}
