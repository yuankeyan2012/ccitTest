package com.chinacoal.microservice.impl.controller;


import com.chinacoal.microservice.api.CcitTestClient;
import com.chinacoal.microservice.impl.service.CapUserService;
import com.chinacoal.microservice.model.ccitTest.CcitTest;
import com.chinacoal.microservice.util.result.CodeMsg;
import com.chinacoal.microservice.util.result.Result;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * <p>
 *  前端控制器
 *    用户管理
 * </p>
 * @author zhangfy
 * @since 2019-05-30
 */
@RestController

public class CcitTestController implements CcitTestClient {

    @Autowired
    private CapUserService capUserService;


    /**
     * @Description: 测试方法
     * @author: yuanky
     * @date: 2019/8/14 17:50
     */
    @Override
    public Result<Object> testFindUserByuserId(String userId) {
        if(StringUtils.isBlank(userId)){
            return Result.error(CodeMsg.BIND_ERROR.fillArgs("用户名不能为空"));
        }
        CcitTest ccitTest = new CcitTest();
        ccitTest.setBirthdate(new Date()).setEmpCode("1009").setEmpName("原科研");
        return Result.success(ccitTest);
    }
}

