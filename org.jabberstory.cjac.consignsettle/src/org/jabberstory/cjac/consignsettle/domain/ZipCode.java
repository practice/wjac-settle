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

/**
 * 우편번호 모델
 * 
 * @author HyunBae Shin
 * @since September 11, 2009
 */

public class ZipCode {

	private int zipcodeid;
	private String zipcode;
	private String serial;
	private String addr01;
	private String addr02;
	private String addr03;
	private String addr04;
	private String addr05;
	private String bungi;
	private String bungifrmain;
	private String bungifrsub;
	private String bungitomain;
	private String bungitosub;
	private String building;
	private String dongfr;
	private String dongto;
	private String datechange;
	private String addr;

	public ZipCode() {
	}

	public ZipCode(String zipcode, String serial, String addr01, String addr02,
			String addr03, String addr04, String addr05, String bungi,
			String bungifrmain, String bungifrsub, String bungitomain,
			String bungitosub, String building, String dongfr, String dongto,
			String datechange, String addr) {
		this.zipcode = zipcode;
		this.serial = serial;
		this.addr01 = addr01;
		this.addr02 = addr02;
		this.addr03 = addr03;
		this.addr04 = addr04;
		this.addr05 = addr05;
		this.bungi = bungi;
		this.bungifrmain = bungifrmain;
		this.bungifrsub = bungifrsub;
		this.bungitomain = bungitomain;
		this.bungitosub = bungitosub;
		this.building = building;
		this.dongfr = dongfr;
		this.dongto = dongto;
		this.datechange = datechange;
		this.addr = addr;
	}

	public int getZipcodeid() {
		return this.zipcodeid;
	}

	public void setZipcodeid(int zipcodeid) {
		this.zipcodeid = zipcodeid;
	}

	public String getZipcode() {
		return this.zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getSerial() {
		return this.serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	public String getAddr01() {
		return this.addr01;
	}

	public void setAddr01(String addr01) {
		this.addr01 = addr01;
	}

	public String getAddr02() {
		return this.addr02;
	}

	public void setAddr02(String addr02) {
		this.addr02 = addr02;
	}

	public String getAddr03() {
		return this.addr03;
	}

	public void setAddr03(String addr03) {
		this.addr03 = addr03;
	}

	public String getAddr04() {
		return this.addr04;
	}

	public void setAddr04(String addr04) {
		this.addr04 = addr04;
	}

	public String getAddr05() {
		return this.addr05;
	}

	public void setAddr05(String addr05) {
		this.addr05 = addr05;
	}

	public String getBungi() {
		return this.bungi;
	}

	public void setBungi(String bungi) {
		this.bungi = bungi;
	}

	public String getBungifrmain() {
		return this.bungifrmain;
	}

	public void setBungifrmain(String bungifrmain) {
		this.bungifrmain = bungifrmain;
	}

	public String getBungifrsub() {
		return this.bungifrsub;
	}

	public void setBungifrsub(String bungifrsub) {
		this.bungifrsub = bungifrsub;
	}

	public String getBungitomain() {
		return this.bungitomain;
	}

	public void setBungitomain(String bungitomain) {
		this.bungitomain = bungitomain;
	}

	public String getBungitosub() {
		return this.bungitosub;
	}

	public void setBungitosub(String bungitosub) {
		this.bungitosub = bungitosub;
	}

	public String getBuilding() {
		return this.building;
	}

	public void setBuilding(String building) {
		this.building = building;
	}

	public String getDongfr() {
		return this.dongfr;
	}

	public void setDongfr(String dongfr) {
		this.dongfr = dongfr;
	}

	public String getDongto() {
		return this.dongto;
	}

	public void setDongto(String dongto) {
		this.dongto = dongto;
	}

	public String getDatechange() {
		return this.datechange;
	}

	public void setDatechange(String datechange) {
		this.datechange = datechange;
	}

	public String getAddr() {
		return this.addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	@Override
	public String toString() {
		return "ZipCode [addr=" + addr + ", addr01=" + addr01 + ", addr02="
				+ addr02 + ", addr03=" + addr03 + ", addr04=" + addr04
				+ ", addr05=" + addr05 + ", building=" + building + ", bungi="
				+ bungi + ", bungifrmain=" + bungifrmain + ", bungifrsub="
				+ bungifrsub + ", bungitomain=" + bungitomain + ", bungitosub="
				+ bungitosub + ", datechange=" + datechange + ", dongfr="
				+ dongfr + ", dongto=" + dongto + ", serial=" + serial
				+ ", zipcode=" + zipcode + ", zipcodeid=" + zipcodeid + "]";
	}
	

}
