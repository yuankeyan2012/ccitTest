package com.chinacoal.microservice.api;

import com.chinacoal.microservice.util.result.Result;
import com.primeton.ptp.tarest.core.api.annotation.TarestOperation;
import com.primeton.ptp.tarest.core.api.annotation.TarestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author sc
 * @createTime 2019/6/12 16:05
 * @description
 */
@Api(tags={"用户管理操作接口*********用户管理已到rbac模块,此处接口不再维护*********"})
@RequestMapping("/testClient")
@TarestService(group="com.chinacoal.microservice.ccitTest",version="v1",name="TestClient")
public interface CcitTestClient {

    @TarestOperation(name="testFindUserByuserId", desc="测试desc-根据登录用户名获取用户信息", displayName="测试displayName-根据登录用户名获取用户信息", checkPermission=false)
    @ApiOperation(value = "根据登录用户名获取用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="body", name = "userId", value = "测试-根据登录用户名获取用户信息", required = true, dataType = "String")
    })
    @GetMapping("/userName")
    public Result<Object> testFindUserByuserId(String userId);

}
