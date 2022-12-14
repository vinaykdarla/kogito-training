package com.test.vnay;

import java.io.Serializable;
import java.util.Objects;

public class Response implements Serializable {

	private static final long serialVersionUID = 4998222558317377389L;

	private boolean isInScope;
	private String reason;
	public boolean isInScope() {
		return isInScope;
	}
	public void setInScope(boolean isInScope) {
		this.isInScope = isInScope;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	@Override
	public String toString() {
		return "Response [isInScope=" + isInScope + ", reason=" + reason + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(isInScope, reason);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Response other = (Response) obj;
		return isInScope == other.isInScope && Objects.equals(reason, other.reason);
	}
	
	
}
