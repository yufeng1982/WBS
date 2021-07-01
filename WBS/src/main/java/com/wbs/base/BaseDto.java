/**
 * 
 */
package com.wbs.base;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author YF
 * @param <T>
 *
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class BaseDto<T> extends BasePage<T> {
	
	private static final long serialVersionUID = 13264334102246016L;
	
	private String id;
	private LocalDateTime createDate;
	private LocalDateTime modifyDate;
	private Boolean active = Boolean.TRUE;
	 
}
