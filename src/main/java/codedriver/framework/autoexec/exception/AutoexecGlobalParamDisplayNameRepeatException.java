package codedriver.framework.autoexec.exception;

import codedriver.framework.exception.core.ApiRuntimeException;

/**
 * @author longrf
 * @date 2022/4/19 11:23 上午
 */
public class AutoexecGlobalParamDisplayNameRepeatException extends ApiRuntimeException {
    public AutoexecGlobalParamDisplayNameRepeatException(String name) {
        super("全局参数显示名：'" + name + "'已存在");
    }
}
