/*
 * Copyright(c) 2021 TechSureCo.,Ltd.AllRightsReserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.dto.schedule;

import codedriver.framework.common.constvalue.ApiParamType;
import codedriver.framework.common.dto.BaseEditorVo;
import codedriver.framework.restful.annotation.EntityField;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;
import java.util.UUID;

/**
 * @author linbq
 * @since 2021/9/29 17:08
 **/
public class AutoexecScheduleVo extends BaseEditorVo {

    @EntityField(name = "定时作业uuid", type = ApiParamType.STRING)
    private String uuid;
    @EntityField(name = "定时作业名称", type = ApiParamType.STRING)
    private String name;
    @EntityField(name = "组合工具id", type = ApiParamType.LONG)
    private Long autoexecCombopId;
    @EntityField(name = "组合工具名称", type = ApiParamType.STRING)
    private String autoexecCombopName;
    @EntityField(name = "cron表达式", type = ApiParamType.STRING)
    private String cron;
    @EntityField(name = "开始时间", type = ApiParamType.LONG)
    private Date beginTime;
    @EntityField(name = "结束时间", type = ApiParamType.LONG)
    private Date endTime;
    @EntityField(name = "状态(0:禁用，1：启用)", type = ApiParamType.INTEGER)
    private Integer isActive;
    @EntityField(name = "执行次数", type = ApiParamType.INTEGER)
    private Integer execCount;

    public String getUuid() {
        if (StringUtils.isBlank(uuid)) {
            uuid = UUID.randomUUID().toString().replace("-", "");
        }
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAutoexecCombopId() {
        return autoexecCombopId;
    }

    public void setAutoexecCombopId(Long autoexecCombopId) {
        this.autoexecCombopId = autoexecCombopId;
    }

    public String getAutoexecCombopName() {
        return autoexecCombopName;
    }

    public void setAutoexecCombopName(String autoexecCombopName) {
        this.autoexecCombopName = autoexecCombopName;
    }

    public String getCron() {
        return cron;
    }

    public void setCron(String cron) {
        this.cron = cron;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getIsActive() {
        return isActive;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }

    public Integer getExecCount() {
        if (execCount == null) {
            execCount = 0;
        }
        return execCount;
    }

    public void setExecCount(Integer execCount) {
        this.execCount = execCount;
    }
}
