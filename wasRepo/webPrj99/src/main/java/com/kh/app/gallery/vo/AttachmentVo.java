package com.kh.app.gallery.vo;

public class AttachmentVo {
	
	private String attachmentNo;
	private String refNo;
	private String originName;
	private String changeName;
	private String filePath;
	private String thumbnailYn;
	public String getAttachmentNo() {
		return attachmentNo;
	}
	public void setAttachmentNo(String attachmentNo) {
		this.attachmentNo = attachmentNo;
	}
	public String getRefNo() {
		return refNo;
	}
	public void setRefNo(String refNo) {
		this.refNo = refNo;
	}
	public String getOriginName() {
		return originName;
	}
	public void setOriginName(String originName) {
		this.originName = originName;
	}
	public String getChangeName() {
		return changeName;
	}
	public void setChangeName(String changeName) {
		this.changeName = changeName;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getThumbnailYn() {
		return thumbnailYn;
	}
	public void setThumbnailYn(String thumbnailYn) {
		this.thumbnailYn = thumbnailYn;
	}
	@Override
	public String toString() {
		return "AttachmentVo [attachmentNo=" + attachmentNo + ", refNo=" + refNo + ", originName=" + originName
				+ ", changeName=" + changeName + ", filePath=" + filePath + ", thumbnailYn=" + thumbnailYn + "]";
	}
	public AttachmentVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AttachmentVo(String attachmentNo, String refNo, String originName, String changeName, String filePath,
			String thumbnailYn) {
		super();
		this.attachmentNo = attachmentNo;
		this.refNo = refNo;
		this.originName = originName;
		this.changeName = changeName;
		this.filePath = filePath;
		this.thumbnailYn = thumbnailYn;
	}
	
	
	

}