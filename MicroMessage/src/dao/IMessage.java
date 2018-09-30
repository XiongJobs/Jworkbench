package dao;

import java.util.List;
import java.util.Map;

import bean.Message;

/**
 * 与Message配置文件相对应的接口
 *
 */
public interface IMessage {
	public List<Message> queryMessageList(Message message);
	
	/**
	 * 根据查询条件查询消息列表的条数
	 */
	public int count(Message message);
	
	/**
	 * 根据查询条件分页查询消息列表
	 */
	public List<Message> queryMessageListByPage(Map<String,Object> parameter);
}
