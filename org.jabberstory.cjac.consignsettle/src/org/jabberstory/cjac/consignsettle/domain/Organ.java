package org.jabberstory.cjac.consignsettle.domain;

import java.util.ArrayList;
import java.util.List;

import org.jabberstory.cjac.forum.domain.PostAttachment;

public class Organ {

	private String organId;
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
	private String subtotal;
	private String totalResearchAmount;
	private String organResponsiblePerson;
	private String organResponsiblePhone1;
	private String organResponsiblePhone2;
	private String organResponsiblePhone3;
	private String organResponsiblePostNumber1;
	private String organResponsiblePostNumber2;
	private String organResponsibleAddress;
	private String organResponsibleEmail;
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
	private String opinion;
	private String remark;
	private String costDetail;
	private String nonApproval1;
	private String nonApproval2;
	private UserGroup ownerGroup;
	private UserGroup subjectGroup;
	private List<OrganAttachment> attachments = new ArrayList<OrganAttachment>();

	public Organ() {
	}

	/**
	 * @param organId
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
	 * @param subtotal
	 * @param totalResearchAmount
	 * @param organResponsiblePerson
	 * @param organResponsiblePhone1
	 * @param organResponsiblePhone2
	 * @param organResponsiblePhone3
	 * @param organResponsiblePostNumber1
	 * @param organResponsiblePostNumber2
	 * @param organResponsibleAddress
	 * @param organResponsibleEmail
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
	 * @param opinion
	 * @param remark
	 * @param costDetail
	 * @param nonApproval1
	 * @param nonApproval2
	 * @param ownerGroup
	 * @param subjectGroup
	 * @param attachments
	 */
	public Organ(String organId, String businessName, String projectName,
			String researchAgency, String researchResponsiblePerson,
			String contractStartDate, String contractEndDate,
			String govContributeAmount, String nonGovContributeAmount,
			String goodsAmount, String totalCashAmount, String govInterests,
			String consignSettlementCommission, String useResultDate,
			String formalObjectAcceptanceDate, String formalObjectResultDate,
			String consignSettlementResultDate, String subtotal,
			String totalResearchAmount, String organResponsiblePerson,
			String organResponsiblePhone1, String organResponsiblePhone2,
			String organResponsiblePhone3, String organResponsiblePostNumber1,
			String organResponsiblePostNumber2, String organResponsibleAddress,
			String organResponsibleEmail, String consignSettlementPerson,
			String consignSettlementPhone1, String consignSettlementPhone2,
			String consignSettlementPhone3,
			String consignSettlementPostNumber1,
			String consignSettlementPostNumber2,
			String consignSettlementAddress, String consignSettlementEmail,
			String currentAccount, String currentInterest,
			String currentNonPropriety, String currentRedemtion,
			String currentSubTotal, String opinion, String remark,
			String costDetail, String nonApproval1, String nonApproval2,
			UserGroup ownerGroup, UserGroup subjectGroup,
			List<OrganAttachment> attachments) {
		super();
		this.organId = organId;
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
		this.subtotal = subtotal;
		this.totalResearchAmount = totalResearchAmount;
		this.organResponsiblePerson = organResponsiblePerson;
		this.organResponsiblePhone1 = organResponsiblePhone1;
		this.organResponsiblePhone2 = organResponsiblePhone2;
		this.organResponsiblePhone3 = organResponsiblePhone3;
		this.organResponsiblePostNumber1 = organResponsiblePostNumber1;
		this.organResponsiblePostNumber2 = organResponsiblePostNumber2;
		this.organResponsibleAddress = organResponsibleAddress;
		this.organResponsibleEmail = organResponsibleEmail;
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
		this.opinion = opinion;
		this.remark = remark;
		this.costDetail = costDetail;
		this.nonApproval1 = nonApproval1;
		this.nonApproval2 = nonApproval2;
		this.ownerGroup = ownerGroup;
		this.subjectGroup = subjectGroup;
		this.attachments = attachments;
	}

	public String getOrganId() {
		return organId;
	}

