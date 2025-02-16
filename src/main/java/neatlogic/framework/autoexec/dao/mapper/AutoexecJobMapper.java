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

package neatlogic.framework.autoexec.dao.mapper;

import com.alibaba.fastjson.JSONArray;
import neatlogic.framework.autoexec.annotation.AutoexecJobCallback;
import neatlogic.framework.autoexec.annotation.AutoexecJobCallbackParam;
import neatlogic.framework.autoexec.dto.combop.AutoexecCombopVo;
import neatlogic.framework.autoexec.dto.customtemplate.CustomTemplateVo;
import neatlogic.framework.autoexec.dto.job.*;
import neatlogic.framework.dto.runner.RunnerMapVo;
import neatlogic.framework.dto.runner.RunnerVo;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

public interface AutoexecJobMapper {
    //job
    List<Long> getJobIdListByParentId(Long parentId);

    List<Long> searchJobId(AutoexecJobVo jobVo);

    List<AutoexecJobVo> searchJob(@Param("jobIdList") List<Long> jobIdList, @Param("jobVo") AutoexecJobVo jobVo);

    List<AutoexecJobVo> getJobByExpiredDays(int expiredDays);

    AutoexecJobVo getJobInfo(Long jobId);

    List<AutoexecJobVo> getJobWarnCountAndStatus(List<Long> idList);

    List<AutoexecJobVo> getJobListByIdList(List<Long> idList);

    AutoexecJobVo getLatestJobByInvokeId(Long invokeId);

    Integer searchJobCount(AutoexecJobVo jobVo);

    List<AutoexecCombopVo> searchJobWithCombopView(AutoexecJobVo jobVo);

    Integer checkIsJobUser(@Param("jobId") Long jobId, @Param("userList") List<String> userList);

    AutoexecJobVo getJobLockByJobId(Long jobId);

    List<AutoexecJobVo> getJobListLockByParentIdAndStatus(@Param("parentId") Long id, @Param("status") String status);

    List<AutoexecJobVo> getJobListByParentIdAndNotInStatus(@Param("parentId") Long id, @Param("status") String status);

    List<AutoexecJobVo> getParentAutoexecJobListIdList(List<Long> idList);

    AutoexecJobContentVo getJobContentLock(String hash);

    AutoexecJobContentVo getJobContent(String hash);

    int checkIsJobParamReference(@Param("jobId") Long jobId, @Param("hash") String hash);

    AutoexecJobVo getJobLockByOperationId(Long operationId);

    //jobGroup
    AutoexecJobGroupVo getJobGroupByJobIdAndSort(@Param("jobId") Long id, @Param("sort") int sort);

    List<AutoexecJobGroupVo> getJobGroupByJobId(@Param("jobId") Long id);

    List<Long> getJobIdListByStatusAndTriggerTypeWithoutBatch(@Param("status") String status, @Param("triggerType") String triggerType);

    List<Long> getBatchJobIdListByStatusAndTriggerType(@Param("status") String status, @Param("triggerType") String triggerType);

    AutoexecJobGroupVo getJobGroupById(Long groupId);

    //jobPhase
    List<AutoexecJobPhaseVo> getJobPhaseListWithGroupByJobId(Long jobId);

    List<AutoexecJobPhaseVo> getJobPhaseListWithGroupByJobIdList(List<Long> jobIdList);

    List<AutoexecJobPhaseVo> getJobPhaseListByJobIdAndPhaseStatus(@Param("jobId") Long jobId, @Param("statusList") List<String> statusList);

    List<AutoexecJobPhaseVo> getJobPhaseListByJobIdAndNodeStatusList(@Param("jobId") Long jobId, @Param("statusList") List<String> statusList);

    AutoexecJobPhaseVo getJobPhaseByPhaseId(Long jobPhaseId);

    AutoexecJobPhaseVo getJobPhaseByJobIdAndPhaseId(@Param("jobId") Long jobId, @Param("jobPhaseId") Long jobPhaseId);

    AutoexecJobPhaseVo getFirstJobPhase(Long jobId);

    AutoexecJobPhaseVo getJobPhaseByJobIdAndPhaseName(@Param("jobId") Long jobId, @Param("jobPhaseName") String jobPhaseName);

