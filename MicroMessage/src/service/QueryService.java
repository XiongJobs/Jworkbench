package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import bean.Command;
import bean.CommandContent;
import bean.Message;
import dao.CommandDao;
import dao.MessageDao;
import entity.Page;
import util.Iconst;

/**
 * �б���ص�ҵ����
 *
 */
public class QueryService {
	MessageDao mesDao=new MessageDao();
	
	//基本列表显示功能
	public List<Message> queryMessageList(String command,String discription) {		
		List<Message> messageList=mesDao.queryMessageList2(command, discription);
		return messageList;
	}
	
	//通过Mybatis拦截器实现分页拦截显示功能
	public List<Message> queryMessageListByPage(String command,String description,Page page) {	
		MessageDao mesDao=new MessageDao();
		
		Map <String,Object> parameter=new HashMap<String,Object>();
		//组织消息对象
		Message message=new Message();
		message.setCommand(command);
		message.setDescription(description);
		parameter.put("message", message);
		parameter.put("page", page);
		//分页查询并返回结果
		return mesDao.queryMessageListByPage(parameter);
	}
	
	//基本聊天机器人回复功能
	public String queryByCommand(String command) {
		List<Message> messageList;
		if(Iconst.HELP_COMMAND.equals(command)) {
			messageList = mesDao.queryMessageList(null, null);
			StringBuilder result = new StringBuilder();
			for(int i = 0; i < messageList.size(); i++) {
				if(i != 0) {
					result.append("<br/>");
				}
				result.append("回复[" + messageList.get(i).getCommand() + "]可以查看" + messageList.get(i).getDescription());
			}
			return result.toString();
		}
		messageList = mesDao.queryMessageList(command, null);
		if(messageList.size() > 0) {
			return messageList.get(0).getContent();
		}
		return Iconst.NO_MATCHING_CONTENT;
	}
	
	//使用commandDao实现聊天机器人随机回复功能（一对多查询）
	public String queryByCommand2(String command) {
		CommandDao commandDao = new CommandDao();
		List<Command> commandList;
		if(Iconst.HELP_COMMAND.equals(command)) {
			commandList = commandDao.queryCommandList(null, null);
			StringBuilder result = new StringBuilder();
			for(int i = 0; i < commandList.size(); i++) {
				if(i != 0) {
					result.append("<br/>");
				}
				result.append("回复[" + commandList.get(i).getName() + "]可以查看" + commandList.get(i).getDescription());
			}
			return result.toString();
		}
		commandList = commandDao.queryCommandList(command, null);
		if(commandList.size() > 0) {
			List<CommandContent> contentList = commandList.get(0).getContentList();
			int i = new Random().nextInt(contentList.size());
			return contentList.get(i).getContent();
		}
		return Iconst.NO_MATCHING_CONTENT;
	}
}
