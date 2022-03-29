/*
 * Copyright(c) 2021. TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.dao.mapper;

import codedriver.framework.autoexec.dto.AutoexecOperationVo;
import codedriver.framework.autoexec.dto.AutoexecToolAndScriptVo;
import codedriver.framework.autoexec.dto.combop.AutoexecCombopVo;
import codedriver.framework.autoexec.dto.script.*;
import codedriver.framework.common.dto.ValueTextVo;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.List;

public interface AutoexecScriptMapper {

    AutoexecScriptVo getScriptBaseInfoById(Long id);

    AutoexecScriptVo getScriptBaseInfoByName(String name);

    List<AutoexecScriptVo> getAutoexecScriptByIdList(ArrayList<Long> idList);

    AutoexecScriptVo getScriptLockById(Long id);

    int checkScriptIsExistsById(Long id);

    int checkScriptNameIsExists(AutoexecScriptVo vo);

    int checkScriptUkIsExists(AutoexecScriptVo vo);

    List<Long> checkScriptIdListExists(List<Long> idList);

    int checkScriptLineContentHashIsExists(String hash);

    AutoexecScriptVersionVo getVersionByVersionIdForUpdate(Long versionId);

    AutoexecScriptVersionVo getVersionByVersionId(Long versionId);

    List<AutoexecScriptVersionVo> getVersionByVersionIdList(ArrayList<Long> versionIdList);

    Integer getMaxVersionByScriptId(Long id);

    int getVersionCountByScriptId(Long scriptId);

    List<AutoexecScriptVersionVo> getVersionList(AutoexecScriptVersionVo versionVo);

    List<AutoexecScriptVersionVo> getVersionListByScriptId(AutoexecScriptVersionVo vo);

    int searchVersionCountForSelect(AutoexecScriptVersionVo vo);

    List<AutoexecScriptVersionVo> searchVersionListForSelect(AutoexecScriptVersionVo vo);

    List<ValueTextVo> getVersionNumberListByScriptId(Long id);

    AutoexecScriptVersionVo getActiveVersionByScriptId(Long scriptId);

    AutoexecScriptVersionVo getActiveVersionLockByScriptId(Long scriptId);

    Integer getActiveVersionNumberByScriptId(Long scriptId);

    List<AutoexecScriptVo> getActiveVersionNumberListByScriptIdList(List<Long> idList);

    AutoexecScriptVersionVo getLatestVersionByScriptId(Long scriptId);

    AutoexecScriptVersionVo getRecentlyVersionByScriptIdAndStatus(@Param("scriptId") Long scriptId, @Param("status") String status);

    int searchHistoricalVersionCountByScriptIdAndStatus(AutoexecScriptVersionVo versionVo);

    List<AutoexecScriptVersionVo> searchHistoricalVersionListByScriptIdAndStatus(AutoexecScriptVersionVo versionVo);

    List<AutoexecScriptVersionVo> getScriptVersionListByScriptId(Long scriptId);

    List<AutoexecScriptVersionParamVo> getParamListByVersionId(Long versionId);

    List<AutoexecScriptVersionParamVo> getParamListByVersionIdAndMode(@Param("versionId") Long versionId, @Param("mode") String mode);

    List<AutoexecScriptVersionParamVo> getParamListByScriptId(Long operationId);

    List<AutoexecScriptLineVo> getLineListByVersionId(Long versionId);

    int searchScriptCount(AutoexecScriptVo scriptVo);

    List<AutoexecScriptVo> searchScript(AutoexecScriptVo scriptVo);

    int searchScriptAndToolCount(AutoexecToolAndScriptVo searchVo);

    List<AutoexecToolAndScriptVo> searchScriptAndTool(AutoexecToolAndScriptVo searchVo);

    List<AutoexecToolAndScriptVo> getScriptListByIdList(List<Long> idList);

    List<AutoexecOperationVo> getAutoexecOperationListByIdList(List<Long> idList);

    int getReferenceCountByScriptId(Long scriptId);

    List<AutoexecCombopVo> getReferenceListByScriptId(Long scriptId);

    List<Long> getVersionIdListByScriptId(Long scriptId);

    AutoexecScriptAuditVo getScriptAuditByScriptVersionIdAndOperate(@Param("versionId") Long versionId, @Param("operate") String operate);

    String getScriptAuditDetailByHash(String hash);

    /**
     * 检查脚本是否已经被发布为组合工具
     *
     * @param scriptId
     * @return
     */
    int checkScriptHasBeenGeneratedToCombop(Long scriptId);

    List<AutoexecScriptVo> checkScriptListHasBeenGeneratedToCombop(List<Long> scriptIdList);

    List<AutoexecScriptVo> getReferenceCountListByScriptIdList(List<Long> scriptIdList);

    int checkScriptHasSubmittedVersionByScriptId(Long scriptId);

    List<Long> getVersionIdList();

    Long getAutoexecCatalogIdByScriptId(Long scriptId);

    /**
     * 根据工具目录id查询有激活版本的脚本id
     *
     * @param catalogIdList 工具目录id列表
     * @return
     */
    List<Long> getAutoexecScriptIdListWhichHasActiveVersionByCatalogIdList(@Param("catalogIdList") List<Long> catalogIdList);

    int updateScriptBaseInfo(AutoexecScriptVo scriptVo);

    int updateScriptVersion(AutoexecScriptVersionVo versionVo);

    int insertScript(AutoexecScriptVo vo);

    int insertScriptVersion(AutoexecScriptVersionVo versionVo);

    int insertScriptVersionParamList(List<AutoexecScriptVersionParamVo> paramList);

    int insertScriptLineContent(AutoexecScriptLineContentVo contentVo);

    int insertScriptAudit(AutoexecScriptAuditVo auditVo);

    int insertScriptAuditDetail(AutoexecScriptAuditContentVo auditContentVo);

    int insertScriptLineList(List<AutoexecScriptLineVo> lineList);

    int batchInsertScriptVersion(List<AutoexecScriptVersionVo> versionList);

    int deleteParamByVersionId(Long versionId);

    int deleteScriptLineByVersionId(Long versionId);

    int deleteParamByVersionIdList(List<Long> versionId);

    int deleteScriptLineByScriptId(Long scriptId);

    int deleteScriptVersionByScriptId(Long scriptId);

    int deleteScriptAuditByScriptId(Long scriptId);

    int deleteVersionByVersionId(Long versionId);

    int deleteScriptById(Long id);

}
