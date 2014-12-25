package edu.ustc.mix.core.util;

public interface MixConstants {
	
	// 用户状态
	public static final Integer USER_STATUS_UNAVAILABLE = 0;		// 不可用
	public static final Integer USER_STATUS_AVAILABLE = 1;			// 可用
	public static final Integer USER_STATUS_LOCKED = 2;				// 锁定
	
	// 资源类型
	public static final Integer RES_TYPE_URL = 0;		// URL地址
	public static final Integer RES_TYPE_FORM = 1;		// 表单元素
	public static final Integer RES_TYPE_DATA = 2;		// 数据
}
