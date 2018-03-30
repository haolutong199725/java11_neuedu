package com.entity;

public class Type {

	public String id;
	public String parent_id;
	public String type;
	public int statu;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getParent_id() {
		return parent_id;
	}
	public void setParent_id(String parent_id) {
		this.parent_id = parent_id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getStatu() {
		return statu;
	}
	public void setStatu(int statu) {
		this.statu = statu;
	}
	public Type(String id, String parent_id, String type, int statu) {
		super();
		this.id = id;
		this.parent_id = parent_id;
		this.type = type;
		this.statu = statu;
	}
	public Type() {
		super();
	}
	@Override
	public String toString() {
		return "Type [id=" + id + ", parent_id=" + parent_id + ", type=" + type + ", statu=" + statu + "]";
	}
	
	
	
	
}
