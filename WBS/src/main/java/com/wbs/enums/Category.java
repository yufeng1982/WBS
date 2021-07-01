/**
 * 
 */
package com.wbs.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;

/**
 * @author YF
 *
 */
public enum Category {

    A(1, "武侠"),  B(2, "科幻"),  C(3, "伦理");

    Category(int code, String desc) {
        this.code = code;
        this.descp = desc;
    }

    public String getDescp() {
		return descp;
	}

	@EnumValue//标记数据库存的值是code
    private final int code;
    private final String descp;
}