    AutoexecJobPhaseVo getJobPhaseByJobIdAndPhaseNameWithGroup(@Param("jobId") Long jobId, @Param("jobPhaseName") String jobPhaseName);

    Integer getJobPhaseNotCompletedCountByJobIdAndGroupSort(@Param("jobId") Long jobId, @Param("groupSort") Integer groupSort);

    List<AutoexecJobPhaseVo> getJobPhaseListByJobIdAndGroupSort(@Param("jobId") Long jobId, @Param("sort") Integer sort);

    Integer checkIsHasActivePhaseFailed(Long jobId);

    int getJobPhaseRunnerCountByPhaseIdListAndRunnerNotStatus(@Param("jobPhaseIdList") List<Long> jobPhaseIdList, @Param("status") String status);

    int getJobPhaseRunnerCountByJobIdAndRunnerStatus(@Param("jobId") Long jobId, @Param("status") String status);

    int getJobPhaseRunnerByPhaseListAndStatusCount(@Param("jobPhaseIdList") List<Long> jobPhaseIdList, @Param("status") String status);

    List<AutoexecJobPhaseVo> getJobPhaseByJobIdAndRunnerStatus(@Param("jobId") Long jobId, @Param("status") String status);

    AutoexecJobPhaseVo getJobPhaseByJobIdAndPhaseStatus(@Param("jobId") Long id, @Param("status") String status);

    AutoexecJobPhaseVo getJobActivePhase(Long jobId);

    List<AutoexecJobPhaseVo> getJobPhaseListWithGroupByJobIdAndPhaseIdList(@Param("jobId") Long jobId, @Param("jobPhaseIdList") List<Long> jobPhaseIdList);

    List<AutoexecJobPhaseVo> getJobPhaseListByJobIdAndPhaseUuidList(@Param("jobId") Long id, @Param("phaseUuidList") List<String> phaseUuidList);

    //jobPhaseRunner
    List<AutoexecJobPhaseRunnerVo> getJobPhaseRunnerByJobIdAndPhaseIdList(@Param("jobId") Long jobId, @Param("jobPhaseIdList") List<Long> jobPhaseId);

    //jobPhaseNode
    List<AutoexecJobPhaseNodeVo> searchJobPhaseNodeWithResource(AutoexecJobPhaseNodeVo jobPhaseNodeVo);

    List<AutoexecJobPhaseNodeVo> searchJobPhaseNodeByDistinct(AutoexecJobPhaseNodeVo nodeParamVo);

    List<AutoexecJobPhaseNodeVo> searchJobPhaseNode(AutoexecJobPhaseNodeVo jobPhaseNodeVo);

    List<AutoexecJobPhaseNodeVo> getJobPhaseNodeIdListByNodeVoAndStartNum(@Param("nodeVo") AutoexecJobPhaseNodeVo jobPhaseNodeVo, @Param("startNum") Integer startNum);

    int searchJobPhaseNodeCountWithResource(AutoexecJobPhaseNodeVo jobPhaseNodeVo);

    int searchJobPhaseNodeCount(AutoexecJobPhaseNodeVo jobPhaseNodeVo);

    int searchJobPhaseNodeByDistinctResourceIdCount(AutoexecJobPhaseNodeVo jobPhaseNodeVo);

    List<AutoexecJobPhaseNodeStatusCountVo> getJobPhaseNodeStatusCount(Long jobId);

    int checkIsJobPhaseNodeExist(AutoexecJobPhaseNodeVo nodeVo);

    List<CustomTemplateVo> getJobPhaseOperationCustomTemplateListByJobPhaseId(Long jobPhaseId);

    List<Long> getJobPhaseOpertionIdListByJobPhaseId(Long jobPhaseId);

    AutoexecJobPhaseOperationVo getMaxSortJobPhaseOperationByPhaseIdAndOperationId(@Param("jobPhaseId") Long jobPhaseId, @Param("operationId") Long operationId);

    @AutoexecJobCallback
    int updateJobStatus(@AutoexecJobCallbackParam() AutoexecJobVo jobVo);

    int updateJobPhaseNodeStatus(AutoexecJobPhaseNodeVo nodeVo);

    int updateJobPhaseNodeStatusByJobIdAndJobPhaseIdListAndRunnerId(@Param("jobId") Long jobId, @Param("jobPhaseIdList") List<Long> jobPhaseIdList, @Param("nodeStatusList") List<String> jobNodeStatusList, @Param("runnerId") Long runnerId);

