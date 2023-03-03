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

/**
 * @author: linbq
 * @date: 2021/4/13 14:49
 **/
public class AutoexecScheduleNameRepeatException extends ApiRuntimeException {

    private static final long serialVersionUID = -977867974799886183L;

    public AutoexecScheduleNameRepeatException(String name) {
        super("exception.autoexec.autoexecschedulenamerepeatexception", name);
    }
}
