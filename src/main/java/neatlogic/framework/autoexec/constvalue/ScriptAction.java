/*
Copyright(c) 2023 NeatLogic Co., Ltd. All Rights Reserved.

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

package neatlogic.framework.autoexec.constvalue;

import neatlogic.framework.util.I18nUtils;

public enum ScriptAction {
    SWITCH_VERSION("switchversion", "enum.autoexec.scriptaction.switch_version.a", "enum.autoexec.scriptaction.switch_version.b", true),
    DISABLE("disable", "enum.autoexec.scriptaction.disable.a", "enum.autoexec.scriptaction.disable.b", true),
    DELETE("delete", "enum.autoexec.scriptaction.delete.a", "enum.autoexec.scriptaction.delete.b", true),
    SUBMIT("submit", "enum.autoexec.scriptaction.submit.a", "enum.autoexec.scriptaction.submit.b", true),
    PASS("pass", "enum.autoexec.scriptaction.pass.a", "enum.autoexec.scriptaction.pass.b", true),
    REJECT("reject", "enum.autoexec.scriptaction.reject.a", "enum.autoexec.scriptaction.reject.b", true),
    REVOKE("revoke", "enum.autoexec.scriptaction.revoke.a", "enum.autoexec.scriptaction.revoke.b", true);
    private String value;
    private String text;
    private String title;
    private boolean needReplaceParam;

    private ScriptAction(String value, String text, String title, boolean needReplaceParam) {
        this.value = value;
        this.text = text;
        this.title = title;
        this.needReplaceParam = needReplaceParam;
    }

    public String getValue() {
        return value;
    }

    public String getText() {
        return I18nUtils.getMessage(text);
    }

    public String getTitle() {
        return I18nUtils.getMessage(title);
    }

    public static boolean isNeedReplaceParam(String _value) {
        for (ScriptAction operate : values()) {
            if (operate.value.equals(_value)) {
                return operate.needReplaceParam;
            }
        }
        return false;
    }

    public static String getTitle(String _value) {
        for (ScriptAction operate : values()) {
            if (operate.value.equals(_value)) {
                return operate.getTitle();
            }
        }
        return "";
    }

}
