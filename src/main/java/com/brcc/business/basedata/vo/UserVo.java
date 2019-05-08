package com.brcc.business.basedata.vo;

public class UserVo {
	
	private Long fdUserId;
	
	private Long companyId;

	private Long groupId;
	
	private String groupName;

	public Long getGroupId() {
		return groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public Long getFdUserId() {
		return fdUserId;
	}

	public void setFdUserId(Long fdUserId) {
		this.fdUserId = fdUserId;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}
	
}
