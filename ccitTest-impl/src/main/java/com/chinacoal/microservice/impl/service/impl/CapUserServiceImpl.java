package com.chinacoal.microservice.impl.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.chinacoal.microservice.impl.mapper.CapUserMapper;
import com.chinacoal.microservice.impl.service.CapUserService;
import com.chinacoal.microservice.model.rbac.Users;
import com.chinacoal.microservice.util.result.CodeMsg;
import com.chinacoal.microservice.util.result.Result;
import lombok.extern.slf4j.Slf4j;
import java.math.BigDecimal;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhangfy
 * @since 2019-05-30
 */
@Slf4j
@Service
public class CapUserServiceImpl extends ServiceImpl<CapUserMapper, Users> implements CapUserService {

	@Resource
	private CapUserMapper capUserMapper;
	
	@Override
	public Result<Object> findUserByuserId(String userId) {
		try {
			return Result.success(capUserMapper.findUserByuserId(userId));
		} catch (Exception e) {
			log.error("findUserByuserId：{}", e.getMessage());
			return Result.error(CodeMsg.SERVER_ERROR);
		}
	}

	@Override
	public Result<Object> findUserByEmpId(BigDecimal empId) {
		try {
			return Result.success(capUserMapper.findUserByEmpId(empId));
		} catch (Exception e) {
			log.error("findUserByEmpId：{}", e.getMessage());
			return Result.error(CodeMsg.SERVER_ERROR);
		}
	}

}
