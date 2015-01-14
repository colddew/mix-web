package edu.ustc.mix.core.util;

public interface MixConstants {
	
	// 当前用户信息在Request中的名称
	public static final String CURRENT_USER = "user";
	
	// 用户状态
	public static final Integer USER_STATUS_UNAVAILABLE = 0;		// 不可用
	public static final Integer USER_STATUS_AVAILABLE = 1;			// 可用
	public static final Integer USER_STATUS_LOCKED = 2;				// 锁定
	
	// 资源类型
	public static final Integer RES_TYPE_URL = 0;		// URL地址
	public static final Integer RES_TYPE_FORM = 1;		// 表单元素
	public static final Integer RES_TYPE_DATA = 2;		// 数据
	
	// 用户类型
	public static final Integer USER_TYPE_SUPER = 0;		// 超级管理员
	public static final Integer USER_TYPE_COMMON = 1;		// 普通用户
	
	// 是否为叶子节点
	public static final Integer IS_LEAF_NO = 0;			// 否
	public static final Integer IS_LEAF_YES = 1;		// 是
}
