/*Copyright (C) 2023  深圳极向量科技有限公司 All Rights Reserved.

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

package neatlogic.framework.autoexec.dto.job;

import neatlogic.framework.common.constvalue.ApiParamType;
import neatlogic.framework.restful.annotation.EntityField;

public class AutoexecJobSortVo {
    @EntityField(name = "排序字段", type = ApiParamType.STRING)
    private String key;
    @EntityField(name = "排序类型", type = ApiParamType.STRING)
    private String type;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        switch (key) {
            case "planStartTime":
                key = "plan_start_time";
                break;
            case "startTime":
                key = "start_time";
                break;
            default:
                break;
        }
        this.key = key;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