    int searchJobPhaseSqlCount(AutoexecJobPhaseNodeVo jobPhaseNodeVo);

    AutoexecJobPhaseNodeVo getJobPhaseNodeInfoByJobNodeId(@Param("nodeId") Long nodeId);

    AutoexecJobPhaseNodeVo getJobPhaseNodeInfoByJobPhaseIdAndResourceId(@Param("jobPhaseId") Long jobPhaseId, @Param("resourceId") Long resourceId);

    AutoexecJobPhaseNodeVo getJobPhaseNodeInfoByJobIdAndJobPhaseNameAndResourceId(@Param("jobId") Long jobId, @Param("jobPhaseName") String jobPhaseName, @Param("resourceId") Long resourceId);

    AutoexecJobPhaseNodeVo getJobPhaseRunnerNodeByJobIdAndPhaseId(@Param("jobId") Long jobId, @Param("phaseId") Long phaseId);

    List<AutoexecJobPhaseNodeVo> getJobPhaseNodeListByJobIdAndPhaseNameAndExceptStatusAndRunnerId(@Param("jobId") Long jobId, @Param("phaseName") String phaseName, @Param("exceptStatus") List<String> exceptStatus, @Param("runnerId") Long runnerId);

    List<AutoexecJobPhaseNodeVo> getJobPhaseNodeListByJobIdAndPhaseIdAndExceptStatus(@Param("jobId") Long jobId, @Param("phaseId") Long phaseId, @Param("exceptStatus") List<String> exceptStatus);

    List<AutoexecJobPhaseNodeVo> getJobPhaseNodeListByJobIdAndPhaseIdAndExceptStatusAndRunnerMapId(@Param("jobId") Long jobId, @Param("phaseId") Long phaseId, @Param("exceptStatus") List<String> exceptStatus, @Param("runnerMapId") Long runnerMapId);

    List<AutoexecJobPhaseNodeVo> getJobPhaseNodeListByJobIdAndPhaseId(@Param("jobId") Long jobId, @Param("phaseId") Long phaseId);

    List<AutoexecJobPhaseNodeVo> getJobPhaseNodeListWithRunnerByJobId(@Param("jobId") Long jobId);

    List<AutoexecJobPhaseNodeVo> getJobPhaseNodeListWithoutDeleteByJobIdAndPhaseId(@Param("jobId") Long jobId, @Param("phaseId") Long phaseId);

    int getJobPhaseNodeCountWithoutDeleteByJobIdAndPhaseId(@Param("jobId") Long jobId, @Param("phaseId") Long phaseId);

    int getJobPhaseNodeCountWithoutDeleteByJobIdAndPhaseIdAndExceptStatusList(@Param("jobId") Long jobId, @Param("phaseId") Long phaseId, @Param("statusList") List<String> statusList);

    List<AutoexecJobPhaseNodeVo> getJobPhaseNodeListByJobIdAndPhaseName(@Param("jobId") Long jobId, @Param("phaseName") String phaseName);

    List<AutoexecJobPhaseNodeVo> getJobPhaseNodeListByNodeIdList(@Param("nodeIdList") List<Long> nodeIdList);

    List<AutoexecJobPhaseNodeVo> getJobPhaseNodeListByJobPhaseIdAndResourceIdList(@Param("jobPhaseId") Long jobPhaseId, @Param("resourceIdList") List<Long> resourceIdList);

    List<AutoexecJobPhaseNodeVo> getJobPhaseNodeListByJobPhaseIdAndResourceIdListAndIsDelete(@Param("jobPhaseId") Long jobPhaseId, @Param("resourceIdList") List<Long> resourceIdList);

    List<AutoexecJobPhaseNodeVo> getJobPhaseNodeRunnerListByNodeIdList(@Param("nodeIdList") List<Long> nodeIdList);

    List<AutoexecJobPhaseNodeVo> getJobPhaseNodeListWithRunnerByJobPhaseIdAndExceptStatusList(@Param("jobPhaseId") Long jobPhaseId, @Param("statusList") List<String> statusList);

    List<AutoexecJobPhaseNodeVo> getJobPhaseNodeListByJobIdAndNodeStatusList(@Param("jobId") Long jobId, @Param("statusList") List<String> statusList);

