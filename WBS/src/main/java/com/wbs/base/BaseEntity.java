/**
 * 
 */
package com.wbs.base;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.Version;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import lombok.Data;

/**
 * @author YF
 *
 */
@Data
public abstract class BaseEntity implements Serializable {

	private static final long serialVersionUID = 7641251899782721861L;

	/**
     * ID
     */
    @TableId(type = IdType.ASSIGN_UUID)
    private String id;
    
    /**
     * 创建时间
     */
    @TableField(value="create_date", fill = FieldFill.INSERT)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	@JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime createDate;

    /**
     * 修改时间
     */
    @TableField(value="modify_date", fill = FieldFill.INSERT, update = "now()")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	@JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime modifyDate;

    /**
     * 是否可用（逻辑删除字段）
     */
    @TableLogic(value = "true", delval = "false")
    private Boolean active = Boolean.TRUE;

    /**
     * 版本号（乐观锁字段）
     */
    @Version
    @TableField(value="version", fill = FieldFill.INSERT, update="%s+1")
    private Integer version;

    
}
