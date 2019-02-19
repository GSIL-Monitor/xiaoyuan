package com.project.modules.warn.domain;

import com.project.common.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * 这是重要时间提醒表 matter_warn
 * 
 * @author lugongqi
 * @date 2019-02-18
 */
@Data
@ToString
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class Warn extends BaseEntity {

	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	private Integer id;
	/**
	 * 备注
	 */
	private String matter;
	/**
	 * 开始时间
	 */
	private Date beginTime;
	/**
	 * 结束时间
	 */
	private Date endTime;
	/**
	 * 提醒时间
	 */
	private Date warnTime;


}