    int checkIsHasRunningNode(Long id);

    int updateJobPhaseNodeListStatus(@Param("nodeIdList") List<Long> jobPhaseNodeIdList, @Param("status") String status);

    List<AutoexecJobPhaseNodeVo> getJobPhaseNodeListBySqlIdList(@Param("sqlIdList") List<Long> sqlIdList);

    List<AutoexecJobPhaseNodeVo> getAutoexecJobNodeListByResourceIdList(List<Long> resourceIdList);

    List<AutoexecJobPhaseNodeVo> getAutoexecJobNodeListByJobIdAndResourceIdList(@Param("jobId") Long jobId, @Param("resourceIdList") List<Long> resourceIdList);

    //jobPhaseOperation
    List<AutoexecJobPhaseOperationVo> getJobPhaseOperationByJobId(Long jobId);

    List<AutoexecJobPhaseOperationVo> getJobPhaseOperationListWithoutParentByJobIdAndPhaseId(@Param("jobId") Long jobId, @Param("phaseId") Long phaseId);

    List<AutoexecJobPhaseOperationVo> getJobPhaseOperationListWithParentByJobIdAndPhaseId(@Param("jobId") Long jobId, @Param("phaseId") Long phaseId);

    AutoexecJobPhaseOperationVo getJobPhaseOperationByJobIdAndPhaseUuidAndUuid(@Param("jobId") Long jobId, @Param("phaseUuid") String phaseUuid, @Param("uuid") String uuid);

    AutoexecJobPhaseOperationVo getJobPhaseOperationByJobIdAndPhaseIdAndOperationId(@Param("jobId") Long jobId, @Param("jobPhaseId") Long jobPhaseId, @Param("jobPhaseOperationId") Long operationId);

    List<AutoexecJobPhaseOperationVo> getJobPhaseOperationByJobIdAndPhaseId(@Param("jobId") Long jobId, @Param("jobPhaseId") Long jobPhaseId);

    AutoexecJobPhaseOperationVo getJobPhaseOperationByOperationId(@Param("jobPhaseOperationId") Long operationId);

    int checkIsJobPhaseOperationParamReference(@Param("jobId") Long jobId, @Param("hash") String hash);

    //jobParamContent
    Integer getNextJobPhaseSortByJobId(@Param("jobId") Long jobId, @Param("sort") Integer sort);

    List<AutoexecJobContentVo> getJobContentList(@Param("hashList") List<String> hashList);

    //runner
    List<RunnerVo> getJobRunnerListByJobId(Long jobId);

    List<Long> getJobPhaseRunnerMapIdListByJobIdList(List<Long> jobIds);

    List<Long> getJobPhaseNodeRunnerMapIdListByNodeVo(AutoexecJobPhaseNodeVo nodeVo);

    RunnerVo getJobRunnerById(Long runnerId);

    List<RunnerMapVo> getJobPhaseRunnerMapByJobIdAndPhaseIdList(@Param("jobId") Long jobId, @Param("jobPhaseIdList") List<Long> jobPhaseId);

    List<RunnerMapVo> getJobPhaseRunnerByJobIdAndPhaseIdListAndStatus(@Param("jobId") Long jobId, @Param("jobPhaseIdList") List<Long> jobPhaseId, @Param("status") String status);

    List<RunnerMapVo> getJobRunnerListByJobIdAndGroupId(@Param("jobId") Long jobId, @Param("groupId") Long groupId);

    List<RunnerMapVo> getJobRunnerListByJobIdAndJobNodeIdList(@Param("jobId") Long jobId, @Param("nodeIdList") List<Long> nodeIdList);

    List<Long> getJobRunnerMapIdListByJobId(@Param("jobId") Long jobId);

    List<RunnerMapVo> getJobPhaseNodeRunnerListByJobPhaseId(Long jobPhaseId);

    //invoke
    AutoexecJobInvokeVo getJobInvokeByJobId(Long id);

    List<AutoexecJobInvokeVo> getJobInvokeListByJobIdList(List<Long> jobIdList);

    Long getJobIdByInvokeIdLimitOne(Long invokeId);

    List<Long> getJobIdListByInvokeId(Long invokeId);

