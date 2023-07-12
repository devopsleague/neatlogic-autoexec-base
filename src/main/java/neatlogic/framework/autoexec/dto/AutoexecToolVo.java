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

package neatlogic.framework.autoexec.dto;

import neatlogic.framework.common.constvalue.ApiParamType;
import neatlogic.framework.restful.annotation.EntityField;
import com.alibaba.fastjson.JSONObject;

public class AutoexecToolVo extends AutoexecOperationVo {
    @EntityField(name = "common.isactive", type = ApiParamType.INTEGER)
    private Integer isActive;

    public AutoexecToolVo() {
    }

    public AutoexecToolVo(JSONObject object) {
        setName(object.getString("opName"));
        setExecMode(object.getString("opType"));
        setParser(object.getString("interpreter"));
        setDescription(object.getString("description"));
        setLcd(object.getDate("lcd"));
    }

    public Integer getIsActive() {
        return isActive;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }

}
