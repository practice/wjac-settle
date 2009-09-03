package org.jabberstory.cjac.consignsettle.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class UserGroup {
	private String groupId;
	private String groupName;
	private String role;	// admin(A), consignee(C, 회계법인), owner(O, 전담), subject(S, 주관)
	private String parentGroupId;
	private String parentGroupName;
	
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
	 * @param parentGroupId
	 * @param parentGroupName
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
			String parentGroupId, String parentGroupName, String businessName,
			String projectName, String researchAgency,
			String researchResponsiblePerson, String contractStartDate,
			String contractEndDate, String govContributeAmount,
			String nonGovContributeAmount, String goodsAmount,
			String totalCashAmount, String govInterests,
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
		this.parentGroupId = parentGroupId;
		this.parentGroupName = parentGroupName;
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

	public String getParentGroupId() {
		return parentGroupId;
	}

	public void setParentGroupId(String parentGroupId) {
		this.parentGroupId = parentGroupId;
	}

	public String getParentGroupName() {
		return parentGroupName;
	}

	public void setParentGroupName(String parentGroupName) {
		this.parentGroupName = parentGroupName;
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

	
}