    List<AutoexecJobInvokeVo> getJobIdCountListByInvokeIdList(List<Long> invokeIdList);

    String getAutoexecJobEnvValueByJobIdAndName(AutoexecJobEnvVo autoexecJobEnvVo);

    List<AutoexecJobEnvVo> getAutoexecJobEnvListByJobId(Long jobId);

    List<AutoexecJobEnvVo> getAutoexecJobEnvListByJobIdList(List<Long> jobIdList);

    Integer getJobPhaseRunnerNotCompletedCountByJobIdAndIsFireNextAndGroupSort(@Param("jobId") Long jobId, @Param("isFireNext") int isFireNext, @Param("groupSort") int groupSort);

    List<HashMap<String, String>> getJobPhaseRunnerAbortingCountMapCountByJobId(@Param("jobId") Long jobId);

    List<AutoexecJobPhaseNodeVo> getAutoexecJobNodeListByJobPhaseIdListAndStatusAndRunnerId(@Param("jobPhaseIdList") List<Long> jobPhaseIdList, @Param("status") String status, @Param("runnerId") Long runnerId);

    Integer getJobPhaseStatusCountByJobIdAndStatus(@Param("jobId") Long jobId, @Param("status") String status);

    //inspect
    List<AutoexecJobResourceInspectVo> getJobResourceInspectByResourceId(List<Long> resourceIdList);

    List<AutoexecJobPhaseVo> getJobPhaseListByJobIdAndNodeFromJob(Long jobId);

    //jobSql

    List<AutoexecSqlNodeDetailVo> searchJobPhaseSql(AutoexecJobPhaseNodeVo jobPhaseNodeVo);

    List<AutoexecSqlNodeDetailVo> getJobSqlDetailListByJobIdAndPhaseName(@Param("jobId") Long jobId, @Param("phaseName") String phaseName, @Param("sqlFileList") JSONArray sqlFileList);

    AutoexecSqlNodeDetailVo getJobSqlByResourceIdAndJobIdAndJobPhaseNameAndSqlFile(@Param("resourceId") Long resourceId, @Param("jobId") Long jobId, @Param("phaseName") String phaseName, @Param("sqlFile") String sqlFile);

    AutoexecSqlNodeDetailVo getJobSqlById(Long id);

    AutoexecSqlNodeDetailVo getJobSqlByJobPhaseIdAndResourceIdAndSqlName(@Param("jobPhaseId") Long jobPhaseId, @Param("resourceId") Long resourceId, @Param("sqlName") String sqlName);

    List<Long> getSqlDetailIdListByJobIdAndPhaseNameAndResourceIdAndLcd(@Param("jobId") Long jobId, @Param("resourceId") Long resourceId, @Param("phaseName") String phaseName, @Param("updateTag") Long updateTag);

    List<Long> getJobSqlIdListByJobIdAndJobPhaseName(@Param("jobId") Long jobId, @Param("phaseName") String phaseName);

    List<AutoexecSqlNodeDetailVo> getJobSqlListByJobIdAndJobPhaseName(@Param("jobId") Long jobId, @Param("phaseName") String phaseName);

    List<Long> getJobSqlIdListByJobIdAndJobPhaseNameList(@Param("jobId") Long jobId, @Param("jobPhaseNameList") List<String> jobPhaseNameList);

    List<AutoexecSqlNodeDetailVo> getJobSqlDetailListByJobIdAndPhaseNameAndExceptStatusAndRunnerMapId(@Param("jobId") Long jobId, @Param("jobPhaseName") String jobPhaseName, @Param("exceptStatusList") List<String> exceptStatusList, @Param("runnerMapId") Long runnerMapId);

    List<AutoexecJobPhaseVo> getJobPhaseListByJobId(Long jobId);

    List<AutoexecJobPhaseRunnerVo> getJobPhaseRunnerStatusByJobIdAndPhaseId(@Param("jobId") Long id, @Param("jobPhaseId") Long id1);

    List<Long> getJobIdListByProcessTaskStepId(Long processTaskStepId);

    int insertJobInvoke(AutoexecJobInvokeVo invokeVo);

    Integer insertIgnoreJobPhaseNodeRunner(AutoexecJobPhaseNodeRunnerVo nodeRunnerVo);
    
