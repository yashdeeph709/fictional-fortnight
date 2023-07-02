package com.fortnight.todoist;

public class ClientDetails {

	private String clientId;
	private String scope;
	private String state;
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public String getScope() {
		return scope;
	}
	public void setScope(String scope) {
		this.scope = scope;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public ClientDetails(String clientId, String scope, String state) {
		super();
		this.clientId = clientId;
		this.scope = scope;
		this.state = state;
	}
	public ClientDetails() {
		super();
	}

}