	public void setOrganId(String organId) {
		this.organId = organId;
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

	public String getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(String subtotal) {
		this.subtotal = subtotal;
	}

	public String getTotalResearchAmount() {
		return totalResearchAmount;
	}

	public void setTotalResearchAmount(String totalResearchAmount) {
		this.totalResearchAmount = totalResearchAmount;
	}

	public String getOrganResponsiblePerson() {
		return organResponsiblePerson;
	}

	public void setOrganResponsiblePerson(String organResponsiblePerson) {
		this.organResponsiblePerson = organResponsiblePerson;
	}

	public String getOrganResponsiblePhone1() {
		return organResponsiblePhone1;
	}

	public void setOrganResponsiblePhone1(String organResponsiblePhone1) {
		this.organResponsiblePhone1 = organResponsiblePhone1;
	}

	public String getOrganResponsiblePhone2() {
		return organResponsiblePhone2;
	}

	public void setOrganResponsiblePhone2(String organResponsiblePhone2) {
		this.organResponsiblePhone2 = organResponsiblePhone2;
	}

	public String getOrganResponsiblePhone3() {
		return organResponsiblePhone3;
	}

	public void setOrganResponsiblePhone3(String organResponsiblePhone3) {
		this.organResponsiblePhone3 = organResponsiblePhone3;
	}

	public String getOrganResponsiblePostNumber1() {
		return organResponsiblePostNumber1;
	}

	public void setOrganResponsiblePostNumber1(String organResponsiblePostNumber1) {
		this.organResponsiblePostNumber1 = organResponsiblePostNumber1;
	}

	public String getOrganResponsiblePostNumber2() {
		return organResponsiblePostNumber2;
	}

	public void setOrganResponsiblePostNumber2(String organResponsiblePostNumber2) {
		this.organResponsiblePostNumber2 = organResponsiblePostNumber2;
	}

	public String getOrganResponsibleAddress() {
		return organResponsibleAddress;
	}

	public void setOrganResponsibleAddress(String organResponsibleAddress) {
		this.organResponsibleAddress = organResponsibleAddress;
	}

	public String getOrganResponsibleEmail() {
		return organResponsibleEmail;
	}

	public void setOrganResponsibleEmail(String organResponsibleEmail) {
		this.organResponsibleEmail = organResponsibleEmail;
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

	public String getOpinion() {
		return opinion;
	}

	public void setOpinion(String opinion) {
		this.opinion = opinion;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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

	public UserGroup getOwnerGroup() {
		return ownerGroup;
	}

	public void setOwnerGroup(UserGroup ownerGroup) {
		this.ownerGroup = ownerGroup;
	}

	public UserGroup getSubjectGroup() {
		return subjectGroup;
	}

	@Override
	public String toString() {
		return "Organ [businessName=" + businessName
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
				+ ", costDetail=" + costDetail + ", currentAccount="
				+ currentAccount + ", currentInterest=" + currentInterest
				+ ", currentNonPropriety=" + currentNonPropriety
				+ ", currentRedemtion=" + currentRedemtion
				+ ", currentSubTotal=" + currentSubTotal
				+ ", formalObjectAcceptanceDate=" + formalObjectAcceptanceDate
				+ ", formalObjectResultDate=" + formalObjectResultDate
				+ ", goodsAmount=" + goodsAmount + ", govContributeAmount="
				+ govContributeAmount + ", govInterests=" + govInterests
				+ ", nonApproval1=" + nonApproval1 + ", nonApproval2="
				+ nonApproval2 + ", nonGovContributeAmount="
				+ nonGovContributeAmount + ", opinion=" + opinion
				+ ", organId=" + organId + ", organResponsibleAddress="
				+ organResponsibleAddress + ", organResponsibleEmail="
				+ organResponsibleEmail + ", organResponsiblePerson="
				+ organResponsiblePerson + ", organResponsiblePhone1="
				+ organResponsiblePhone1 + ", organResponsiblePhone2="
				+ organResponsiblePhone2 + ", organResponsiblePhone3="
				+ organResponsiblePhone3 + ", organResponsiblePostNumber1="
				+ organResponsiblePostNumber1
				+ ", organResponsiblePostNumber2="
				+ organResponsiblePostNumber2 + ", projectName=" + projectName
				+ ", remark=" + remark + ", researchAgency=" + researchAgency
				+ ", researchResponsiblePerson=" + researchResponsiblePerson
				+ ", subtotal=" + subtotal + ", totalCashAmount="
				+ totalCashAmount + ", totalResearchAmount="
				+ totalResearchAmount + ", useResultDate=" + useResultDate
				+ "]";
	}

	public void addAttachment(int index, OrganAttachment attachment) {
		getAttachments().add(index, attachment);
	}
	
	public void setSubjectGroup(UserGroup subjectGroup) {
		this.subjectGroup = subjectGroup;
	}

	public List<OrganAttachment> getAttachments() {
		return attachments;
	}

	public void setAttachments(List<OrganAttachment> attachments) {
		this.attachments = attachments;
	}

	
}