    Integer batchInsertJobPhaseNodeRunner(List<AutoexecJobPhaseNodeRunnerVo> nodeRunnerVo);

    Integer insertJobPhaseRunner(@Param("jobId") Long jobId, @Param("jobGroupId") Long jobGroupId, @Param("jobPhaseId") Long jobPhaseId, @Param("runnerMapId") Long runnerMapId, @Param("lcd") Date lcd);

    Integer insertJob(AutoexecJobVo jobVo);

    Integer insertJobGroup(AutoexecJobGroupVo autoexecJobGroupVo);

    Integer insertJobPhase(AutoexecJobPhaseVo jobVo);

    Integer insertJobPhaseNode(AutoexecJobPhaseNodeVo jobVo);

    Integer batchInsertJobPhaseNode(List<AutoexecJobPhaseNodeVo> nodeList);

    Integer insertJobPhaseOperation(AutoexecJobPhaseOperationVo operationVo);

    Integer insertIgnoreJobContent(AutoexecJobContentVo contentVo);

    Integer updateJobLncdById(@Param("jobId") Long jobId, @Param("lcd") Date lcd);

    Integer updateJobGroupLncdById(@Param("jobGroupId") Long jobGroupId, @Param("lcd") Date lcd);

    Integer updateJobPhaseStatus(AutoexecJobPhaseVo autoexecJobPhaseVo);

    Integer updateJobPhaseStatusByJobIdAndPhaseStatus(@Param("jobId") Long jobId, @Param("whereStatus") String whereStatus, @Param("status") String status);

    Integer updateJobPhaseNodeStatusByJobIdAndIsDelete(@Param("jobId") Long id, @Param("status") String status, @Param("isDelete") Integer isDelete);

    Integer updateJobPhaseNodeStatusByJobPhaseIdAndIsDelete(@Param("jobPhaseId") Long id, @Param("status") String status, @Param("isDelete") Integer isDelete);

    Integer updateJobPhaseRunnerStatusBatch(@Param("phaseIdList") List<Long> phaseIdList, @Param("status") String phaseStatus, @Param("runnerId") Long runnerId);

    Integer updateJobPhaseStatusByJobId(@Param("jobId") Long id, @Param("status") String value);

    Integer updateJobPhaseRunnerStatus(@Param("jobPhaseIdList") List<Long> jobPhaseIdList, @Param("runnerId") Long runnerId, @Param("status") String status);

    Integer updateJobPhaseRunnerStatusAndWarnCount(@Param("jobPhaseIdList") List<Long> jobPhaseIdList, @Param("runnerId") Long runnerId, @Param("status") String status, @Param("warnCount") Integer warnCount);

    Integer updateJobPhaseRunnerStatusByJobIdAndRunnerIdAndStatus(@Param("jobId") Long jobId, @Param("runnerId") Long runnerId, @Param("status") String status);

    Integer updateBatchJobPhaseRunnerStatus(@Param("jobPhaseId") Long jobPhaseId, @Param("status") String status);

    Integer updateJobPhaseStatusByPhaseIdList(@Param("phaseIdList") List<Long> phaseIdList, @Param("status") String status);

    Integer updateJobPhaseNodeById(AutoexecJobPhaseNodeVo jobPhaseNodeVo);

    Integer updateJobPhaseNodeByJobIdAndPhaseIdAndResourceId(AutoexecJobPhaseNodeVo jobPhaseNodeVo);

    Integer updateJobPhaseRunnerFireNextByPhaseIdAndRunnerId(@Param("phaseId") Long phaseId, @Param("isFireNext") int isFireNext, @Param("runnerMapId") Long runnerMapId);

    Integer updateJobPhaseRunnerFireNextByJobIdAndGroupSortAndRunnerId(@Param("jobId") Long jobId, @Param("groupSort") Integer groupSort, @Param("isFireNext") int isFireNext, @Param("runnerMapId") Long runnerMapId);

    Integer updateJobPhaseLcdById(@Param("jobPhaseId") Long jobPhaseId, @Param("lcd") Date lcd);

    Integer updateJobPhaseLncdById(@Param("jobPhaseId") Long jobPhaseId, @Param("lcd") Date lcd);

    Integer updateJobPhaseNodeIsDeleteByJobPhaseIdAndLcd(@Param("jobPhaseId") Long jobPhaseId, @Param("lcd") Date lcd);

