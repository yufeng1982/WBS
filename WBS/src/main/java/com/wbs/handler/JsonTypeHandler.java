/**
 * 
 */
package com.wbs.handler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;
import org.postgresql.util.PGobject;

import com.baomidou.mybatisplus.extension.handlers.FastjsonTypeHandler;

/**
 * @author YF
 *
 */
@MappedTypes({ Object.class })
public class JsonTypeHandler extends FastjsonTypeHandler {

	public JsonTypeHandler(Class<?> type) {
		super(type);
	}
	
	//报错的话，请将pom文件的引入graphql的地方<version></version>标签注释掉
	private static final PGobject jsonObject = new PGobject();

	@Override
	public void setNonNullParameter(PreparedStatement ps, int i, Object parameter, JdbcType jdbcType)
			throws SQLException {
		if (ps != null) {
			jsonObject.setType("json");
			jsonObject.setValue(parameter.toString());
			ps.setObject(i, jsonObject);
		}
	}

	@Override
	public Object getNullableResult(ResultSet rs, String columnName) throws SQLException {
		return rs.getObject(columnName);
	}

	@Override
	public Object getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
		return rs.getObject(columnIndex);
	}

	@Override
	public Object getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
		return cs.getObject(columnIndex);
	}

}