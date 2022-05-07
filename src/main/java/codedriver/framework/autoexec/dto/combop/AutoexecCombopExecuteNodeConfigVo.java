/*
 * Copyright(c) 2021 TechSureCo.,Ltd.AllRightsReserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.dto.combop;

import codedriver.framework.autoexec.dto.node.AutoexecNodeVo;
import codedriver.framework.common.constvalue.ApiParamType;
import codedriver.framework.restful.annotation.EntityField;
import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;
import java.util.List;

/**
 * @author: linbq
 * @since: 2021/4/23 11:57
 **/
public class AutoexecCombopExecuteNodeConfigVo implements Serializable {
    @EntityField(name = "标签列表", type = ApiParamType.STRING)
    private List<Long> tagList;
    @EntityField(name = "参数列表", type = ApiParamType.JSONARRAY)
    private List<String> paramList;
    @EntityField(name = "选择节点列表", type = ApiParamType.JSONARRAY)
    private List<AutoexecNodeVo> selectNodeList;
    @EntityField(name = "输入节点列表", type = ApiParamType.JSONARRAY)
    private List<AutoexecNodeVo> inputNodeList;
    @EntityField(name = "过滤器选择条件", type = ApiParamType.JSONOBJECT)
    private JSONObject filter; // 过滤器

    public List<Long> getTagList() {
        return tagList;
    }

    public void setTagList(List<Long> tagList) {
        this.tagList = tagList;
    }

    public List<String> getParamList() {
        return paramList;
    }

    public void setParamList(List<String> paramList) {
        this.paramList = paramList;
    }

    public List<AutoexecNodeVo> getSelectNodeList() {
        return selectNodeList;
    }

    public void setSelectNodeList(List<AutoexecNodeVo> selectNodeList) {
        this.selectNodeList = selectNodeList;
    }

    public List<AutoexecNodeVo> getInputNodeList() {
        return inputNodeList;
    }

    public void setInputNodeList(List<AutoexecNodeVo> inputNodeList) {
        this.inputNodeList = inputNodeList;
    }

    public JSONObject getFilter() {
        return filter;
    }

    public void setFilter(JSONObject filter) {
        this.filter = filter;
    }
}
