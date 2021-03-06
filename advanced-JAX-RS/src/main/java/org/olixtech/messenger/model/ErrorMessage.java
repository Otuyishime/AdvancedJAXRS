package org.olixtech.messenger.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ErrorMessage {
	
	private String errorMessage;
	private int errorCode;
	private String documentation;
	
	public String getErrorMessage() {
		return errorMessage;
	}
	public int getErrorCode() {
		return errorCode;
	}
	public String getDocumentation() {
		return documentation;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	public void setDocumentation(String documentation) {
		this.documentation = documentation;
	}
	
	public ErrorMessage() {
		super();
	}
	
	public ErrorMessage(String errorMessage, int errorCode, String documentation) {
		super();
		this.errorMessage = errorMessage;
		this.errorCode = errorCode;
		this.documentation = documentation;
	}
}
