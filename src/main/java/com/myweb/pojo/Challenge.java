package com.myweb.pojo;
public class Challenge {
    private Integer cid;
    private Integer type;
    private String title;
    private String picAddress;
    private String name;
    private String flag;
    private String description;
    private String platform;
    private String link;
    private String isuse;
    private int solvedNumber;
    private String subtype;
    private String myuse;
    private String isopen;
    private String address;
    public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPicAddress() {
		return picAddress;
	}

	public void setPicAddress(String picAddress) {
		this.picAddress = picAddress;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}
	public int getSolvedNumber() {
		return solvedNumber;
	}

	public void setSolvedNumber(int solvedNumber) {
		this.solvedNumber = solvedNumber;
	}

	public String getSubtype() {
		return subtype;
	}

	public void setSubtype(String subtype) {
		this.subtype = subtype;
	}

	public String getMyuse() {
		return myuse;
	}

	public void setMyuse(String myuse) {
		this.myuse = myuse;
	}

	public String getIsuse() {
		return isuse;
	}

	public void setIsuse(String isuse) {
		this.isuse = isuse;
	}

	public String getIsopen() {
		return isopen;
	}

	public void setIsopen(String isopen) {
		this.isopen = isopen;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
    public String toString() {
        return "Challenge{" +
                "cid=" + cid +
                ", flag='" + flag + '\'' +
                ", title='" + title + '\'' +
                ", type=" + type +
                ", description='" + description + '\'' +
                ", solvedNumber=" + solvedNumber +
                ", link='" + link + '\'' +
                '}';
    }
}
