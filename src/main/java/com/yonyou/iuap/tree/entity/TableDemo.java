package com.yonyou.iuap.tree.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.yonyou.iuap.baseservice.entity.AbsDrModel;
import com.yonyou.iuap.baseservice.entity.annotation.CodingEntity;
import com.yonyou.iuap.baseservice.multitenant.entity.MultiTenant;
import com.yonyou.iuap.baseservice.support.condition.Condition;
import com.yonyou.iuap.baseservice.support.generator.GeneratedValue;

/**
 * 表TableDemo
 */

@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name = "IUAPD_TREELIST_DETAIL")
@CodingEntity(codingField = "")
public class TableDemo extends AbsDrModel implements Serializable, MultiTenant {
	@Id
	@GeneratedValue
	@Condition
	protected String id;// ID

	@Override
	public String getId() {
		return id;
	}

	@Override
	public void setId(Serializable id) {
		this.id = id.toString();
		super.id = id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Condition
	@Column(name = "TREE_ID")
	private String treeId; // 树ID

	public void setTreeId(String treeId) {
		this.treeId = treeId;
	}

	public String getTreeId() {
		return this.treeId;
	}

	@Condition
	@Column(name = "CODE")
	private String code; // 工号

	public void setCode(String code) {
		this.code = code;
	}

	public String getCode() {
		return this.code;
	}

	@Condition
	@Column(name = "SEX")
	private Integer sex; // 性别

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public Integer getSex() {
		return this.sex;
	}

	@Transient
	private String sexEnumValue; // 性别

	public void setSexEnumValue(String sexEnumValue) {
		this.sexEnumValue = sexEnumValue;
	}

	public String getSexEnumValue() {
		return this.sexEnumValue;
	}

	@Condition
	@Column(name = "NAME")
	private String name; // 姓名

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	@Condition
	@Column(name = "AGE")
	private Integer age; // 年龄

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getAge() {
		return this.age;
	}

	@Column(name = "TENANT_ID")
	@Condition
	private String tenantid;

	public String getTenantid() {
		return this.tenantid;
	}

	public void setTenantid(String tenantid) {
		this.tenantid = tenantid;
	}

}
