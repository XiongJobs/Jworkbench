package bean;

import java.util.List;

/**
 * 与指令表对应的实体类
 *
 */
public class Command {
	private String id;							//主键
	private String name;						//指令名称
	private String description;					//描述
	private List<CommandContent> contentList;	//一条指令对应的自动回复内容列表
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<CommandContent> getContentList() {
		return contentList;
	}
	public void setContentList(List<CommandContent> contentList) {
		this.contentList = contentList;
	}
}
