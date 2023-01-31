/*
 * Copyright(c) 2021. TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package neatlogic.framework.autoexec.dao.mapper;

import neatlogic.framework.autoexec.dto.AutoexecRiskVo;
import neatlogic.framework.common.dto.ValueTextVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AutoexecRiskMapper {

    int checkRiskIsExistsById(Long id);

    Long getRiskIdByName(String name);

    List<ValueTextVo> getAllActiveRisk();

    AutoexecRiskVo getAutoexecRiskById(Long riskId);

    int searchRiskCount(AutoexecRiskVo vo);

    List<AutoexecRiskVo> searchRisk(AutoexecRiskVo vo);

    Integer getMaxSort();

    int checkRiskNameIsRepeats(AutoexecRiskVo vo);

    int checkRiskHasBeenReferredById(Long id);

    List<AutoexecRiskVo> getReferenceCountListForTool(List<Long> idList);

    List<AutoexecRiskVo> getReferenceCountListForScript(List<Long> idList);

    int updateRisk(AutoexecRiskVo vo);

    int updateSortDecrement(@Param("fromSort")Integer fromSort, @Param("toSort")Integer toSort);

    int updateSortIncrement(@Param("fromSort")Integer fromSort, @Param("toSort")Integer toSort);

    int insertRisk(AutoexecRiskVo vo);

    int deleteRiskById(Long id);
}
