package org.olixtech.messenger.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.olixtech.messenger.database.DatabaseClass;
import org.olixtech.messenger.exception.DataNotFoundException;
import org.olixtech.messenger.model.Message;

public class MessageService {

	private Map<Long, Message> messages;
	
	
	public MessageService() {
		super();
		messages = DatabaseClass.getMessages();
		
		Message m1 = new Message("first message", "user1");
		Message m2 = new Message("second message", "user2");
		Message m3 = new Message("third message","user3");
		
		m1.setId(1L);
		m2.setId(2L);
		m3.setId(3L);
		
		messages.put(m1.getId(), m1);
		messages.put(m2.getId(), m2);
		messages.put(m3.getId(), m3);
	}

	public List<Message> getAllMessages(){
		List<Message> mesgList = new ArrayList<Message>();
		mesgList.addAll(messages.values());
		return mesgList;
	}
	
	public List<Message> getMessagesPerYear(int year){
		List<Message> messagesForYear = new ArrayList<Message>();
		Calendar calendar = Calendar.getInstance();
		for(Message message : messages.values()){
			calendar.setTime(message.getCreated());
			if( calendar.get(Calendar.YEAR) == year){
				messagesForYear.add(message);
			}
		}
		
		return messagesForYear;
	}
	
	public List<Message> getMessagesPaginated(int offset, int size){
		List<Message> paginatedMessages = new ArrayList<Message>(messages.values());
		if((offset + size) > messages.size()){
			return new ArrayList<Message>();
		}
		return paginatedMessages.subList(offset, offset + size); 
	}
	
	public Message getMessage(long id) {
		Message message = messages.get(id);
		if( message == null){
			throw new DataNotFoundException("Message with id " + id + " not found!");
		}
		return message;
	}
	
	public Message addMessage(Message msg) {
		msg.setId(messages.size() + 1);
		messages.put(msg.getId(), msg);
		return messages.get(msg.getId());
	}
	
	public Message  updateMessage(Message msg) {
		messages.put(msg.getId(), msg);
		return msg;
	}
	
	public Message removeMessage(long id) {
		Message msg = messages.remove(id);
		return msg;
	}
}
