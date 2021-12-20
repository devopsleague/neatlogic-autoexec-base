/*
 * Copyright(c) 2021. TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.dto;

import codedriver.framework.autoexec.constvalue.CombopOperationType;
import codedriver.framework.autoexec.constvalue.ParamMode;
import codedriver.framework.autoexec.constvalue.ToolType;
import codedriver.framework.autoexec.dto.script.AutoexecScriptVo;
import codedriver.framework.common.constvalue.ApiParamType;
import codedriver.framework.common.dto.BaseEditorVo;
import codedriver.framework.restful.annotation.EntityField;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class AutoexecToolAndScriptVo extends BaseEditorVo {

    @EntityField(name = "id", type = ApiParamType.LONG)
    private Long id;
    @EntityField(name = "唯一标识", type = ApiParamType.STRING)
    private String uk;
    @EntityField(name = "名称", type = ApiParamType.STRING)
    private String name;
    @EntityField(name = "类型(tool:工具;script:脚本)", type = ApiParamType.ENUM, member = ToolType.class)
    private String type;
    @EntityField(name = "执行方式", type = ApiParamType.STRING)
    private String execMode;
    @EntityField(name = "分类ID", type = ApiParamType.LONG)
    private Long typeId;
    @EntityField(name = "工具目录ID", type = ApiParamType.LONG)
    private Long catalogId;
    @EntityField(name = "工具目录名称", type = ApiParamType.STRING)
    private String catalogName;
    @EntityField(name = "分类名称", type = ApiParamType.STRING)
    private String typeName;
    @EntityField(name = "操作级别ID", type = ApiParamType.LONG)
    private Long riskId;
    @EntityField(name = "操作级别名称", type = ApiParamType.STRING)
    private String riskName;
    @EntityField(name = "操作级别颜色", type = ApiParamType.STRING)
    private String riskColor;
    @EntityField(name = "操作级别")
    private AutoexecRiskVo riskVo;
    @EntityField(name = "描述说明", type = ApiParamType.STRING)
    private String description;

    @EntityField(name = "参数列表", type = ApiParamType.JSONARRAY)
    @JSONField(serialize = false)
    private List<AutoexecParamVo> paramList;
    @EntityField(name = "入参列表", type = ApiParamType.JSONARRAY)
    private List<AutoexecParamVo> inputParamList;
    @EntityField(name = "出参列表", type = ApiParamType.JSONARRAY)
    private List<AutoexecParamVo> outputParamList;
    @EntityField(name = "自由参数", type = ApiParamType.JSONOBJECT)
    private AutoexecParamVo argument;
    @JSONField(serialize = false)
    private String configStr;//工具的参数配置

    @JSONField(serialize = false)
    private List<Long> typeIdList;

    @JSONField(serialize = false)
    private List<Long> catalogIdList;

    @JSONField(serialize = false)
    private List<Long> riskIdList;

    public AutoexecToolAndScriptVo() {
    }

    public AutoexecToolAndScriptVo(AutoexecToolVo autoexecToolVo) {
        this.id = autoexecToolVo.getId();
        this.uk = autoexecToolVo.getUk();
        this.name = autoexecToolVo.getName();
        this.type = CombopOperationType.TOOL.getValue();
        this.execMode = autoexecToolVo.getExecMode();
        this.typeId = autoexecToolVo.getTypeId();
        this.typeName = autoexecToolVo.getTypeName();
        this.riskId = autoexecToolVo.getRiskId();
    }

    public AutoexecToolAndScriptVo(AutoexecScriptVo autoexecScriptVo) {
        this.id = autoexecScriptVo.getId();
        this.uk = autoexecScriptVo.getUk();
        this.name = autoexecScriptVo.getName();
        this.type = CombopOperationType.SCRIPT.getValue();
        this.execMode = autoexecScriptVo.getExecMode();
        this.typeId = autoexecScriptVo.getTypeId();
        this.typeName = autoexecScriptVo.getTypeName();
        this.riskId = autoexecScriptVo.getRiskId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUk() {
        return uk;
    }

    public void setUk(String uk) {
        this.uk = uk;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getExecMode() {
        return execMode;
    }

    public void setExecMode(String execMode) {
        this.execMode = execMode;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public Long getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(Long catalogId) {
        this.catalogId = catalogId;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public Long getRiskId() {
        return riskId;
    }

    public void setRiskId(Long riskId) {
        this.riskId = riskId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRiskColor() {
        return riskColor;
    }

    public void setRiskColor(String riskColor) {
        this.riskColor = riskColor;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getRiskName() {
        return riskName;
    }

    public void setRiskName(String riskName) {
        this.riskName = riskName;
    }

    public List<Long> getTypeIdList() {
        return typeIdList;
    }

    public void setTypeIdList(List<Long> typeIdList) {
        this.typeIdList = typeIdList;
    }

    public List<Long> getCatalogIdList() {
        return catalogIdList;
    }

    public void setCatalogIdList(List<Long> catalogIdList) {
        this.catalogIdList = catalogIdList;
    }

    public List<Long> getRiskIdList() {
        return riskIdList;
    }

    public void setRiskIdList(List<Long> riskIdList) {
        this.riskIdList = riskIdList;
    }

    public AutoexecRiskVo getRiskVo() {
        return riskVo;
    }

    public void setRiskVo(AutoexecRiskVo riskVo) {
        this.riskVo = riskVo;
    }

    public List<AutoexecParamVo> getParamList() {
        if (CollectionUtils.isEmpty(paramList) && StringUtils.isNotBlank(configStr)) {
            JSONObject toolConfig = JSONObject.parseObject(configStr);
            JSONArray params = toolConfig.getJSONArray("paramList");
            if (CollectionUtils.isNotEmpty(params)) {
                this.paramList = params.toJavaList(AutoexecParamVo.class);
            }
        }
        return paramList;
    }

    public void setParamList(List<AutoexecParamVo> paramList) {
        this.paramList = paramList;
    }

    public List<AutoexecParamVo> getInputParamList() {
        // 主动调用getParamList()，确保paramList优先赋值
        getParamList();
        if (CollectionUtils.isNotEmpty(paramList) && CollectionUtils.isEmpty(inputParamList)) {
            inputParamList = paramList.stream()
                    .filter(o -> ParamMode.INPUT.getValue().equals(o.getMode()))
                    .sorted(Comparator.comparing(AutoexecParamVo::getSort))
                    .collect(Collectors.toList());
        }
        return inputParamList;
    }

    public void setInputParamList(List<AutoexecParamVo> inputParamList) {
        this.inputParamList = inputParamList;
    }

    public List<AutoexecParamVo> getOutputParamList() {
        getParamList();
        if (CollectionUtils.isNotEmpty(paramList) && CollectionUtils.isEmpty(outputParamList)) {
            outputParamList = paramList.stream()
                    .filter(o -> ParamMode.OUTPUT.getValue().equals(o.getMode()))
                    .sorted(Comparator.comparing(AutoexecParamVo::getSort))
                    .collect(Collectors.toList());
        }
        return outputParamList;
    }

    public void setOutputParamList(List<AutoexecParamVo> outputParamList) {
        this.outputParamList = outputParamList;
    }

    public AutoexecParamVo getArgument() {
        if (argument == null && StringUtils.isNotBlank(configStr)) {
            JSONObject toolConfig = JSONObject.parseObject(configStr);
            JSONObject argumentJson = toolConfig.getJSONObject("argument");
            if (MapUtils.isNotEmpty(argumentJson)) {
                argument = new AutoexecParamVo(argumentJson);
            }
        }
        return argument;
    }

    public void setArgument(AutoexecParamVo argument) {
        this.argument = argument;
    }

    public String getConfigStr() {
        return configStr;
    }

    public void setConfigStr(String configStr) {
        this.configStr = configStr;
    }
}