    Integer updateJobParamHashById(@Param("jobId") Long jobId, @Param("paramHash") String paramHash);

    Integer updateJobPhaseFrom(AutoexecJobVo jobVo);

    Integer updateJobPhaseNodeResetStartTimeAndEndTimeByNodeIdList(@Param("nodeIdList") List<Long> nodeIdList);

    Integer updateJobPhaseOperationVersionIdByJobIdAndOperationId(@Param("versionId") Long versionId, @Param("jobId") Long jobId, @Param("operationId") Long operationId);

    int updateJobPlanStartTimeAndTriggerTypeById(AutoexecJobVo vo);

    int updateJobExecUser(@Param("jobId") Long jobId, @Param("execUser") String execUser);

    void updateSqlIsDeleteByIdList(@Param("idList") List<Long> idList);

    void updateSqlDetailById(AutoexecSqlNodeDetailVo paramSqlVo);

    void updateSqlStatusByIdList(@Param("idList") List<Long> sqlIdList, @Param("status") String status);

    void resetJobSqlStatusBySqlIdList(@Param("idList") List<Long> idList);

    Integer updateJobLocalRunnerId(@Param("jobId") Long jobId, @Param("runnerId") Long runnerId);

    int updateJobParentIdById(@Param("id") Long id, @Param("parentId") int parentId);

    int insertDuplicateJobEnv(AutoexecJobEnvVo jobEnvVo);

    int insertDuplicateJobResourceInspect(@Param("jobId") Long jobId, @Param("resourceId") Long resourceId, @Param("phaseId") Long phaseId, @Param("lcd") Date lcd);

    void insertSqlDetail(AutoexecSqlNodeDetailVo sqlFileDetailVo);

    void insertSqlDetailList(@Param("sqlList") List<AutoexecSqlNodeDetailVo> sqlList, @Param("phaseName") String phaseName, @Param("phaseId") Long phaseId, @Param("runnerId") Long runnerId, @Param("updateTag") Long updateTag);

    void insertAutoexecJobProcessTaskStep(@Param("jobId") Long jobId, @Param("processTaskStepId") Long processTaskStepId);

    void deleteJobContentByHash(String paramHash);

    void deleteJobPhaseOperationByJobId(Long jobId);

    void deleteJobPhaseNodeByJobId(Long jobId);

    void deleteJobPhaseByJobId(Long jobId);

    void deleteJobByJobId(Long jobId);

    void deleteJobPhaseNodeByJobPhaseIdList(@Param("jobPhaseIdList") List<Long> jobPhaseIdList);

    void deleteJobPhaseRunnerByJobId(Long jobId);

    void deleteJobPhaseNodeRunnerByJobId(Long jobId);

    void deleteJobPhaseNodeByJobPhaseIdAndLcd(@Param("jobPhaseId") Long jobPhaseId, @Param("lcd") Date lcd);

    Integer deleteJobPhaseNodeByJobPhaseIdAndLcdAndStatus(@Param("jobPhaseId") Long jobPhaseId, @Param("lcd") Date lcd, @Param("status") String status);

    void deleteJobPhaseNodeRunnerByJobPhaseIdAndLcdAndStatus(@Param("jobPhaseId") Long jobPhaseId, @Param("lcd") Date lcd, @Param("status") String status);

    void deleteJobEvnByJobId(Long jobId);

    void deleteJobInvokeByJobId(Long jobId);

    void deleteJobResourceInspectByJobId(Long jobId);

    void deleteJobPhaseRunnerByJobPhaseIdAndRunnerMapId(@Param("jobPhaseId") Long id, @Param("runnerMapId") Long runnerMapId);

    void deleteJobGroupByJobId(Long jobId);

    void deleteJobSqlDetailByJobId(Long jobId);

    void deleteAutoexecJobByProcessTaskStepId(Long processTaskStepId);

    List<AutoexecJobVo> getJobListLockByParentId(Long jobId);

    void updateJobSqlStatusByJobIdAndPhaseId(@Param("jobId") Long jobId,@Param("phaseId") Long phaseId,@Param("status") String status);

    void updateJobPhaseRunnerStatusByJobIdAndPhaseId(@Param("jobId") Long jobId,@Param("phaseId") Long phaseId,@Param("status") String status);
}
