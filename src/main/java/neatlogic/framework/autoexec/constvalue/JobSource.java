/*Copyright (C) 2024  深圳极向量科技有限公司 All Rights Reserved.

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU Affero General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU Affero General Public License for more details.

You should have received a copy of the GNU Affero General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.*/

package neatlogic.framework.autoexec.constvalue;

import neatlogic.framework.autoexec.source.IAutoexecJobSource;
import neatlogic.framework.util.$;

public enum JobSource implements IAutoexecJobSource {
    HUMAN("人工", "human"),
    SERVICE("快捷服务", "service"),
    AUTOEXEC_SCHEDULE("定时任务", "autoexecschedule"),
    COMBOP("组合工具", "combop"),
    COMBOP_TEST("组合工具测试", "comboptest"),
    SCRIPT_TEST("自定义工具测试", "scripttest"),
    TOOL_TEST("工具测试", "tooltest"),
    TEST("测试", "test");
    private final String text;
    private final String value;


    JobSource(String _text, String _value) {
        this.text = _text;
        this.value = _value;
    }

    public String getValue() {
        return value;
    }

    public String getText() {
        return $.t(text);
    }

    public static String getText(String _status) {
        for (JobSource s : JobSource.values()) {
            if (s.getValue().equals(_status)) {
                return s.getText();
            }
        }
        return "";
    }

    public String getType(){
        return JobSourceType.AUTOEXEC.getValue();
    }

}
