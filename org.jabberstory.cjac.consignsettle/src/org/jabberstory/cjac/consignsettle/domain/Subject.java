/*
 * Copyright 2002-2008 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
*/
package org.jabberstory.cjac.consignsettle.domain;

import java.util.Date;

/**
 * 주관기관 도메인 모델
 *
 * @author HyunBae Shin
 * @since August 28, 2009
 */
public class Subject {

	private String ownerId;
	private String ownerName;
	private String subjectId;
	private String subjectName;
	private String businessName;
	private String projectName;
	private String researchAgency;
	private String researchResponsiblePerson;
	private Date contractStartDate;
	private Date contractEndDate;
	
	private long govContributeAmount;
	private long nonGovContributeAmount;
	private long goodsAmount;
	private long totalCashAmount;
	private long govInterests;
	private long consignSettlementCommission;
	
	private Date useResultDate;	
	private Date formalObjectAcceptanceDate;
	private Date formalObjectResultDate;
	private Date consignSettlementResultDate;
	
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
	
	private long currentAccount;
	private long currentInterest;
	private long currentNonPropriety;
	private long currentRedemtion;
	private long currentSubTotal;
	
	private String createUserId;
	private String createUserName;
	private Date createDate;
	
	public Subject(){
	}
	
	public Subject(String ownerId, String ownerName, String subjectId,
			String subjectName, String businessName, String projectName,
			String researchAgency, String researchResponsiblePerson,
			Date contractStartDate, Date contractEndDate,
			long govContributeAmount, long nonGovContributeAmount,
			long goodsAmount, long totalCashAmount, long govInterests,
			long consignSettlementCommission, Date useResultDate,
			Date formalObjectAcceptanceDate, Date formalObjectResultDate,
			Date consignSettlementResultDate, String subjectResponsiblePerson,
			String subjectResponsiblePhone1, String subjectResponsiblePhone2,
			String subjectResponsiblePhone3,
			String subjectResponsiblePostNumber1,
			String subjectResponsiblePostNumber2,
			String subjectResponsibleAddress, String subejctResponsibleEmail,
			String consignSettlementPerson, String consignSettlementPhone1,
			String consignSettlementPhone2, String consignSettlementPhone3,
			String consignSettlementPostNumber1,
			String consignSettlementPostNumber2,
			String consignSettlementAddress, String consignSettlementEmail,
			long currentAccount, long currentInterest,
			long currentNonPropriety, long currentRedemtion,
			long currentSubTotal, String createUserId, String createUserName,
			Date createDate) {
		super();
		this.ownerId = ownerId;
		this.ownerName = ownerName;
		this.subjectId = subjectId;
		this.subjectName = subjectName;
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
	}

