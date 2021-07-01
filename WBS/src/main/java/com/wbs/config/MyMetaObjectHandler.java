/**
 * 
 */
package com.wbs.config;

import java.time.LocalDateTime;

import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;

/**
 * @author YF
 *
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

	@Override
	public void insertFill(MetaObject metaObject) {
		this.strictInsertFill(metaObject, "version", Integer.class, new Integer(0));
		this.strictInsertFill(metaObject, "createDate", LocalDateTime.class, LocalDateTime.now());
		this.strictInsertFill(metaObject, "modifyDate", LocalDateTime.class, LocalDateTime.now());
	}

	@Override
	public void updateFill(MetaObject metaObject) {
		this.strictUpdateFill(metaObject, "modifyDate", LocalDateTime.class, LocalDateTime.now());
	}

}
