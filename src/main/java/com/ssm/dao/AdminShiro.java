package com.ssm.dao;

import java.util.List;
import com.ssm.po.AdminShiroS;
import org.apache.ibatis.annotations.Param;

public interface AdminShiro {

	/**
	 * 查询所有权限
	 * 
	 * @return
	 * @throws Exception
	 */
	List<AdminShiroS> ShiroGets() throws Exception;

	/**
	 * 更新管理员权限
	 * 
	 * @param shiroId
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	int AdminUpdateShiro(@Param("shiroId") Integer shiroId, @Param("userId") Integer userId) throws Exception;

}
