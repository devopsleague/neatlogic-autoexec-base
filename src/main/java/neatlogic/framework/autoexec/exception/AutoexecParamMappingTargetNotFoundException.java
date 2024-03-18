/*Copyright (C) $today.year  深圳极向量科技有限公司 All Rights Reserved.

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

package neatlogic.framework.autoexec.exception;

import neatlogic.framework.exception.core.ApiRuntimeException;

/**
 * @author: linbq
 * @since: 2021/4/19 11:23
 **/
public class AutoexecParamMappingTargetNotFoundException extends ApiRuntimeException {

    private static final long serialVersionUID = -977868375722886184L;

    public AutoexecParamMappingTargetNotFoundException(String phaseName, String operationName, String key, String target) {
        super("nfae.autoexecparammappingtargetnotfoundexception.autoexecparammappingtargetnotfoundexception_a", phaseName, operationName, key, target);
    }

    public AutoexecParamMappingTargetNotFoundException(String phaseName, String target) {
        super("nfae.autoexecparammappingtargetnotfoundexception.autoexecparammappingtargetnotfoundexception_b", phaseName, target);
    }
    public AutoexecParamMappingTargetNotFoundException(Integer groupSort, String target) {
        super("nfae.autoexecparammappingtargetnotfoundexception.autoexecparammappingtargetnotfoundexception_c", groupSort, target);
    }
    public AutoexecParamMappingTargetNotFoundException(String target) {
        super("nfae.autoexecparammappingtargetnotfoundexception.autoexecparammappingtargetnotfoundexception_d", target);
    }

}
