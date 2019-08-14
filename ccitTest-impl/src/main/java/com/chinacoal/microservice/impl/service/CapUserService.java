package com.chinacoal.microservice.impl.service;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.service.IService;
import com.chinacoal.microservice.model.rbac.Users;
import com.chinacoal.microservice.util.result.Result;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhangfy
 * @since 2019-05-30
 */
public interface CapUserService extends IService<Users> {

	Result<Object> findUserByuserId(String userId);

	Result<Object> findUserByEmpId(BigDecimal empId);

}
