package com.wellsfargo.stockmarket.companydetails.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class BoardOfDir {
	
	@Column(name="boardofdirname")
	private String boardOfDirName;
	
	public BoardOfDir() {
		
	}
	public String getBoardOfDirName() {
		return boardOfDirName;
	}
	public void setBoardOfDirName(String boardOfDirName) {
		this.boardOfDirName = boardOfDirName;
	}


}
