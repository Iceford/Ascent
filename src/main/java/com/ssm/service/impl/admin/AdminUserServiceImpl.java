/*
 * @Description: Java�࣬��ΪAdminUserServiceImpl��ʵ����AdminUserServiceInter�ӿ�
 * @FilePath: \src\main\java\com\ssm\service\impl\admin\AdminUserServiceImpl.java
 * @Author: hhrwvyy5654v huang_rongquan@outlook.com
 * @Date: 2023-06-05 11:32:03
 * @LastEditors: hhrwvyy5654v huang_rongquan@outlook.com
 * @LastEditTime: 2023-06-06 21:58:59
 * Copyright (c) 2023 by hhrwvyy5654v , All Rights Reserved. 
 */
package com.ssm.service.impl.admin;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ssm.dao.AdminUserMapper;
import com.ssm.po.AdminUser;
import com.ssm.po.AdminUserOV;
import com.ssm.service.inter.admin.AdminUserServiceInter;

public class AdminUserServiceImpl implements AdminUserServiceInter {

	@Autowired
	private AdminUserMapper adminMapper;

	// ��֤����Ա�û��ĵ�¼��Ϣ,������洢��Cookie��Session��,�Ա��ں�����������ʹ��
	@Override
	public boolean adminLogin(AdminUser adminUser) throws Exception {
		boolean blo = false;
		// ����AdminUserMapper�����adminLogin����,�������AdminUser������Ϊ����,�����ݿ��в�ѯ�Ƿ���ڸù���Ա�û�
		AdminUser user = adminMapper.adminLogin(adminUser);
		if (user != null) {
			blo = true; // ������ڽ�blo������ֵ����Ϊtrue
			// �����û�����ת��ΪJSON��ʽ���ַ���,������洢��Cookie��Session�У��Ա��ں�������ʹ��
			String jsonUser = JSONObject.toJSONString(user);
			System.out.println(jsonUser);
			// ����һ����Ϊ"admin-users"��Cookie��������JSON��ʽ���ַ�������URL�������ΪCookie��ֵ
			Cookie cookies = new Cookie("admin-users", java.net.URLEncoder.encode(jsonUser, "UTF-8"));
			// ʹ��Spring��ܵ�ServletRequestAttributes���ȡHttpServletRequest��HttpServletResponse���󣬽�Cookie��ӵ���Ӧ��
			HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
					.getResponse();
			response.addCookie(cookies);
			// ʹ��Spring��ܵ�ServletRequestAttributes���ȡHttpServletRequest��HttpServletResponse���󣬽�Cookie��ӵ���Ӧ��
			HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
					.getRequest();
			// ��JSON���ַ����洢��Session�У��Ա��ں�����������ʹ��
			request.getSession().setAttribute("admin-users", jsonUser);
		} else {
			// ��������ڸù���Ա�û�,�򷵻�false
			return false;
		}
		return blo;
	}

	// ע����ǰ�û��ĵ�¼״̬,��������������һ�������͵�request������һ����HttpServletResponse���͵�response����
	@Override
	public void LoginOut(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// ͨ��request.getSession()������ȡ��ǰ�û���session����
		HttpSession session = request.getSession();
		// ����session.removeAttribute("admin-users")������session����Ϊ"admin-users"�������Ƴ�
		session.removeAttribute("admin-users");
		// ����session.invalidate()����ʹsessionʧЧ
		session.invalidate();
		// ͨ��request.getCookies()������ȡ��ǰ�û�������cookie
		Cookie[] cookies = request.getCookies();
		// ����ÿ��cookie�����������ʱ������Ϊ0
		for (Cookie ck : cookies) {
			ck.setMaxAge(0);
			// ͨ��response.addCookie(ck)������cookie��ӵ���Ӧ�У�ʹ��ʧЧ
			response.addCookie(ck);
		}
	}

	// ��ȡ���й���Ա�û���Ϣ���޲���,����һ���ַ������͵�JSON��ʽ����
	@Override
	public String GetAdmins() throws Exception {
		// ������adminMapper�����GetAdmin()����,����һ��AdminUserOV���͵��б�
		List<AdminUserOV> lists = adminMapper.GetAdmin();
		// ʹ��JSON.toJSONString(lists)�������б�ת��ΪJSON��ʽ���ַ�������������Ϊ����ֵ����
		return JSON.toJSONString(lists);
	}

}
