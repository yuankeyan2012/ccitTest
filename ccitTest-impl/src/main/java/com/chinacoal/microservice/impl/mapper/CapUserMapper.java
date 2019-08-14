package com.chinacoal.microservice.impl.mapper;

import java.math.BigDecimal;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.chinacoal.microservice.model.rbac.Users;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zhangfy
 * @since 2019-05-30
 */
public interface CapUserMapper extends BaseMapper<Users> {

	Users findUserByuserId(@Param("userId")String userId);

	Users findUserByEmpId(@Param("empId")BigDecimal empId);


}
