package com.kh.app.gallery.vo;

import java.util.ArrayList;
import java.util.List;

public class GalleryVo {
	
	public String getSrc() {
		return thumbnailVo.getFilePath() + thumbnailVo.getChangeName();
	}
	
	private String galleryNo;
	private String title;
	private String writerNo;
	private String hit;
	private String enrollDate;
	private String modifyDate;
	private String status;
	
	// att 관련 필드는, rs 에서 꺼낸 데이터를 임시로 담기 위해서만 사용
	private String attachmentNo;
	private String refNo;
	private String originName;
	private String changeName;
	private String filePath;
	private String thumbnailYn;
	
	private String writerNick;
	
	private List<AttachmentVo> attachmentVoList = new ArrayList<AttachmentVo>();
	private AttachmentVo thumbnailVo;
	public String getGalleryNo() {
		return galleryNo;
	}
	public void setGalleryNo(String galleryNo) {
		this.galleryNo = galleryNo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriterNo() {
		return writerNo;
	}
	public void setWriterNo(String writerNo) {
		this.writerNo = writerNo;
	}
	public String getHit() {
		return hit;
	}
	public void setHit(String hit) {
		this.hit = hit;
	}
	public String getEnrollDate() {
		return enrollDate;
	}
	public void setEnrollDate(String enrollDate) {
		this.enrollDate = enrollDate;
	}
	public String getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(String modifyDate) {
		this.modifyDate = modifyDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
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
	public String getWriterNick() {
		return writerNick;
	}
	public void setWriterNick(String writerNick) {
		this.writerNick = writerNick;
	}
	public List<AttachmentVo> getAttachmentVoList() {
		return attachmentVoList;
	}
	public void setAttachmentVoList(List<AttachmentVo> attachmentVoList) {
		this.attachmentVoList = attachmentVoList;
	}
	public AttachmentVo getThumbnailVo() {
		return thumbnailVo;
	}
	public void setThumbnailVo(AttachmentVo thumbnailVo) {
		this.thumbnailVo = thumbnailVo;
	}
	@Override
	public String toString() {
		return "GalleryVo [galleryNo=" + galleryNo + ", title=" + title + ", writerNo=" + writerNo + ", hit=" + hit
				+ ", enrollDate=" + enrollDate + ", modifyDate=" + modifyDate + ", status=" + status + ", attachmentNo="
				+ attachmentNo + ", refNo=" + refNo + ", originName=" + originName + ", changeName=" + changeName
				+ ", filePath=" + filePath + ", thumbnailYn=" + thumbnailYn + ", writerNick=" + writerNick
				+ ", attachmentVoList=" + attachmentVoList + ", thumbnailVo=" + thumbnailVo + "]";
	}
	public GalleryVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public GalleryVo(String galleryNo, String title, String writerNo, String hit, String enrollDate, String modifyDate,
			String status, String attachmentNo, String refNo, String originName, String changeName, String filePath,
			String thumbnailYn, String writerNick, List<AttachmentVo> attachmentVoList, AttachmentVo thumbnailVo) {
		super();
		this.galleryNo = galleryNo;
		this.title = title;
		this.writerNo = writerNo;
		this.hit = hit;
		this.enrollDate = enrollDate;
		this.modifyDate = modifyDate;
		this.status = status;
		this.attachmentNo = attachmentNo;
		this.refNo = refNo;
		this.originName = originName;
		this.changeName = changeName;
		this.filePath = filePath;
		this.thumbnailYn = thumbnailYn;
		this.writerNick = writerNick;
		this.attachmentVoList = attachmentVoList;
		this.thumbnailVo = thumbnailVo;
	}
	
	
	public GalleryVo(String galleryNo, String title, String writerNo, String hit, String enrollDate, String modifyDate,
			String status, String attachmentNo, String refNo, String originName, String changeName, String filePath,
			String thumbnailYn, String writerNick) {
		super();
		this.galleryNo = galleryNo;
		this.title = title;
		this.writerNo = writerNo;
		this.hit = hit;
		this.enrollDate = enrollDate;
		this.modifyDate = modifyDate;
		this.status = status;
		this.attachmentNo = attachmentNo;
		this.refNo = refNo;
		this.originName = originName;
		this.changeName = changeName;
		this.filePath = filePath;
		this.thumbnailYn = thumbnailYn;
		this.writerNick = writerNick;
	}
	
	
	
	
	
	
	
	

}