package org.jabberstory.cjac.consignsettle.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class UserGroup {
	private String groupId;
	private String groupName;
	private String role;	// admin(A), consignee(C, 회계법인), owner(O, 전담), subject(S, 주관)
	private String refGroupId;
	
	private String businessName;
	private String projectName;
	private String researchAgency;
	private String researchResponsiblePerson;
	private String contractStartDate;
	private String contractEndDate;
	
	private String govContributeAmount;
	private String nonGovContributeAmount;
	private String goodsAmount;
	private String totalCashAmount;
	private String govInterests;
	private String consignSettlementCommission;
	
	private String useResultDate;	
	private String formalObjectAcceptanceDate;
	private String formalObjectResultDate;
	private String consignSettlementResultDate;
	
	private String subjectResponsiblePerson;
	private String subjectResponsiblePhone1;
	private String subjectResponsiblePhone2;
	private String subjectResponsiblePhone3;
	private String subjectResponsiblePostNumber1;
	private String subjectResponsiblePostNumber2;
	private String subjectResponsibleAddress;
	private String subejctResponsibleEmail;
	
	private String consignSettlementPerson;
	private String consignSettlementPhone1;
	private String consignSettlementPhone2;
	private String consignSettlementPhone3;
	private String consignSettlementPostNumber1;
	private String consignSettlementPostNumber2;
	private String consignSettlementAddress;
	private String consignSettlementEmail;
	
	private String currentAccount;
	private String currentInterest;
	private String currentNonPropriety;
	private String currentRedemtion;
	private String currentSubTotal;
	
	private String createUserId;
	private String createUserName;
	private Date createDate;
	
	private String costDetail;		// 사업비 사용 명세
	private String nonApproval1;	// 1차 불인정 내역
	private String nonApproval2;	// 최종 불인정 내역
	
	private Set<User> users = new HashSet<User>();

	public UserGroup(){}

	/**
	 * @param groupId
	 * @param groupName
	 * @param role
	 * @param refGroupId
	 * @param businessName
	 * @param projectName
	 * @param researchAgency
	 * @param researchResponsiblePerson
	 * @param contractStartDate
	 * @param contractEndDate
	 * @param govContributeAmount
	 * @param nonGovContributeAmount
	 * @param goodsAmount
	 * @param totalCashAmount
	 * @param govInterests
	 * @param consignSettlementCommission
	 * @param useResultDate
	 * @param formalObjectAcceptanceDate
	 * @param formalObjectResultDate
	 * @param consignSettlementResultDate
	 * @param subjectResponsiblePerson
	 * @param subjectResponsiblePhone1
	 * @param subjectResponsiblePhone2
	 * @param subjectResponsiblePhone3
	 * @param subjectResponsiblePostNumber1
	 * @param subjectResponsiblePostNumber2
	 * @param subjectResponsibleAddress
	 * @param subejctResponsibleEmail
	 * @param consignSettlementPerson
	 * @param consignSettlementPhone1
	 * @param consignSettlementPhone2
	 * @param consignSettlementPhone3
	 * @param consignSettlementPostNumber1
	 * @param consignSettlementPostNumber2
	 * @param consignSettlementAddress
	 * @param consignSettlementEmail
	 * @param currentAccount
	 * @param currentInterest
	 * @param currentNonPropriety
	 * @param currentRedemtion
	 * @param currentSubTotal
	 * @param createUserId
	 * @param createUserName
	 * @param createDate
	 * @param costDetail
	 * @param nonApproval1
	 * @param nonApproval2
	 * @param users
	 */
	public UserGroup(String groupId, String groupName, String role,
			String refGroupId, String businessName, String projectName,
			String researchAgency, String researchResponsiblePerson,
			String contractStartDate, String contractEndDate,
			String govContributeAmount, String nonGovContributeAmount,
			String goodsAmount, String totalCashAmount, String govInterests,
			String consignSettlementCommission, String useResultDate,
			String formalObjectAcceptanceDate, String formalObjectResultDate,
			String consignSettlementResultDate,
			String subjectResponsiblePerson, String subjectResponsiblePhone1,
			String subjectResponsiblePhone2, String subjectResponsiblePhone3,
			String subjectResponsiblePostNumber1,
			String subjectResponsiblePostNumber2,
			String subjectResponsibleAddress, String subejctResponsibleEmail,
			String consignSettlementPerson, String consignSettlementPhone1,
			String consignSettlementPhone2, String consignSettlementPhone3,
			String consignSettlementPostNumber1,
			String consignSettlementPostNumber2,
			String consignSettlementAddress, String consignSettlementEmail,
			String currentAccount, String currentInterest,
			String currentNonPropriety, String currentRedemtion,
			String currentSubTotal, String createUserId, String createUserName,
			Date createDate, String costDetail, String nonApproval1,
			String nonApproval2, Set<User> users) {
		super();
		this.groupId = groupId;
		this.groupName = groupName;
		this.role = role;
		this.refGroupId = refGroupId;
		this.businessName = businessName;
		this.projectName = projectName;
		this.researchAgency = researchAgency;
		this.researchResponsiblePerson = researchResponsiblePerson;
		this.contractStartDate = contractStartDate;
		this.contractEndDate = contractEndDate;
		this.govContributeAmount = govContributeAmount;
		this.nonGovContributeAmount = nonGovContributeAmount;
		this.goodsAmount = goodsAmount;
		this.totalCashAmount = totalCashAmount;
		this.govInterests = govInterests;
		this.consignSettlementCommission = consignSettlementCommission;
		this.useResultDate = useResultDate;
		this.formalObjectAcceptanceDate = formalObjectAcceptanceDate;
		this.formalObjectResultDate = formalObjectResultDate;
		this.consignSettlementResultDate = consignSettlementResultDate;
		this.subjectResponsiblePerson = subjectResponsiblePerson;
		this.subjectResponsiblePhone1 = subjectResponsiblePhone1;
		this.subjectResponsiblePhone2 = subjectResponsiblePhone2;
		this.subjectResponsiblePhone3 = subjectResponsiblePhone3;
		this.subjectResponsiblePostNumber1 = subjectResponsiblePostNumber1;
		this.subjectResponsiblePostNumber2 = subjectResponsiblePostNumber2;
		this.subjectResponsibleAddress = subjectResponsibleAddress;
		this.subejctResponsibleEmail = subejctResponsibleEmail;
		this.consignSettlementPerson = consignSettlementPerson;
		this.consignSettlementPhone1 = consignSettlementPhone1;
		this.consignSettlementPhone2 = consignSettlementPhone2;
		this.consignSettlementPhone3 = consignSettlementPhone3;
		this.consignSettlementPostNumber1 = consignSettlementPostNumber1;
		this.consignSettlementPostNumber2 = consignSettlementPostNumber2;
		this.consignSettlementAddress = consignSettlementAddress;
		this.consignSettlementEmail = consignSettlementEmail;
		this.currentAccount = currentAccount;
		this.currentInterest = currentInterest;
		this.currentNonPropriety = currentNonPropriety;
		this.currentRedemtion = currentRedemtion;
		this.currentSubTotal = currentSubTotal;
		this.createUserId = createUserId;
		this.createUserName = createUserName;
		this.createDate = createDate;
		this.costDetail = costDetail;
		this.nonApproval1 = nonApproval1;
		this.nonApproval2 = nonApproval2;
		this.users = users;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getRefGroupId() {
		return refGroupId;
	}

	public void setRefGroupId(String refGroupId) {
		this.refGroupId = refGroupId;
	}

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getResearchAgency() {
		return researchAgency;
	}

	public void setResearchAgency(String researchAgency) {
		this.researchAgency = researchAgency;
	}

	public String getResearchResponsiblePerson() {
		return researchResponsiblePerson;
	}

	public void setResearchResponsiblePerson(String researchResponsiblePerson) {
		this.researchResponsiblePerson = researchResponsiblePerson;
	}

	public String getContractStartDate() {
		return contractStartDate;
	}

	public void setContractStartDate(String contractStartDate) {
		this.contractStartDate = contractStartDate;
	}

	public String getContractEndDate() {
		return contractEndDate;
	}

	public void setContractEndDate(String contractEndDate) {
		this.contractEndDate = contractEndDate;
	}

	public String getGovContributeAmount() {
		return govContributeAmount;
	}

	public void setGovContributeAmount(String govContributeAmount) {
		this.govContributeAmount = govContributeAmount;
	}

	public String getNonGovContributeAmount() {
		return nonGovContributeAmount;
	}

	public void setNonGovContributeAmount(String nonGovContributeAmount) {
		this.nonGovContributeAmount = nonGovContributeAmount;
	}

	public String getGoodsAmount() {
		return goodsAmount;
	}

	public void setGoodsAmount(String goodsAmount) {
		this.goodsAmount = goodsAmount;
	}

	public String getTotalCashAmount() {
		return totalCashAmount;
	}

	public void setTotalCashAmount(String totalCashAmount) {
		this.totalCashAmount = totalCashAmount;
	}

	public String getGovInterests() {
		return govInterests;
	}

	public void setGovInterests(String govInterests) {
		this.govInterests = govInterests;
	}

	public String getConsignSettlementCommission() {
		return consignSettlementCommission;
	}

	public void setConsignSettlementCommission(String consignSettlementCommission) {
		this.consignSettlementCommission = consignSettlementCommission;
	}

	public String getUseResultDate() {
		return useResultDate;
	}

	public void setUseResultDate(String useResultDate) {
		this.useResultDate = useResultDate;
	}

	public String getFormalObjectAcceptanceDate() {
		return formalObjectAcceptanceDate;
	}

	public void setFormalObjectAcceptanceDate(String formalObjectAcceptanceDate) {
		this.formalObjectAcceptanceDate = formalObjectAcceptanceDate;
	}

	public String getFormalObjectResultDate() {
		return formalObjectResultDate;
	}

	public void setFormalObjectResultDate(String formalObjectResultDate) {
		this.formalObjectResultDate = formalObjectResultDate;
	}

	public String getConsignSettlementResultDate() {
		return consignSettlementResultDate;
	}

	public void setConsignSettlementResultDate(String consignSettlementResultDate) {
		this.consignSettlementResultDate = consignSettlementResultDate;
	}

	public String getSubjectResponsiblePerson() {
		return subjectResponsiblePerson;
	}

	public void setSubjectResponsiblePerson(String subjectResponsiblePerson) {
		this.subjectResponsiblePerson = subjectResponsiblePerson;
	}

	public String getSubjectResponsiblePhone1() {
		return subjectResponsiblePhone1;
	}

	public void setSubjectResponsiblePhone1(String subjectResponsiblePhone1) {
		this.subjectResponsiblePhone1 = subjectResponsiblePhone1;
	}

	public String getSubjectResponsiblePhone2() {
		return subjectResponsiblePhone2;
	}

	public void setSubjectResponsiblePhone2(String subjectResponsiblePhone2) {
		this.subjectResponsiblePhone2 = subjectResponsiblePhone2;
	}

	public String getSubjectResponsiblePhone3() {
		return subjectResponsiblePhone3;
	}

	public void setSubjectResponsiblePhone3(String subjectResponsiblePhone3) {
		this.subjectResponsiblePhone3 = subjectResponsiblePhone3;
	}

	public String getSubjectResponsiblePostNumber1() {
		return subjectResponsiblePostNumber1;
	}

	public void setSubjectResponsiblePostNumber1(
			String subjectResponsiblePostNumber1) {
		this.subjectResponsiblePostNumber1 = subjectResponsiblePostNumber1;
	}

	public String getSubjectResponsiblePostNumber2() {
		return subjectResponsiblePostNumber2;
	}

	public void setSubjectResponsiblePostNumber2(
			String subjectResponsiblePostNumber2) {
		this.subjectResponsiblePostNumber2 = subjectResponsiblePostNumber2;
	}

	public String getSubjectResponsibleAddress() {
		return subjectResponsibleAddress;
	}

	public void setSubjectResponsibleAddress(String subjectResponsibleAddress) {
		this.subjectResponsibleAddress = subjectResponsibleAddress;
	}

	public String getSubejctResponsibleEmail() {
		return subejctResponsibleEmail;
	}

	public void setSubejctResponsibleEmail(String subejctResponsibleEmail) {
		this.subejctResponsibleEmail = subejctResponsibleEmail;
	}

	public String getConsignSettlementPerson() {
		return consignSettlementPerson;
	}

	public void setConsignSettlementPerson(String consignSettlementPerson) {
		this.consignSettlementPerson = consignSettlementPerson;
	}

	public String getConsignSettlementPhone1() {
		return consignSettlementPhone1;
	}

	public void setConsignSettlementPhone1(String consignSettlementPhone1) {
		this.consignSettlementPhone1 = consignSettlementPhone1;
	}

	public String getConsignSettlementPhone2() {
		return consignSettlementPhone2;
	}

	public void setConsignSettlementPhone2(String consignSettlementPhone2) {
		this.consignSettlementPhone2 = consignSettlementPhone2;
	}

	public String getConsignSettlementPhone3() {
		return consignSettlementPhone3;
	}

	public void setConsignSettlementPhone3(String consignSettlementPhone3) {
		this.consignSettlementPhone3 = consignSettlementPhone3;
	}

	public String getConsignSettlementPostNumber1() {
		return consignSettlementPostNumber1;
	}

	public void setConsignSettlementPostNumber1(String consignSettlementPostNumber1) {
		this.consignSettlementPostNumber1 = consignSettlementPostNumber1;
	}

	public String getConsignSettlementPostNumber2() {
		return consignSettlementPostNumber2;
	}

	public void setConsignSettlementPostNumber2(String consignSettlementPostNumber2) {
		this.consignSettlementPostNumber2 = consignSettlementPostNumber2;
	}

	public String getConsignSettlementAddress() {
		return consignSettlementAddress;
	}

	public void setConsignSettlementAddress(String consignSettlementAddress) {
		this.consignSettlementAddress = consignSettlementAddress;
	}

	public String getConsignSettlementEmail() {
		return consignSettlementEmail;
	}

	public void setConsignSettlementEmail(String consignSettlementEmail) {
		this.consignSettlementEmail = consignSettlementEmail;
	}

	public String getCurrentAccount() {
		return currentAccount;
	}

	public void setCurrentAccount(String currentAccount) {
		this.currentAccount = currentAccount;
	}

	public String getCurrentInterest() {
		return currentInterest;
	}

	public void setCurrentInterest(String currentInterest) {
		this.currentInterest = currentInterest;
	}

	public String getCurrentNonPropriety() {
		return currentNonPropriety;
	}

	public void setCurrentNonPropriety(String currentNonPropriety) {
		this.currentNonPropriety = currentNonPropriety;
	}

	public String getCurrentRedemtion() {
		return currentRedemtion;
	}

	public void setCurrentRedemtion(String currentRedemtion) {
		this.currentRedemtion = currentRedemtion;
	}

	public String getCurrentSubTotal() {
		return currentSubTotal;
	}

	public void setCurrentSubTotal(String currentSubTotal) {
		this.currentSubTotal = currentSubTotal;
	}

	public String getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}

	public String getCreateUserName() {
		return createUserName;
	}

	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getCostDetail() {
		return costDetail;
	}

	public void setCostDetail(String costDetail) {
		this.costDetail = costDetail;
	}

	public String getNonApproval1() {
		return nonApproval1;
	}

	public void setNonApproval1(String nonApproval1) {
		this.nonApproval1 = nonApproval1;
	}

	public String getNonApproval2() {
		return nonApproval2;
	}

	public void setNonApproval2(String nonApproval2) {
		this.nonApproval2 = nonApproval2;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((businessName == null) ? 0 : businessName.hashCode());
		result = prime
				* result
				+ ((consignSettlementAddress == null) ? 0
						: consignSettlementAddress.hashCode());
		result = prime
				* result
				+ ((consignSettlementCommission == null) ? 0
						: consignSettlementCommission.hashCode());
		result = prime
				* result
				+ ((consignSettlementEmail == null) ? 0
						: consignSettlementEmail.hashCode());
		result = prime
				* result
				+ ((consignSettlementPerson == null) ? 0
						: consignSettlementPerson.hashCode());
		result = prime
				* result
				+ ((consignSettlementPhone1 == null) ? 0
						: consignSettlementPhone1.hashCode());
		result = prime
				* result
				+ ((consignSettlementPhone2 == null) ? 0
						: consignSettlementPhone2.hashCode());
		result = prime
				* result
				+ ((consignSettlementPhone3 == null) ? 0
						: consignSettlementPhone3.hashCode());
		result = prime
				* result
				+ ((consignSettlementPostNumber1 == null) ? 0
						: consignSettlementPostNumber1.hashCode());
		result = prime
				* result
				+ ((consignSettlementPostNumber2 == null) ? 0
						: consignSettlementPostNumber2.hashCode());
		result = prime
				* result
				+ ((consignSettlementResultDate == null) ? 0
						: consignSettlementResultDate.hashCode());
		result = prime * result
				+ ((contractEndDate == null) ? 0 : contractEndDate.hashCode());
		result = prime
				* result
				+ ((contractStartDate == null) ? 0 : contractStartDate
						.hashCode());
		result = prime * result
				+ ((costDetail == null) ? 0 : costDetail.hashCode());
		result = prime * result
				+ ((createDate == null) ? 0 : createDate.hashCode());
		result = prime * result
				+ ((createUserId == null) ? 0 : createUserId.hashCode());
		result = prime * result
				+ ((createUserName == null) ? 0 : createUserName.hashCode());
		result = prime * result
				+ ((currentAccount == null) ? 0 : currentAccount.hashCode());
		result = prime * result
				+ ((currentInterest == null) ? 0 : currentInterest.hashCode());
		result = prime
				* result
				+ ((currentNonPropriety == null) ? 0 : currentNonPropriety
						.hashCode());
		result = prime
				* result
				+ ((currentRedemtion == null) ? 0 : currentRedemtion.hashCode());
		result = prime * result
				+ ((currentSubTotal == null) ? 0 : currentSubTotal.hashCode());
		result = prime
				* result
				+ ((formalObjectAcceptanceDate == null) ? 0
						: formalObjectAcceptanceDate.hashCode());
		result = prime
				* result
				+ ((formalObjectResultDate == null) ? 0
						: formalObjectResultDate.hashCode());
		result = prime * result
				+ ((goodsAmount == null) ? 0 : goodsAmount.hashCode());
		result = prime
				* result
				+ ((govContributeAmount == null) ? 0 : govContributeAmount
						.hashCode());
		result = prime * result
				+ ((govInterests == null) ? 0 : govInterests.hashCode());
		result = prime * result + ((groupId == null) ? 0 : groupId.hashCode());
		result = prime * result
				+ ((groupName == null) ? 0 : groupName.hashCode());
		result = prime * result
				+ ((nonApproval1 == null) ? 0 : nonApproval1.hashCode());
		result = prime * result
				+ ((nonApproval2 == null) ? 0 : nonApproval2.hashCode());
		result = prime
				* result
				+ ((nonGovContributeAmount == null) ? 0
						: nonGovContributeAmount.hashCode());
		result = prime * result
				+ ((projectName == null) ? 0 : projectName.hashCode());
		result = prime * result
				+ ((refGroupId == null) ? 0 : refGroupId.hashCode());
		result = prime * result
				+ ((researchAgency == null) ? 0 : researchAgency.hashCode());
		result = prime
				* result
				+ ((researchResponsiblePerson == null) ? 0
						: researchResponsiblePerson.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		result = prime
				* result
				+ ((subejctResponsibleEmail == null) ? 0
						: subejctResponsibleEmail.hashCode());
		result = prime
				* result
				+ ((subjectResponsibleAddress == null) ? 0
						: subjectResponsibleAddress.hashCode());
		result = prime
				* result
				+ ((subjectResponsiblePerson == null) ? 0
						: subjectResponsiblePerson.hashCode());
		result = prime
				* result
				+ ((subjectResponsiblePhone1 == null) ? 0
						: subjectResponsiblePhone1.hashCode());
		result = prime
				* result
				+ ((subjectResponsiblePhone2 == null) ? 0
						: subjectResponsiblePhone2.hashCode());
		result = prime
				* result
				+ ((subjectResponsiblePhone3 == null) ? 0
						: subjectResponsiblePhone3.hashCode());
		result = prime
				* result
				+ ((subjectResponsiblePostNumber1 == null) ? 0
						: subjectResponsiblePostNumber1.hashCode());
		result = prime
				* result
				+ ((subjectResponsiblePostNumber2 == null) ? 0
						: subjectResponsiblePostNumber2.hashCode());
		result = prime * result
				+ ((totalCashAmount == null) ? 0 : totalCashAmount.hashCode());
		result = prime * result
				+ ((useResultDate == null) ? 0 : useResultDate.hashCode());
		result = prime * result + ((users == null) ? 0 : users.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserGroup other = (UserGroup) obj;
		if (businessName == null) {
			if (other.businessName != null)
				return false;
		} else if (!businessName.equals(other.businessName))
			return false;
		if (consignSettlementAddress == null) {
			if (other.consignSettlementAddress != null)
				return false;
		} else if (!consignSettlementAddress
				.equals(other.consignSettlementAddress))
			return false;
		if (consignSettlementCommission == null) {
			if (other.consignSettlementCommission != null)
				return false;
		} else if (!consignSettlementCommission
				.equals(other.consignSettlementCommission))
			return false;
		if (consignSettlementEmail == null) {
			if (other.consignSettlementEmail != null)
				return false;
		} else if (!consignSettlementEmail.equals(other.consignSettlementEmail))
			return false;
		if (consignSettlementPerson == null) {
			if (other.consignSettlementPerson != null)
				return false;
		} else if (!consignSettlementPerson
				.equals(other.consignSettlementPerson))
			return false;
		if (consignSettlementPhone1 == null) {
			if (other.consignSettlementPhone1 != null)
				return false;
		} else if (!consignSettlementPhone1
				.equals(other.consignSettlementPhone1))
			return false;
		if (consignSettlementPhone2 == null) {
			if (other.consignSettlementPhone2 != null)
				return false;
		} else if (!consignSettlementPhone2
				.equals(other.consignSettlementPhone2))
			return false;
		if (consignSettlementPhone3 == null) {
			if (other.consignSettlementPhone3 != null)
				return false;
		} else if (!consignSettlementPhone3
				.equals(other.consignSettlementPhone3))
			return false;
		if (consignSettlementPostNumber1 == null) {
			if (other.consignSettlementPostNumber1 != null)
				return false;
		} else if (!consignSettlementPostNumber1
				.equals(other.consignSettlementPostNumber1))
			return false;
		if (consignSettlementPostNumber2 == null) {
			if (other.consignSettlementPostNumber2 != null)
				return false;
		} else if (!consignSettlementPostNumber2
				.equals(other.consignSettlementPostNumber2))
			return false;
		if (consignSettlementResultDate == null) {
			if (other.consignSettlementResultDate != null)
				return false;
		} else if (!consignSettlementResultDate
				.equals(other.consignSettlementResultDate))
			return false;
		if (contractEndDate == null) {
			if (other.contractEndDate != null)
				return false;
		} else if (!contractEndDate.equals(other.contractEndDate))
			return false;
		if (contractStartDate == null) {
			if (other.contractStartDate != null)
				return false;
		} else if (!contractStartDate.equals(other.contractStartDate))
			return false;
		if (costDetail == null) {
			if (other.costDetail != null)
				return false;
		} else if (!costDetail.equals(other.costDetail))
			return false;
		if (createDate == null) {
			if (other.createDate != null)
				return false;
		} else if (!createDate.equals(other.createDate))
			return false;
		if (createUserId == null) {
			if (other.createUserId != null)
				return false;
		} else if (!createUserId.equals(other.createUserId))
			return false;
		if (createUserName == null) {
			if (other.createUserName != null)
				return false;
		} else if (!createUserName.equals(other.createUserName))
			return false;
		if (currentAccount == null) {
			if (other.currentAccount != null)
				return false;
		} else if (!currentAccount.equals(other.currentAccount))
			return false;
		if (currentInterest == null) {
			if (other.currentInterest != null)
				return false;
		} else if (!currentInterest.equals(other.currentInterest))
			return false;
		if (currentNonPropriety == null) {
			if (other.currentNonPropriety != null)
				return false;
		} else if (!currentNonPropriety.equals(other.currentNonPropriety))
			return false;
		if (currentRedemtion == null) {
			if (other.currentRedemtion != null)
				return false;
		} else if (!currentRedemtion.equals(other.currentRedemtion))
			return false;
		if (currentSubTotal == null) {
			if (other.currentSubTotal != null)
				return false;
		} else if (!currentSubTotal.equals(other.currentSubTotal))
			return false;
		if (formalObjectAcceptanceDate == null) {
			if (other.formalObjectAcceptanceDate != null)
				return false;
		} else if (!formalObjectAcceptanceDate
				.equals(other.formalObjectAcceptanceDate))
			return false;
		if (formalObjectResultDate == null) {
			if (other.formalObjectResultDate != null)
				return false;
		} else if (!formalObjectResultDate.equals(other.formalObjectResultDate))
			return false;
		if (goodsAmount == null) {
			if (other.goodsAmount != null)
				return false;
		} else if (!goodsAmount.equals(other.goodsAmount))
			return false;
		if (govContributeAmount == null) {
			if (other.govContributeAmount != null)
				return false;
		} else if (!govContributeAmount.equals(other.govContributeAmount))
			return false;
		if (govInterests == null) {
			if (other.govInterests != null)
				return false;
		} else if (!govInterests.equals(other.govInterests))
			return false;
		if (groupId == null) {
			if (other.groupId != null)
				return false;
		} else if (!groupId.equals(other.groupId))
			return false;
		if (groupName == null) {
			if (other.groupName != null)
				return false;
		} else if (!groupName.equals(other.groupName))
			return false;
		if (nonApproval1 == null) {
			if (other.nonApproval1 != null)
				return false;
		} else if (!nonApproval1.equals(other.nonApproval1))
			return false;
		if (nonApproval2 == null) {
			if (other.nonApproval2 != null)
				return false;
		} else if (!nonApproval2.equals(other.nonApproval2))
			return false;
		if (nonGovContributeAmount == null) {
			if (other.nonGovContributeAmount != null)
				return false;
		} else if (!nonGovContributeAmount.equals(other.nonGovContributeAmount))
			return false;
		if (projectName == null) {
			if (other.projectName != null)
				return false;
		} else if (!projectName.equals(other.projectName))
			return false;
		if (refGroupId == null) {
			if (other.refGroupId != null)
				return false;
		} else if (!refGroupId.equals(other.refGroupId))
			return false;
		if (researchAgency == null) {
			if (other.researchAgency != null)
				return false;
		} else if (!researchAgency.equals(other.researchAgency))
			return false;
		if (researchResponsiblePerson == null) {
			if (other.researchResponsiblePerson != null)
				return false;
		} else if (!researchResponsiblePerson
				.equals(other.researchResponsiblePerson))
			return false;
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		if (subejctResponsibleEmail == null) {
			if (other.subejctResponsibleEmail != null)
				return false;
		} else if (!subejctResponsibleEmail
				.equals(other.subejctResponsibleEmail))
			return false;
		if (subjectResponsibleAddress == null) {
			if (other.subjectResponsibleAddress != null)
				return false;
		} else if (!subjectResponsibleAddress
				.equals(other.subjectResponsibleAddress))
			return false;
		if (subjectResponsiblePerson == null) {
			if (other.subjectResponsiblePerson != null)
				return false;
		} else if (!subjectResponsiblePerson
				.equals(other.subjectResponsiblePerson))
			return false;
		if (subjectResponsiblePhone1 == null) {
			if (other.subjectResponsiblePhone1 != null)
				return false;
		} else if (!subjectResponsiblePhone1
				.equals(other.subjectResponsiblePhone1))
			return false;
		if (subjectResponsiblePhone2 == null) {
			if (other.subjectResponsiblePhone2 != null)
				return false;
		} else if (!subjectResponsiblePhone2
				.equals(other.subjectResponsiblePhone2))
			return false;
		if (subjectResponsiblePhone3 == null) {
			if (other.subjectResponsiblePhone3 != null)
				return false;
		} else if (!subjectResponsiblePhone3
				.equals(other.subjectResponsiblePhone3))
			return false;
		if (subjectResponsiblePostNumber1 == null) {
			if (other.subjectResponsiblePostNumber1 != null)
				return false;
		} else if (!subjectResponsiblePostNumber1
				.equals(other.subjectResponsiblePostNumber1))
			return false;
		if (subjectResponsiblePostNumber2 == null) {
			if (other.subjectResponsiblePostNumber2 != null)
				return false;
		} else if (!subjectResponsiblePostNumber2
				.equals(other.subjectResponsiblePostNumber2))
			return false;
		if (totalCashAmount == null) {
			if (other.totalCashAmount != null)
				return false;
		} else if (!totalCashAmount.equals(other.totalCashAmount))
			return false;
		if (useResultDate == null) {
			if (other.useResultDate != null)
				return false;
		} else if (!useResultDate.equals(other.useResultDate))
			return false;
		if (users == null) {
			if (other.users != null)
				return false;
		} else if (!users.equals(other.users))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UserGroup [businessName=" + businessName
				+ ", consignSettlementAddress=" + consignSettlementAddress
				+ ", consignSettlementCommission="
				+ consignSettlementCommission + ", consignSettlementEmail="
				+ consignSettlementEmail + ", consignSettlementPerson="
				+ consignSettlementPerson + ", consignSettlementPhone1="
				+ consignSettlementPhone1 + ", consignSettlementPhone2="
				+ consignSettlementPhone2 + ", consignSettlementPhone3="
				+ consignSettlementPhone3 + ", consignSettlementPostNumber1="
				+ consignSettlementPostNumber1
				+ ", consignSettlementPostNumber2="
				+ consignSettlementPostNumber2
				+ ", consignSettlementResultDate="
				+ consignSettlementResultDate + ", contractEndDate="
				+ contractEndDate + ", contractStartDate=" + contractStartDate
				+ ", costDetail=" + costDetail + ", createDate=" + createDate
				+ ", createUserId=" + createUserId + ", createUserName="
				+ createUserName + ", currentAccount=" + currentAccount
				+ ", currentInterest=" + currentInterest
				+ ", currentNonPropriety=" + currentNonPropriety
				+ ", currentRedemtion=" + currentRedemtion
				+ ", currentSubTotal=" + currentSubTotal
				+ ", formalObjectAcceptanceDate=" + formalObjectAcceptanceDate
				+ ", formalObjectResultDate=" + formalObjectResultDate
				+ ", goodsAmount=" + goodsAmount + ", govContributeAmount="
				+ govContributeAmount + ", govInterests=" + govInterests
				+ ", groupId=" + groupId + ", groupName=" + groupName
				+ ", nonApproval1=" + nonApproval1 + ", nonApproval2="
				+ nonApproval2 + ", nonGovContributeAmount="
				+ nonGovContributeAmount + ", projectName=" + projectName
				+ ", refGroupId=" + refGroupId + ", researchAgency="
				+ researchAgency + ", researchResponsiblePerson="
				+ researchResponsiblePerson + ", role=" + role
				+ ", subejctResponsibleEmail=" + subejctResponsibleEmail
				+ ", subjectResponsibleAddress=" + subjectResponsibleAddress
				+ ", subjectResponsiblePerson=" + subjectResponsiblePerson
				+ ", subjectResponsiblePhone1=" + subjectResponsiblePhone1
				+ ", subjectResponsiblePhone2=" + subjectResponsiblePhone2
				+ ", subjectResponsiblePhone3=" + subjectResponsiblePhone3
				+ ", subjectResponsiblePostNumber1="
				+ subjectResponsiblePostNumber1
				+ ", subjectResponsiblePostNumber2="
				+ subjectResponsiblePostNumber2 + ", totalCashAmount="
				+ totalCashAmount + ", useResultDate=" + useResultDate
				+ ", users=" + users + "]";
	}

	
}
