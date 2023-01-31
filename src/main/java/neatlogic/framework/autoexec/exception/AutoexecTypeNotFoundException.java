/*
 * Copyright(c) 2021. TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package neatlogic.framework.autoexec.exception;

import neatlogic.framework.exception.core.ApiRuntimeException;

public class AutoexecTypeNotFoundException extends ApiRuntimeException {

    private static final long serialVersionUID = -7666866845075372241L;

    public AutoexecTypeNotFoundException(Long id) {
        super("工具类型：'" + id + "'不存在");
    }

    public AutoexecTypeNotFoundException(String name) {
        super("工具类型：'" + name + "'不存在");
    }


}