	@Override
	public String toString() {
		return "Subject [businessName=" + businessName
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
				+ ", createDate=" + createDate + ", createUserId="
				+ createUserId + ", createUserName=" + createUserName
				+ ", currentAccount=" + currentAccount + ", currentInterest="
				+ currentInterest + ", currentNonPropriety="
				+ currentNonPropriety + ", currentRedemtion="
				+ currentRedemtion + ", currentSubTotal=" + currentSubTotal
				+ ", formalObjectAcceptanceDate=" + formalObjectAcceptanceDate
				+ ", formalObjectResultDate=" + formalObjectResultDate
				+ ", goodsAmount=" + goodsAmount + ", govContributeAmount="
				+ govContributeAmount + ", govInterests=" + govInterests
				+ ", nonGovContributeAmount=" + nonGovContributeAmount
				+ ", ownerId=" + ownerId + ", ownerName=" + ownerName
				+ ", projectName=" + projectName + ", researchAgency="
				+ researchAgency + ", researchResponsiblePerson="
				+ researchResponsiblePerson + ", subejctResponsibleEmail="
				+ subejctResponsibleEmail + ", subjectId=" + subjectId
				+ ", subjectName=" + subjectName
				+ ", subjectResponsibleAddress=" + subjectResponsibleAddress
				+ ", subjectResponsiblePerson=" + subjectResponsiblePerson
				+ ", subjectResponsiblePhone1=" + subjectResponsiblePhone1
				+ ", subjectResponsiblePhone2=" + subjectResponsiblePhone2
				+ ", subjectResponsiblePhone3=" + subjectResponsiblePhone3
				+ ", subjectResponsiblePostNumber1="
				+ subjectResponsiblePostNumber1
				+ ", subjectResponsiblePostNumber2="
				+ subjectResponsiblePostNumber2 + ", totalCashAmount="
				+ totalCashAmount + ", useResultDate=" + useResultDate + "]";
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
				+ (int) (consignSettlementCommission ^ (consignSettlementCommission >>> 32));
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
				+ ((createDate == null) ? 0 : createDate.hashCode());
		result = prime * result
				+ ((createUserId == null) ? 0 : createUserId.hashCode());
		result = prime * result
				+ ((createUserName == null) ? 0 : createUserName.hashCode());
		result = prime * result
				+ (int) (currentAccount ^ (currentAccount >>> 32));
		result = prime * result
				+ (int) (currentInterest ^ (currentInterest >>> 32));
		result = prime * result
				+ (int) (currentNonPropriety ^ (currentNonPropriety >>> 32));
		result = prime * result
				+ (int) (currentRedemtion ^ (currentRedemtion >>> 32));
		result = prime * result
				+ (int) (currentSubTotal ^ (currentSubTotal >>> 32));
		result = prime
				* result
				+ ((formalObjectAcceptanceDate == null) ? 0
						: formalObjectAcceptanceDate.hashCode());
		result = prime
				* result
				+ ((formalObjectResultDate == null) ? 0
						: formalObjectResultDate.hashCode());
		result = prime * result + (int) (goodsAmount ^ (goodsAmount >>> 32));
		result = prime * result
				+ (int) (govContributeAmount ^ (govContributeAmount >>> 32));
		result = prime * result + (int) (govInterests ^ (govInterests >>> 32));
		result = prime
				* result
				+ (int) (nonGovContributeAmount ^ (nonGovContributeAmount >>> 32));
		result = prime * result + ((ownerId == null) ? 0 : ownerId.hashCode());
		result = prime * result
				+ ((ownerName == null) ? 0 : ownerName.hashCode());
		result = prime * result
				+ ((projectName == null) ? 0 : projectName.hashCode());
		result = prime * result
				+ ((researchAgency == null) ? 0 : researchAgency.hashCode());
		result = prime
				* result
				+ ((researchResponsiblePerson == null) ? 0
						: researchResponsiblePerson.hashCode());
		result = prime
				* result
				+ ((subejctResponsibleEmail == null) ? 0
						: subejctResponsibleEmail.hashCode());
		result = prime * result
				+ ((subjectId == null) ? 0 : subjectId.hashCode());
		result = prime * result
				+ ((subjectName == null) ? 0 : subjectName.hashCode());
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
				+ (int) (totalCashAmount ^ (totalCashAmount >>> 32));
		result = prime * result
				+ ((useResultDate == null) ? 0 : useResultDate.hashCode());
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
		Subject other = (Subject) obj;
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
		if (consignSettlementCommission != other.consignSettlementCommission)
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
		if (currentAccount != other.currentAccount)
			return false;
		if (currentInterest != other.currentInterest)
			return false;
		if (currentNonPropriety != other.currentNonPropriety)
			return false;
		if (currentRedemtion != other.currentRedemtion)
			return false;
		if (currentSubTotal != other.currentSubTotal)
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
		if (goodsAmount != other.goodsAmount)
			return false;
		if (govContributeAmount != other.govContributeAmount)
			return false;
		if (govInterests != other.govInterests)
			return false;
		if (nonGovContributeAmount != other.nonGovContributeAmount)
			return false;
		if (ownerId == null) {
			if (other.ownerId != null)
				return false;
		} else if (!ownerId.equals(other.ownerId))
			return false;
		if (ownerName == null) {
			if (other.ownerName != null)
				return false;
		} else if (!ownerName.equals(other.ownerName))
			return false;
		if (projectName == null) {
			if (other.projectName != null)
				return false;
		} else if (!projectName.equals(other.projectName))
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
		if (subejctResponsibleEmail == null) {
			if (other.subejctResponsibleEmail != null)
				return false;
		} else if (!subejctResponsibleEmail
				.equals(other.subejctResponsibleEmail))
			return false;
		if (subjectId == null) {
			if (other.subjectId != null)
				return false;
		} else if (!subjectId.equals(other.subjectId))
			return false;
		if (subjectName == null) {
			if (other.subjectName != null)
				return false;
		} else if (!subjectName.equals(other.subjectName))
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
		if (totalCashAmount != other.totalCashAmount)
			return false;
		if (useResultDate == null) {
			if (other.useResultDate != null)
				return false;
		} else if (!useResultDate.equals(other.useResultDate))
			return false;
		return true;
	}
	
	
	
}
